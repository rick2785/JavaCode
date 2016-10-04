public class Radio implements ElectronicDevice {

	private int volume = 0;
	
	public void on() {
		
		System.out.println("Radio is on");
		
	}

	public void off() {
		
		System.out.println("Radio is off");
		
	}

	public void volumeUp() {
		
		volume++;
		
		System.out.println("Radio Volume is at: " + volume);
		
	}

	public void volumenDown() {
		
		volume--;
		
		System.out.println("Radio Volume is at: " + volume);
		
	}
	
}