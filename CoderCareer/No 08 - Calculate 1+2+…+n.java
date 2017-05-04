
public class Calculate {
	private int n;
	private int sum = 0;

	public Calculate(int n)
	{
		this.n = n;
	}

	private void calculate(int n)
	{
		try
		{
			sum += n;
			int[] a = new int[n - 2];
			calculate(n-1);
		} catch(Exception e)
		{

		}

	}

	public int calculate()
	{
		calculate(n);
		return sum;
	}

	public static void main (String[] args)
	{
		Calculate c = new Calculate(10);
		System.out.println(c.calculate());
	}
}
