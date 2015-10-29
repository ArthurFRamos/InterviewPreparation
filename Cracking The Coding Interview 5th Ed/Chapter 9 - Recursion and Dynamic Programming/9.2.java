public class RobotGrid {

	private int[][] grid;
	private boolean[][] offLimits;
	
	public RobotGrid(int x, int y, boolean[][] offLimits)
	{
		grid = new int[x][y];
		this.offLimits = offLimits;
	}
	
	
	public int numberOfPaths(int x, int y)
	{
		
		if((y < 0 || y >= grid.length) || (x <0 || x >= grid[0].length))
			return -1;
		
		if(offLimits[0][0])
			return -1;
		
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[0].length; j++)
			{	
				if(!offLimits[i][j])
					setValue(grid,j,i);
			}
		}
		return grid[y][x];
	}
	
	public String pathLeftToBottom()
	{		
		int currentX = grid[0].length - 1;
		int currentY = grid.length - 1;
		
		this.numberOfPaths(currentX, currentY);
		
		if(grid[grid.length - 1][grid[0].length - 1] == 0)
			return "There is no such path";
		
		StringBuffer buffer = new StringBuffer();
		
		while(currentX != 0 || currentY != 0)
		{
			buffer.append(currentY);
			buffer.append(",");
			buffer.append(currentX);
			buffer.append(" - ");
			
			if(currentX == 0)
				currentY--;
			
			else if(currentY == 0)
				currentX--;
			
			else
			{
				if(grid[currentY-1][currentX] != 0)
					currentY--;
				else
					currentX--;
			}
		}
		
		buffer.append("0,0");
		buffer.reverse();
		
		return buffer.toString();
	}
	
	private void setValue(int[][] grid, int x, int y)
	{
		if(x == 0 && y == 0)
		{
			grid[0][0] = 1;
			return;
		}
		
		int leftValue = 0;
		
		if(x - 1 >= 0)
			leftValue = grid[y][x-1];
		
		int rightValue = 0;
		
		if(y - 1 >= 0)
			rightValue = grid[y - 1][x];
		
		grid[y][x] = leftValue + rightValue;
	}