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
import javax.ws.rs.core.Response;

import com.google.inject.Inject;

import Database.Student;
import services.CreateBook;

@Path("banana")
public class bookResoure {
	@Inject
	CreateBook cb;
	
	@POST
	@Path("/create")
	public Response createBook(@FormParam ("name") String name,@FormParam ("sid") int id) {
		cb.createBook(name,id);
		return Response.ok("Books added successfully").build();
		
	}
	
	@GET
	@Path("/showBooks")
	public void showBooks(@Context HttpServletRequest req, @Context HttpServletResponse res)
			throws ServletException, IOException {
		List<Student> list = cb.showStudent();

		// setAttribute
		req.setAttribute("list", list);

		// Redirect

		req.getRequestDispatcher("/show2.jsp").forward(req, res);
	}
	
	
	@GET
	@Path("/deleteBook")
	public void deleteBook(@Context HttpServletRequest req, @Context HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("bid"));
		cb.deleteBook(id);
		res.sendRedirect("../apple/showStudent");
	}
	
	@GET
	@Path("/updateBook")
	public void updateStudent(@Context HttpServletRequest req, @Context HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("bid"));
		
		cb.updateBook(id, req.getParameter("name"));
		
		res.sendRedirect("../apple/showStudent");
		
	}
	
	@GET
	@Path("/updatedBook")
	public void updateSelectedPeople(@Context HttpServletRequest req, @Context HttpServletResponse res)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("bid"));
		
		//setAttr
		req.setAttribute("bid", id);
		
		//redirect
		req.getRequestDispatcher("../updatebook.jsp").forward(req, res);
	}
}
