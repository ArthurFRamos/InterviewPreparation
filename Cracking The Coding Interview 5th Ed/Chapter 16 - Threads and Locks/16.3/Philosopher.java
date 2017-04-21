
public class Philosopher implements Runnable {

	private Silverware left;
	private Silverware right;
	public int id;
	private int chompNumber;
	
	public Philosopher(Silverware left, Silverware right, int id)
	{
		this.left = left;
		this.right = right;
		this.id = id;
		this.chompNumber = 1;
	}
	
	private void pickUp()
	{
		boolean leftLock = false;
		boolean rightLock = false;
	
		while(!leftLock || !rightLock)
		{
			leftLock = left.pickUp();
			if(leftLock)
			{
				rightLock = right.pickUp();
				if(!rightLock)
					left.putDown();
			}
		}
	}
	
	private void chomp()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("Philosopher ");
		buffer.append(this.id);
		buffer.append(" has just eaten piece number ");
		buffer.append(this.chompNumber);
		buffer.append(" of a delicious vegetarian salad");
		System.out.println(buffer.toString());
		chompNumber++;
	}
	
	private void putDown()
	{
		left.putDown();
		right.putDown();
	}
	
	private void eat()
	{
		for(int i = 0; i < 10; i++)
		{
			pickUp();
			chomp();
			putDown();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void run()
	{
		eat();
	}
}
