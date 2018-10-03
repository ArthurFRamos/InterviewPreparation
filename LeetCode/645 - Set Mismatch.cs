public class Solution {
    public int[] FindErrorNums(int[] nums) {
        bool[] flags = new bool[nums.Length];
        int repetead = 0;
        int missing = 0;
        
        foreach(var n in nums)
        {
            if(flags[n-1])
                repetead = n;
            flags[n-1] = true;
        }
        
        for(int i = 0; i < flags.Length; i++)
        {
           if(!flags[i])
               missing = i + 1;
        }
        
        return new int[]{repetead, missing};
    }
}