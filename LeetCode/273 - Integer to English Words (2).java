public class Solution {
    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {" ", " ", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    StringBuffer buffer = new StringBuffer();
    
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        
        helper(num);
        
        return buffer.toString().trim();
    }
    
    private void helper(int num)
    {
        if(num < 10)
        {
            if(num != 0)
                buffer.append(" ");
            buffer.append(belowTen[num]);   
        }
        
        else if(num < 20)
        {
            buffer.append(" ");
            buffer.append(belowTwenty[num - 10]);
        }
        
        else if(num < 100)
        {
            buffer.append(" ");
            buffer.append(belowHundred[num / 10]);
            helper(num % 10);
        }
        
        else if(num < 1000)
        {
            helper(num/100);
            buffer.append(" Hundred");
            helper(num%100);
        }
        
        else if (num < 1000000)
        {

            helper(num/1000);
            buffer.append(" Thousand");
            helper(num % 1000);
        }
        
        else if( num < 1000000000)
        {
            helper(num/1000000);
            buffer.append(" Million");
            helper(num % 1000000);
        }
        
        else
        {
            helper(num/1000000000);
            buffer.append(" Billion");
            helper(num % 1000000000);
        }
    }
}