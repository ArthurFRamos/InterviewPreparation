public class QueueTaker implements Runnable {

	private BlockedQueueSync queue;
	
	public QueueTaker (BlockedQueueSync queue)
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