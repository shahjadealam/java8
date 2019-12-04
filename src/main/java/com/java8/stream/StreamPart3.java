package com.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import com.java8.data.Employee;
import com.java8.data.Employee.Sex;

public class StreamPart3 {
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

		// Reduction Operation : Average, Sum, Count, Max
		// For Getting Single Value

		// Employees-List
		// empList.stream().map(emp->emp.getId()); return Stream<Integer>
		// and reduction operation are not available for them
		// So we should use mapToInt() function which return IntStream,
		// to avail these reduction operations.

		// Average of Id's
		OptionalDouble averageId = empList.stream().mapToInt(emp -> emp.getId()).average();

		// Sum of Id's of Female Employee
		int sumOfFemaleId = empList.stream().filter(a -> a.getGender().equals(Sex.Female)).mapToInt(m -> m.getId())
				.sum();

		// count the number of Male Employees
		long maleEmpCount = empList.stream().filter(a -> a.getGender().equals(Sex.Male)).count();

		// Max id of Male Employee
		OptionalInt maxIdOfMaleEmp = empList.stream().filter(m -> m.getGender().equals(Sex.Male))
				.mapToInt(a -> a.getId()).max();
		
		System.out.println("max Id Of Male Emp : " + maxIdOfMaleEmp.getAsInt());
		System.out.println("Avarage Id : " + averageId.getAsDouble());
		System.out.println("sum Of Female Ids : " + sumOfFemaleId);
		System.out.println("male Emp Count : " + maleEmpCount);

	}
}
