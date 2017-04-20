
public class IntegerIndex {
	private int[] array;
	
	public IntegerIndex(int[] array)
	{
		this.array = array;
	}
	
	public int BinarySearch()
	{
		int begin = 0;
		int end = array.length - 1;
		
		while(begin <= end)
		{
			int mid = (begin + end)/2;
			if(array[mid] == mid)
				return mid;
			
			if(array[mid] < mid)
				begin = mid + 1;
			else
				end = mid - 1;
		}
		
		return -1;
	}
	
	public static void main(String[] args)
	{
		IntegerIndex i = new IntegerIndex(new int[] {-3,-1,1,2,5});
		System.out.println(i.BinarySearch());
	}
}
