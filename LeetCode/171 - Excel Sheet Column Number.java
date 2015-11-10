public class Solution {
    public int titleToNumber(String s) {
        
        int number = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            int temp = s.charAt(s.length() - 1 - i) - 'A' + 1;
            
            number += temp*Math.pow(26, i);
        }
        
        return number;
    }
}