	public int CountSteps(int n)
	{
		if(n < 3)
			return n;
		
		int[] temp = new int[3];
		temp[0] = 0;
		temp[1] = 1;
		temp[2] = 2;
		
		for(int i = 3; i <= n; i++)
		{
			int result = temp[0] + temp[1] + temp[2];
			temp[0] = temp[1];
			temp[1] = temp[2];
			temp[2] = result;
		}
		
		return temp[2];
	}