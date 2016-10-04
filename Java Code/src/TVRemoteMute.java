// Refined Abstraction

// If I decide I want to further extend the remote I can

public class TVRemoteMute extends RemoteButton{
	
	public TVRemoteMute(EntertainmentDevice newDevice) {
		super(newDevice);
	}
	
	public void buttonNinePressed() {
		
		System.out.println("TV was Muted");
		
	}
	
}