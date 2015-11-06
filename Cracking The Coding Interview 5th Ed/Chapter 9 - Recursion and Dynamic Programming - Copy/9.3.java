public int getMagicIndex(int[] A)
	{
		int begin = 0;
		int end = A.length - 1;
		
		int mid = 0;
		
		while(begin <= end)
		{
			mid = (begin + end)/2;
			
			if(A[mid] == mid)
				return mid;
			if(A[mid] > mid)
				end = mid - 1;
			else
				begin = mid + 1;
		}
		
		return -1;
	}
	
	//follow up
	
	public int getMagicIndexWithRepetition(int[] A)
	{
		return search(0,A.length - 1,A);
	}
	
	private int search(int begin, int end, int[] A)
	{
		if((begin < 0 || end > A.length - 1) || begin > end)
			return -1;
		
		int mid = (begin + end)/2;
		int result = -1;
		
		if(A[mid] == mid)
			return mid;
		
		if(A[mid] > mid)
		{
			result = search(begin,mid -1,A);
			return result != -1 ? result : search(A[mid],end,A);
		}
	
		else
		{
			result = search(mid + 1,end);
			return result != -1 ? result : search(begin,A[mid],A);
		}
	}
	