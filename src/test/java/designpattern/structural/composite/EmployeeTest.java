package designpattern.structural.composite;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

	private PrintStream old = System.out;
	private ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private PrintStream ps = new PrintStream(baos);
	
	@Before
	public void beforeTests() {
	    System.setOut(ps);
	}
	
	@After
	public void afterTest() {
		System.setOut(old);
	}
	
	@Test
	public void testCompositeDesignPattern() {
		Employee CEO = new Employee("John","CEO", new BigDecimal(30000));
		Employee headSales = new Employee("Robert","Head Sales", new BigDecimal(20000));

	      Employee headMarketing = new Employee("Michel","Head Marketing", new BigDecimal(20000));

	      Employee clerk1 = new Employee("Laura","Marketing", new BigDecimal(10000));
	      Employee clerk2 = new Employee("Bob","Marketing", new BigDecimal(10000));

	      Employee salesExecutive1 = new Employee("Richard","Sales", new BigDecimal(10000));
	      Employee salesExecutive2 = new Employee("Rob","Sales", new BigDecimal(10000));

	      CEO.add(headSales);
	      CEO.add(headMarketing);

	      headSales.add(salesExecutive1);
	      headSales.add(salesExecutive2);

	      headMarketing.add(clerk1);
	      headMarketing.add(clerk2);

	      //print all employees of the organization
	      System.out.println(CEO); 
	      
	      for (Employee headEmployee : CEO.getSubordinates()) {
	         System.out.println(headEmployee);
	         
	         for (Employee employee : headEmployee.getSubordinates()) {
	            System.out.println(employee);
	         }
	      }
	      
	      String message = "Employee :[ Name : John, dept : CEO, salary :30000 ]\r\n" +
	    		  			"Employee :[ Name : Robert, dept : Head Sales, salary :20000 ]\r\n" +
	    		  			"Employee :[ Name : Richard, dept : Sales, salary :10000 ]\r\n" +
	    		  			"Employee :[ Name : Rob, dept : Sales, salary :10000 ]\r\n" +
	    		  			"Employee :[ Name : Michel, dept : Head Marketing, salary :20000 ]\r\n" +
	    		  			"Employee :[ Name : Laura, dept : Marketing, salary :10000 ]\r\n" +
	    		  			"Employee :[ Name : Bob, dept : Marketing, salary :10000 ]\r\n";
	      assertEquals(message, baos.toString());
		
	}
}
