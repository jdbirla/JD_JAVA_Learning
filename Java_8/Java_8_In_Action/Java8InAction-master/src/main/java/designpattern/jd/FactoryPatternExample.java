package designpattern.jd;

abstract class Vehicle {

	public abstract int getWheel();

	public String toString() {

		return "Wheel :" + this.getWheel();
	}
}

	class Car extends Vehicle {
		int wheel;

		public Car(int wheel) {
			super();
			this.wheel = wheel;
		}

		@Override
		public int getWheel() {
			return this.wheel;
		}

	}
	
	class Bike extends Vehicle {
		int wheel;

		public Bike(int wheel) {
			super();
			this.wheel = wheel;
		}

		@Override
		public int getWheel() {
			return this.wheel;
		}

	}
	
	class VehicleFactory{
		public static Vehicle getInstance(String instanceType, int wheel)
		{
			if(instanceType=="Car")
				return new Car(wheel);
			else if(instanceType=="Bike")
				return new Bike(wheel);
			
			return null;
		}
	}


public class FactoryPatternExample {
	

	  public static void main(String[] args) {
		    Vehicle car = VehicleFactory.getInstance("Car", 4);
		    System.out.println(car);
		    
		    Vehicle bike = VehicleFactory.getInstance("Car", 2);
		    System.out.println(bike);
		  }
}
