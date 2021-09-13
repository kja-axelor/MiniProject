package services;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

import Database.Books;
import Database.Student;

public class CreateBook {

	@Inject
	Provider<EntityManager> emp;
	
	@Transactional
	
	//CREATION
	public boolean createBook(String s,int id)
	{
		EntityManager em = emp.get();
		Student student = em.find(Student.class, id);
		Books book = new Books(s);
		student.setBook(Arrays.asList(book));
		book.setS(student);
		em.persist(student);
		return true;
		
	}
	
	//DISPLAY
	public List<Student> showStudent() {
		
		EntityManager em = emp.get();
		Query q = em.createQuery("from Student order by id" , Books.class);
		
		@SuppressWarnings("unchecked")
		List<Student> list = q.getResultList();
		return list; 
		}
	
	
	//DELETION
	@Transactional
	public void deleteBook(int bid) {
		EntityManager em = emp.get();
		
		Books book =em.find(Books.class, bid);
		
		book.getS().getBook().remove(book);
		em.remove(book);
		
		}
	
	//UPDATION
	
	public void updateBook(int bid, String name) {
		EntityManager em = emp.get();
		Books b = em.find(Books.class, bid);
		b.setBname(name);
		
	}
	
	
}
