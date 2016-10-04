import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

// Basic class definition
// public means this class can be used by other classes
// Class names should begin with a capital letter
// A file can't contain two public classes. It can contain classes that are not public
// If you place class files in the same folder the java compiler will be able to find them

public class MonsterTwo{
	// Creates a multidimensional array of chars
	static char[][] battleBoard = new char[10][10];
	
	// This static method builds an empty battle board
	public static void buildBattleBoard(){
		
		// Cycles through the array and gives a default value of * to everything
		
		for(char[] row : battleBoard)
			Arrays.fill(row, '*');
	}
	
	// Redraws the board
	public static void redrawBoard()
	{
		
		int k = 1;
		while(k <= 30){ System.out.print('-'); k++; }
		System.out.println();
		
		for(int i = 0; i < battleBoard.length; i++)
		{
			for(int j = 0; j < battleBoard[i].length; j++)
			{
				System.out.print("|" + battleBoard[i][j] + "|");
			}
			System.out.println();
			
		}
		k = 1;
		while(k <= 30){ System.out.print('-'); k++; }
		System.out.println();
	}
	
	// Class Variables or Fields
	// You declare constants with final
	
	public final String TOMBSTONE = "Here Lies a Dead monster";
	
	// private fields are not visible outside of the class
	private int health = 500;
	private int attack = 20;
	private int movement = 2;
	
	// Monitors whether the monster is alive or dead
	private boolean alive = true;
	
	// public variables are visible outside of the class
	// You should have as few as possible public fields
	public String name = "Big Monster";
	public int xPosition = 0;
	public int yPosition = 0;
	public char nameChar1 = 'B';
	public static int numOfMonsters = 0;
	
	
	// Class Methods
	// Accessor Methods are used to get and set the values of private fields
	
	public int getAttack()
	{
		return attack;
	}
	
