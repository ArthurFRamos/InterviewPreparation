class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int max = 1;
        
        int current = 1;
        int temp = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] > temp)
            {
                current++;
                if(current > max)
                    max = current;
            }
            else
                current = 1;
                    
            temp = nums[i];
        }
        
        return max;
    }
}