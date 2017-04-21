
public class Manager {
	private Philosopher[] philosophers;
	
	public Manager(int numberOfPhilosophers)
	{
		Silverware[] silverwares = new Silverware[numberOfPhilosophers];
		for(int i = 0; i < silverwares.length; i++)
			silverwares[i] = new Silverware();
		
		philosophers = new Philosopher[numberOfPhilosophers];
		for(int i = 0; i < numberOfPhilosophers; i++)
			philosophers[i] = new Philosopher(silverwares[i], silverwares[(i+1)%numberOfPhilosophers], i + 1);
	}
	
	public void simulate()
	{
		for(int i = 0; i < philosophers.length; i++)
			new Thread(philosophers[i]).start();
		
	}
	
	public static void main(String[] args)
	{
		Manager m = new Manager(100);
		m.simulate();
	}
}
