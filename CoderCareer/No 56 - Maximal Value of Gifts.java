
public class Gifts {
	private int[][] gifts;
	
	public Gifts(int[][] matrix)
	{
		gifts = new int[matrix.length + 1][matrix[0].length + 1];
		
		for(int i = 1; i < gifts.length; i++)
			for(int j = 1; j < gifts[0].length; j++)
				gifts[i][j] = matrix[i-1][j-1];
	}
	
	public int maxGifts()
	{
		for(int i = 1; i < gifts.length; i++)
			for(int j = 1; j < gifts.length; j++)
				gifts[i][j] += Math.max(gifts[i-1][j], gifts[i][j-1]);
		
		return gifts[gifts.length - 1][gifts[0].length - 1];
	}
	
	public static void main (String[] args)
	{
		Gifts g = new Gifts(new int[][] {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}});
		
		System.out.println(g.maxGifts());
	}
}
