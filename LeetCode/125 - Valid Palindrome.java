public class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer buffer = new StringBuffer();
        
        s = s.toLowerCase();

        for(int i = 0; i < s.length(); i++)
        {
            int value = (int)s.charAt(i);
            
            if((value >= 'a' && value <= 'z') || (value >= '0' && value <= '9'))
                buffer.append(s.charAt(i));
        }
        
        return checkPalindrome(buffer.toString());
    }
    
    private boolean checkPalindrome(String s)
    {
        for(int i = 0; i < s.length()/2; i++)
        {
            if(s.charAt(i) != s.charAt(s.length() -1 - i))
                return false;
        }
        
        return true;
    }
}