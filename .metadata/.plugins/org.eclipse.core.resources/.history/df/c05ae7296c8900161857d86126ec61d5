// Layout used by the JPanel
import java.awt.BorderLayout;

// Define color of shapes
import java.awt.Color;

// Allows me to draw and render shapes on components
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;

// Will hold all of my Rock objects
import java.util.ArrayList;

// Runs commands after a given delay
import java.util.concurrent.ScheduledThreadPoolExecutor;

// Defines time units. In this case TimeUnit.MILLISECONDS
import java.util.concurrent.TimeUnit;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class GameBoard extends JFrame{
	
	// Height and width of the game board
	
	public static int boardWidth = 1000;
	public static int boardHeight = 800;
	
	// Used to check if a key is being held down
	
	public static boolean keyHeld = false;
	
	// Gets the keycode for the key being held down
	
	public static int keyHeldCode;
	
	public static void main(String [] args)
    {
            new GameBoard();
            
    }
	
	public GameBoard()
    {
    	// Define the defaults for the JFrame
    	
        this.setSize(boardWidth, boardHeight);
        this.setTitle("Java Asteroids");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Handles executing code based on keys being pressed
        
        addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==87)
			    {
					System.out.println("Forward");
					
					keyHeldCode = e.getKeyCode();
			    	keyHeld = true;
					
			    } else if (e.getKeyCode()==83){
			    	System.out.println("Backward");
			    	
			    	keyHeldCode = e.getKeyCode();
			    	keyHeld = true;
			    	
			    } 
			    
				// Id the d key is pressed set keyHeld as if it
				// was being held down. This will cause the ship to 
				// constantly rotate. keyHeldCode stores the keyCode for d
			    
			    else if (e.getKeyCode()==68){
			    	System.out.println("Rotate Right");
			    	
			    	keyHeldCode = e.getKeyCode();
			    	keyHeld = true;
			    	
			    } 
			    
			    // Same thing is done here as was done with the last
				// 65 is the keyCode for a
			    
			    else if (e.getKeyCode()==65){
			    	System.out.println("Rotate Left");
			    	
			    	keyHeldCode = e.getKeyCode();
			    	keyHeld = true;
			    }
				
			}

			// When the key is released this informs the code that
			// the key isn't being held down
			
			public void keyReleased(KeyEvent e) {
		
				keyHeld = false;
				
			}
        	
        });

        
        GameDrawingPanel2 gamePanel = new GameDrawingPanel2();

     // Make the drawing area take up the rest of the frame
        
        this.add(gamePanel, BorderLayout.CENTER);
        
        // Used to execute code after a given delay
        // The attribute is corePoolSize - the number of threads to keep in 
        // the pool, even if they are idle
        
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
		
        // Method to execute, initial delay, subsequent delay, time unit
        
		executor.scheduleAtFixedRate(new RepaintTheBoard2(this), 0L, 20L, TimeUnit.MILLISECONDS);
        
        // Show the frame
        
        this.setVisible(true);
    }
	
}


// Class implements the runnable interface
// By creating this thread we can continually redraw the screen
// while other code continues to execute

class RepaintTheBoard2 implements Runnable{

	GameBoard theBoard;
	
	public RepaintTheBoard2(GameBoard theBoard){
		this.theBoard = theBoard;
	}

	@Override
	public void run() {
		
		// Redraws the game board
		
		theBoard.repaint();
		
	}
	
}

@SuppressWarnings("serial")

// GameDrawingPanel is what we are drawing on

class GameDrawingPanel2 extends JComponent { 
	
	// Holds every Rock I create
	
	public static ArrayList<Rock> rocks = new ArrayList<Rock>();
	
	// Get the original x & y points for the polygon
	
	int[] polyXArray = Rock.sPolyXArray;
	int[] polyYArray = Rock.sPolyYArray;
	
	// Create a SpaceShip
	SpaceShip theShip = new SpaceShip();
	
	// Gets the game board height and weight
	
	int width = GameBoard.boardWidth;
	int height = GameBoard.boardHeight;
	
	// Creates 50 Rock objects and stores them in the ArrayList
	// Suppress warnings when I clone the rocks array

	public GameDrawingPanel2() { 
		
		for(int i = 0; i < 10; i++){
			
			// Find a random x & y starting point
			// The -40 part is on there to keep the Rock on the screen
			
			int randomStartXPos = (int) (Math.random() * (GameBoard.boardWidth - 40) + 1);
			int randomStartYPos = (int) (Math.random() * (GameBoard.boardHeight - 40) + 1);
			
			// Add the Rock object to the ArrayList based on the attributes sent
			
			rocks.add(new Rock(Rock.getpolyXArray(randomStartXPos), Rock.getpolyYArray(randomStartYPos), 13, randomStartXPos, randomStartYPos));
			
			Rock.rocks = rocks; // NEW
			
		}
		
	} 
	
	public void paint(Graphics g) { 
		
		// Allows me to make many settings changes in regards to graphics
		
		Graphics2D graphicSettings = (Graphics2D)g; 
		
		AffineTransform identity = new AffineTransform();
		
		// Draw a black background that is as big as the game board
		
		graphicSettings.setColor(Color.BLACK);
		graphicSettings.fillRect(0, 0, getWidth(), getHeight());
		
		// Set rendering rules
		
		graphicSettings.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		
		// Set the drawing color to white
		
		graphicSettings.setPaint( Color.WHITE ); 
		
		// Cycle through all of the Rock objects
		
		for(Rock rock : rocks){
			
			// Move the Rock polygon 
			
			rock.move(); 
			
			// Stroke the polygon Rock on the screen
			
			graphicSettings.draw(rock); 
			
		} 
		
		// Handles spinning the ship in the clockwise direction when the D key
		// is pressed and held
		
		if(GameBoard.keyHeld == true && GameBoard.keyHeldCode == 68){
			
			theShip.increaseRotationAngle();
			
			System.out.println("Ship Angle: " + theShip.getRotationAngle());
			
		} else
			
		// Continues to rotate the ship counter clockwise if the A key is held
			
		if(GameBoard.keyHeld == true && GameBoard.keyHeldCode == 65){
				
			theShip.decreaseRotationAngle();
				
			System.out.println("Ship Angle: " + theShip.getRotationAngle());
				
		} else
			
		if (GameBoard.keyHeld == true && GameBoard.keyHeldCode == 87){
			
			// Set movement angle to the current rotation angle
			// This is done so that the ship rotation can be set by the A & D keys
			// but when the throttle is hit the ship knows what direction to go
			
			theShip.setMovingAngle(theShip.getRotationAngle());
			
			// Changes the values of x & y based on the angle of the ship. This way it knows if it        should increase or decrease x & y. By putting .01 in here we can slowly increase the velocity

			theShip.increaseXVelocity(theShip.shipXMoveAngle(theShip.getMovingAngle())*0.1);
			theShip.increaseYVelocity(theShip.shipYMoveAngle(theShip.getMovingAngle())*0.1);
			
		}
		
		theShip.move();
		
		// Sets the origin on the screen so rotation occurs properly
		
		graphicSettings.setTransform(identity);
		
		// Moves the ship to the center of the screen
		
		graphicSettings.translate(theShip.getXCenter(),theShip.getYCenter());
		
		// Rotates the ship
		
		graphicSettings.rotate(Math.toRadians(theShip.getRotationAngle()));
		
		graphicSettings.draw(theShip);
		
		
	} 
	
}