package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import Database.Student;

public class CreateStudent {

	@Inject
	Provider<EntityManager> emp;

	@Transactional
	public boolean createStudent(String s) {
		EntityManager em = emp.get();
		Student st = new Student(s);
		em.persist(st);
		return true;
	}

	@Transactional
	public List<Student> showStudent() {

		EntityManager em = emp.get();
		Query q = em.createQuery("from Student", Student.class);

		@SuppressWarnings("unchecked")
		List<Student> list = q.getResultList();
		return list;
	}

}
