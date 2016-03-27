package fyp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "Departments")
@DynamicUpdate
public class Department extends IdStatusTimeModel implements Comparable<Department> {
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Column(length = 8, nullable = false, unique = true)
	private String abbreviation;
	
	public String getAbbreviation(){
		return abbreviation;
	}
	
	public void setAbbreviation(String abbreviation){
		this.abbreviation = abbreviation;
	}
	
	@Column(length = 64, nullable = false, unique = true)
	private String name;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	
	public int compareTo(Department department) {
		return abbreviation.compareTo(department.abbreviation);
	}
}