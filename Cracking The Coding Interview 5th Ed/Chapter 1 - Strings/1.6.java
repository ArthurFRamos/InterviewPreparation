	public void rotate(int[][] matrix)
	{
		rotate(0,matrix.length, matrix);
	}
	
	private void rotate(int begin, int size, int[][] matrix)
	{
		if(size <= 0)
			return;
		
		for(int i = 0; i < size/2; i++)
		{
			int temp = 	matrix[begin + size - 1][begin + i];
			matrix[begin + size - 1][begin + i] = matrix[begin + size - 1][begin + size - 1 - i];
			matrix[begin + size - 1][begin + size -1 -i] = matrix[begin][begin + size - 1 - i];
			matrix[begin][begin + size -1 - i] = matrix[begin + i][begin];
			matrix[begin + i][begin] = temp;
		}
		
		rotate(begin + 1, size - 2, matrix);
	
	}