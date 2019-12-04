package com.java8.functional.interfaces;

 interface MyCustomFunctionalInterface {
	
	int getSqure(int n);
	//boolean equals();
	default String getName(String name) {
		return null;
	}
	
	static int getnum() {
		return 0;
	}

}

 
 public class CustomFunctionalInterface 
 {
	 
	 public static void main(String[] args) {
		 MyCustomFunctionalInterface o = (n)->n*n;
		System.out.println(o.getSqure(5));
		System.out.println("===="+ o.getName("S"));
		
	}

	/*
	 * @Override public int getSqure(int n) { return n*n; }
	 */
	 
 }