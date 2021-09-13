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
	
	//show
	@Transactional
	public List<Student> showStudent() {
		
	EntityManager em = emp.get();
	Query q = em.createQuery("from Student order by id" , Student.class);
	
	@SuppressWarnings("unchecked")
	List<Student> list = q.getResultList();

	return list; 
	}
	
	//search
		@Transactional
		public List<Student> searchStudent(String name){
		EntityManager em = emp.get();
		Query q = em.createQuery("from Student where name like '%"+name+"%'");
		@SuppressWarnings("unchecked")
		List<Student> std = q.getResultList();
		return std;
		}
		
	//delete
		@Transactional
		public String deleteStudent(int sid) {
		EntityManager em = emp.get();
		
		Student p =em.find(Student.class, sid);
		em.remove(p);
		
		return "Student deleted with "+"id = "+ sid;
		
		}
		
	//create
		@Transactional
		public boolean createStudent(String s) {
			EntityManager em = emp.get();
			Student st = new Student(s);
			em.persist(st);
			return true;
		}

	//update
		@Transactional
		
		public void updateStudent(int sid, String name) {
		EntityManager em = emp.get();
		Student s = em.find(Student.class, sid);
		s.setName(name);
		}
		
}
