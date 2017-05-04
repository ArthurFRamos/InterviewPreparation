
public class CutRope {

	private int length;
	private int[][] map;
	private int cuts;
	
	public CutRope(int l, int cuts)
	{
		this.length = l;
		this.cuts = cuts;
		map = new int[length + 1][cuts + 1];
	}
	
	public int maxProduct()
	{
		return maxProduct(length, cuts);
	}
	private int maxProduct(int n, int m)
	{
		
		if(n == m)
		{
			map[n][m] = 1;
			return 1;
		}
		if(map[n][m] != 0)
			return map[n][m];
		
		if(m == 1)
		{
			map[n][m] = n;
			return n;
		}
		
		int maxProduct = Integer.MIN_VALUE;
		
		for(int i = 1; i <= n - m; i++)
		{
			int current =  i* maxProduct(n - i, m - 1);
			if(current > maxProduct)
				maxProduct = current;
		}
		
		map[n][m] = maxProduct;
		
		return map[n][m];
	}
	
	public static void main (String[] args)
	{
		CutRope r = new CutRope(8, 8);
		System.out.println(r.maxProduct());
	}
}
