public class SecurityCodeCheck {
	
	private int securityCode = 1234;
	
	public int getSecurityCode() { return securityCode; }
	
	public boolean isCodeCorrect(int secCodeToCheck){
		
		if(secCodeToCheck == getSecurityCode()) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
}