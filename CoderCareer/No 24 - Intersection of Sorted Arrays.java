import java.util.ArrayList;
import java.util.Iterator;

public class SortedArrayIntersection {
	private int[] nums1;
	private int[] nums2;
	
	public SortedArrayIntersection(int[] nums1, int[] nums2)
	{
		this.nums1 = nums1;
		this.nums2 = nums2;
	}
	
	public ArrayList<Integer> getIntersection()
	{
		int first = 0;
		int second = 0;
		ArrayList<Integer> intersection = new ArrayList<>();
		
		while(first < nums1.length && second < nums2.length)
		{
			if(nums1[first] == nums2[second])
			{
				intersection.add(nums1[first]);
				first++;
				second++;
			}
			else if(nums1[first] > nums2[second])
				second++;
			else
				first++;
		}
		
		return intersection;
	}
	
	public static void main (String[] args)
	{
		ArrayList<Integer> i = new ArrayList<>();
		SortedArrayIntersection a = new SortedArrayIntersection(new int[]{1,4,7,10,13}, new int[]{1,3,5,7,9});
		i = a.getIntersection();
		Iterator<Integer> it = i.iterator();
		
		while(it.hasNext())
			System.out.print(it.next() + " ");
	}
}
