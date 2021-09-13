package services;


import javax.persistence.EntityManager;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import Database.Student;

public class DeleteStudent {
	
	@Inject
	Provider<EntityManager> emp;
	
	
	@Transactional
	public String deleteStudent(int sid) {
	EntityManager em = emp.get();
	
	Student p =em.find(Student.class, sid);
	em.remove(p);
	
	return "Student deleted with "+"id = "+ sid;
	
	}

}
