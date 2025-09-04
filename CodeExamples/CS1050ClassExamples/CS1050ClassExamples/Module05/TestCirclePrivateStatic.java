
//comments go here

public class TestCirclePrivateStatic
{

	public static void main(String[] args)
	{
		int totalCircles = CircleWithStaticPrivate.getNumberOfObjects();

		// Create a circle with radius 1
		CircleWithStaticPrivate circle1 = new CircleWithStaticPrivate();
		System.out.println("\nThe area of the circle of radius "
				+ circle1.getRadius() + " is " + circle1.getArea());

		totalCircles = CircleWithStaticPrivate.getNumberOfObjects();

		// Create a circle with radius 25
		CircleWithStaticPrivate circle2 = new CircleWithStaticPrivate(25);

		circle2.setRadius(-1);
		System.out.println("\nThe area of the circle of radius "
				+ circle1.getRadius() + " is " + circle2.getArea());

		totalCircles = CircleWithStaticPrivate.getNumberOfObjects();

		circle2.setRadius(1);
		
	    // Print areas for radius 1, 2, 3, 4, and 5.
	    final int MAX = 5;
	    printAreas(circle2, MAX);

	    // See myCircle.radius and times
	    System.out.println("\n" + "Radius is " + circle2.getRadius());
	    System.out.println("max is " + MAX);
	    
	    totalCircles = CircleWithStaticPrivate.getNumberOfObjects();

	}// end of main

	/** Print a table of areas for radius */
	public static void printAreas(CircleWithStaticPrivate currentCircle, int times) {
		System.out.println("Radius \t\tArea");
		
		//what might be a better loop to use?
		while (times >= 1) {
			System.out.println(currentCircle.getRadius() + "\t\t" + currentCircle.getArea());
			currentCircle.setRadius(currentCircle.getRadius() + 1);
			times--;
		}
	}

}//end TestCirclePrivateStatic

// start of class is after end of class above
//comments would go here

class CircleWithStaticPrivate {

	/** The radius of the circle
	 * Instance Variable
	 * attribute associated with instance of one object */
	private double radius = 1;

	/** 
	 *  The number of the objects created
	 *  Static Variable
	 * Not associated with instance of one object */
	private static int numberOfObjects = 0;

	/** Construct a circle with radius 1 */
	public CircleWithStaticPrivate() {
		numberOfObjects++;
	}

	/** Construct a circle with a specified radius 
	 * overloaded method*/
	public CircleWithStaticPrivate(double newRadius) {
		radius = newRadius;
		numberOfObjects++;
	}

	/** Return radius */
	public double getRadius() {
		return radius;
	}

	/** Set a new radius 
	 * Setter to private variable*/
	public void setRadius(double newRadius) {
		if(newRadius >= 0) 
		{
			radius = newRadius;
		}else
		{
			System.out.println("Need a positive numbers so radius set to 1");
			radius = 1;
		}
	}


	/** Return the area of this circle */
	public double getArea() {
		return radius * radius * Math.PI;
	}

	/** Return numberOfObjects
	 * static method 
	 * do not need instance of an object to determine*/
	public static int getNumberOfObjects() {
		return numberOfObjects;
	}
}