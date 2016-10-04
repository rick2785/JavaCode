public class JavaLessonThree {
	
	public static void main(String[] args)
	{
		// Creates a random number between 0 and 50
		int randomNumber = (int) (Math.random() * 50);
		
		/* Relational Operators: 
		 * Java has 6 relational operators
		 * > : Greater Than
		 * < : Less Than
		 * == : Equal To
		 * != : Not Equal To
		 * >= : Greater Than Or Equal To
		 * <= : Less Than Or Equal To
		 */
		
		// If randomNumber is less than 25, execute the code between {} and then stop checking
		if (randomNumber < 25)
		{
			System.out.println("The random number is less than 25");
		}
		
		// If randomNumber wasn't less than 25, then check if it's greater than it. If so, execute the code between {} and then stop checking
		else if (randomNumber > 25)
		{
			System.out.println("The random number is greater than 25");
		}
		
		// Checks if randomNumber equals 25
		else if (randomNumber == 25)
		{
			System.out.println("The random number is equal to 25");
		}
		
		// Checks if randomNumber is not equal to 25
		else if (randomNumber != 15)
		{
			System.out.println("The random number is not equal to 15");
		}
		
		// Checks if randomNumber is less than or equal to 25
		else if (randomNumber <= 25)
		{
			System.out.println("The random number is less than or equal to 25");
		}
		
		// Checks if randomNumber is greater than or equal to 25
		else if (randomNumber >= 25)
		{
			System.out.println("The random number is greater than or equal to 25");
		}
		
		// If none of the above were correct print out the random number
		else 
		{
			System.out.println("The random number is " + randomNumber);
		}
		
		// Prints out the random number
		System.out.println("The random number is " + randomNumber);
		
		/* Logical Operators:
		 * Java has 6 logical operators
		 * ! : Converts the boolean value to its right to its opposite form ie. true to false
		 * & : Returns true if boolean value on the right and left are both true (Always evaluates both boolean values)
		 * && : Returns true if boolean value on the right and left are both true (Stops evaluating after first false)
		 * | : Returns true if either boolean value on the right or left are true (Always evaluates both boolean values)
		 * || : Returns true if either boolean value on the right or left are true (Stops evaluating after first true)
		 * ^ : Returns true if there is 1 true and 1 false boolean value on the right or left
		 */
		
		if (!(false))
		{
			System.out.println("I turned false into true");
		}
		
		
		if ((false) && (true))
		{
			System.out.println("\nBoth are true");
		}
		
		// There is also a & logical operator it checks the second boolean result even if the first comes back false
		
		if ((true) || (true))
		{
			System.out.println("\nAt least 1 are true");
		}
		
		// There is also a | logical operator it checks the second boolean result even if the first comes back true
		
		if ((true) ^ (false))
		{
			System.out.println("\n1 is true and the other false");
		}
		
		int valueOne = 1;
		int valueTwo = 2;
		
		// The Conditional or Ternary Operator assigns one or another value based on a condition
		// If true valueOne is assigned to biggestValue. If not valueTwo is assigned
		int biggestValue = (valueOne > valueTwo) ? valueOne : valueTwo;
		
		System.out.println(biggestValue + " is the biggest\n");
		
		char theGrade = 'B';
		
		/* When you have a limited number of possible values a switch statement makes sense 
		 * The switch statement checks the value of theGrade to the values that follow case
		 * If it matches it executes the code between {} and then break ends the switch statement
		 * default code is executed if there are no matches
		 * You are not required to use the break or default statements
		 * The expression must be an int, short, byte, or char
		 */
		switch (theGrade)
		{
		case 'A':
			System.out.println("Great Job");
			break; // Ends the switch statement
		case 'b': // You can use multiple case statements in a row
		case 'B':
			System.out.println("Good Job, get an A next time");
			break;
		case 'C':
			System.out.println("OK, but you can do better");
			break;
		case 'D':
			System.out.println("You must work harder");
			break;
		default:
			System.out.println("You failed");
			break;
		}
		
	}
	
}