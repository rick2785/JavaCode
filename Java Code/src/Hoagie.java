// A Template Method Pattern contains a method that provides
// the steps of the algorithm. It allows subclasses to override 
// some of the methods

public abstract class Hoagie {
	
	boolean afterFirstCondiment = false;
	
	// This is the Template Method
	// Declare this method final to keep subclasses from
	// changing the algorithm
	
	final void makeSandwich(){
		
		cutBun();
		
		if(customerWantsMeat()){
			
			addMeat();
			
			// Here to handle new lines for spacing
			afterFirstCondiment = true;
			
		}
		
		if(customerWantsCheese()){
			
			if(afterFirstCondiment) { System.out.print("\n"); }
			
			addCheese();
			
			afterFirstCondiment = true;
			
		}
		
		if(customerWantsVegetables()){
			
			if(afterFirstCondiment) { System.out.print("\n"); }
			
			addVegetables();
			
			afterFirstCondiment = true;
			
		}
		
		if(customerWantsCondiments()){
			
			if(afterFirstCondiment) { System.out.print("\n"); }
			
			addCondiments();
			
			afterFirstCondiment = true;
			
		}
		
		wrapTheHoagie();
		
	}
	
	// These methods must be overridden by the extending subclasses
	
	abstract void addMeat();
	abstract void addCheese();
	abstract void addVegetables();
	abstract void addCondiments();
	
	public void cutBun(){
		
		System.out.println("The Hoagie is Cut");
		
	}
	
	// These are called hooks
	// If the user wants to override these they can
	
	// Use abstract methods when you want to force the user
	// to override and use a hook when you want it to be optional
	
	boolean customerWantsMeat() { return true; }
	boolean customerWantsCheese() { return true; }
	boolean customerWantsVegetables() { return true; }
	boolean customerWantsCondiments() { return true; }
	
	public void wrapTheHoagie(){
		
		System.out.println("\nWrap the Hoagie");
		
	}
	
	public void afterFirstCondiment(){
		
		System.out.println("\n");
		
	}
	
}