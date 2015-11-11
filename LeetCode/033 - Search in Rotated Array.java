public class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(0,nums.length - 1, nums, target);
    }
    
    private int binarySearch(int begin, int end, int[] nums, int target)
    {
     if(begin > end)
            return -1;
            
        int mid = (begin + end)/2;
        
        if(nums[mid] == target)
            return mid;

        if(nums[begin] <= nums[mid])
        {
            if(target >= nums[begin] && target < nums[mid])
                return binarySearch(begin,mid - 1, nums, target);
            else
                return binarySearch(mid + 1, end, nums , target);
        }
        else
        {
            if(nums[mid] < target && target <= nums[end])
                return binarySearch(mid + 1, end, nums, target);
            else
                return binarySearch(begin, mid - 1, nums, target);
        }
    }
}