public class Solution {
    public int findPeakElement(int[] nums) {
        return bSearch(0,nums.length - 1,nums);
    }
    
    public int bSearch(int begin, int end, int[] nums)
    {
        while(begin <= end)
        {
            int mid = (begin + end)/2;
            int low = (mid == 0) ? Integer.MIN_VALUE : nums[mid-1];
            int high = (mid == (nums.length - 1)) ? Integer.MIN_VALUE : nums[mid+1];
         
            if(low <= nums[mid] && nums[mid] <= high)
                begin = mid + 1;
            else if (low >= nums[mid] && nums[mid] >= high)
                end = mid - 1;
            else if(nums[mid] <= low && nums[mid] <= high)
                end = mid - 1;
            else
                return mid;
        }
        //You have to take in account the case that there is only one element and it is equal to MIN_VALUE..
        //Therefore, it will not return mid, since it will pass the first condition
        //Also, begin will be higher than end, returning the wrong index. We return 0 to handle that case.
        return 0;
    }
}