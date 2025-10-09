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
		Book unitTestBook = new Book("Unmasking AI", "Joy Buolamwini", 2023);
		System.out.println("getTitle():   " + unitTestBook.getTitle());
		System.out.println("getAuthor():  " + unitTestBook.getAuthor());
		System.out.println("getYear():    " + unitTestBook.getYear());
		System.out.println("stringOfBookDetails():   " + unitTestBook.stringOfBookDetails());
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
		library.addBook(new Book("Unmasking AI", "Joy Buolamwini", 2023));
		library.addBook(new Book("Hello World", "Hannah Fry", 2018));
		library.addBook(new Book("Race After Technology", "Ruha Benjamin", 2019));
		library.addBook(new Book("Deep Learning", "Ian Goodfellow", 2016));
		library.displayCountPerShelf();
		library.printAllBooks();
		library.displayOldest();
		System.out.println();
		// Row 1
		library.addBook(new Book("Algorithms to Live By", "Brian Christian", 2016));
		library.addBook(new Book("Weapons of Math Destruction", "Cathy O'Neil", 2016));
		library.addBook(new Book("The Mythical Man-Month", "Fred Brooks", 1975));
		library.addBook(new Book("Refactoring", "Martin Fowler", 1999));
		System.out.println();
		// Row 2
		library.addBook(new Book("The Pragmatic Programmer", "Andrew Hunt & David Thomas", 1999));
		library.addBook(new Book("Peopleware", "Tom DeMarco & Tim Lister", 1987));
		library.addBook(new Book("Computer Lib / Dream Machines", "Ted Nelson", 1975));
		library.displayCountPerShelf();
		System.out.println();
		library.printAllBooks();
		library.displayOldest();
		System.out.println();
		System.out.println("Test add more books than capacity...");
		library.addBook(new Book("Filling da Library", "Me, lol", 2025));
		library.addBook(new Book("Extra Title", "Extra Author", 2024)); // should trigger "full" message
		library.displayCountPerShelf();
		library.printAllBooks();
		library.displayOldest(); 
		
	}// end main
}
	
class Book {
	private String title;
	private String author;
	private int year;

	// Book parameters (note: private, with getters listed below //
	
	public Book(String newTitle, String newAuthor, int newYear) {
		title = newTitle;
		author = newAuthor;
		year = newYear;
	}
	
	// Constructor for the Book //
	
	String getTitle() {
		return title;
	}
	
	String getAuthor() {
		return author;
	}
	
	int getYear() {
		return year;
	}
	
	// Getters for Book parameters to follow good encapsulation practice //

	String stringOfBookDetails() {
		return "\"" + title + "\" by " +  author + " (" + year + ")";	
	}
	
	// Return all Book parameters
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
			System.out.println("Library is full. Couldn't add " + book.stringOfBookDetails());
			return false;
		}
		
		bookShelf[currentShelf][currentSlot] = book;
		// put instance of book at array index currentShelf, currentSlot
		
		System.out.println("Added " + book.stringOfBookDetails() + " at shelf " + (currentShelf + 1) + ", slot "
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
			System.out.println("" + currentShelf + "" + currentSlot);
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
					System.out.println (bookShelf[row][column].stringOfBookDetails() + " on Shelf " + (row+1) + " in slot " + (column+1));
				
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
						System.out.println("Oldest Book: " + bookShelf[row][column].stringOfBookDetails());
					}
				}
			}
		}
		// Finds books with the oldest year and prints them
	
	/*
	class printBook extends Book () {
	}
	*/
	}
}