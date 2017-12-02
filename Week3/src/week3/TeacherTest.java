package week3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TeacherTest {

  Teacher teacher;
  @Before
  public void setUp() throws Exception {
    teacher = new Teacher("Nhu", 1996, "DN", 2.9f, "CNTT", "Thac si", 40);
  }

  @Test
  public void testGetSalary() {
    double expected = 2.9*730 + 900 + 40*45;
    assertEquals(expected,teacher.getSalary(),0.001);
  }

  @Test
  public void testTeacherStringIntStringFloatStringStringInt() {
    assertEquals("Nhu",teacher.getName());
    assertEquals(1996,teacher.getYear());
    assertEquals("DN",teacher.getAddress());
    assertEquals(2.9f,teacher.getCoefficientSalary(),0.001);
    assertEquals("CNTT",teacher.getFaculty());
    assertEquals("Thac si",teacher.getDegree());
    assertEquals(40,teacher.getClassHours());
    assertEquals(900,teacher.getAllowance(),0.001);
  }

  @Test
  public void testSetGetAllowance() {
    teacher.setAllowance("Tien si");
    assertEquals(2000,teacher.getAllowance(),0.001);
  }

  @Test
  public void testSetGetFaculty() {
    teacher.setFaculty("DTVT");
    assertEquals("DTVT",teacher.getFaculty());
  }

  @Test
  public void testSetGetDegree() {
    teacher.setDegree("Tien si");
    assertEquals("Tien si",teacher.getDegree());
  }

  @Test
  public void testSetGetClassHours() {
    teacher.setClassHours(50);
    assertEquals(50,teacher.getClassHours());
  }

  @Test
  public void testSetGetCoefficientSalary() {
    teacher.setCoefficientSalary(3.2f);
    assertEquals(3.2f,teacher.getCoefficientSalary(),0.001);
  }

}
