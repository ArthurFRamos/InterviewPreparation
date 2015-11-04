public class Solution {
    
    public boolean canJump(int[] nums) {
        int max = 0;
        int current = 0;

        
        for(int i = 0; i < nums.length; i++)
        {
            if(i > max)
                return false;
            current = i + nums[i];
            if(current > max)
                max = current;
        }
        
        if(max >= nums.length - 1)
            return true;
            
        return false;
    }
}