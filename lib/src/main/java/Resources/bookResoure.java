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

@Path("book")
public class bookResoure {
	@Inject
	CreateBook cb;
	
	@POST
	@Path("/createBook")
	public void createBook(@Context HttpServletRequest req, @Context HttpServletResponse res) throws IOException {
		String name = req.getParameter("name");
		int id = Integer.parseInt(req.getParameter("sid"));
		cb.createBook(name,id);
		res.sendRedirect("../student/showStudent");
	}
	
	@GET
	@Path("/deleteBook")
	public void deleteBook(@Context HttpServletRequest req, @Context HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("bid"));
		cb.deleteBook(id);
		res.sendRedirect("../student/showStudent");
	}
	
	
	@GET
	@Path("/updateBook")
	public void updateBook(@Context HttpServletRequest req, @Context HttpServletResponse res) throws ServletException, IOException {
		int bid = Integer.parseInt(req.getParameter("id"));
		
		cb.updateBook(bid, req.getParameter("bname"));
		res.sendRedirect(req.getContextPath()+"/student/showStudent");
//		res.sendRedirect("../student/showStudent");
		
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
