public class Solution {
    
    public int rob(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
            
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        max = dp[0];
        
        dp[1] = Math.max(dp[0], nums[1]);
        
        if(dp[1] > max)
            max = dp[1];
        
        for(int i = 2; i < dp.length; i++)
        {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            if(dp[i] > max)
                max = dp[i];
        }
        
        return max;
    }
}
