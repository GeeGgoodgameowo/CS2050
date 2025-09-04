/**
 * Calculate the BMI using formula in US units. 
 * User will enter weight in pounds and height in inches
 */

// ADD CODE to import Scanner class

public class BodyMassIndexActivity
{

	public static void main(String[] args)
	{
		// constants
		final int BMI_US_FACTOR = 703; // factor formula in pounds
		// Variables
		double weight; // The user's weight
		double height; // The user's height
		double bmi; // The user's BMI

		// Create a Scanner object for scanning input from keyboard
		// ADD CODE name object variable input

		// Tell the user what the program will do.
		System.out.println("This program will calculate your " + "body mass index, or BMI.");

		// Get the user's weight.
		System.out.print("Enter your weight, in pounds: ");
		// ADD CODE to input next double for weight

		// Get the user's height.
		System.out.print("Enter your height, in inches: ");
		// ADD CODE input next double for height

		// Calculate the user's body mass index.
		bmi = weight * BMI_US_FACTOR / (height * height);

		// Display the user's BMI.
		System.out.printf("Your body mass index (BMI) is %f", bmi);

	}
}