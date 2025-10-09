/**
 * 
 */

/**
 * 
 */
public class LibraryProject {
	public static void main(String[] args)
	{
		// --- unit test checks for Book --- //
		System.out.println("Unit Test Book Class");
		Book unitTestBook = new PrintBook("Unmasking AI", "Joy Buolamwini", 2023);
		System.out.println("getTitle():   " + unitTestBook.getTitle());
		System.out.println("getAuthor():  " + unitTestBook.getAuthor());
		System.out.println("getYear():    " + unitTestBook.getYear());
		System.out.println("stringOfBookDetails():   " + unitTestBook.toString());
		System.out.println();
		
		// --- Clear Book unit test, proceeding --- // 
		
		System.out.println("Setting up Test Library");
		int numberOfShelves = 3;
		int shelfCapacity = 4;
		System.out.println("Shelves (rows): " + numberOfShelves);
		System.out.println("Slots per shelf (columns): " + shelfCapacity);
		System.out.println("Total capacity: " + (numberOfShelves * shelfCapacity));
		System.out.println();
		Library library = new Library("Test Library", numberOfShelves, shelfCapacity);
		library.displayCountPerShelf(); 
		// Creating an EMPTY library 
		
		// --- Clear Library with Shelves unit test, proceeding --- // 

		library.printAllBooks();
		library.displayOldest();
		System.out.println();
		// --- Clear Display All Books unit test, proceeding --- // 
		

		// Row 0
		library.addBook(null);
		library.addBook(new PrintBook("Unmasking AI", "Joy Buolamwini", 2023));
		library.addBook(new PrintBook("Hello World", "Hannah Fry", 2018));
		library.addBook(new PrintBook("Race After Technology", "Ruha Benjamin", 2019));
		library.addBook(new PrintBook("Deep Learning", "Ian Goodfellow", 2016));
		library.displayCountPerShelf();
		library.printAllBooks();
		library.displayOldest();
		System.out.println();
		// Row 1
		library.addBook(new PrintBook("Algorithms to Live By", "Brian Christian", 2016));
		library.addBook(new PrintBook("Weapons of Math Destruction", "Cathy O'Neil", 2016));
		library.addBook(new PrintBook("The Mythical Man-Month", "Fred Brooks", 1975));
		library.addBook(new PrintBook("Refactoring", "Martin Fowler", 1999));
		System.out.println();
		// Row 2
		library.addBook(new PrintBook("The Pragmatic Programmer", "Andrew Hunt & David Thomas", 1999));
		library.addBook(new PrintBook("Peopleware", "Tom DeMarco & Tim Lister", 1987));
		library.addBook(new PrintBook("Computer Lib / Dream Machines", "Ted Nelson", 1975));
		library.displayCountPerShelf();
		System.out.println();
		library.printAllBooks();
		library.displayOldest();
		System.out.println();
		System.out.println("Test add more books than capacity...");
		library.addBook(new PrintBook("Filling da Library", "Me, lol", 2025));
		library.addBook(new PrintBook("Extra Title", "Extra Author", 2024)); // should trigger "full" message
		library.displayCountPerShelf();
		library.printAllBooks();
		library.displayOldest(); 
		// End Test Library, make a new test library for both print books and ebooks
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("New, mixed Library test:");
		numberOfShelves = 3;
		shelfCapacity = 2;
		Library libraryMix = new Library("Test Mixed Library", numberOfShelves, shelfCapacity);
		libraryMix.addBook(null);
		libraryMix.addBook(new PrintBook("Unmasking AI", "Joy Buolamwini", 2023));
		libraryMix.addBook(new EBook("Experimental EBook", "Me, Myself", 2025));
		libraryMix.addBook(new PrintBook("Race After Technology", "Ruha Benjamin", 2019));
		libraryMix.addBook(new EBook("Experimental EBook, The Sequel", "and I", 2025));
		libraryMix.printAllBooks();
		libraryMix.displayOldest();
		
		
		
	}// end main
}
	
abstract class Book {
	private String title;
	private String author;
	private int year;
	/*
	private String bookType;
	private int daysLate;
	private double dailyLateFee;
	*/
	// Book parameters (note: private, with getters listed below //
	
	
	public Book(String newTitle, String newAuthor, int newYear) {
		title = newTitle;
		author = newAuthor;
		year = newYear;
	}
	// Constructor for the Book //
	
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getYear() {
		return year;
	}
	
	// Getters for Book parameters to follow good encapsulation practice //

	@Override
	public String toString() {
		return "\"" + title + "\" by " +  author + " (" + year + ")" + " [Print, " + getLoanDays() + " days, $" + getDailyLateFee() + "/day]";	
	}
	// Return all Book parameters
	
	public abstract int getLoanDays();
	public abstract double getDailyLateFee();
	
	// Shared behavior using polymorphism
	/** Calculates the late fee based on subclass policy. */
	public final double calculateLateFee(int daysLate){
		double lateFee = 0;
		if (daysLate > 0){
			lateFee = daysLate * getDailyLateFee();
		}
		return lateFee;
	}
}


