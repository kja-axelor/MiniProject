package Database;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "s",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Books> book;

	
	
	public List<Books> getBook() {
		return book;
	}


	public void setBook(List<Books> book) {
		this.book = book;
	}

	public Student(String name) {
		super();
		this.name = name;
	}
	
	public Student() {
		super();
	}	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", book=" + book + "]";
	}

	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
