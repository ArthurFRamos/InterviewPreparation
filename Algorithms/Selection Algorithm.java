public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return rank(0,nums.length -1, k, nums);
    }
    
    private int rank(int left, int right, int rank, int[] nums)
    {
        Random r = new Random();
        
        int pivot = nums[r.nextInt(right - left + 1) + left];
        
        int leftIndex = partition(left,right,pivot,nums);
        int leftSize = leftIndex - left + 1;
        
        if(leftSize == rank)
            return min(left,leftIndex,nums);
        else if(rank < leftSize)
        {   
            if(nums[leftIndex] == nums[leftIndex - 1])
                leftIndex = leftIndex - 1;
    
            return rank(left,leftIndex,rank,nums);
        }
        else
            return rank(leftIndex + 1, right, rank - leftSize, nums);
        
    }
    
    private int partition(int left, int right, int pivot, int[] nums)
    {
        while(true)
        {
            while(left <= right && nums[left] >= pivot)
                left++;
            while(left <= right && nums[right] < pivot)
                right--;
                
            if(left > right)
            {
                return left - 1;
                
            }
  
            swap(left,right,nums);
        }
    }
    
    private int min(int left, int right, int[] nums)
    {
        int min = Integer.MAX_VALUE;
        
        for(int i = left; i <= right; i++)
        {
            if(nums[i] < min)
                min = nums[i];
        }
        
        return min;
    }
    
    private void swap(int a, int b, int[] nums)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
}