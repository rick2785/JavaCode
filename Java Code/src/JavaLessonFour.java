import java.util.Scanner; // Library that allows us to capture user input

public class JavaLessonFour {
	
	// Creates a Scanner object that monitors keyboard input
	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		/*
		 * The while loop : A while loop executes the code between {} until the 
		 * condition is no longer true
		 */
		// while loops create a loop iterator before the loop begins
		int i = 1;
		
		while(i < 20)
		{
			// Use continue to skip over printing 3
			if(i == 3)
			{
				i+=2; // When using continue, don't forget to change the iterator
				continue; // continue skips a loop iteration, but not the loop
			}
			
			System.out.println(i);
			i++;
			
			// Just print odd numbers
			if((i%2) == 0)
			{
				i++;
			}
			
			// i is greater than 10 jump out of the loop
			if(i > 10)
			{
				break; // Forces the program to leave the loop prematurely
			}
		}
		
		/* 
		 * Code that calculates the value for PI
		 */
		double myPi = 4.0; // My starting value for pi
		
		// Starting value for my loop iterator in the loop
		double j = 3.0; 
		
		// The while loop
		while(j<11)
		{
			// I calculate pi with this formula
			// PI = 4 - 4/3 + 4/5 - 4/7...
			myPi = myPi - (4/j) + (4/(j+2));
			j += 4;
			System.out.println(myPi);
		}
		
		System.out.println("Value of PI: " + Math.PI);
		
		/*
		 * Execute while loop until the user quits it
		 */
		String contYorN = "Y";
		int h = 1;
		
		// equalsIgnoreCase checks if the input string is equal to y or Y
		while (contYorN.equalsIgnoreCase("y"))
		{
			System.out.println(h);
			System.out.print("Continue y or n?");
			contYorN = userInput.nextLine(); // Accepts a string input from the user
			h++;
			
		}
		
		/* 
		 * The do while loop : Used when you want to guarantee the code 
		 * between {} will execute at least once. The code is executed and
		 * then java checks if it should execute again
		 */
		// loop iterator for the do while loop
		// It must be created before the expression is evaluated below
		int k = 1;
		
		do 
		{
			System.out.println(k);
			k++;
		} while (k <= 10); // Counts from 1 to 10
		
		/*
		 * The for loop : Another looping tool in Java
		 * for( declare iterator; conditional statement; change iterator value)
		 */
		
		for (int l=10; l >= 1; l--)
		{
			System.out.println(l);
		}
		
		// System.out.println(l); The variable l is not callable outside of for

		int m, n; // You don't have to declare variables in the for loop
		// You can use multiple variables in the for loop
		for (m=1, n=2; m <= 9; m+=2, n+=2)
		{
			System.out.println(m + "\n" + n);
		}
		
		// You can have for loops inside of for loops, but I'll save 
		// that topic until I talk about arrays
		
	}
	
}