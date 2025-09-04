
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CarDealershipTest
{

	public static void main(String[] args)
	{
		final int MAX_NUM_CARS = 5;
		
		//TEST CARS AND DEALERSHIP CLASS 

		Dealership dealership1 = new Dealership("Deb's Dealership", MAX_NUM_CARS);

		try {
			System.out.println("Setting up " + dealership1.getName());
			dealershipSetUp(dealership1, "dealership1.txt");
			System.out.println("Number of cars in dealership: " + dealership1.getNumberCars());
			System.out.println("Adding more cars ");
			
			//TEST WHEN NOT ENOUGH ROOM FOR CARS
			Car car5 = new Car("Porsche", "Spyder", 164200.00);
			Car car6 = new Car("Hyundai", "Ioniq", 29000.00);
			dealership1.addCar(car5);
			dealership1.addCar(car6);
			
			dealership1.displayCars();
			
			// Display the name and price of car with the highest price in the dealership
			//UNCOMMENT WHEN READY TO TEST
			/*
			Car mostExpensive = dealership1.findMostExpensiveCar();
			System.out.println("Car with highest price in dealership ");
			System.out.println("Dealership: " + dealership1.getName());
			System.out.println("Make:        " + mostExpensive.getMake());
			System.out.println("Model:        " + mostExpensive.getModel());
			System.out.println("Price:      " + mostExpensive.getPrice());
			*/

		} catch (FileNotFoundException e) {
			System.out.println("Error: Can't Upload course information\n" + e.getMessage());
		}


	}//end main

	public static void dealershipSetUp(Dealership dealership, String filename) throws FileNotFoundException 
	{

		// ******* ADD CODE *****
		
	}// end dealership set up

}//end garageofcars class

//Represents one car.
class Car {
	private String make;
	private String model;
	private double price;

	public Car(String make, String model, double price) {
		this.make = make;
		this.model = model;
		this.price = price;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public double getPrice () {
		return price;
	}

} // Car


//Represents one dealership.  A dealership has a name and a list of cars for sale.
class Dealership {
	private String name;
	private Car[] cars;
	private int numCars;

	public Dealership(String name, int maxNumCars) {
		// ******* ADD CODE *****

	}


	public String getName() {
		return name;
	}
	
	public int getNumberCars() {
		return numCars;
	}
	

	// Add the incoming car to the dealership if there is room.  
	public void addCar(Car carToAdd) {

		// Ensure there is room in the array to add the car
		// numCars keeps track of the number of cars currently in the array
		// ******* ADD CODE *****

	} // addCar


	// Finds and returns the car with the highest price in the dealership
	public Car findMostExpensiveCar() {

		// Initialize the variables to keep track of the highest price seen so far
		// and that car's location in the array of cars.
		// Start off by setting the highest price to the 1st car in array
		double highestPrice = cars[0].getPrice();
		int highestPriceIndex = 0;

		// ******* ADD CODE *****

		// Return the car with the highest price in the dealership
		return cars[highestPriceIndex];

	} // findMostExpensiveCar


	// Display all cars in the dealership's array
	public void displayCars() {

		// Display a header
		System.out.println("--------------------------------------------");
		System.out.println(name);
		System.out.println("Make \t\t  Model\t\t   Price ");
		System.out.println("--------------------------------------------");

		// ******* ADD CODE *****


	} // displayCars

} // Dealership

