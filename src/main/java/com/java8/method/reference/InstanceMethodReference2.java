package com.java8.method.reference;

import java.util.function.Consumer;

public class InstanceMethodReference2 {

	public static void main(String[] args) {
		Mechanic myWorker = new Mechanic();
		Car carOne = new Car("Jaguar", "Himanshu");
		Car carTwo = new Car("Audi", "Nagpal");
		Car carThree = new Car("Range Rover", "Harry");

		// Anonymous Class
		Consumer<Car> anonymousConsumer = new Consumer<Car>() {
			@Override
			public void accept(Car car) {
				myWorker.work(car);
			}
		};

		// Lambda Function
		Consumer<Car> lambdaConsumer = (car) -> myWorker.work(car);

		// Method Reference
		Consumer<Car> methodRefConsumer = myWorker::work;

		// Verifying
		anonymousConsumer.accept(carOne);
		lambdaConsumer.accept(carTwo);
		methodRefConsumer.accept(carThree);
	}

}

class Mechanic {
	public void work(Car c) {
		System.out.println("Working on Car : " + c.getCarName());
	}
}

class Car {
	private String carName;
	private String ownerName;

	public Car() {
		super();
	}

	public Car(String carName, String ownerName) {
		super();
		this.carName = carName;
		this.ownerName = ownerName;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Override
	public String toString() {
		return "Car [carName=" + carName + ", ownerName=" + ownerName + "]";
	}

}
