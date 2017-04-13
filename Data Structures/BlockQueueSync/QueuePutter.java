import java.util.Random;

public class QueuePutter implements Runnable {

	private BlockedQueueSync queue;

	public QueuePutter(BlockedQueueSync queue)
	{
		this.queue = queue;
	}

	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(10);

				Random rand = new Random();
				queue.add(rand.nextInt(10));

				Thread.sleep(10);

			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

}