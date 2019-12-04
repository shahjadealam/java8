package com.java8.data;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private Integer id;
	private String company;
	private Sex gender;
	private Double salary;
	transient private String password;

	public enum Sex {
		Male, Female
	};

	public Employee() {
		super();
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public Employee(Integer id, String name) {
		super();
		this.name = name;
		this.id = id;
	}

	public Employee(String name, Double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public Employee(String name, Integer id, String company) {
		super();
		this.name = name;
		this.id = id;
		this.company = company;
	}

	public Employee(String name, Integer id, String company, Sex gender) {
		super();
		this.name = name;
		this.id = id;
		this.company = company;
		this.gender = gender;
	}

	public Employee(String name, Integer id, String company, Sex gender, Double salary) {
		super();
		this.name = name;
		this.id = id;
		this.company = company;
		this.gender = gender;
		this.salary = salary;
	}

	public Employee(String name, Integer id, String company, Sex gender, Double salary, String password) {
		super();
		this.name = name;
		this.id = id;
		this.company = company;
		this.gender = gender;
		this.salary = salary;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee withName(String name) {
		setName(name);
		return this;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employee withId(Integer id) {
		setId(id);
		return this;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Employee withCompany(String company) {
		setCompany(company);
		return this;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public Employee withGender(Sex gender) {
		setGender(gender);
		return this;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Employee withSalary(Double salary) {
		setSalary(salary);
		return this;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee withPassword(String password) {
		setPassword(password);
		return this;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", company=" + company + ", gender=" + gender + ", salary="
				+ salary + ", password=" + password + "]";
	}

	public void salaryIncrement(Double percentage) {
		this.salary *= (100 + percentage) / 100;
	}

	public Employee finById(int id) {
		return this;
	}

	public static class EmployeeBuilder {
		private String name;
		private Integer id;
		private String company;
		private Sex gender;
		private Double salary;
		transient private String password;

		public EmployeeBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public EmployeeBuilder setId(Integer id) {
			this.id = id;
			return this;
		}

		public EmployeeBuilder setCompany(String company) {
			this.company = company;
			return this;
		}

		public EmployeeBuilder setGender(Sex gender) {
			this.gender = gender;
			return this;
		}

		public EmployeeBuilder setSalary(Double salary) {
			this.salary = salary;
			return this;
		}

		public EmployeeBuilder setPassword(String password) {
			this.password = password;
			return this;
		}

		public Employee createEmployee() {
			return new Employee(name, id, company, gender, salary, password);
		}

		public Employee build() {
			return new Employee(name, id, company, gender, salary, password);
		}

	}

	public static boolean isTaxable(Employee e) {

		return e.getSalary() > 50000;
	}

	public Double calculateSal() {
		Double tax;
		if (salary < 500000)
			tax = 0.0;

		else if (salary >= 500000 && salary < 1000000)
			tax = salary / 10;

		else
			tax = salary / 5;
		return salary-tax;
	}

}
