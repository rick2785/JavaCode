//If you don't want the user to create objects from
//a class mark it as abstract.
//Subclasses can still extend it

abstract public class Creature{
	
	// protected fields are like private fields except 
	// subclasses can inherit them 
	
	protected String name;
	protected double height;
	protected int weight;
	protected String favFood;
	protected double speed;
	protected String sound;
	
	// There are no abstract fields in Java, but
	// there are abstract methods. Every method
	// marked abstract must be overridden
	// Not all methods must be abstract and you
	// can also use static methods
	
	public abstract void setName(String newName);
	public abstract String getName();
	
	public abstract void setHeight(double newheight);
	public abstract double getHeight();
	
	public abstract void setWeight(double newWeight);
	public abstract double getWeight();
	
	public abstract void setFavFood(String newFood);
	public abstract String getFavFood();
	
	public abstract void setSpeed(double newSpeed);
	public abstract double getSpeed();
	
	public abstract void setSound(String newSound);
	public abstract String getSound();
	
}