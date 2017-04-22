
public class Solution {

	
	public static class Foo implements Runnable
	{
		public static Boolean _FIRST = false;
		public static boolean _SECOND = false;
		private int threadId;
	 
		public Foo(int threadId)
		{
			this.threadId = threadId;
		}
		
		public void first()
		{
			System.out.println("Called First ");
			
		}
		
		public void second()
		{
			System.out.println("Called Second");
		}
		
		public void third()
		{
			System.out.println("Called Third");
		}
		
		public void run()
		{
			if(threadId == 0)
			{
				first();
				_FIRST = true;
			}
			
			else if(threadId == 1)
			{
				while(!_FIRST);
				second();
				_SECOND = true;
			}
			else
			{
				while(!_FIRST || !_SECOND);
				third();
			}
		}
	}
	public void startThreads()
	{
		Foo firstFoo = new Foo(0);
		Foo secondFoo = new Foo(1);
		Foo thirdFoo = new Foo(2);
		Thread first = new Thread(firstFoo);
		Thread second = new Thread(secondFoo);
		Thread third = new Thread(thirdFoo);
		third.start();
		second.start();
		first.start();
		
	}
	public static void main(String[] args)
	{
		Solution s = new Solution();
		s.startThreads();
	}
}
