public class Solution {
    public boolean search(int[] nums, int target) {
        int temp = binarySearch(0,nums.length - 1, nums, target);
        
        if(temp == -1)
            return false;
        return true;
    }
    
    private int binarySearch(int begin, int end, int[] nums, int target)
    {
     if(begin > end)
            return -1;
            
        int mid = (begin + end)/2;
        
        if(nums[mid] == target)
            return mid;

        if(nums[begin] < nums[mid])
        {
            if(target >= nums[begin] && target <= nums[mid])
                return binarySearch(begin,mid - 1, nums, target);
            else
                return binarySearch(mid + 1, end, nums , target);
        }
        else if (nums[mid] < nums[end])
        {
            if(nums[mid] <= target && target <= nums[end])
                return binarySearch(mid + 1, end, nums, target);
            else
                return binarySearch(begin, mid - 1, nums, target);
        }
        else
        {
            int temp = binarySearch(mid + 1, end, nums,target);
            if(temp == -1)
                return binarySearch(begin, mid -1, nums, target);
            
            return temp;
        }
    }
}