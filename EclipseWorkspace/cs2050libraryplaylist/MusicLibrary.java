/**
 * 
 */
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * 
 */
public class MusicLibrary {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Name the playlist: ");
		MusicPlaylist musicPlaylist = new MusicPlaylist(scanner.next());
		System.out.println("Key CSV file: Project_01.csv");
		System.out.print("Enter CSV filename: ");
		CSVLoader.loadFromCsv(musicPlaylist, scanner.next());
		DisplayMenu.LoadDisplayMenu();
		
		
		/* 
		System.out.println("Project_01.csv");
		System.out.print("Enter CSV filename: ");
		CSVLoader.loadFromCsv(musicPlaylist, scanner.next());
		musicPlaylist.showAllSongs();
	
		
		System.out.println(">>>> DEVELOPMENT TESTING <<<< ");
		
		System.out.println("");
		System.out.println("**************************************");
		System.out.println("");
		System.out.println("USERSTORY4");
		
		
		Song testSongQueue = new Song ("the reaper", "keshi", 199);
		MusicQueue musicQueue = new MusicQueue(musicPlaylist);
		System.out.println("Add song index to add to queue: ");
		musicQueue.addSongQueue();
		musicQueue.displayQueue();	
		
		musicQueue.addSongQueue();
		musicQueue.displayQueue();	
		
		musicQueue.playNext(); */
		
	}

}


class Song {
	private String name;
	private String artist;
	// private String genre;
	// private int releaseYear;
	private int durationSeconds;
	private String durationMinutes;
	
	public Song(String newName, String newArtist, int newdurationSeconds) {
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
	
	/*
	public String getGenre() {
		return genre;
	}
	
	public int getreleaseYear() {
		return releaseYear;
	}
	*/
	// Getters for later functionality
	
	public String getDuration() {
		return durationMinutes;
	}
	// Getter methods for easy future implementation (i.e sorting, organizing, retrieval)
	
	@Override
	public String toString() {
		// return "\"" + name + "\" by " +  artist + " (" + releaseYear + ")" + " [" + genre +", " + durationSeconds + "s]";	
		return "\"" + name + "\" by " +  artist + " (" + durationMinutes + ")";	
	}
	// Return all Song parameters
	
}
	
class MusicPlaylist {
	private String playlistName;
	private ArrayList<Song> songList = new ArrayList<>();
	
	
	public MusicPlaylist (String playlistName) {
		this.playlistName = playlistName;
		this.songList = new ArrayList<Song>();
	}
	// MusicPlaylist constructor
	
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
	
	public void playSong() {
		int nextSongIndex = 0;
		boolean validInput = false;
		Scanner choiceInt = new Scanner(System.in);
		// Secondary scanner specifically for input validation on this method
		
		
		System.out.println("Enter your choice (0-" + (songList.size()-1) + ")");
		while (validInput == false) {
			try {
				nextSongIndex = choiceInt.nextInt();
				if (nextSongIndex >= 0 && nextSongIndex < songList.size()) {
					System.out.println("Now playing: " + (songList.get(nextSongIndex)).toString());
					validInput = true;
				} else {
					choiceInt.nextLine();
					System.out.println("Invalid index");
					System.out.println("Please enter a number between 0 and " + (songList.size()-1));
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid index");
				System.out.println("Please enter a number between 0 and " + (songList.size()-1));
				choiceInt.nextLine();
			}
		}
		choiceInt.close();
		// Close secondary scanner for memory
	}
}

class MusicQueue {
	private Node head;
	private Node tail;
	private MusicPlaylist songList;
	
	public MusicQueue(MusicPlaylist songList) {
		this.songList = songList;
		head = null;
		tail = null;
	}
	// Queue constructor. Both head and tail start empty.
	
	class Node {
		Song song;
		Node next;
		
		public Node (Song song) {
			this.song = song;
			this.next = null;
		}
		// Node constructor
	}
	// Node class for singlylinkedlist dev. Stores Songs
	
	
	public void addSongQueue() {
		int nextQueuedIndex = 0;
		boolean validInput = false;
		Scanner choiceInt = new Scanner(System.in);
		// Secondary scanner specifically for input validation on this method
		
		
		System.out.println("Enter your choice (0-" + (songList.getSize()-1) + ")");
		while (validInput == false) {
			try {
				nextQueuedIndex = choiceInt.nextInt();
				if (nextQueuedIndex >= 0 && nextQueuedIndex < songList.getSize()) {
					validInput = true;
				} else {
					System.out.println("Invalid index. Nothing enqueued.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid index. Nothing enqueued.");
			}
		}
		// Integer validation for queued song choice
		
		/* choiceInt.close();
		// Close secondary scanner for memory */ 
	
		Node queuedSong = new Node (songList.getSong(nextQueuedIndex));
		if (head == null) {
			head = queuedSong;
		// Add input song to both start of queue if empty
		} else {
			Node current = head;
	        while (current.next != null) {
	            current = current.next;
	        }
	        current.next = queuedSong;
		// Otherwise just add it on the end}
		}
		System.out.println("Song added to queue.");
		
		
		
	}
	
	
	public void displayQueue() {
		if (head == null) {
			System.out.println("Queue is empty.");
			return;
		}
		
		Node current = head;
		int index = 0;
		while (current != null) {
			System.out.println("[" + index + "] " + current.song);
			current = current.next;
			index++;
		// Cursor to last node
		}
	}
	
	
	public void playNext() {
		Node removedSong = head;
		if (head == null) {
			System.out.println("Queue is empty.");
		} else {
			head = head.next;
			if (head == null) {
				tail = null;
			}
			// Make queue empty if removing song empties queue.
		}
		System.out.println(removedSong.toString());
		System.out.println("Now playing: " + removedSong.toString());
	}
	
}

class CSVLoader {
	public static void loadFromCsv(MusicPlaylist songList, String filename) {
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
	int duration;
	try{
		duration = Integer.parseInt(durationText);
	} catch (NumberFormatException ex){
	     System.out.println("Line " + lineNumber + ": invalid duration \"" + durationText + "\" → skipping line.");
	     return null; // early return
	}
	return new Song(name, artist, duration);
}
//Parses one CSV line into a Song or returns null if invalid. Expected: name, artist, duration (seconds).
}


class DisplayMenu {
		public static void LoadDisplayMenu() {
			System.out.println("=== Music Playlist Menu ===");
			System.out.println("1. Load Songs from CSV");
			System.out.println("2. Display Playlist");
			System.out.println("3. Play a Song by Index");
			System.out.println("4. Add Song to Up-Next Queue");
			System.out.println("5. Show Up-Next Queue");
			System.out.println("6. Play Next from Queue");
			System.out.println("7. Exit");
		}
		
		
		
}






