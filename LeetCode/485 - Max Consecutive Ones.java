public class Solution {
    
    int maxConsecutive = 0;
    
    public int findMaxConsecutiveOnes(int[] nums) {
        int currentConsecutive = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 1)
                currentConsecutive++;
            else
            {
                if(currentConsecutive > maxConsecutive)
                    maxConsecutive = currentConsecutive;
    
                currentConsecutive = 0;
            }
        }
        
        if(currentConsecutive > maxConsecutive)
            return currentConsecutive;
            
        return maxConsecutive;
    }
}