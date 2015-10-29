public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
            
        int[] cash = new int[2];
        cash[0] = 0;
        cash[1] = nums[0];
        int answer = 0;
        
        
        
        for(int i = 1; i < nums.length; i++)
        {
            answer = Math.max(cash[1], cash[0] + nums[i]);
            cash[0] = cash[1];
            cash[1] = answer;
        }
        return answer;
    }
}