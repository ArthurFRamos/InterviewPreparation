public class Solution {
    
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;

        int current;
        int acc =Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++)
        {
            current = nums[i];
            
            if(acc < 0 && current > acc)
                acc = current;
            
            else
                acc += current;
                
            if(acc > max)
                max = acc;
        }
        
        return max;
    }
}
