public class Solution {
    public int singleNumber(int[] nums) {
        
        int answer = 0;
        
        for(int i = 0; i < 32; i++)
        {
            int countOnes = 0;
            int countZeros = 0;
            
            for(int j = 0; j < nums.length; j++)
            {
                int current = getBit(i,nums[j]);
                if(current == 0)
                    countZeros++;
                else
                    countOnes++;
            }
            
            
            if(countOnes % 3 != 0)
                answer = setBit(i,answer,1);
            else
                answer = setBit(i,answer,0);
        }
        
        return answer;
    }
    
    private int getBit(int pos, int num)
    {
        return (((1 << pos) & num) == 0) ? 0 : 1;
    }
    
    private int setBit(int pos, int num, int bit)
    {
        if(bit == 1)
            return ((1 << pos) | num);
        
        else
            return (~(1 << pos) & num);
    }
    
}