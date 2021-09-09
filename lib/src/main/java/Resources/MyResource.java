package Resources;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;

import Database.Student;
import services.DeleteStudent;
import services.CreateStudent;
import services.ShowStudentService;
import services.UpdateStudent;

@Path("/apple")
public class MyResource {
	@Inject
	CreateStudent ms;
	@Inject
	ShowStudentService ss;
	@Inject
	DeleteStudent ds;
	@Inject
	UpdateStudent us;

	@POST
	@Path("/test")
	public Response createStudent(@FormParam ("name") String name ) {
		ms.createStudent(name);
		return Response.ok("Data added successfully").build();
		
	}

	@GET
	@Path("/showStudent")
	public void showStudent(@Context HttpServletRequest req, @Context HttpServletResponse res)
			throws ServletException, IOException {
		List<Student> list = ss.showStudent();

		// setAttribute
		req.setAttribute("list", list);

		// Redirect

		req.getRequestDispatcher("/show1.jsp").forward(req, res);
	}

	@GET
	@Path("/deleteStudent")
	public void deleteStudent(@Context HttpServletRequest req, @Context HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ds.deleteProduct(id);
		showStudent(req, res);
	}

	@GET
	@Path("/updateStudent")
	public void updateStudent(@Context HttpServletRequest req, @Context HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		us.updateStudent(id, req.getParameter("name"));
		
		showStudent(req, res);
		
	}
	
	
	@GET
	@Path("/updatedStudent")
	public void updateSelectedPeople(@Context HttpServletRequest req, @Context HttpServletResponse res)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		//setAttr
		req.setAttribute("id", id);
		
		//redirect
		req.getRequestDispatcher("../update.jsp").forward(req, res);
	}
}
