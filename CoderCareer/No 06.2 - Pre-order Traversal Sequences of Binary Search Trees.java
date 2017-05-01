
public class PreOrder {
	private int[] traversal;
	
	public PreOrder(int[] nums)
	{
		this.traversal = nums;
	}
	
	public boolean checkTraversal()
	{
		return checkTraversal(0,traversal.length - 1);
	}
	private boolean checkTraversal(int begin, int end)
	{
		if(begin >= end)
			return true;
		
		int mid = -1;
		
		for(int i = begin + 1; i <= end; i++)
		{
			if(traversal[i] > traversal[begin])
			{
				mid = i;
				break;
			}
		}
		if(mid == -1)
			return checkTraversal(begin + 1,end);
		
		if(!checkSeq(mid,end,traversal[begin]))
			return false;
		
		return checkTraversal(begin + 1, mid - 1) && checkTraversal(mid, end);
		
		
	}
	
	private boolean checkSeq(int begin, int end, int root)
	{
		for(int i = begin; i <= end; i++)
		{
			if(traversal[i] <= root)
				return false;
		}
		
		return true;
	}
	
	public static void main (String[] args)
	{
		PreOrder p = new PreOrder(new int[]{10,11,9});
		System.out.println(p.checkTraversal());
	}
	
}
