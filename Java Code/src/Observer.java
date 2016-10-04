// The Observers update method is called when the Subject changes

public interface Observer {
	
	public void update(double ibmPrice, double aaplPrice, double googPrice);
	
}