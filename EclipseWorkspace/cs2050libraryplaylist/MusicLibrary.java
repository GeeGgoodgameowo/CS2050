/**
 * 
 */
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map; // Also added in iteration 2 for key-value pairs (hashmap purposes)
import java.util.HashMap; // iteration 2 update for sorting
import java.util.Comparator; // iteration 2 update for fast lookup by ID
/**
 * 
 */
public class MusicLibrary {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Iteration 02: expanded menu but same structure as Iteration 01
				final int MENU_END = 9;
				final String[] menuItems =
				{ "Load Songs from CSV", // 1
						"Display Playlist", // 2
						"Play Song by Index", // 3
						"Add Song to Up-Next Queue", // 4
						"Show Up-Next Queue", // 5
						"Play Next Song in Up-Next Queue", // 6
						"Search Songs (by ID or Artist)", // 7 (User Story 8)
						"View Playlist Sorted", // 8 (User Story 9)
						"Exit" // 9
				};
				final String menuPrompt = "Enter your choice (1–" + MENU_END + "): ";
				Scanner keyboardScanner = new Scanner(System.in);
				System.out.print("Enter CSV filename: ");
				String playlistname = keyboardScanner.next();
				MusicPlaylist manager = new MusicPlaylist(playlistname);
				MusicQueue queue = new MusicQueue(manager);
				int choice;
				do
				{
					System.out.println("\n=== Music Playlist Menu ===");
					for (int i = 0; i < menuItems.length; i++)
					{
						System.out.println((i + 1) + ". " + menuItems[i]);
					}
					choice = getValidInt(keyboardScanner, menuPrompt, 1, MENU_END);
					switch (choice)
					{
					case 1:
					{
						// User Story 1 — Load my music (UPDATED with IDs in Iteration 02)
						System.out.print("Enter CSV filename: ");
						String filename = keyboardScanner.next();
						boolean loaded = CSVLoader.loadFromCsv(manager, filename);
						if (!loaded)
						{
							System.out.println("No songs were loaded.");
							System.out.println("Working directory: " + java.nio.file.Paths.get("").toAbsolutePath());
						} else
						{
							// Iteration 02 UPDATE (User Story 8): build HashMap for ID lookup after loading
							manager.buildByIdMap();
						}
						break;
					}
					case 2:
					{
						// User Story 2 — See what’s in the playlist
						manager.showAllSongs();
						break;
					}
					case 3:
					{
						// User Story 3 — Play a specific song now (by index, as in Iteration 01)
						if (manager.getSize() == 0)
						{
							System.out.println("Playlist is empty.");
						} else
						{
							int index = getValidInt(keyboardScanner, "Enter index to play: ", 0, manager.getSize() - 1);
							Song song = manager.playSong(index);
							if (song == null)
							{
								System.out.println("Invalid index.");
							} else
							{
								System.out.println("Now playing: " + song);
							}
						}
						break;
					}
					case 4:
					{
						// User Story 4 — Add songs to the Up-Next linked list queue
						if (manager.getSize() == 0)
						{
							System.out.println("Playlist is empty.");
						} else
						{
							int addIdx = getValidInt(keyboardScanner, "Enter song number to add to Up-Next Queue: ", 0,
									manager.getSize() - 1);
							boolean ok = queue.addSongQueue(addIdx);
							if (ok)
							{
								System.out.println("Song added to Up-Next Queue.");
							} else
							{
								System.out.println("Invalid index. Nothing added.");
							}
						}
						break;
					}
					case 5:
					{
						// User Story 5 — See what’s coming up in Up-Next queue
						queue.displayQueue();
						break;
					}
					case 6:
					{
						// User Story 6 — Play the next song in Up-Next queue
						Song next = queue.playNext();
						if (next == null)
						{
							System.out.println("Up-Next Queue is empty (head is null).");
						} else
						{
							System.out.println("Now playing: " + next);
						}
						break;
					}
					case 7:
					{
						// User Story 8 — Unique Song IDs & Fast Lookup
						System.out.println("\nSearch Options");
						System.out.println("1. Find song by ID");
						System.out.println("2. List songs by artist");
						int searchChoice = getValidInt(keyboardScanner, "Enter search choice: ", 1, 2);
						if (searchChoice == 1)
						{
							System.out.print("Enter song ID (e.g., S1000): ");
							String id = keyboardScanner.next();
							manager.playSongById(id);
						} else
						{
							System.out.print("Enter artist name: ");
							keyboardScanner.nextLine(); 
							// REPLACED FROM NEXT IN ORDER TO CATCH ARTIST NAMES OF MULITPLE WORDS
							String artist = keyboardScanner.nextLine();
							manager.displaySongsByArtist(artist);
						}
						break;
					}
					case 8:
					{
						// User Story 9 — Sort the Playlist
						System.out.println("\nSort Options");
						System.out.println("1. Sort by title A–Z");
						System.out.println("2. Sort by duration longest first");
						int sortChoice = getValidInt(keyboardScanner, "Enter sort choice: ", 1, 2);
						if (sortChoice == 1)
						{
							manager.displayPlaylistSortedByTitle();
						} else
						{
							manager.displayPlaylistSortedByDuration();
						}
						break;
					}
					case 9:
					{
						System.out.println("Goodbye!");
						break;
					}
					}
				} while (choice != MENU_END);
				keyboardScanner.close();
			}
			/**
			 * Prompt for an integer in [min, max] and keep prompting until valid
			 *
			 * @param scanner source of input
			 * @param prompt  message to display each time
			 * @param min     minimum allowed value (inclusive)
			 * @param max     maximum allowed value (inclusive)
			 * @return a valid integer in the specified range
			 */
			public static int getValidInt(Scanner scanner, String prompt, int min, int max)
			{
				int value = min - 1; // start invalid for boolean flag
				boolean valid = false;
				while (!valid)
				{
					System.out.print(prompt);
					if (scanner.hasNextInt())
					{
						value = scanner.nextInt();
						if (value >= min && value <= max)
						{
							valid = true; // exit condition
						} else
						{
							System.out.println("Please enter a number between " + min + " and " + max + ".");
						}
					} else
					{
						System.out.println("Invalid input. Please enter a whole number.");
						scanner.next(); // clear if not valid int
					}
				}
				return value;
			}
		}



