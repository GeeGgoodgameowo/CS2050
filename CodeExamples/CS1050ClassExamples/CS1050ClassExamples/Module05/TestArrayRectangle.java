
// 1 Fix the way the class is implemented and how the variables are being accessed in main
// 2 Generate Comments  and update with information
// 3 Troubleshoot the problem with the output for area and perimeter


public class TestArrayRectangle {

	public static void main(String[] args) {
		
		System.out.println("Number of rectangles: " + BasicRectangle.getNumberOfRectangles());
		
		BasicRectangle rectangle1 = new BasicRectangle();
		rectangle1.length= 8.5;
		rectangle1.width = 5.2;
		
		System.out.printf("Rectangle width: %.1f and height: %.1f\n",
				rectangle1.width, rectangle1.length);
		
		
	    System.out.println("The area of the rectangle 1 is " + rectangle1.getArea());
	    System.out.println("The perimeter of the rectangle 1 is " + rectangle1.getPerimeter());
		System.out.println("Number of rectangles: " + BasicRectangle.getNumberOfRectangles());
		
		
		BasicRectangle rectangle2 = new BasicRectangle(4, 5);
	    System.out.println("The area of the rectangle 2 is " + rectangle2.getArea());
	    System.out.println("The perimeter of the rectangle 2 is " + rectangle1.getPerimeter());
	    System.out.println("Number of rectangles: " + BasicRectangle.getNumberOfRectangles());
	    
	    //5 In the  code declare a third rectangle
	    
	    //6 Declare an array called rectangles  to store 3 SimpleRectangle’s
	    
	    //7 Assign rectangle1 to index 0, rectangle2 to index 1 and rectangle 3 to index 2.
	    
	    //8 Use the array index to set the width of rectangle3 length to 10.4
	    
	    //9 Use the array index to display the area of rectangle3. 
	    
	    //10 Create a method iterate through the array to print the perimeter of each rectangle
	    
	    
	    //11 Create a method to find  the  index of the rectangle with the largest length 
	    
	    
	    //12 Print the area of the rectangle with the largest length

	    	    	    
	    
	}// end main
	
	
	
} //end TestBasicRectangle Class	
	
	

class BasicRectangle {
	
	  double length = 1;
	  double width = 1;
	  
	  
	  static int numberOfRectangles = 0;
	

	BasicRectangle() {
		  numberOfRectangles++;
	  }
	


	BasicRectangle(double length, double width) {
		  length  = length;
		  width  = width;
		  numberOfRectangles++;
	  }
	

	  double getArea() {
	    return length * width;
	  }
	

	  double getPerimeter() {
	    return 2* (width + length);
	  }
	

	  
	  static int getNumberOfRectangles() {
	    return numberOfRectangles;
	  } 
	  
	  
}// BasicRectangle Class

