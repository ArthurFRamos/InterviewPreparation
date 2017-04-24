
public class PairDifference {
	
	private int[] nums;
	
	public PairDifference(int[] nums)
	{
		this.nums = nums;
	}
	
	public int maxDiff()
	{
		int minimum = nums[nums.length - 1];
		int diff = Integer.MIN_VALUE;
		
		for(int i = nums.length - 2; i > 0; i--)
		{
			int temp = nums[i] - minimum;
			if(nums[i] < minimum)
				minimum = nums[i];
			if(temp > diff)
				diff = temp;
		}
		
		return diff;
	}
	
	public static void main(String[] args)
	{
		int[] array = {2,4,1,16,7,5,11,9};
		PairDifference d = new PairDifference(array);
		System.out.println(d.maxDiff());
	}
}
