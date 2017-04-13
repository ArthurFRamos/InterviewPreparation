import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedQueueWithLock {

	private Lock lock;
	private LinkedList<Integer> queue;
	private int length;
	private int size;
	private Condition isFull;
	private Condition isEmpty;

	public BlockedQueueWithLock(int size)
	{
		lock = new ReentrantLock();
		this.length = 0;
		this.size = size;
		queue = new LinkedList<Integer>();
		isFull = lock.newCondition();
		isEmpty = lock.newCondition();
	}

	public void add(int element)
	{
		lock.lock();

		try
		{
			while(length == size)
			{
				isFull.await();
			}

			queue.add(element);
			length++;
			isEmpty.signalAll();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		finally
		{
			lock.unlock();
		}
		
		this.printLinkedList();
	}

	public void remove()
	{


		lock.lock();

		try
		{
			while(length == 0)
			{
				isEmpty.await();
			}

			queue.poll();
			length--;
			isFull.signalAll();

		} catch(InterruptedException e){
			e.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}
		
		this.printLinkedList();
	}
	
	public void printLinkedList()
	{
		lock.lock();
		
		Iterator<Integer> it = queue.iterator();
		
		while(it.hasNext())
			System.out.print(it.next() + " ");
		
		System.out.println("");
		
		lock.unlock();
	}
	
}
