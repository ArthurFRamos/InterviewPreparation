public class LeastNumber {
	private int number;
	
	public LeastNumber(int number)
	{
		this.number = number;
	}
	
	public int leastNumber(int k)
	{
		return leastNumber(Integer.toString(number), k);
	}
	private int leastNumber(String current, int k)
	{
		if(k == 0)
			return Integer.parseInt(current);
		if(current.length() == 0)
			return 0;
		
		for(int i = 0; i < current.length() - 1; i++)
		{
			int temp = Character.getNumericValue(current.charAt(i));
			if(temp > Character.getNumericValue(current.charAt(i + 1)))
				return leastNumber(current.substring(0, i).concat(current.substring(i + 1, current.length())),k - 1);
		}
		
		return leastNumber(current.substring(0, current.length()  - 1), k - 1);
	}
	
	public static void main(String[] args)
	{
		LeastNumber n = new LeastNumber(666666);
		System.out.println(n.leastNumber(3));
	}
}
