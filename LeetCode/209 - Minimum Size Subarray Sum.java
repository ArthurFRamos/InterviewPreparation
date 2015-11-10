public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i < nums.length; i++)
            nums[i] += nums[i-1];
        
        
        for(int i = nums.length - 1; i >= 0; i--)
        {
            int current = binarySearch(nums[i],i - 1,s,nums);
            
            if(current != -1)
            {
                int temp = i - current;
                if(current == -2)
                	temp = i + 1;
                
                if(temp < min)
                    min = temp;
            }
        }
        
        if(min == Integer.MAX_VALUE)
            return 0;
            
        return min;
    }
    
    private int binarySearch(int sum, int end, int s, int[] nums)
    {
        int begin = 0;
        
        while(begin <= end)
        {
            int mid = (begin + end)/2;
            

                
            if(sum - nums[mid] >= s)
                begin = mid + 1;
            else
                end = mid - 1;
        }
        
        if(begin < nums.length && sum - nums[begin] >= s)
            return begin;
        else if(end >= 0 && sum - nums[end] >= s)
            return end;
        
        if(sum >= s)
        	return -2;
        
        return -1;
    }
}