public class FibonacciSequence {
	public int[] fibonacci;
	
	public FibonacciSequence()
	{
		fibonacci = new int[1000];
		fibonacci[0] = 1;
		fibonacci[1] = 1;
	}
	
	public int calculate(int n)
	{
		if(fibonacci[n-1] != 0)
			return fibonacci[n-1];
		fibonacci[n-1] = calculate(n-2) + calculate(n-1);
		
		return fibonacci[n-1];
	}
	
	public static void main(String[] args)
	{
		FibonacciSequence s = new FibonacciSequence();
		System.out.println(s.calculate(1000));
	}
	
	
}
