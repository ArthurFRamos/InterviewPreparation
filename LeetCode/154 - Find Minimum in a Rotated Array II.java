public class Solution {
    public int findMin(int[] nums) {
        return binarySearch(nums,0,nums.length - 1);
    }
    
    private int binarySearch(int[] nums, int begin, int end)
    {
        int mid = (begin + end)/2;
        
        if(begin == end)
            return nums[begin];
            
        if(nums[mid] > nums[end])
            return binarySearch(nums, mid + 1, end);
        else if(nums[begin] > nums[mid])
            return binarySearch(nums,begin, mid);
        else if(nums[begin] < nums[mid] && nums[mid] < nums[end])
            return nums[begin];
        else
        {
            int first = binarySearch(nums, mid + 1, end);
            int second = binarySearch(nums,begin, mid);
            return Math.min(first,second);
        }
    }
}