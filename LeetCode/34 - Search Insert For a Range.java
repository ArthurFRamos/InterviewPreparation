public class Solution {
    
public int[] searchRange(int[] nums, int target) {
        int first = FirstBinarySearch(nums, target);
        
        if(first < 0 || first > nums.length || nums[first] != target)
            return new int[]{-1,-1};
            
        int second = SecondBinarySearch(nums, target);
        
        return new int[]{second, first};
        
    }
    
    public int FirstBinarySearch(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length - 1;
        
        int mid = start;
        
        while(start <= end)
        {
            mid = (start + end)/2;
            
            if(nums[mid] <= target)
            {
                start = mid + 1;
            }
            else 
            {
                end = mid - 1;
            }
        }
        return start - 1;
    }
    
     public int SecondBinarySearch(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length - 1;
        
        int mid = end;
        
        while(start <= end)
        {
            mid = (start + end)/2;
            
            if(nums[mid] < target)
            {
                start = mid + 1;
            }
            else 
            {
                end = mid - 1;
            }
        }
        return end + 1;
    }
}