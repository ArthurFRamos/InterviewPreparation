public class Solution {
    public void sortColors(int[] nums) {
       int[] count = new int[3];
       
       for(int i = 0; i < nums.length; i++)
            count[nums[i]]++;
        
        int pos = 0;
        for(int i = 0; i < 3 && pos < nums.length; i++)
        {
            while(count[i] != 0)
            {
                nums[pos] = i;
                count[i]--;
                pos++;
            }
        }
    }
}