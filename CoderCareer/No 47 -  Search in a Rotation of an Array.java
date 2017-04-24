public class Solution {
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        
        while(begin <= end)
        {
            int mid = (begin + end)/2;
            if(nums[mid] == target)
                return mid;
            
            if(nums[mid] < nums[end])
            {
                if(target >= nums[mid] && target <= nums[end])
                    begin = mid + 1;
                else
                    end = mid - 1;
            }
            else
            {
                if(target >= nums[mid] || target <= nums[end])
                    begin = mid + 1;
                else
                    end = mid - 1;
            }
        }
        
        return -1;
    }
}