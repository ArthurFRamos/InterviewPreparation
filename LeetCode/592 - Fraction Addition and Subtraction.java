public class Solution {
    public String fractionAddition(String expression) {
        int index = 0;
        ArrayList<Long> numerators = new ArrayList<>();
        ArrayList<Long> denominators = new ArrayList<>();
        
        long denominatorTotal = 1;
        boolean isPositive = true;
        
        while(index < expression.length())
        {
            char temp = expression.charAt(index);
            if(temp == '+')
            {
                isPositive = true;
                index++;
                continue;   
            }
            
            if(temp == '-')
            {
                isPositive = false;
                index++;
                continue;
            }
            
            StringBuffer buffer = new StringBuffer();
            while(expression.charAt(index) != '/')
            {
                buffer.append(expression.charAt(index));
                index++;
            }
            long helper = Long.parseLong(buffer.toString());
            if(!isPositive)
                helper = -helper;
                
            numerators.add(helper);
            index++;
            buffer = new StringBuffer();
            
            while(index < expression.length())
            {
                buffer.append(expression.charAt(index));
                if(index == expression.length() - 1 || (expression.charAt(index + 1) == '+' || expression.charAt(index + 1) == '-'))
                    break;
                index++;
            }
            helper = Long.parseLong(buffer.toString());
            denominators.add(helper);
            
            denominatorTotal *= helper;
            index++;            
        }
        
        long total = 0;
        
        for(int i = 0; i < numerators.size(); i++)
        {
            long temp = numerators.get(i);
            long temp2 = denominators.get(i);
            total += temp *denominatorTotal/temp2;
        }
        
    
        if(total != 0)
        {
            long gcd = GCD(Math.abs(total), denominatorTotal);
            total /= gcd;
            denominatorTotal /= gcd;
        }
        else if(total == 0)
            denominatorTotal = 1;
        
        StringBuffer buffer = new StringBuffer();
    
        buffer.append(Long.toString(total));
        buffer.append("/");
        buffer.append(Long.toString(denominatorTotal));
        
        return buffer.toString();
        
    }
    
    private long GCD(Long a, Long b)
    {
        if(a < b)
        {
            long temp = a;
            a = b;
            b = temp;
        }
        
        if(a % b == 0)
            return b;
            
        return GCD(b, a - b);
        
    }
}