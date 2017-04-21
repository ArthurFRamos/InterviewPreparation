
public class TurningNumber {
	private int[] array;
	
	public TurningNumber(int[] array)
	{
		this.array = array;
	}
	
	public int search()
	{
		if(array.length == 1)
			return 0;
		
		int begin = 0;
		int end = array.length - 1;
		
		while(begin <= end)
		{
			int mid = (begin + end)/2;
			
			if(mid == 0)
			{
				if(array[mid] > array[mid+1])
					return mid;
				begin = mid + 1;
			}
			else if(mid == array.length - 1)
			{
				if(array[mid] > array[mid - 1])
					return mid;
				end = mid - 1;
			}
			else
			{
				if(array[mid] > array[mid -1] && array[mid] > array[mid + 1])
					return mid;
				if(array[mid] < array[mid + 1])
					begin = mid + 1;
				else if(array[mid] > array[mid + 1])
					end = mid - 1;
			}
		}
		
		return -1;
	}
	
	public static void main (String[] args)
	{
		int[] a = {5};
		
		TurningNumber t = new TurningNumber(a);
		
		System.out.println(t.search());
	}
}
