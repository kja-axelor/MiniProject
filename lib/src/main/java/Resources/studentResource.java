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
import services.CreateBook;
import services.ShowStudentService;

@Path("/student")
public class studentResource {
	@Inject
	ShowStudentService ss;

	@POST
	@Path("/createStudent")
	public void createStudent( @Context HttpServletRequest req, @Context HttpServletResponse res ) throws IOException {
		String name = req.getParameter("name");
		ss.createStudent(name);
		res.sendRedirect("../student/showStudent");
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
		ss.deleteStudent(id);
		res.sendRedirect("../student/showStudent");
	}

	@GET
	@Path("/updateStudent")
	public void updateStudent(@Context HttpServletRequest req, @Context HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		ss.updateStudent(id, req.getParameter("name"));
		
		res.sendRedirect("../student/showStudent");
		
	}
	@GET
	@Path("/updatedStudent")
	public void updateSelectedPeople(@Context HttpServletRequest req, @Context HttpServletResponse res)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		//setAttr
		req.setAttribute("id", id);
		
		//redirect
		req.getRequestDispatcher("../updateStudent.jsp").forward(req, res);
	}
	
	@GET
	@Path("/search")
	public void search(@Context HttpServletRequest req, @Context HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		List<Student> list = ss.searchStudent(name);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/show1.jsp").forward(req, res);
	} 
	
	
	
}
