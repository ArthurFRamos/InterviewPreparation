
public class StringPath {
	private char[][] matrix;
	private String word;
	private boolean[][] flags;
	
	public StringPath(char[][] matrix, String word)
	{
		this.matrix = matrix;
		this.word = word;
		flags = new boolean[matrix.length][matrix[0].length];
	}
	
	public boolean findPath()
	{
		boolean ans = false;
		
		for(int i = 0; i < matrix.length && !ans; i++)
			for(int j = 0; j < matrix[i].length; j++)
				ans = ans || findPath(0,i,j);
		
		return ans;
	}
	private boolean findPath(int index, int i, int j)
	{
		if(index == word.length())
			return true;
		
		if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length)
			return false;
		if(flags[i][j])
			return false;
		
		
		boolean ans = false;
		if(matrix[i][j] == word.charAt(index))
		{
			flags[i][j] = true;
			ans = findPath(index + 1, i-1,j) || findPath(index + 1, i+1,j) 
						  || findPath(index + 1, i, j + 1) || findPath(index + 1, i, j - 1);
			flags[i][j] = false;
		}
		else
			return false;
		
		return ans;
	}
	
	public static void main (String[] args)
	{
		char[][] matrix = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "BCCEDS";
		StringPath p = new StringPath(matrix, word);
		System.out.println(p.findPath());
	}
}
