public class Solution {
    public int findComplement(int num) {
        int helper = ~0;
        int first = firstNoLeadingZero(num);
        helper = helper << (first + 1);
        helper = ~helper;
        
        return ~num & helper;
    }
    
    public int firstNoLeadingZero(int num)
    {
        for(int i = 31; i >= 0; i--)
        {
            if(((1 << i) & num) != 0)
                return i;
        }
        
        return 0;
    }
}