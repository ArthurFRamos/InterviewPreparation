	public int[] findNumber(int[][] matrix, int num)
	{
		int[] index = new int[2];
		index[0] = -1;
		index[1] = -1;
		
		int col = matrix[0].length - 1;
		int row = 0;
		
		while(col >= 0 && row < matrix.length)
		{
			if(matrix[row][col] == num)
			{
				index[0] = row;
				index[1] = col;
				return index;
			}
			else if(matrix[row][col] > num)
				col--;
			else
				row++;
		}
		
		return index;
	}