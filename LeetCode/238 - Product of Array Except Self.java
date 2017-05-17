public class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        
        if(nums.length == 0)
            return new int[0];
        
        int[] output = new int[nums.length];
        
        if(nums.length == 1)
            return output;

        output[0] = 1;
        int temp = nums[0];
        
        for(int i = 1; i < output.length; i++)
        {
            output[i] = temp;
            temp  = temp * nums[i];
        }
        
        temp = nums[nums.length - 1];
        
        for (int i = output.length -2; i >= 0; i--)
        {
            output[i] = output[i]* temp;
            temp = temp * nums[i];
        }
        
        return output;
        
    }
}