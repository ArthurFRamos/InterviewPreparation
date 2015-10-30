public class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length == 0)
            return 0;
            
        int repetition = 1;
        int last = nums[0];
        int position = 1;
        
        for(int i = 1; i < nums.length; i++)
        {
            if(last == nums[i])
                repetition++;
            else
                repetition = 0;
                
            if(repetition <= 2)
            {
                nums[position] = nums[i];
                position++;
            }
            
            repetition++;
            last = nums[i];
        }
        
        return position;
    }
}