package com.java8.method.reference;

import java.util.function.Function;

public class InstanceMethodReference {

	public static void main(String[] args) {

		// Simple : FirstWay is sufficient to Learn , SecondWay is complicated
		firstWay();
		System.out.println("--------------------------------------------");

		// Complex : Using Method Reference/lambda As Function Parameter
		secondWay();
		System.out.println("--------------------------------------------");

	}

	private static void firstWay() {
		// Create Data to work on....
		Shipment shipOne = new Shipment("Vikrant", 10, 12.0);
		Shipment shipTwo = new Shipment("Jalsena", 20, 9.6);

		// Anonymous Class
		Function<Shipment, Double> anonymousFun = new Function<Shipment, Double>() {
			@Override
			public Double apply(Shipment ship) {
				return ship.calculateTotalWeight();
			}
		};

		// Lambda OR Anonymous Function
		Function<Shipment, Double> lambdaFun = (ship) -> ship.calculateTotalWeight();

		// Method Reference
		Function<Shipment, Double> methodRefFun = Shipment::calculateTotalWeight;

		// Extracting Values
		Double anonymousWeight = anonymousFun.apply(shipOne);
		Double lambdaWeight = lambdaFun.apply(shipTwo);
		Double methodRefWeight = methodRefFun.apply(shipOne);

		// Verifying Results
		System.out.println("First Way:" + "\n anonymousWeight : " + anonymousWeight + "\n lambdaWeight : "
				+ lambdaWeight + "\n methodRefWeight : " + methodRefWeight);

	}

	/**
	 * 1) In first Method we are evaluating "Function<> Object(Reference)", 2) Then
	 * applying, apply() method over "Function<> Object(Reference)" it to find Total
	 * weight 3) Also by passing Shipment Object in Apply Function
	 *
	 * Same we have to do here, 1) Calculate "Function<> Object" and pass it in a
	 * method with "Shipment Object" 2) Now in this method just call apply function
	 * on "Function<> Object" 3) And pass "Shipment object" in apply() method
	 */
	private static void secondWay() {

		// Create Data to work on....
		Shipment shipOne = new Shipment("Vikrant", 10, 12.0);
		Shipment shipTwo = new Shipment("Jalsena", 20, 9.6);

		// Anonymous Class
		Double anonymousWeight = calculateWeightOnShip(shipTwo, new Function<Shipment, Double>() {
			@Override
			public Double apply(Shipment t) {
				return t.calculateTotalWeight();
			}
		});
		// Lambda Function
		Double lambdaWeight = calculateWeightOnShip(shipOne, ship -> ship.calculateTotalWeight());
		// Method Reference
		Double methodRefWeight = calculateWeightOnShip(shipTwo, Shipment::calculateTotalWeight);

		// Verifying Result
		System.out.println("Second Way:" + "\n anonymousWeight : " + anonymousWeight + "\n lambdaWeight : "
				+ lambdaWeight + "\n methodRefWeight : " + methodRefWeight);
	}

	// To Show How to Pass "Function<internal_parameter, return_type> Object" as a
	// parameter
	public static Double calculateWeightOnShip(Shipment shipment, Function<Shipment, Double> func) {
		return func.apply(shipment);
	}

}

class Shipment {
	private String shipName;
	private Integer numberOfItems;
	private Double weightOfEachItem;

	public Shipment() {
		super();
	}

	public Shipment(String shipName, Integer numberOfItems, Double weightOfEachItem) {
		super();
		this.shipName = shipName;
		this.numberOfItems = numberOfItems;
		this.weightOfEachItem = weightOfEachItem;
	}

	public Double calculateTotalWeight() {
		return (numberOfItems * weightOfEachItem);
	}

	@Override
	public String toString() {
		return "Shipment [shipName=" + shipName + ", numberOfItems=" + numberOfItems + ", weightOfEachItem="
				+ weightOfEachItem + "]";
	}

}
