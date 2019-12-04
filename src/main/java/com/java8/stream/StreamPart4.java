package com.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java8.data.Employee;
import com.java8.data.Employee.Sex;

/**
 * 
 * @author nagpalh
 *
 *         Note:- -> Reduction mean method which can convert Stream into single
 *         data or collection of data -> Reduction Example of single data :-
 *         sum() , min() , max() , average() -> Reduction Example of collection
 *         of data :- reduce() , collect() -> Stream is returned by stream() or
 *         map() functions -> Reduce method always creates a new value when it
 *         processes an element, collect method modifies, or mutates, an
 *         existing value.
 *
 */
public class StreamPart4 {
	public static void main(String[] args) {
		// Inputs
		Employee e1 = new Employee("Himanshu", 1, "HCL", Employee.Sex.Male);
		Employee e2 = new Employee("Bhawna", 2, "HP", Employee.Sex.Female);
		Employee e3 = new Employee("Nagpal", 3, "INFOSYS", Employee.Sex.Male);
		Employee e4 = new Employee("Chandni", 4, "SAMSUNG", Employee.Sex.Female);
		Employee e5 = new Employee("Roshni", 5, "GLOBALLOGIC", Employee.Sex.Female);
		Employee e6 = new Employee("Harry", 6, "INFOSYS", Employee.Sex.Male);
		Employee e7 = new Employee("Rahul", 7, "HCL", Employee.Sex.Male);
		List<Employee> empList = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5, e6, e7));

		// Reduction Operation : collect, reduce
		// For getting collection of data

		// Point 1 : reduce() Usage
		int sumofEmpIds = empList.stream().mapToInt(Employee::getId).reduce(100, (emp1, emp2) -> emp1 + emp2);
		int sumofEmpIds2 = empList.stream().map(Employee::getId).reduce(10, (emp1, emp2) -> emp1 + emp2);

		System.out.println("sumofEmpIds + 100 : " + sumofEmpIds);
		System.out.println("sumofEmpIds2 + 10 : " + sumofEmpIds2);

		// Point 2 : collect() Usage
		List<String> nameList = empList.stream().map(Employee::getName).collect(Collectors.toList());
		System.out.println("name List : " + nameList);

		nameList = empList.stream().map(Employee::getName).collect(ArrayList::new, List::add, List::addAll);
		System.out.println("name List : " + nameList);
		// 1) we can use ArrayList/List both but instantiation can only be possible via
		// ArrayList //
		// 2) .collect(supplier, accumulator, combiner); //
		// -> supplier : result required //
		// -> accumulator : handle single stream element operation //
		// -> combiner : takes two container as input and merge //

		// Point 3 : distinct() Usage : Get list of unique company names
		List<String> uniqueCompanyList = empList.stream().map(Employee::getCompany).distinct()
				.collect(Collectors.toList());
		System.out.println("unique company list : " + uniqueCompanyList);

		// Point 4 : collect() with groupBy : get Map of "List<Employee>" based on
		// gender
		Map<Sex, List<Employee>> mapofEmpListByGender = empList.stream()
				.collect(Collectors.groupingBy(emp -> emp.getGender()));

		List<Employee> listOfMaleEmp = mapofEmpListByGender.get(Sex.Male);
		List<Employee> listOfFemaleEmp = mapofEmpListByGender.get(Sex.Female);

		System.out.println("Female Emp : " + listOfFemaleEmp);
		System.out.println("Male Emp : " + listOfMaleEmp);

		// Point 5 : Map of "List of Employee Name" by Gender
		Map<Sex, List<String>> mapOfEmpNameListByGender = empList.stream().collect(Collectors
				.groupingBy(emp -> emp.getGender(), Collectors.mapping(e -> e.getName(), Collectors.toList())));
		List<String> femaleEmpNames = mapOfEmpNameListByGender.get(Sex.Female);
		List<String> maleEmpNames = mapOfEmpNameListByGender.get(Sex.Male);

		System.out.println("Males : " + maleEmpNames);
		System.out.println("Females : " + femaleEmpNames);

		// Point 6 : Map having keys as gender and values as maximum Id byGender)
		Map<Sex, Integer> mapOfMaxIdByGender = empList.stream().collect(
				Collectors.groupingBy(emp -> emp.getGender(), Collectors.reducing(0, e -> e.getId(), Integer::max)));

		Integer maxMaleId = mapOfMaxIdByGender.get(Sex.Male);
		Integer maxFemaleId = mapOfMaxIdByGender.get(Sex.Female);

		System.out.println("Males max id: " + maxMaleId);
		System.out.println("Females max id : " + maxFemaleId);

		// Point 7 : 
		
	}
}
