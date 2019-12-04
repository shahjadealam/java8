package com.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.java8.data.Employee;
import com.java8.data.Employee.Sex;
/**
 * 
 * @author shahjade.a
 * <br>
 * <br>Stream Api uses Example
 *
 */

public class StreamPart2 {
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

		// Get List of Employee Names : use of map()
		System.out.println("Get List of Employee Names");
		List<String> nameList = empList.stream().map(emp -> emp.getName()).collect(Collectors.toList());
		nameList.forEach(System.out::println);

		// Get List of Female Employees : use of filter()
		System.out.println("Get List of Female Employees");
		List<Employee> femaleEmpList = empList.stream().filter(emp -> emp.getGender().equals(Sex.Female))
				.collect(Collectors.toList());
		femaleEmpList.forEach(System.out::println);

		// Get List of Female Employee Names : use of filter() and map()
		System.out.println("Get List of Female Employee Names");
		List<String> femaleEmpNameList = empList.stream().filter(emp -> emp.getGender().equals(Sex.Female))
				.map(emp -> emp.getName()).collect(Collectors.toList());
		femaleEmpNameList.forEach(System.out::println);

	}
}
