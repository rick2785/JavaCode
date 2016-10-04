public class ConversionContext {

    private String conversionQues = "";
    private String conversionResponse = "";
    private String fromConversion = "";
    private String toConversion = "";
    private double quantity;
    
    String[] partsOfQues;

    public ConversionContext(String input)
    {
      this.conversionQues = input;
      
      partsOfQues = getInput().split(" ");
      
      fromConversion = getCapitalized(partsOfQues[1]);
      
      toConversion = getLowercase(partsOfQues[3]);
      
      quantity = Double.valueOf(partsOfQues[0]);
      
      conversionResponse = partsOfQues[0] + " "+ partsOfQues[1] + " equals ";
    }

    public String getInput() { return conversionQues; }
    
    public String getFromConversion() { return fromConversion; }
    
    public String getToConversion() { return toConversion; }
    
    public String getResponse() { return conversionResponse; }
    
    public double getQuantity() { return quantity; }
    
    // Make String lowercase
    
    public String getLowercase(String wordToLowercase){
    	
    	return wordToLowercase.toLowerCase();
    	
    }
    
    // Capitalizes the first letter of a word
    
    public String getCapitalized(String wordToCapitalize){
    	
    	// Make characters lower case
    	
    	wordToCapitalize = wordToCapitalize.toLowerCase();
    	
    	// Make the first character uppercase
    	
    	wordToCapitalize = Character.toUpperCase(wordToCapitalize.charAt(0)) + wordToCapitalize.substring(1);
    	
    	// Put s on the end if not there
    	
    	int lengthOfWord = wordToCapitalize.length();
    	
    	if((wordToCapitalize.charAt(lengthOfWord -1)) != 's'){
    		
    		wordToCapitalize = new StringBuffer(wordToCapitalize).insert(lengthOfWord, "s").toString();
    		
    	}
    	
    	return wordToCapitalize;
    	
    }

}