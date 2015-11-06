public int findIndex(int[] nums, int value)
	{
		return binarySearch(nums,value,0,nums.length - 1);
	}
	
	private int binarySearch (int[] nums, int value, int begin, int end)
	{
		if(begin > end)
			return -1;

		int mid = (begin + end)/2;

		if(nums[mid] == value)
			return mid;
		if(nums[begin] == value)
			return begin;
		if(nums[end] == value)
			return end;
		
		boolean firstCondition = ((nums[begin] < nums[mid]) && (value > nums[begin] && value < nums[mid]));
		boolean secondCondition = ((nums[begin] >= nums[mid]) && (value > nums[begin] || value < nums[mid]));
		
		if(firstCondition || secondCondition)
		{
			int answer = binarySearch(nums,value,begin + 1, mid - 1);
			if(answer != -1)
				return answer;
		}
		
		firstCondition = ((nums[mid] < nums[end]) && (value > nums[mid] && value < nums[end]));
		secondCondition = (nums[mid] >= nums[end]) && (value > nums[mid] || value < nums[end]);

		if(firstCondition || secondCondition)
		{
			int answer =  binarySearch(nums,value,mid + 1, end - 1);
			if(answer != -1)
				return answer;
		}
		
		return -1;
	}