package com.java8.method.reference;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import com.java8.data.Employee;
import com.java8.data.Employee.Sex;

public class ConstructorMethodReference {
	public static void main(String[] args) throws Exception {
		// Using Supplier<Return-Type> Functional Interface
		System.out.println("--------Zero Argument Constructor--------");
		ZeroArgumentConstructor();

		// Using Function<Arg1-Type, Return-Type> Functional Interface
		System.out.println("--------One Argument Constructor---------");
		OneArgumentConstructor();

		// Using BiFunction<Arg1-Type, Arg2-Type, Return-Type> Functional Interface
		System.out.println("--------Two Argument Constructor---------");
		TwoArgumentConstructor();

	}

	private static void ZeroArgumentConstructor() {

		// Using Anonymous class
		Supplier<Employee> supplierAnonymous = new Supplier<Employee>() {
			@Override
			public Employee get() {
				return new Employee();
			}
		};

		// Using Lambda Expression
		Supplier<Employee> supplierLambda = () -> new Employee();

		// Using Method Reference
		Supplier<Employee> supplierMethodReference = Employee::new;

		// Creating Output
		Employee anonymousEmp = supplierAnonymous.get();
		Employee lambdaEmp = supplierLambda.get();
		Employee methodRefEmp = supplierMethodReference.get();

		// Populating Some Values and Verifying
		anonymousEmp.withName("Himanhsu").withCompany("Hcl").withGender(Sex.Male).setSalary(30000.0);
		lambdaEmp.withName("Harry").withCompany("Hp").withGender(Sex.Male).setSalary(40000.0);
		methodRefEmp.withName("Nagpal").withCompany("Samsung").withGender(Sex.Male).setSalary(50000.0);

		System.out.println("Employee from Anonymous :" + anonymousEmp);
		System.out.println("Employee from Lambda :" + lambdaEmp);
		System.out.println("Employee from Method Reference :" + methodRefEmp);

	}

	private static void OneArgumentConstructor() {
		// Using Anonymous Function
		Function<String, Employee> anonymousFun = new Function<String, Employee>() {
			@Override
			public Employee apply(String t) {
				return new Employee(t);
			}
		};

		// Using Lambda Expression
		Function<String, Employee> lambdaFun = (str) -> new Employee(str);

		// Using Method Reference
		Function<String, Employee> methodRefFun = Employee::new;

		// Creating Output
		Employee anonymousInt = anonymousFun.apply("Himanshu");
		Employee lambdaInt = lambdaFun.apply("Bhawna");
		Employee methodRefInt = methodRefFun.apply("Roshni");

		System.out.println("Employee from Anonymous function : " + anonymousInt);
		System.out.println("Employee from Lambda Expression : " + lambdaInt);
		System.out.println("Employee from Method Reference : " + methodRefInt);
	}

	private static void TwoArgumentConstructor() {
		// Using Anonymous Function
		BiFunction<Integer, String, Employee> anonymousBiFun = new BiFunction<Integer, String, Employee>() {
			@Override
			public Employee apply(Integer t, String u) {
				return new Employee(t, u);
			}
		};

		// Using Lambda Expression
		BiFunction<Integer, String, Employee> lambdaBiFun = (Integer t, String u) -> new Employee(t, u);

		// Using Method Reference
		// It worked only bcz Employee have constructor with (Integer, String)
		BiFunction<Integer, String, Employee> methodRefBiFun = Employee::new;

		// Creating Output
		// apply() of BiFunction<...> returns Emloyee type object,
		// So we can use Bifunction (Reference) Object and call apply method over it
		// to create Employee Object.
		Employee anonymousList = anonymousBiFun.apply(1, "Nagpal");
		Employee lambdaList = lambdaBiFun.apply(2, "Himanshu");
		Employee methodRefList = methodRefBiFun.apply(3, "Harry");

		System.out.println("anonymousList : " + anonymousList);
		System.out.println("lambdaList : " + lambdaList);
		System.out.println("methodRefList : " + methodRefList);

	}

}
