package week3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

  Employee employee;
  @Before
  public void setUp() throws Exception {
    employee = new Employee("Nhu", 1996, "DN", 3.2f, "Ke toan", "Truong phong", 25);
  }

  @Test
  public void testEmployeeStringIntStringFloatStringStringInt() {
   assertEquals("Nhu",employee.getName());
   assertEquals(1996,employee.getYear());
   assertEquals("DN",employee.getAddress());
   assertEquals(3.2f,employee.getCoefficientSalary(),0.001);
   assertEquals("Ke toan",employee.getDepartment());
   assertEquals("Truong phong",employee.getPosition());
   assertEquals(25,employee.getWorkDays());
   assertEquals(1000,employee.getAllowance(),0.001);
  }
  
  @Test
  public void testGetSalary() {
    double expected = 3.2*730 + 1000 + 25*30;
    assertEquals(expected,employee.getSalary(),0.001);
  }

  @Test
  public void testSetGetAllowance() {
    employee.setAllowance("Pho phong");
    assertEquals(600,employee.getAllowance(),0.001);
  }

  @Test
  public void testSetGetDepartment() {
    employee.setDepartment("Dao tao");
    assertEquals("Dao tao",employee.getDepartment());
  }

  @Test
  public void testSetGetPosition() {
    employee.setPosition("Pho phong");
    assertEquals("Pho phong",employee.getPosition());
  }

  @Test
  public void testSetGetWorkDays() {
    employee.setWorkDays(20);
    assertEquals(20,employee.getWorkDays());
  }

  @Test
  public void testSetGetCoefficientSalary() {
    employee.setCoefficientSalary(2.9f);
    assertEquals(2.9f,employee.getCoefficientSalary(),0.001);
  }

}
