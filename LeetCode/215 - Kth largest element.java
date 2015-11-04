public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return select(nums,nums.length - k + 1,0, nums.length - 1);
    }
    
    
    int select(int[] nums, int k, int left, int right)
    {
        if(left == right)
            return nums[left];
            
        int q = randomizedPartition(left, right, nums);
        int less = q - left + 1;
        
        if(less == k)
            return nums[q];
        else if(k < less)
            return select(nums,k,left,q -1);
        else
            return select(nums, k - less, q + 1, right);
    }
    
    int randomizedPartition(int left, int right, int[] nums)
    {
    	int random = left + (int)((right - left + 1)*Math.random());
    	int temp = nums[random];
    	nums[random] = nums[right];
    	nums[right] = temp;
    	
    	return randomPartition(left,right,nums);
    }
    
    int randomPartition(int left, int right, int[] nums)
    {
        int pivot = right;
        
        int i = left - 1;
        int temp;
        for(int j = left; j < right; j++)
        {
        	if(nums[j] <= nums[pivot])
        	{
        		i = i + 1;
        		temp = nums[i];
        		nums[i] = nums[j];
        		nums[j] = temp;
        	}
        }
        
        temp = nums[i+1];
        nums[i + 1] = nums[pivot];
        nums[pivot] = temp;
        
        return i + 1;
    }
    
}