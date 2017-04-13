import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedQueueSync {

	private LinkedList<Integer> queue;
	private int size;
    private final Object lock = new Object();
    
	public BlockedQueueSync(int size)
	{
		this.size = size;
		queue = new LinkedList<Integer>();
	}

	public void add(int element)
	{

        synchronized(lock)
        {
    		try
    		{
    			while(this.queue.size() == size)
    			{
    				lock.wait();
    			}
    
    			queue.add(element);
    			lock.notifyAll();
        
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		} 
    		
    		this.printLinkedList();
        }
	}

	public synchronized void remove()
	{
        synchronized(lock)
        {
    		try
    		{
    			while(this.queue.size() == 0)
    			{
    			    lock.wait();
    			}
    
    			queue.poll();
    			lock.notifyAll();
    
    		} catch(InterruptedException e){
    			e.printStackTrace();
    		}
    
    		this.printLinkedList();
        }
	}
	
	public void printLinkedList()
	{
		
		Iterator<Integer> it = queue.iterator();
		
		while(it.hasNext())
			System.out.print(it.next() + " ");
		
		System.out.println("");
		
	}
	
}