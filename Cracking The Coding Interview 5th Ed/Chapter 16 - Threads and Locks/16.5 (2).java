import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ExecuteOrder implements Runnable {
	
	private Semaphore sem1, sem2;
	
	public ExecuteOrder ()
	{
		sem1 = new Semaphore(1);
		sem2 = new Semaphore(1);
		try
		{
			sem1.acquire();
			sem2.acquire();
		}catch(Exception e)
		{
			
		}
	}
	
	public void foo()
	{
		int id = (int)(Thread.currentThread().getId() % 3) + 1;

		if(id == 1)
			first();
		else if(id == 2)
			second();
		else
			third();
	}
	private void first()
	{
		System.out.println("first");
		sem1.release();
	}
	
	private void second()
	{
		try{
			sem1.acquire();
		}
		
		catch(Exception e)
		{
			
		}
		System.out.println("second");
		sem1.release();
		sem2.release();
	}
	
	private void third()
	{
		try
		{
			sem2.acquire();
		}catch (Exception e)
		{
			
		}
		
		sem2.release();
		System.out.println("third");
	}
	
	public void run()
	{
		this.foo();
	}
	
	public static void main(String[] args)
	{
		ExecuteOrder ex = new ExecuteOrder();
		for(int i = 0; i < 3; i++)
			new Thread(ex).start();
	}
}
