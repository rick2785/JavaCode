import java.awt.Polygon;
import java.awt.Rectangle;

public class PhotonTorpedo extends Polygon{
	
	private static final long serialVersionUID = 1L;
	
	// Get the board width and height

	int gBWidth = GameBoard.boardWidth;
	int gBHeight = GameBoard.boardHeight;
		
	// Center of torpedo
		
	private double centerX = 0, centerY = 0;
		
	// Will hold the x & y coordinates for the torpedo
	// Everything is based on coordinates from the center
		
	public static int[] polyXArray = {-3,3,3,-3,-3};
	public static int[] polyYArray = {-3,-3,3,3,-3};
	
	// Width and height of torpedo
	
	private int torpedoWidth = 6, torpedoHeight = 6;
	
	// Keep track of whether torpedo is on screen
	
	public boolean onScreen = false;
	
	// The angle the torpedo moves on the screen
	
	private double movingAngle = 0;
	
	// Determines how quickly the torpedo moves on 
	// its assigned path
	
	private double xVelocity = 5, yVelocity = 5;
	
	public PhotonTorpedo(double centerX, double centerY, double movingAngle){
		
		// Creates a Polygon by calling the super or parent class Polygon
		
		super(polyXArray, polyYArray, 5);
		
		// Defines the center based on the vectors of
		// the ships nose. movingAngle is the same as ship
		
		this.centerX = centerX;
		this.centerY = centerY;
		this.movingAngle = movingAngle;
		
		// Tells program to show the torpedo
		
		this.onScreen = true;
		
		// Sets how quickly the torpedo moves along the path defined
		// by setXVelocity and setYVelocity
		
		this.setXVelocity(this.torpedoXMoveAngle(movingAngle)*10);
		this.setYVelocity(this.torpedoYMoveAngle(movingAngle)*10);
		
	}
	
	// Gets & sets the values for the x & y center of torpedo
	
	public double getXCenter(){ return centerX; }
		
	public double getYCenter(){ return centerY; }
		
	public void setXCenter(double xCent){ this.centerX = xCent; }
		
	public void setYCenter(double yCent){ this.centerY = yCent; }
		
	public void changeXPos(double incAmt) { this.centerX += incAmt; }
		
	public void changeYPos(double incAmt) { this.centerY += incAmt; }
	
	// Gets, sets, the torpedo velocity
	
	public double getXVelocity(){ return xVelocity; }
		
	public double getYVelocity(){ return yVelocity; }
		
	public void setXVelocity(double xVel){ this.xVelocity = xVel; }
		
	public void setYVelocity(double yVel){ this.yVelocity = yVel; }
	
	// Gets & sets the x & y for upper left hand corner of ship
	
	public int getWidth(){ return torpedoWidth; }
			
	public int getHeight(){ return torpedoHeight; }
	
	// Set and increase the torpedo movement angle
	
	public void setMovingAngle(double moveAngle){ this.movingAngle = moveAngle; }
		
	public double getMovingAngle(){ return movingAngle; }
	
	// NEW Artificial rectangle that is used for collision detection
	
	public Rectangle getBounds(){
			
		return new Rectangle((int) getXCenter() - 6, (int) getYCenter() - 6, getWidth(), getHeight());
			
	}
	
	// Calculate the torpedo angle of movement
	
	// By taking the cos of the angle I get the opposite value of x
	// Angle * Math.PI / 180 converts degrees into radians
		
	public double torpedoXMoveAngle(double xMoveAngle){
			
		return (double) (Math.cos(xMoveAngle * Math.PI / 180));
			
	}
		
	// By taking the sin of the angle I get the adjacent value of y
	// Angle * Math.PI / 180 converts degrees into radians 
		
	public double torpedoYMoveAngle(double yMoveAngle){
			
		return (double) (Math.sin(yMoveAngle * Math.PI / 180));
			
	}
	
	public void move(){
		
		if(this.onScreen){
			
			// Increase the x origin value based on current velocity
			
			this.changeXPos(this.getXVelocity());
		
		// If the ship goes off the board flip it to the other side of the board
		
		if(this.getXCenter() < 0){
			
			this.onScreen = false;
			
		} else
			if (this.getXCenter() > gBWidth){
				
				this.onScreen = false;
				
			}
		
		// Increase the x origin value based on current velocity 
		
		this.changeYPos(this.getYVelocity());
		
		// If the ship goes off the board flip it to the other side of the board
		
		if(this.getYCenter() < 0){
			
			this.onScreen = false;
			
		} else
			if (this.getYCenter() > gBHeight){
				
				this.onScreen = false;
				
			}
		
		} // END OF onScreen CHECK
		
	}

	
}