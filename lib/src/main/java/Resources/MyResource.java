package Resources;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;

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
	@Path("test")
	public void getHello(@Context HttpServletRequest req, @Context HttpServletResponse res) {
		String s = req.getParameter("name");
		ms.createStudent(s);
		try {
			req.getRequestDispatcher("/records.html").forward(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@POST
	@Path("/showStudent")
	@Produces(MediaType.TEXT_PLAIN)
	public Response showProduct() {
		return Response.ok(ss.showStudent()).build();
	}

	@POST
	@Path("/deleteStudent")
	public Response deleteProduct(@FormParam("id") int id) {
		ds.deleteProduct(id);
		return Response.ok("Record is deleted").build();
	}

	@POST
	@Path("/updateStudent")
	public Response updateProduct(@FormParam("id") int id, @FormParam("name") String name) {
		us.updateStudent(id, name);
		return Response.ok("Student record is updated !").build();
	}
}
