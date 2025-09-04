import java.util.Scanner;   // Scanner class to read input

//import input/output package classes to write to a file 
import java.io.*;

/**
   This program writes data to a file. It makes sure the
   specified file does not exist before opening it.
 */

public class FileWriteDemo2
{
	public static void main(String[] args) throws IOException
	{
		
		//Add comments to explain the code.
				
		String[] categories = {"Class Participation","Guided Exploration",
				"Quizzes","Project Percent","Final Exam"};
		double[] percentWeights = {.12,.22,.22,.22,.22};
		
		// 
		Scanner readKeyboard = new Scanner(System.in);
		
		//
		String filename; 
		System.out.print("Enter the filename with no spaces and include .txt \n");
		filename = readKeyboard.nextLine();

		//
		File gradeFile = new File(filename);
		
		// 
		if (gradeFile.exists())
		{			
			System.out.println("/nThe file " + filename +
					" already exists.");
			
		}else
		{

			//
			PrintWriter outputFile = new PrintWriter(gradeFile);
	
			// 		
			outputFile.println("\nCategories and percentage weights");
			
			for(int categoryColumn = 0; categoryColumn < categories.length; categoryColumn++ )
			{	
				outputFile.printf("%s Grade: %.2f\n", categories[categoryColumn], percentWeights[categoryColumn]);
			}

			String absoluteFilePath = gradeFile.getAbsolutePath();
			System.out.println("\nFile located at " + absoluteFilePath);
			
			// 
			outputFile.close();
		}//end else
		
		
		//
		readKeyboard.close();		
	}//end main

	
	
}//end FileWriteDemo2
