import java.util.Arrays;

public class JavaLessonNine {
	
	public static void main(String[] args){
		
		// An array is a variable that can hold a bunch of values
		// Think of an array as a big box filled with other boxes
		// Each box has a number on it called an index that you use 
		// to access its specific value
		
		/* Array Rules
		 * An array can contain only values of the same type
		 * An arrays size can't be changed once it is set
		 * An array is an object
		 */
		
		// You declare an array with the dataType[] arrayName
		int[] randomArray; 
		
		// You create an array with 
		// dataType[] arrayName = new dataType[sizeOfArray];
		
		int[] numberArray = new int[10];
		
		// You can add values to the array in many ways
		// Individually
		
		// Most create array and define size first
		randomArray = new int[20]; 
		randomArray[1] = 2;
		
		// You can also create the array and its values from the start
		String[] stringArray = {"Just", "Random", "Words"};
		
		// You can add values with a loop
		// arrayName.length returns the number of elements in the array
		for(int i = 0; i < numberArray.length; i++)
		{
			
			numberArray[i] = i;
			
		}
		
		// Draws 41 lines on the screen
		int k = 1;
		while(k <= 41){ System.out.print('-'); k++; }
		System.out.println();
		
		// Cycles through all of the boxes in the array and prints them
		for(int j = 0; j < numberArray.length; j++)
		{
			System.out.print("| " + j + " ");
		}
		System.out.println("|");
		
		// Draws 41 lines on the screen
		k = 1;
		while(k <= 41){ System.out.print('-'); k++; }
		System.out.println();
		
		// Multidimensional Array
		// To but arrays in an array just add another []
		
		String[][] multiDArray = new String[10][10];
		
		// Adding values to a multidimensional array
		
		for(int i = 0; i < multiDArray.length; i++)
		{
			
			// To get the length for the array in the array you must follow it 
			// with brackets with the index between them like [i]
			
			for(int j = 0; j < multiDArray[i].length; j++)
			{
				
				multiDArray[i][j] = i + " " + j;
				
			}
			
		}
		
		// Draws 61 lines on the screen
		k = 1;
		while(k <= 61){ System.out.print('-'); k++; }
		System.out.println();
		
		// Prints out a multidimensional array with the values being the indexes
		
		for(int i = 0; i < multiDArray.length; i++)
		{
			
			for(int j = 0; j < multiDArray[i].length; j++)
			{
				
				System.out.print("| " + multiDArray[i][j] + " ");
				
			}
			System.out.println("|");
			
		}
		
		// Draws 61 lines on the screen
		k = 1;
		while(k <= 61){ System.out.print('-'); k++; }
		System.out.println();
		
		// You can use the enhanced for loop to print out array values
		// for(itemDataType tempVariable : arrayName)
		
		for(int row : numberArray)
		{
			System.out.print(row);
		}
		System.out.println("\n");
		
		// To use enhanced for for a multidimensional array you follow this formula
		// for(dataType[] varForRow : arrayName)
		
		for(String[] rows : multiDArray) 
		{
			// for(elementDataType varForColumn : varForRow)
			for(String column : rows) 
			{
				System.out.print("| " + column + " ");
		    }
		        System.out.println("|");
		}
		
		// You can copy an array in a couple of ways
		// Arrays.copyOf(arrayToCopy, numberToCopyFromBeginning);
		
		int[] numberCopy = Arrays.copyOf(numberArray, 5);
		for(int num : numberCopy)
		{
			System.out.print(num);
		}
		System.out.println("\n");
		
		// You can copy an array from one index to another with copyOfRange
		// int[] numberCopy = Arrays.copyOf(numberArray, 1, 5);
		
		// You can print out the whole array with toString
		System.out.println(Arrays.toString(numberCopy));
		
		
		// Do define a default value for an array use fill
		// Arrays.fill(arrayName, valueToFill);
		// valueToFill must be the same for each element in the array
		
		int[] moreNumbers = new int[100];
		Arrays.fill(moreNumbers, 2);
		
		// Filling a multidimensional array
		char[][] boardGame = new char[10][10];
		for(char[] row : boardGame)
		{
			Arrays.fill(row, '*');
		}
		
		// You can sort an array using sort()
		int[] numsToSort = new int[10];
		
		// Generate array full of random numbers
		for(int i = 0; i < 10; i++)
		{
			numsToSort[i] = (int) (Math.random() * 100);
		}
		
		// Sort the array in ascending order
		Arrays.sort(numsToSort);
		
		System.out.println(Arrays.toString(numsToSort));
		
		// binarySearch returns the index for the searched for value
		// If it doesn't find it it returns a negative number
		
		int whereIs50 = Arrays.binarySearch(numsToSort, 50);
		
		System.out.println(whereIs50);
	}
	
}