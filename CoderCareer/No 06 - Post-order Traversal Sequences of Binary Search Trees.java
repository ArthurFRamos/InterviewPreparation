import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostOrder {
	private int[] list;
	
	public PostOrder(int[] array)
	{
		this.list = array;
	}
	
	public boolean checkOrder()
	{
		return checkOrder(0,list.length - 1);
	}
	
	private boolean checkOrder(int i, int j)
	{
		int root = list[j];
		if(i == j)
			return true;
		
		for(int k = i; k <= j; k++)
		{
			if(list[k] < root)
				continue;
			return checkArray(k,j-1,root) && checkOrder(i, k - 1) && checkOrder(k, j -1);
		}
		
		return false;
	}
	
	private boolean checkArray(int i, int j, int number)
	{
		for(int k = i; k <= j; k++)
		{
			if(list[k] < number)
				return false;
		}
		
		return true;
	}
	
	public static void main (String[] args)
	{
		PostOrder p = new PostOrder(new int[] {7,4,6,5});
		System.out.println(p.checkOrder());
	}
}
