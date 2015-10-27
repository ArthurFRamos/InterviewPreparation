public class Operations {

	
	public int subtract(int x, int y)
	{
		return x + multiply(-1,y);
	}
	
	public int multiply(int x, int y)
	{
		int temp = 0;
		int absY = Math.abs(y);
		int absX = Math.abs(x);
		for(int i = 0; i < absX; i++)
			temp += absY;
		
		return getSignal(temp,x,y);
	}
	
	public int division(int x, int y)
	{
		int count = 0;
		int absY = Math.abs(y);
		int absX = Math.abs(x);
		int accumulator = absY;
		
		while(accumulator <= absX)
		{
			count++;
			accumulator += absY;
		}
		
		return getSignal(count,x,y);
		
	}
	
	private int getSignal(int result, int x, int y)
	{
		if(x >= 0 && y >=0 )
			return result;
		else if (x < 0 && y < 0)
			return result;
		else
			return -result;
	}