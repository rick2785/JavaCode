// You could also lock down a method and then unlock it
// when you are finished with it. This library does that

import java.util.concurrent.locks.ReentrantLock;

public class PerformSystemCheck implements Runnable{
	
	private String checkWhat;
	
	// Creates a lock for your method
	
	ReentrantLock lock = new ReentrantLock();
	
	public PerformSystemCheck(String checkWhat){
		
		this.checkWhat = checkWhat;
		
	}
	
	// By putting synchronized before a method, you make
	// sure only one thread at a time can execute it.
	// Synchronizing slows down Java, so it should only
	// be used when necessary.
	
	/* synchronized */ public void run(){
		
		// this locks down the method just like synchronized
		// You can't use synchronized and lock, that's why 
		// synchronized is commented out above
			
		lock.lock();
		
		System.out.println("Checking " + this.checkWhat);
		
		// this unlocks the method just like synchronized
		
		lock.unlock();
		
	}
	
}