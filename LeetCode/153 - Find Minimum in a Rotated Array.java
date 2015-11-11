public class Solution {
    public int findMin(int[] nums) {
        return binarySearch(nums,0,nums.length - 1);
    }
    
    private int binarySearch(int[] nums, int begin, int end)
    {
        while(begin < end)
        {
            int mid = (begin + end)/2;
            
            if(nums[mid] > nums[end])
                begin = mid + 1;
            else if(nums[begin] > nums[mid])
                end = mid;
            else
                return nums[begin];
        }
        
        return nums[begin];
    }
}