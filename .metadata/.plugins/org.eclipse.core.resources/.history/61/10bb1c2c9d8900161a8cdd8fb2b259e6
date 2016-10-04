public class UFOEnemyShip extends EnemyShip{
	
	private String idcode = "100";
	
	private String getPrivate() { return "How did you get this"; }
	
	private String getOtherPrivate(int thisInt, String thatString){
		
		return "How did you get here " + thisInt + " " + thatString;
		
	}
	
	public UFOEnemyShip(int number, String randString){
		
		System.out.println("You sent: " + number + " " + randString);
		
	}
	
	// We define the type of ship we want to create
	// by stating we want to use the factory that 
	// makes enemy ships
	
	EnemyShipFactory shipFactory;
	
	// The enemy ship required parts list is sent to 
	// this method. They state that the enemy ship
	// must have a weapon and engine assigned. That 
	// object also states the specific parts needed
	// to make a regular UFO versus a Boss UFO
	
	public UFOEnemyShip(EnemyShipFactory shipFactory){
		
		this.shipFactory = shipFactory;
		
	}

	// EnemyShipBuilding calls this method to build a 
	// specific UFOEnemyShip
	
	void makeShip() {
		
		System.out.println("Making enemy ship " + getName());
		
		// The specific weapon & engine needed were passed in
		// shipFactory. We are assigning those specific part
		// objects to the UFOEnemyShip here
		
		weapon = shipFactory.addESGun();
		engine = shipFactory.addESEngine();
		
	}
	
}