class Song {
	private String name;
	private String artist;
	private int size;
	// private String genre;
	// private int releaseYear;
	private int durationSeconds;
	private String durationMinutes;
	private final String uniqueID;
	// final keyword ensures uniqueIDs do not change 
	
	public Song(String newuniqueID, String newName, String newArtist, int newdurationSeconds) {
		uniqueID = newuniqueID;
		name = newName;
		artist = newArtist;
		// genre = newGenre;
		// releaseYear = newreleaseYear;
		durationSeconds = newdurationSeconds;	
		
		if (durationSeconds % 60 < 10) {
			durationMinutes = (durationSeconds / 60) + ":0" + (durationSeconds % 60);
		} else {
			durationMinutes = (durationSeconds / 60) + ":" + (durationSeconds % 60);
		}
		// Format conversion of durationSeconds
		
	}
	// Constructor for the song
	
	public String getName() {
		return name;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getID() {
		return uniqueID;
	}
	
	/*
	public String getGenre() {
		return genre;
	}
	
	public int getreleaseYear() {
		return releaseYear;
	}
	*/
	// Getters for later functionality
	
	public int getDurationInt() {
		return durationSeconds;
	}
	
	public String getDuration() {
		return durationMinutes;
	}
	// Getter methods for easy future implementation (i.e sorting, organizing, retrieval)
	
	@Override
	public String toString() {
		// return "\"" + name + "\" by " +  artist + " (" + releaseYear + ")" + " [" + genre +", " + durationSeconds + "s]";	
		return uniqueID + " \"" + name + "\" by " +  artist + " (" + durationMinutes + ")";	
	}
	// Return all Song parameters
	
}
	
class MusicPlaylist {
	private String playlistName;
	private ArrayList<Song> songList = new ArrayList<>();
	private HashMap<String, Song> songIdMap;
	
	public MusicPlaylist (String playlistName) {
		this.playlistName = playlistName;
		this.songList = new ArrayList<Song>();
        this.songIdMap = new HashMap<>();
		
	}
	
	public void playSongById(String id) {
	    Song song = songIdMap.get(id);
	    if (song == null) {
	        System.out.println("No song found with ID: " + id);
	    } else {
	        System.out.println("Found: " + song); 
	    }
	}
	// MusicPlaylist constructor		

	 public void buildByIdMap() {
	        songIdMap.clear(); 
	        // Clear previous entries
	        
	        for (Song song : songList) {
	            songIdMap.put(song.getID(), song); 
	            // Add song to HashMap with ID as key
	        }
	    }
		
	public void displayPlaylistSortedByDuration() {
		 ArrayList<Song> sortPlaylist = new ArrayList<>(songList);
	        sortPlaylist.sort((a, b) -> Integer.compare(b.getDurationInt(), a.getDurationInt()));
	        for (Song sortedSong : sortPlaylist) {
	        	System.out.println(sortedSong);
	    }
		// Make a new copy of the songlist, use comparator to compare with duration in returning integer. Print for each song in playlist
	}
	
	public void displayPlaylistSortedByTitle() {
		ArrayList<Song> sortPlaylist = new ArrayList<>(songList);
        sortPlaylist.sort(Comparator.comparing(Song::getName));
        for (Song sortedSong : sortPlaylist) {
        	System.out.println(sortedSong);
        }
        // Make a new copy of the songlist, use comparator to compare title.  Print for each song in playlist
	}
	
	
	public String getName() {
		return playlistName;
	}
	
