package week3;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Person>{
	public int compare(Person obj1, Person obj2) {
		 if (obj1.getSalary() == obj2.getSalary())
	            return 0;
	        else if (obj1.getSalary() > obj2.getSalary())
	            return 1;
	        else
	            return -1;
	}

}
