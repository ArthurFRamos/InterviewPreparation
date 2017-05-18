public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        
        StringBuffer buffer = new StringBuffer();
        boolean negative = false;
        
        for(int i = 0; i < str.length(); i++)
        {
            if(i == 0)
            {
                if(str.charAt(i) == '+')
                    continue;
                else if (str.charAt(i) == '-')
                {
                    negative = true;
                    continue;
                }
            }
            if(str.charAt(i) == ' ' || (str.charAt(i) < '0' || str.charAt(i) > '9'))
                break;
            buffer.append(str.charAt(i));
        }
        
        if(buffer.length() == 0)
            return 0;
        
        long ans = 0;
        long temp = 1;
        
        if(buffer.length() >= 11)
        {
            if(negative)
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }
            
        for(int i = buffer.length() - 1; i >= 0; i--)
        {
            int current = Character.getNumericValue(buffer.charAt(i));
            ans += current * temp;
            temp = temp * 10;
        }
        
        if(negative)
            ans = -ans;
        if(ans > Integer.MAX_VALUE)
            ans = Integer.MAX_VALUE;
        else if (ans < Integer.MIN_VALUE)
            ans = Integer.MIN_VALUE;
        
        return (int)ans;
    }
}