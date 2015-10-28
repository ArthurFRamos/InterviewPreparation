public class Solution {
    public int removeDuplicates(int[] nums) {
        Integer current = null;
        
        int currentPos = -1;
        int temp = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(current == null)
            {
                current = nums[i];
                currentPos = i;
            }
            
            if(nums[i] != current)
            {
                nums[currentPos + 1] = nums[i];
                current = nums[i];
                currentPos++;
            }
        }
        
        return currentPos + 1;
    }
}