	public int getMovement()
	{
		return movement;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public boolean getAlive()
	{
		return alive;
	}
	
	// You can create multiple versions using the same method name
	// Now setHealth can except an attack that contains decimals
	// When overloading a method you can't just change the return type
	// Focus on creating methods that except different parameters
	
	public void setHealth(int decreaseHealth)
	{
		health = health - decreaseHealth;
		if (health < 0)
		{
			alive = false;
		}
	}
	
	public void setHealth(double decreaseHealth)
	{
		int intDecreaseHealth = (int) decreaseHealth;
		health = health - intDecreaseHealth;
		if (health < 0)
		{
			alive = false;
		}
	}
	
	public void moveMonster(MonsterTwo[] monster, int arrayItemIndex)
	{
		// isSpaceOpen will be used to track whether the space the
		// monster plans to move into is occupied
		boolean isSpaceOpen = true;
		
		// Define the maximum x and y for the battle board
		// It's 1 less because the array index starts at 0
		int maxXBoardSpace = battleBoard.length - 1;
		int maxYBoardSpace = battleBoard[0].length - 1;
		
		
		// while loop used to make sure I don't move a monster
		// into an occupied space
		while(isSpaceOpen)
		{
		
		// Randomly generate move direction N, S, E, or W
		int randMoveDirection = (int) (Math.random() * 4);
		
		// Randomly generate move distance based on max move distance
		int randMoveDistance = (int) (Math.random() * (this.getMovement() + 1));
		
		// Prints move distance and move direction
		System.out.println(randMoveDistance + " " + randMoveDirection);
		
		// Erase monsters character on the board by replacing it with a *
		
		battleBoard[this.yPosition][this.xPosition] = '*';
		

			
		if(randMoveDirection == 0)
		{
			// Find new xPosition & yPosition based on the current position on the board
			// If statements won't allow monster to move off the board
			
			if((this.yPosition - randMoveDistance) < 0)
			{
				this.yPosition = 0;
			} else {
				this.yPosition = this.yPosition - randMoveDistance;
			}
		} else if (randMoveDirection == 1) {
			if((this.xPosition + randMoveDistance) > maxXBoardSpace)
			{
				this.xPosition = maxXBoardSpace;
			} else {
				this.xPosition = this.xPosition + randMoveDistance;
			}
		} else if (randMoveDirection == 2) {
			if((this.yPosition + randMoveDistance) > maxYBoardSpace)
			{
				this.yPosition = maxYBoardSpace;
			} else {
				this.yPosition = this.yPosition + randMoveDistance;
			}
		} else {
			if((this.xPosition - randMoveDistance) < 0)
			{
				this.xPosition = 0;
			} else {
				this.xPosition = this.xPosition - randMoveDistance;
			}
		}
		
		// monster.length returns the number of items in the array monster
		for (int i = 0; i < monster.length; i++)
		{
			// if statement skips checking the same monster position against itself
			
			if (i == arrayItemIndex)
			{
				continue;
			} 
			
			// onMySpace receives the monster array, index for the object I'm 
			// checking currently, and the index for the monster sent to 
			// this function
			
			if(onMySpace(monster, i, arrayItemIndex))
			{
				// If a monster tries to move to an occupied space the
				// while loop repeats after I break out of the for loop
				
				isSpaceOpen = true;
				break;
			} else {
				// There was no monster in the space so end the while loop
				isSpaceOpen = false;
				
			}
			
		}
		
		} // End of while loop
		
		// Set the value in the array to the first letter of the monster
		battleBoard[this.yPosition][this.xPosition] = this.nameChar1;	
	}
	
	// Checks if one monster is trying to move into the same x/y position as 
	// another monster
	public boolean onMySpace(MonsterTwo[] monster, int indexToChk1, int indexToChk2)
	{
		// Checks if the 2 monsters have the same x/y position
		if((monster[indexToChk1].xPosition)==(monster[indexToChk2].xPosition)&&(monster[indexToChk1].yPosition)==(monster[indexToChk2].yPosition))
		{
			// If they are equal return true so a new x/y position is calculated
			
			return true;
			
		} else {
			
			// If false I know the x/y position isn't occupied
			return false;
		}
	}
	
	
	/* The Constructor
	 * Code that is executed when an object is created from this class definition
	 * The method name is the same as the class
	 * The constructor is only executed once per object
	 * The constructor can't return a value
	 */
	
	public MonsterTwo(int health, int attack, int movement, String name)
	{
		this.health = health;
		this.attack = attack;
		this.movement = movement;
		this.name = name;
		/* If the attributes had the same names as the class health, attack, movement
		 * You could refer to the objects fields by proceeding them with this
		 * this.health = health;
		 * this.attack = attack;
		 * objectFieldName = attributeFieldName;
		 */
		
		// Define the maximum x and y for the battle board
		// It's 1 less because the array index starts at 0
		int maxXBoardSpace = battleBoard.length - 1;
		int maxYBoardSpace = battleBoard[0].length - 1;
		
		// The random starting position for a monster
		int randNumX, randNumY;
		
		// We use a do loop because we always want to define a start 
		// position for each monster
		
		do {
		// Calculate start position based on max board space
		randNumX = (int) (Math.random() * maxXBoardSpace);
		randNumY = (int) (Math.random() * maxYBoardSpace);
		} while(battleBoard[randNumY][randNumX] != '*');
		// Only allow monster to start on a space with a * on it
		
		// Assign x and y position to the object that called this method
		this.xPosition = randNumX;
		this.yPosition = randNumY;
		
		// Assign character in the array based on the first initial
		// of the monsters name charAt(0) returns first letter of name
		this.nameChar1 = this.name.charAt(0);
		
		// Put first character of monster in the array
		battleBoard[this.yPosition][this.xPosition] = this.nameChar1;
		
		numOfMonsters++; // Adds 1 to the number of monsters on the board
	}
	
	// You can overload constructors like any other method
	// The following constructor is the one provided by default if you don't create any other constructors
	// Default Constructor
	
	public MonsterTwo()
	{
		numOfMonsters++; // Adds 1 to the number of monsters on the board
	}
	
public static void main(String[] args)
{
	
	
	
}
	
}