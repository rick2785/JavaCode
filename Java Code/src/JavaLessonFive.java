import java.util.Scanner; // Scanner is a class that contains a bunch of methods

public class JavaLessonFive {
	// main is a method that contains all of the code to be executed when a program runs
	
	// This is a class variable that is available to every method
	// If you declare a variable in a method it is only accessible in that method (local variable)
	
	static double myPI = 3.14159265; 
	
	// Any changes made to randomNumber in any functions will effect its global value
	
	static int randomNumber;
	
	// Creates a Scanner object that monitors keyboard input
	
	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		
		/* Basic Method
		 * accessModifier static returnDataType methodName (parameters)
		 * { Statements }
		 * Access Modifier: Determines who can execute a method
		 * static: Used when you want to be able to execute a method that isn't part of a class definition
		 * Return Data Type: The data type of value returned after a method executes (void if no values are returned)
		 * Method Name: Must start with a letter, but can include letters, numbers, $, or _
		 * Parameters / Arguments: Values passed to a method
		 */
		
		System.out.println(addThem(1,2)); // addThem(1,2) will be replaced with the value that method returns
		
		// Demonstrating passing by value
		int d = 5;
		
		// Changes to the variable d in tryToChange don't effect its value globally
		// We are passing the value of d to tryToChange and not the variable
		
		tryToChange(d);
		System.out.println("Static Variable d = "+ d);
		
		// Guessing a random number
		System.out.println("\n");
		
		System.out.println(getRandomNum()); // Both prints and generates the value for randomNumber
		
		int guessResult = 1;
		int randomGuess = 0;
		
		while(guessResult != -1)
		{
		System.out.print("Guess a number between 0 and 50: ");
		
		// Accepts an integer input from the user
		// You can't declare this variable inside the while loop if you want to access it outside the while loop
		
		randomGuess = userInput.nextInt(); 
		
		guessResult = checkGuess(randomGuess);
		}
		
		System.out.println("Yes the random number is " + randomGuess);
		
		System.out.println(randomNumber); // Random value was changed globally by getRandomNum
		
	}
	
	// Adds the two numbers sent and returns the solution
	// public is the access modifier and means anyone can execute this method
	// Java Methods can return any primitive data type, or reference to an object (More on that later)
	
	public static int addThem(int a, int b)
	{
		double smallPI = 3.140; // This variable is local to the addThem function
		
		// compare returns 0 if equal | -1 if smallPI is less than myPI | 1 if smallPI is greater than myPI
		
		System.out.println(Double.compare(smallPI, myPI));
		
		int c = a + b;
		
		// return returns a value that replaces the call to this method
		// It must be an int since you defined this method returns ints above
		
		return c; 
	}
	
	// When you define an attribute / parameter you must define its type
	// That's why you can't type tryToChange(d)
	// Because this function doesn't return a value return type is void
	
	public static void tryToChange(int d)
	{
		d = d + 1;
		System.out.println("tryToChange d = " + d);
	}
	
	public static int getRandomNum()
	{
		// Creates a random number between 0 and 50
		// Since randomNumber is a class variable you don't have to declare, or define its type
		// If int randomNumber was declared in this method it wouldn't effect the global variable named randomNumber
		
		randomNumber = (int) (Math.random() * 51);
		return randomNumber;
	}
	
	public static int checkGuess(int guess)
	{
		if(guess == randomNumber)
		{
			return -1;
		} else {
			return guess; // Must return a value of type int
		}
	}
	
}