public class Solution {
    public int maxSubArray(int[] nums) {
        
        if(nums.length == 0)
            return 0;
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++)
        {
            curSum += nums[i];
            if(curSum > maxSum)
                maxSum = curSum;
            if(curSum < 0)
                curSum = 0;
        }
        
        return maxSum;
    }
}