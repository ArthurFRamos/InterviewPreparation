public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        int[] helper = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++)
            helper[i] = nums[i];
        
        Arrays.sort(helper);
        
        while(left < nums.length && nums[left] == helper[left])
            left++;
        while( right > 0 && nums[right] == helper[right])
            right--;
        
        if(right < left)
            return 0;
            
        return right - left + 1;
    }
}