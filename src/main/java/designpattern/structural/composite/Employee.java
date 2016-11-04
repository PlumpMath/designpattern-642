package designpattern.structural.composite;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Employee {
	
	private String name;
	private String dept;
	private BigDecimal salary;
	private List<Employee> subordinates;
	
	public Employee(String name, String dept, BigDecimal salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.subordinates = new ArrayList<Employee>();
	}
	
	public void add(Employee employee) {
		subordinates.add(employee);
	}
	
	public void remove(Employee employee) {
		subordinates.remove(employee);
	}
	
	public List<Employee> getSubordinates() {
		return this.subordinates;
	}
	
	public String toString(){
	      return ("Employee :[ Name : " + name + ", dept : " + dept + ", salary :" + salary+" ]");
	}
	
}