	public int getSize() {
		return songList.size();
	}
	// Playlist name getter
	
	public Song getSong(int index) {
		return songList.get(index);
	}
	
	public String getSongString(int index) {
		return songList.get(index).toString();
	}
	// Specific Song getters at index
	
	
	public boolean addSong(Song song) {
		boolean validAdd = false;
		if (song == null){
			System.out.println("Invalid song.");
			return validAdd;
		}
		else {
			songList.add(song);
			validAdd = true;
			return validAdd;
		}
	}
	// Adds object Song to arrayList
	
	
	public void showAllSongs() {
		if (songList.size() == 0) {
			System.out.println ("Playlist is empty.");
			return;
		}
		for (int i = 0; i < songList.size(); i++) {
			System.out.println("["+ i + "] " + (songList.get(i)).toString());
		}
		System.out.println("");
	}
	// Iterates over size of Playlist, printing object at each index
	
	public Song playSong(int choice) {
		if (songList.size() == 0) {
			System.out.println("Playlist empty -> import songs.");
			return null;
		}
		return songList.get(choice);
	}
	
	/* class songHashMap () {
		public void playSongById(String id) {
			// TODO Auto-generated method stub
			
		} */


		public void displaySongsByArtist(String searchArtist) {
			System.out.println("Songs by " + searchArtist + ":");
			boolean artistFound = false;
			
	        for (Song artistSongs : songList) {
	            if (artistSongs.getArtist().equalsIgnoreCase(searchArtist)) {
	                System.out.println(artistSongs);
	                artistFound = true;
	            }
	        }
		    if (artistFound = false) {
		            System.out.println("No songs available for " + searchArtist + ".");
		      }
		    }
		}
	


class MusicQueue<T extends Song> {
	// extends functionality implemented due to not defining the queue independently from the data. Needs data from the songList for functionality
    private Node<T> head;
    private Node<T> tail;
    private int size;
    private MusicPlaylist songList;

    public MusicQueue(MusicPlaylist songList) {
        this.songList = songList;
        head = null;
        tail = null;
        this.size = 0;
    }

    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }
    }
    // re=iteration to implement generics

    public boolean addSongQueue(int songID) {
        if (songList.getSize() == 0) {
            System.out.println("No songs added in library, queue unavailable.");
            return false;
        }

        Song songQueue = songList.getSong(songID);
        
        
        Node<T> addNode = new Node<>((T) songQueue);
        // node using the data from the queue
        
        if (head == null) {
            head = addNode;
            tail = addNode;
        } else {
            tail.next = addNode;
            tail = addNode;
        }

        size++;
        return true;
    }

    public void displayQueue() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return;
        }

        Node<T> current = head;
        int index = 0;
        while (current != null) {
            System.out.println("[" + index + "] " + current.data);
            current = current.next;
            index++;
        }
    }

    public T playNext() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return null;
        }

        T song = head.data;
        head = head.next;
        // NO NODE declaration because of data comparison

        if (head == null) {
            tail = null;
        }

        size--;
        // track queue size
        return song;
    }
}



class CSVLoader {
	public static boolean loadFromCsv(MusicPlaylist songList, String filename) {
    try (Scanner fileScan = new Scanner(new File(filename))){
	int lineNumber = 0;
	while (fileScan.hasNextLine()){
		String line = fileScan.nextLine();
		lineNumber++;
		Song parsed = parseSongLine(line, lineNumber);
		if (parsed != null){
		     boolean added = songList.addSong(parsed);
		     if (!added){
		    	 System.out.println("Line " + lineNumber + ": playlist full or invalid song.");
			}
		}
	}
      } catch (FileNotFoundException ex){
		System.out.println("Could not open file: " + filename);
     }
   // parseSongLine over the length of the csv file
    
   System.out.println("Loading complete. Loaded " + songList.getSize() + " songs.");
   // Everything post-csv loaded
   return true;
}
	
private static Song parseSongLine(String line, int lineNumber){
	if (line == null){
		System.out.println("Line " + lineNumber + ": empty line.");
		return null; // early return
	}
	String[] parts = line.split(",");
	if (parts.length != 3){
	      System.out.println("Line " + lineNumber + ": wrong number of fields → " + line);
	      return null; // early return
	}
	String name = parts[0].trim();
	String artist = parts[1].trim();
	String durationText = parts[2].trim();
	String uniqueID = "S10" + lineNumber; // iteration 2 addition
	int duration;
	try{
		duration = Integer.parseInt(durationText);
	} catch (NumberFormatException ex){
	     System.out.println("Line " + lineNumber + ": invalid duration \"" + durationText + "\" → skipping line.");
	     return null; // early return
	}
	return new Song(uniqueID, name, artist, duration);
}
//Parses one CSV line into a Song or returns null if invalid. Expected: name, artist, duration (seconds).
}