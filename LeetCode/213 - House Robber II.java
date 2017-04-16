public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0 || nums.length == 1 || nums.length == 2)
            return robHelper(nums);
        
        int max = Integer.MIN_VALUE;
        int[] helper = new int[nums.length - 2];
        int current = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(i == 0)
            {
                for(int j = 2; j < nums.length - 1; j++)
                {
                    helper[current] = nums[j];
                    current++;
                }
            }
            
            else if (i == nums.length - 1)
            {
                for(int j = 1; j < i - 1; j++)
                {
                    helper[current] = nums[j];
                    current++;
                }
            }
            
            else
            {
            
                for(int j = i + 2; j < nums.length; j++)
                {
                    helper[current] = nums[j];
                    current++;
                }
                
                for(int j = 0; j < i - 1; j++ )
                {
                    helper[current] = nums[j];
                    current++;
                }
            }
            
            int temp = nums[i] + robHelper(helper);
            if(temp > max)
                max = temp;
            current = 0;
         }
         
         return max;
    }
    
    public int robHelper(int[] nums) {
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