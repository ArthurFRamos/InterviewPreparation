public class Solution {
    public int search(int[] nums, int target) {
     
        int b = 0;
        int e = nums.length - 1;
        
        while(b <= e)
        {
            int mid = (b + e)/2;
            
            if(nums[mid] == target)
                return mid;
            if(target > nums[mid])
            {
                if(target <= nums[e])
                    b = mid + 1;
                else if (nums[e] < nums[mid])
                    b = mid + 1;
                else 
                    e = mid - 1;
            }
            
            else
            {
                if(nums[b] <= target)
                    e = mid - 1;
                else if(nums[b] > nums[mid])
                    e = mid - 1;
                else
                    b = mid + 1;
            }
        }
        
        return -1;
    }
}
