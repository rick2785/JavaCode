// This is a factory thats only job is creating ships
// By encapsulating ship creation, we only have one
// place to make modifications

public class EnemyShipFactory2{
	
	// This could be used as a static method if we
	// are willing to give up subclassing it
	
	public EnemyShip2 makeEnemyShip(String newShipType){
		
		EnemyShip newShip = null;
		
		if (newShipType.equals("U")){
			
			return new UFOEnemyShip3();
			
		} else 
		
		if (newShipType.equals("R")){
			
			return new RocketEnemyShip2();
			
		} else 
		
		if (newShipType.equals("B")){
			
			return new BigUFOEnemyShip2();
			
		} else return null;
		
	}
	
}