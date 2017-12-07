package week3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

  Person person;
  @Before
  public void setUp() throws Exception {
    person = new Person("Nhu", 1996, "DN", "GV");
  }

  @Test
  public void testPersonStringIntStringString() {
    assertEquals("Nhu",person.getName());
    assertEquals(1996,person.getYear());
    assertEquals("DN",person.getAddress());
    assertEquals("GV",person.getCareer());
  }

  @Test
  public void testGetSetName() {
    person.setName("An");
    assertEquals("An",person.getName());
  }

  @Test
  public void testGetSetYear() {
    person.setYear(1994);
    assertEquals(1994,person.getYear());
  }

  @Test
  public void testGetSetAddress() {
    person.setAddress("Da Nang");
    assertEquals("Da Nang",person.getAddress());
  }

  @Test
  public void testGetSetCareer() {
    person.setCareer("NV");
    assertEquals("NV",person.getCareer());
  }


}
