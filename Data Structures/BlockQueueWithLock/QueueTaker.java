
public class QueueTaker implements Runnable {

	private BlockedQueueWithLock queue;
	
	public QueueTaker (BlockedQueueWithLock queue)
	{
		this.queue = queue;
	}
	
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(100);
				
				queue.remove();
				
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
