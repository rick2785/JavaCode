import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Polygon;
import java.awt.Rectangle; 
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

// Extending the Polygon class because I'm drawing Polygons

class Rock extends Polygon{
	
	// Upper left hand corner of the Polygon
	
	int uLeftXPos, uLeftYPos;
	
	// Used to change the direction of the asteroid when 
	// it hits something and determines how fast it moves
	
	int xDirection = 1;
	int yDirection = 1;
	
	// Define rock height and width
	
	int rockWidth = 26;
	int rockHeight = 31;
	
	// Copy of the Rock ArrayList
	// Holds every Rock I create
	
	static ArrayList<Rock> rocks = new ArrayList<Rock>();
	
	// For JApplet
	// int width = ExampleBoard.WIDTH;
	// int height = ExampleBoard.HEIGHT;
	
	// Get the board width and height
	
	int width = GameBoard.boardWidth;
	int height = GameBoard.boardHeight;
	
	// Will hold the x & y coordinates for the Polygons
	
	int[] polyXArray, polyYArray;
	
	// x & y positions available for other methods
	// There will be more Polygon points available later
	
	public static int[] sPolyXArray = {10,17,26,34,27,36,26,14,8,1,5,1,10};
	public static int[] sPolyYArray = {0,5,1,8,13,20,31,28,31,22,16,7,0};
	
	// NEW Keep track of whether Rock is on screen
	
	public boolean onScreen = true;
	
	// NEW Sound file names
	// The JavaSound api allows wavs, au, aiff files
	
	String explodeFile = "file:./src/explode.wav";
	
	// Creates a new asteroid 
	
	public Rock(int[] polyXArray, int[] polyYArray, int pointsInPoly, int randomStartXPos, int randomStartYPos){
		
		// Creates a Polygon by calling the super or parent class of Rock Polygon
		
		super(polyXArray, polyYArray, pointsInPoly);
		
		// Randomly generate a speed for the Polygon
		
		this.xDirection = (int) (Math.random() * 4 + 1);
		
		this.yDirection = (int) (Math.random() * 4 + 1);
		
		// Holds the starting x & y position for the Rock
		
		this.uLeftXPos = randomStartXPos;
		
		this.uLeftYPos = randomStartYPos;
		
	}
	
	// Creates a bounding rectangle for collision checking
	
	public Rectangle getBounds() {
		
        return new Rectangle(super.xpoints[0], super.ypoints[0], rockWidth, rockHeight);
        
    }

	// NEW move receives SpaceShip and Torpedos now
	public void move(SpaceShip theShip, ArrayList<PhotonTorpedo> torpedos){
		
		// This rectangle surrounds the rock I'll check against
		// all of the other rocks below
		
		Rectangle rockToCheck = this.getBounds();
		
		// Cycle through all the other rocks and check if they
		// cross over the rectangle I created above
		
		for(Rock rock : rocks){
			
			// NEW Is rock viewable
			
			if(rock.onScreen){
			
			// Creates a bounding rectangle that is used temporarily
			// for each other rock on the board
			
			Rectangle otherRock = rock.getBounds();
			
			// Check to make sure I'm not comparing one rock to itself
			// Check if one rock crosses over another rock
			
			if(rock != this && otherRock.intersects(rockToCheck)){

				// Switch the direction the rocks are moving on impact
				
				int tempXDirection = this.xDirection;
				int tempYDirection = this.yDirection;
				
				this.xDirection = rock.xDirection;
				this.yDirection = rock.yDirection;
				
				rock.xDirection = tempXDirection;
				rock.yDirection = tempYDirection;
				
			}
			
				// NEW Check if theShip hits a Rock
			
				Rectangle shipBox = theShip.getBounds();
				
				if(otherRock.intersects(shipBox)){
					
					// NEW play explosion if ship is hit
					
					GameBoard.playSoundEffect(explodeFile);
					
					theShip.setXCenter(theShip.gBWidth/2);
					theShip.setYCenter(theShip.gBHeight/2);
					
					theShip.setXVelocity(0);
					theShip.setYVelocity(0);
					
					
				}
				
				for(PhotonTorpedo torpedo : torpedos){
					
					// Make sure the Torpedo is on the screen
					
					if(torpedo.onScreen){
					
						// NEW Check if a torpedo hits a Rock
						
						if(otherRock.contains(torpedo.getXCenter(),torpedo.getYCenter())){
							
							rock.onScreen = false;
							torpedo.onScreen = false;
							
							System.out.println("HIT");
							
							// NEW play explosion sound if rock is destroyed
							
							GameBoard.playSoundEffect(explodeFile);
						}
					
					}
					
				}
			
			}
			
		} 
		
		// Get the upper left and top most point for the Polygon
		// This will be dynamic later on
		
		int uLeftXPos = super.xpoints[0]; 
		
		int uLeftYPos = super.ypoints[0];
		
		// If the Rock hits a wall it will go in the opposite direction
		
		if (uLeftXPos < 0 || (uLeftXPos + 25) > width) xDirection = -xDirection; 
		
		if (uLeftYPos < 0 || (uLeftYPos + 50) > height) yDirection = -yDirection;
		
		// Change the values of the points for the Polygon
		
		for (int i = 0; i < super.xpoints.length; i++){
			
			super.xpoints[i] += xDirection;
			super.ypoints[i] += yDirection;
			
		}
		
	}
	
	// public method available for creating Polygon x point arrays
	
	public static int[] getpolyXArray(int randomStartXPos){
		
		// Clones the array so that the original shape isn't changed for the asteroid
		
		int[] tempPolyXArray = (int[])sPolyXArray.clone();
		
		for (int i = 0; i < tempPolyXArray.length; i++){
			
			tempPolyXArray[i] += randomStartXPos;
			
		}
		
		return tempPolyXArray;
		
	}
	
	// public method available for creating Polygon y point arrays
	
	public static int[] getpolyYArray(int randomStartYPos){
		
		// Clones the array so that the original shape isn't changed for the asteroid
		
		int[] tempPolyYArray = (int[])sPolyYArray.clone();
		
		for (int i = 0; i < tempPolyYArray.length; i++){
			
			tempPolyYArray[i] += randomStartYPos;
			
		}
		
		return tempPolyYArray;
		
	}
	
}