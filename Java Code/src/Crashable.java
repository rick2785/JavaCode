/* If you want to create a class in which every method
 * doesn't have to be implemented use abstract classes.
 */

// Create an abstract class with the abstract keyword
public abstract class Crashable{
	
	boolean carDrivable = true;
	
	public void youCrashed(){
		this.carDrivable = false;
	}
	
	public abstract void setCarStrength(int carStrength);
	
	public abstract int getCarStrength();
	
}