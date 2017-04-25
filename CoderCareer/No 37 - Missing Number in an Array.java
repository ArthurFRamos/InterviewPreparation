public class MissingNumber {
	private int[] numbers;
	private int totalSum;
	public MissingNumber(int[] numbers)
	{
		this.numbers = numbers;
		totalSum = ((numbers.length)*(numbers.length + 1))/2;
	}
	
	public int findMissing()
	{
		int sum = 0;
		for(int i = 0; i < numbers.length; i++)
			sum += numbers[i];
		
		return totalSum - sum;
	}
	
}
