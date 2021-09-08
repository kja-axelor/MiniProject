package Resources;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.hql.internal.ast.tree.UpdateStatement;

import com.google.inject.Inject;

import Database.Student;
import services.DeleteStudent;
import services.MyService;
import services.ShowStudentService;
import services.UpdateStudent;

@Path("/apple")
public class MyResource {
	@Inject
	MyService ms;
	@Inject
	ShowStudentService ss;
	@Inject
	DeleteStudent ds;
	@Inject
	UpdateStudent us;
	
	@POST
	@Path("test")
	public void getHello(@FormParam("name") String name) {
		
		Student s = new Student(name);
		ms.createStudent(s);
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
	return Response.ok("Student deleted with id =  "+id + "!!!").build();
	}
	
	
	@POST
	@Path("/updateStudent")
	public Response updateProduct(@FormParam("id") int id,@FormParam("name") String name) {
	us.updateStudent(id,name);
	return Response.ok("Student record is Updated !").build();
	}

}
