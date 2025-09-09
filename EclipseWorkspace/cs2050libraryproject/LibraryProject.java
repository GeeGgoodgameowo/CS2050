/**
 * 
 */

/**
 * 
 */
public class LibraryProject {
	public static void main(String[] args)
	{
		// --- unit test checks for Book ---
		System.out.println("Unit Test Book Class");
		Book unitTestBook = new Book("Unmasking AI", "Joy Buolamwini", 2023);
		System.out.println("getTitle():   " + unitTestBook.getTitle());
		System.out.println("getAuthor():  " + unitTestBook.getAuthor());
		System.out.println("getYear():    " + unitTestBook.getYear());
		System.out.println("stringOfBookDetails():   " + unitTestBook.stringOfBookDetails());
		System.out.println();
		
		// Clear Book unit test, proceeding // 
		
		System.out.println("Setting up Test Library");
		int numberOfShelves = 3;
		int shelfCapacity = 4;
		System.out.println("Shelves (rows): " + numberOfShelves);
		System.out.println("Slots per shelf (columns): " + shelfCapacity);
		System.out.println("Total capacity: " + (numberOfShelves * shelfCapacity));
		System.out.println();
		Library library = new Library("Test Library", numberOfShelves, shelfCapacity);
		library.displayCountPerShelf();
		library.printAllBooks();
		library.displayOldest();
		// Row 0
		library.addBook(null);
		library.addBook(new Book("Unmasking AI", "Joy Buolamwini", 2023));
		library.addBook(new Book("Hello World", "Hannah Fry", 2018));
		library.addBook(new Book("Race After Technology", "Ruha Benjamin", 2019));
		library.addBook(new Book("Deep Learning", "Ian Goodfellow", 2016));
		library.displayCountPerShelf();
		library.printAllBooks();
		library.displayOldest();
		// Row 1
		library.addBook(new Book("Algorithms to Live By", "Brian Christian", 2016));
		library.addBook(new Book("Weapons of Math Destruction", "Cathy O'Neil", 2016));
		library.addBook(new Book("The Mythical Man-Month", "Fred Brooks", 1975));
		library.addBook(new Book("Refactoring", "Martin Fowler", 1999));
		// Row 2
		library.addBook(new Book("The Pragmatic Programmer", "Andrew Hunt & David Thomas", 1999));
		library.addBook(new Book("Peopleware", "Tom DeMarco & Tim Lister", 1987));
		library.addBook(new Book("Computer Lib / Dream Machines", "Ted Nelson", 1975));
		library.displayCountPerShelf();
		library.printAllBooks();
		library.displayOldest();
		System.out.println();
		System.out.println("Test add more books than capacity...");
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
	public int currentTotalBooks;
	
	
	// Library parameters for encapsulation
	
	public Library(String newName, int newNumberOfShelves, int newShelfCapacity){
		name = newName;
		numberOfShelves = newNumberOfShelves;
		shelfCapacity = newShelfCapacity;
	}
	
	// Library constructor //
	
	String getName() {
		return name;
	}
	
	// THIS IS NOT MY CODE LMAO, STUDY THIS FIRST //
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
		// needs an isFull statement for library, returns false if isFull is true
		
		bookShelf[currentShelf][currentSlot] = book;
		// put a book at array index currentShelf, currentSlot
		
		System.out.println("Added " + book.stringOfBookDetails() + " at shelf " + (currentShelf + 1) + ", slot "
				+ (currentSlot + 1));
		// move cursory slot with statement confirmation
		
		currentTotalBooks = currentTotalBooks + 1;
		// --> ADD THIS VARIABLE -- running count of books added

		if (currentTotalBooks >= totalBookCapacity){
			isFull = true;
		} else{
			int nextIndex = currentTotalBooks; 
			currentShelf = nextIndex / shelfCapacity;
			currentSlot = nextIndex % shelfCapacity;
		}
		return true;
	}
	
	int displayCountPerShelf() {
		
	}
	
	String printAllBooks() {
		for (int i = 0; i < shelfCapacity; i++) {
			for (int j = 0; )
		}
		// nested for loops, print each book class in each index
	}
	
	String displayOldest() {
		// if null not found, take first book year 
	}
	
}