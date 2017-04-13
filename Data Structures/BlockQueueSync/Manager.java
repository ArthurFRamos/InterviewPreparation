public class Manager{

    private int numberPutters;
	private int numberTakers;
	
	public Manager(int nPutters, int nTakers)
	{
		this.numberPutters = nPutters;
		this.numberTakers = nTakers;
	}
	
	public void simulate()
	{
		BlockedQueueSync queue = new BlockedQueueSync(20);
		
		for(int i = 0; i < numberPutters; i++)
		{
			QueuePutter temp = new QueuePutter(queue);
			new Thread(temp).start();
			
		}
		
		for(int i = 0; i < numberTakers; i++)
		{
			QueueTaker temp = new QueueTaker(queue);
			new Thread(temp).start();
		}
		
	}
	
	public static void main(String[] args)
	{
		Manager m = new Manager(10, 10);
		
		m.simulate();
		
	}
	
}
