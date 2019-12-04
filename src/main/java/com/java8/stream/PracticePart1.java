package com.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.java8.data.Employee;
import com.java8.data.Employee.Sex;

//part-1 complete
// part-2 start
public class PracticePart1 {

	public static void main(String[] args) {

		// Inputs
				Employee e1 = new Employee("Himanshu", 1, "HCL", Employee.Sex.Male);
				Employee e2 = new Employee("Bhawna", 2, "HCL", Employee.Sex.Female);
				Employee e3 = new Employee("Nagpal", 3, "HCL", Employee.Sex.Male);
				Employee e4 = new Employee("Chandni", 4, "HCL", Employee.Sex.Female);
				Employee e5 = new Employee("Roshni", 5, "HCL", Employee.Sex.Female);
				Employee e6 = new Employee("Harry", 6, "HCL", Employee.Sex.Male);
				Employee e7 = new Employee("Rahul", 7, "HCL", Employee.Sex.Male);

				List<Employee> empList = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5, e6, e7));
				empList.forEach(System.out::println);

				// Get List of Employee Names : use of map()
				List<String> nameList = empList.stream().map(e->e.getName()).collect(Collectors.toList());
				nameList.forEach(System.out::println);
				
				// Get List of Female Employees : use of filter()
				System.out.println("-----------------------------");
				List<Employee> femaleNames = empList.stream().filter(e->e.getGender().equals(Sex.Female)).collect(Collectors.toList());
				femaleNames.forEach(a->System.out.println(a.getName()));
				// Get List of Female Employee Names : use of filter() and map()
				List<String> fNames = empList.stream().filter(e->e.getGender().equals(Sex.Female)).map(m->m.getName()).collect(Collectors.toList());
				fNames.forEach(System.out::println);
				
				
	}

	
}

