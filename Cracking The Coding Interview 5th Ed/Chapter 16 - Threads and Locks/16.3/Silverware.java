import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Silverware {
	private Lock lock;
	
	public Silverware()
	{
		lock = new ReentrantLock();
	}
	
	public boolean pickUp()
	{
		return lock.tryLock();
	}
	
	public void putDown()
	{
		lock.unlock();
	}
}
