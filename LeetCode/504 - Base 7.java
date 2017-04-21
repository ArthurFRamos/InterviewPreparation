public class Solution {
    public String convertToBase7(int num) {
        if(num == 0)
            return "0";
        boolean negative = false;
        
        if(num < 0)
        {
            negative = true;
            num = -num;   
        }
        
        StringBuffer buffer = new StringBuffer();
        
        while(num != 0)
        {
            int current = num % 7;
            buffer.append(current);
            num /= 7;
        }
        
        if(negative)
            buffer.append('-');
        
        return buffer.reverse().toString();
        
    }
}