// Each command you want to issue will implement 
// the Command interface

public interface Command {
	
	public void execute();
	
	// You may want to offer the option to undo a command
	
	public void undo();
	
}