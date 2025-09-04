
/*
 * Add comments to the code
 */

public class TestPassArrays {

	public static void main(String[] args) {
			
		System.out.println("Review: Write down answers to the following");
		System.out.println("\tWhen an array is declared and initialize:");
		System.out.println("\tWhat is stored on the stack what is stored on the heap?");		
		System.out.println("\tWhy are array variables  called reference variables?");
		
		//Part 1: explore assigning one array to another
		System.out.println("\nPart 1: ******************************");
		System.out.println("\tSet breakpoint here");
		System.out.println("\tWrite down answers to questions in part1");
	
		System.out.println("\tDeclare and initialize array1 and array2");
		int[] array1 = new int[4];
		int[] array2 = new int[4];		
		
		System.out.println("\tWhat does new return?");
		System.out.println("\tLook at ids being stored in the reference variables");
		System.out.println("\tWhat is stored on the stack what is stored on the heap?");
		
		
		array1[0] = 10;
		array1[1] = 2;
		array1[2] = 45;
		array1[3] = 12;

		array2[0] = 1;
		array2[1] = 112;
		array2[2] = 82;
		
		System.out.println("\tOriginal Arrays");
		System.out.println("\n\tDisplay array1");	
		displayArray(array1);
		System.out.println("\n\tDisplay array2");
		displayArray(array2);
		
		System.out.println("\n\tWrite down the id for array1 and array2");
		System.out.println("\tAssign array1 to array2");
		array2 = array1;
		
		System.out.println("\twrite down the ids for array1 and array2");
		System.out.println("\n\tAfter array2 = array1\n");
		System.out.println("\tWhat happened and why?");
		
		System.out.println("\tDisplay array1\n");	
		displayArray(array1);
		System.out.println("\tDisplay array2\n");
		displayArray(array2);
		
		array1[1] = 9000;
		array2[3] = 1000;
		System.out.println("\tAfter array1[1] = 9000");
		System.out.println("\tAfter array2[3] = 1000");
		System.out.println("\tDisplay array1");	
		displayArray(array1);
		System.out.println("\tDisplay array2");
		displayArray(array2);
		System.out.println("End Part 1: Write down summary of what happened and any questions");
		
		//Part 2 Copy Array 1 one element at a time into arrayCopy
		System.out.println("\nPart 2: ******************************");
		System.out.println("\tSet breakpoint here");
		System.out.println("\tWrite notes as you step through");
		System.out.println("\tAssign each element from array 1 into a copyArray");
		
		int[] arrayCopy = new int[4];
		System.out.println("\tWrite down the ids for array1 and arrayCopy");
		
		// Correct way to copy arrays
		for (int i = 0; i < array1.length; i++) {
			arrayCopy[i] = array1[i];
		}
		System.out.println("\tDisplay array1");	
		displayArray(array1);
		displayArray(array1);
		System.out.println("\tDisplay arrayCopy");
		displayArray(arrayCopy);
		displayArray(array1);
		
		System.out.println("\n\tarray1  at [1] and arrayCopy at [3] are being updated");
		array1[1] = -400;
		arrayCopy[3] = -999;
		System.out.println("\tDisplay array1");	
		displayArray(array1);
		System.out.println("\tDisplay arrayCopy");
		displayArray(arrayCopy);		
		System.out.println("End Part 2: Write down summary of what happened and any questions");
				

		//Part 3 Passing array3 into a method
		System.out.println("\nPart 3: ******************************");
		System.out.println("\tSet breakpoint here and in updatePassedArray");
		System.out.println("\tWrite down notes as you step through");
		System.out.println("\tPassing array3 into a method");
		System.out.println("\tThink about how passing non-primative datatype arrray is passed");
		System.out.println("\tCompared to passing a primitive datatype");
		
		int[] array3 = new int[4];	
		
		
		array3[0] = 100;
		array3[1] = 200;
		array3[2] = 300;
		array3[3] = 400;
		

		System.out.println("\tIn main display array3\n");
		displayArray(array3);
		
		//passing arrays to methods
		System.out.println("\tWrite down the id of array3. What is being passed to method stack? ");
		System.out.println("\tWhat is stored on the stack what is stored on the heap?");
		
		updatePassedArray(array3);
		System.out.println("\tBack in main display array3\n");
		displayArray(array3);
		System.out.println("End Part 3: Write down summary of what happened and questions");
		
		
		//Part 4 Returning arrays from a method
		System.out.println("\nPart 4: ******************************");
		System.out.println("\tSet breakpoint here and in createArray");
		System.out.println("\tWrite down notes as you step through");
		//returning arrays from methods
		System.out.println("\n\tCall method that creates and Returns an array\n");
		int[] numbersArray =  createArray(5);	
		System.out.println("\tBack in main. What is being returned?");
		System.out.println("\tWhat is stored on the stack what is stored on the heap?");
		System.out.println("\tDisplay numbersArray\n");
		displayArray(numbersArray);
		System.out.println("End Part 4: Write down summary of what happened and questions");

	}// end main
	
	public static void updatePassedArray(int passedArray[])
	{		
		System.out.println("\t\t--In updatePassedArray method stack--");
		System.out.println("\t\tWrited down the id for passedArray");
		System.out.println("\t\tWhat was passsed?");
		System.out.println("\t\tDisplay passed array\n");
		displayArray(passedArray);
		System.out.println("\t\tAdd 100 to each array element");
		for (int i = 0; i < passedArray.length; i++) {
			
			passedArray[i] = passedArray[i] +100; 
		} 

		System.out.println("\t\tNotice you can call a method from with in this method to display array\n");
		displayArray(passedArray);
		System.out.println("\t\t--Leaving method stack updatePassedArray--");
		
	}
	
	
	public static int[] createArray (int arraySize)
	{
		System.out.println("\t\t--In method to declare and initialize new array--");
		System.out.println("\t\tHow was arraySize passed?");
		int[] newArray = new int[arraySize];
		for (int i = 0; i < newArray.length; i++) {
			
			newArray[i] = (int)(Math.random() * 10 + 1); 
		} 
		System.out.println("\t\tNotice id in createArray method before returning the array");
		System.out.println("\t\t--Leaving method stack and returning reference variable newArray--");
		return newArray;
	}
	
	public static void displayArray(int passedArray[])
	{
		System.out.println("\t\t\t--In method stack to display passed array--");
		for (int i = 0; i < passedArray.length; i++) {
			
			System.out.printf("\t\t\tarray1[%d] = %d \n",i, passedArray[i]);
		}
		System.out.println("\t\t\t--Leaving method stack to display passed array--");
	}
	
}//end of class