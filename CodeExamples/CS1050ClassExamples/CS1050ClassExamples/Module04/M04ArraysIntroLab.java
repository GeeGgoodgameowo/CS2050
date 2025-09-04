
/**
 *  Add comments
 */


import java.util.Scanner;


public class M04ArraysIntroLab
{

	public static void main(String[] args)
	{
					
		
		final int TOTAL_NUMBERS = 5;
		
		Scanner keyboardInput = new Scanner(System.in);
		
		//*** Part 1 Code ****  add comments to explain
		//Declaring Arrays compared to creating an array
		//Determining size of an array
		//Initializing Arrays different ways
		// Iterating through an array
		
		int[] numbersArray = new int[TOTAL_NUMBERS];
		
		int numbersLength = numbersArray.length;
		
		System.out.println("Enter " + numbersLength + " values: ");
		for (int index = 0; index < numbersLength; index++) {
			System.out.printf("Enter value #%d: ", index+1);
			numbersArray[index] = keyboardInput.nextInt();
		}

		
		int[] numbersArray2 = {3, 34, 44, 81, 7}; 
		
		
		//*** Part 2 Code ****  add comments to explain what each sections of code is doing
		
		//2.1: 
		System.out.println("Next the code will UPDATE MESSAGE ");
		for (int index = 0; index < numbersLength; index++) {
			System.out.println("numbers[" + index + "] = " + numbersArray[index]);
		}

		//2.2: 
		System.out.println("Next the code will UPDATE MESSAGE ");
		int badNameVar = 0;
		for (int index = 0; index < numbersArray2.length; index++) {
			badNameVar = badNameVar + numbersArray2[index];
		}
		System.out.println("Update badNameVar = " + badNameVar);

		//2.3 
		System.out.println("Next the code will UPDATE MESSAGE ");
		int badNameVar2 = numbersArray2[0];
		for (int index = 1; index < numbersArray2.length; index++) {
			if (numbersArray2[index] > badNameVar2) {
				badNameVar2 = numbersArray2[index];
			}
		}
		System.out.println("Update badNameVar2 = " + badNameVar2);
		
		//*** Part 3 Write algorithm on paper for 3.2 -3.6  ****
		
		
		// 3.1 Declare new array called randomNumbers to hold 5 numbers 
		
		// 3.2 Fill the randomNumbers array with random numbers from 1 to 10 
		
		// 3.3 Call the method you create where the 
		// randomNumbers array is passed to the method and it display each number in the array
		
		// 3.4 Display only the smallest number in the randomNumbers array (Do not worry about duplicates)
		
		
		// 3.5 Display the index where the smallest number is located (Do not worry about duplicates)
		
		// 3.6 Call the method you create where the 
		// randomNumbers array is passed to the method and it returns the sum of all the numbers


		keyboardInput.close();
		
	} // main
	
	/**
	 *  3.3 method
	 */
	
	
	
	
	/**
	 *  3.6 method
	 */

}