class Library {
	private String name;
	private Book[][] bookShelf; 
	private int numberOfShelves;
	private int shelfCapacity;
	private int currentShelf;
	private int currentSlot;
	private boolean isFull;
	private int totalBookCapacity = (numberOfShelves * shelfCapacity);
	// ^ or the length of the bookShelf array? 
	private int currentTotalBooks;
	private int booksOnShelf;
	
	// Library parameters for encapsulation
	public Library(String name, int numberOfShelves, int shelfCapacity){
		this.name = name;
		this.numberOfShelves = numberOfShelves;
		this.shelfCapacity = shelfCapacity;
		// Library parameters are specified to the instance of the object
		
		this.bookShelf = new Book[numberOfShelves][shelfCapacity];
		// Fills each spot on the bookshelf with an empty Book object
		
		this.totalBookCapacity = (numberOfShelves * shelfCapacity);
		this.currentTotalBooks = 0;
		this.currentShelf = 0;
		this.currentSlot = 0;
		this.booksOnShelf = 0;
		this.isFull = false;
		// Assigning base values to instance of Library to avoid null exceptions
		
	}
	// Library constructor
	
	String getName() {
		return name;
	}
	
	public boolean addBook(Book book) {
		if (book == null){
			System.out.println("Invalid book.");
			return false;
		}
		// if the book is invalid in any way, return false
		
		if (isFull){
			System.out.println("Library is full. Couldn't add " + book.toString());
			return false;
		}
		
		bookShelf[currentShelf][currentSlot] = book;
		// put instance of book at array index currentShelf, currentSlot
		
		System.out.println("Added " + book.toString() + " at Shelf " + (currentShelf + 1) + ", Slot "
				+ (currentSlot + 1));
		// move cursory slot with statement confirmation
		
		currentTotalBooks = currentTotalBooks + 1;
		booksOnShelf = booksOnShelf + 1;
		
		if (currentTotalBooks >= totalBookCapacity){
			isFull = true;
		} else{
			int nextIndex = currentTotalBooks; 
			currentShelf = nextIndex / shelfCapacity;
			currentSlot = nextIndex % shelfCapacity;
		}
		return true;
	}
	
	
	public void displayCountPerShelf() {
		for (int row = 0; row < numberOfShelves; row++) {
			int runningCount = 0;
			for (int column = 0; column < shelfCapacity; column++) {
				if (bookShelf[row][column] != null) {
					runningCount = runningCount + 1;
				}
			}
			System.out.println("Books on shelf " + (row+1) + " = " + runningCount);
		}
	}
	
	public void printAllBooks() {
		System.out.println("Showing all books:");
		if (currentTotalBooks == 0) {
			System.out.println ("Cannot show books -> Empty library.");
			return;
		}
		for (int row = 0; row < numberOfShelves; row++) {
			for (int column = 0; column < shelfCapacity; column++) {
				if (bookShelf[row][column] != null) {
					System.out.println (bookShelf[row][column].toString() + " on Shelf " + (row+1) + " in Slot " + (column+1));
				
				}
			}
		}
		// nested for loops, print each book class in each index
	}
	
	
	public void displayOldest() {
		if (currentTotalBooks == 0) {
			System.out.println ("Cannot display oldest -> Empty library.");
			return;
		}
		
		int oldestYear = bookShelf[0][0].getYear();
		
		for (int row = 0; row < numberOfShelves; row++) {
			for (int column = 0; column < shelfCapacity; column ++) {
				if (bookShelf[row][column] != null) {
					if (bookShelf[row][column].getYear() < oldestYear) {
						oldestYear = bookShelf[row][column].getYear();
					}
				}
			}
		}
		// Finds the oldest year on the bookshelf
		
		System.out.println("Oldest publication year = " + oldestYear);
		// Prints oldest year
		
		for (int row = 0; row < numberOfShelves; row++) {
			for (int column = 0; column < shelfCapacity; column ++) {
				if (bookShelf[row][column] != null) {
					if (bookShelf[row][column].getYear() == oldestYear)  {
						System.out.println("Oldest Book: " + bookShelf[row][column].toString());
					}
				}
			}
		}
		// Finds books with the oldest year and prints them
	}
}	

class PrintBook extends Book {
	private String title;
	private String author;
	private int year;
	
	public PrintBook(String title, String author, int year) {
		super(title, author, year);
		this.title = title;
		this.author = author;
		this.year = year;
	}
	
	
	@Override
	public String toString() {
		return "\"" + title + "\" by " +  author + " (" + year + ")" + " [Print, " + getLoanDays() + " days, $" + getDailyLateFee() + "/day]";	
	}
	@Override
	public int getLoanDays() {
		return 21;
	}
		
	@Override
	public double getDailyLateFee() {
		return .25;
	}
	
}
	
class EBook extends Book {
	private String title;
	private String author;
	private int year;
	
	public EBook(String title, String author, int year) {
		super(title, author, year);
		this.title = title;
		this.author = author;
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "\"" + title + "\" by " +  author + " (" + year + ")" + " [EBook, " + getLoanDays() + " days, $" + getDailyLateFee() + "/day]";	
	}
		
	public int getLoanDays() {
		return 14;
	}
		
	public double getDailyLateFee() {
		return .10;
	}
}