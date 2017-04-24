import java.util.HashSet;

public class GroupOfOne {
	private int[][] matrix;
	HashSet<Integer> flags;
	
	public GroupOfOne(int[][] matrix)
	{
		this.matrix = matrix;
		flags = new HashSet<>();
	}
	
	public int countGroups()
	{
		int count = 0;
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				int position = i*matrix[0].length + j;
				if(matrix[i][j] == 1 && !flags.contains(position))
				{
					pass(i,j);
					count++;
				}
			}
		}
		
		return count;
	}
	private void pass( int i, int j)
	{
		if(i < 0 || j < 0 || i > matrix.length - 1 || j > matrix[0].length - 1)
			return;
		if(matrix[i][j] != 1)
			return;
		
		int position = i * matrix[0].length + j;
		if(flags.contains(position))
			return;
		
		flags.add(position);
		pass(i-1, j);
		pass( i + 1, j);
		pass(i,j+1);
		pass(i,j-1);
	}
	
	public static void main(String[] args)
	{
		int[][] matrix = {{1,1,0,0,1}, {1,0,0,1,0}, {1,1,0,1,0},{0,0,1,0,0}};
		GroupOfOne g = new GroupOfOne(matrix);
		System.out.println(g.countGroups());
	}
}
