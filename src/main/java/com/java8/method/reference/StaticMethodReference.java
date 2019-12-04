package com.java8.method.reference;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

class MyExample {
	// Method for BiPredicate Example
	public static boolean isMoreThanFifty(Integer t, Integer u) {
		if (t + u > 50)
			return true;
		return false;
	}

	// Method for Predicate example
	public static Boolean isPrime(Integer t) {
		Boolean flag = true;
		for (int i = 2; i <= t / 2; i++) {
			if (t % i == 0)
				flag = false;
		}
		return flag;
	}
}

public class StaticMethodReference {

	public static void main(String[] args) {
		// Static Method Reference Using BiPredicate Example
		usingBiPredicateExample();

		// Sttaic Method Refernce Using Predicate Example
		usingPredicateExample();

	}

	private static void usingBiPredicateExample() {
		// Anonymous Class
		BiPredicate<Integer, Integer> anonymousBiPredicate = new BiPredicate<Integer, Integer>() {
			@Override
			public boolean test(Integer t, Integer u) {
				return MyExample.isMoreThanFifty(t, u);
			}
		};

		// Lambda Or Anonymous Function
		BiPredicate<Integer, Integer> lambdaBiPredicate = (t, u) -> MyExample.isMoreThanFifty(t, u);

		// Method Reference
		BiPredicate<Integer, Integer> methodRefBiPredicate = MyExample::isMoreThanFifty;

		// Verifying
		System.out.println("---- BiPredicate Results ---- " + "\n anonymousBiPredicate : "
				+ anonymousBiPredicate.test(25, 20) + "\n lambdaBiPredicate : " + lambdaBiPredicate.test(25, 30)
				+ "\n methodRefBiPredicate : " + methodRefBiPredicate.test(45, 05));

	}

	private static void usingPredicateExample() {
		// Anonymous Class
		Predicate<Integer> anonymousPredicate = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return MyExample.isPrime(t);
			}
		};

		// Lambda Function
		Predicate<Integer> lambdaPredicate = (t) -> MyExample.isPrime(t);

		// Method Refernce
		Predicate<Integer> methodRefPredicate = MyExample::isPrime;

		// Verifying
		System.out.println("---- Predicate Results ----");
		System.out.println(" 11 is prime : " + anonymousPredicate.test(11));
		System.out.println(" 13 is prime : " + lambdaPredicate.test(13));
		System.out.println(" 15 is prime : " + methodRefPredicate.test(15));
	}

}
