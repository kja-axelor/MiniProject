package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import Database.Student;



public class ShowStudentService {
	
	@Inject
	Provider<EntityManager> emp;
	
	@Transactional
	public List<Student> showStudent() {
		
	EntityManager em = emp.get();
	Query q = em.createQuery("from Student" , Student.class);
	
	@SuppressWarnings("unchecked")
	List<Student> list = q.getResultList();
	return list;
	}

}
