import java.util.Arrays;
import java.util.Iterator;

public class SongsOfThe80s implements SongIterator{
	
	// Create an array of SongInfo Objects
	
	SongInfo[] bestSongs;
	
	// Used to increment to the next position in the array
	
	int arrayValue = 0;
	
	public SongsOfThe80s() {
		
		bestSongs = new SongInfo[3];
		
		addSong("Roam", "B 52s", 1989);
		addSong("Cruel Summer", "Bananarama", 1984);
		addSong("Head Over Heels", "Tears For Fears", 1985);
		
	}
	
	// Add a SongInfo Object to the array and increment to the next position
	
	public void addSong(String songName, String bandName, int yearReleased){
		
		SongInfo song = new SongInfo(songName, bandName, yearReleased);
			
		bestSongs[arrayValue] = song;
		
		arrayValue++;
		
	}
	
	// This is replaced by the Iterator
	
	public SongInfo[] getBestSongs(){
		
		return bestSongs;
		
	}

	// NEW By adding this method I'll be able to treat all
	// collections the same
		
	@Override
	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return Arrays.asList(bestSongs).iterator();	
	}
	
}