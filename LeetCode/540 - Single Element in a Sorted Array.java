public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1)
            return nums[0];
            
        int begin = 0;
        int end = nums.length - 1;

        while(begin <= end)
        {
            int mid = (begin + end)/2;
    
            if(mid == nums.length - 1)
            {
                if(nums[mid] == nums[mid - 1])
                    end = mid - 2;
                else
                    return nums[mid];
            }
            
            else if(mid == 0)
            {
                if(nums[mid] == nums[nums.length - 1])
                    begin = mid + 2;
                else
                    return nums[mid];
            }
            else
            {
                if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid + 1])
                    return nums[mid];
                
                if(mid % 2 == 0)
                {
                    if(nums[mid] == nums[mid + 1])
                        begin = mid + 2;
                    else
                        end = mid - 1;
                }
                else
                {
                    if(nums[mid] == nums[mid - 1])
                        begin = mid + 1;
                    else
                        end = mid - 1;
                }
            }
        }
        
        return -1;
    }
}