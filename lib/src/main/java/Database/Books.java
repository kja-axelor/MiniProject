package Database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bid;
	private String bname;
	@ManyToOne
	private Student s;
	
	
	
	
	public Books(String bname, Student s) {
		super();
		this.bname = bname;
		this.s = s;
	}

	public Student getS() {
		return s;
	}

	public void setS(Student s) {
		this.s = s;
	}

	public Books( String bname) {
		super();
		this.bname = bname;
	}
	
	
	public Books() 
	{
		super();
	}
	

	@Override
	public String toString() {
		return "Books [bid=" + bid + ", bname=" + bname + ", s=" + s + "]";
	}

	public int getBid() {
		return bid;
	}
	
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	
	
}
