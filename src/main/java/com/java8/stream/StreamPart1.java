package com.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamPart1 {
	public static void main(String[] args) {

		// Ways of sorting list

		// 1
		List<Integer> intList = Arrays.asList(5, 2, 4, 3, 2, 1);
		Collections.sort(intList);
		intList.forEach(System.out::print);

		System.out.println("\n===================================");
		// 2
		List<Integer> intList2 = Arrays.asList(5, 2, 4, 3, 2, 1);
		intList2.sort(null);
		intList2.forEach(System.out::print);

		System.out.println("\n===================================");
		// 3
		List<Integer> intList3 = new ArrayList<Integer>(Arrays.asList(5, 2, 4, 3, 2, 1));
		// intList3.sort((a, b) -> a.compareTo(b));
		intList3.sort(Integer::compareTo);
		intList3.forEach(System.out::print);

		System.out.println("\n===================================");
		// 4
		List<Integer> intList4 = new ArrayList<Integer>(Arrays.asList(5, 2, 4, 3, 2, 1));
		// intList4.sort((a, b) -> Integer.compare(a, b));
		intList4.sort(Integer::compare);
		intList2.forEach(System.out::print);

	}
}
