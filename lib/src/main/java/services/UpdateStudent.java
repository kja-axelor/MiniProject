package services;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import Database.Student;

public class UpdateStudent {
	@Inject
	Provider<EntityManager> emp;

	@Transactional
	
	public void updateStudent(int sid, String name) {
	EntityManager em = emp.get();
	Student s = em.find(Student.class, sid);
	s.setName(name);
	}
}
