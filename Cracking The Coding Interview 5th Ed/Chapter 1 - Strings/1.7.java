	public void setZeros(int[][] matrix)
	{
		boolean[] rows = new boolean[matrix.length];
		boolean[] columns = new boolean[matrix[0].length];
		
		for(int i = 0; i < rows.length; i++)
		{
			for(int j = 0; j < columns.length; j++)
			{
				if(matrix[i][j] == 0)
				{
					rows[i] = true;
					columns[j] = true;
				}
			}
		}
		
		for(int i = 0; i < rows.length; i++)
		{
			if(rows[i])
			{
				for(int j = 0; j < columns.length; j++)
					matrix[i][j] = 0;
			}
		}
		
		for(int i = 0; i < columns.length; i++)
		{
			if(columns[i])
			{
				for(int j = 0; j < rows.length; j++)
					matrix[j][i] = 0;
			}
		}
	}