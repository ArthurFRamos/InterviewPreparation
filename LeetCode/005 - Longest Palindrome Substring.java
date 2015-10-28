public class Solution {
    public String longestPalindrome(String s) {
        for(int i = s.length(); i >0; i--)
        {
            String temp = checkPalindromer(s,s.length(),i);
            if(temp != null)
                return temp;
        }
        return null;
    }
    
    public boolean checkPalindrome(String s, int begin, int end)
    {
        for(int i = 0; i < (end - begin)/2; i++)
        {
            if(s.charAt(begin + i) != s.charAt(end - 1 - i))
                return false;
        }
        return true;
    }
    
    public String checkPalindromer(String s, int stringSize, int size)
    {
        String temp = null;
        for(int i = 0; i <= stringSize - size; i++)
        {
            if(checkPalindrome(s,i, i + size))
            {
                temp = s.substring(i, i + size);
                return temp;   
            }
        }
        return temp;
    }
    
}