public class Solution {
    public String longestPalindrome(String s) {
        String max = "";
        
        for(int i = 0; i < s.length(); i++)
        {
            String temp = expand(i,i,s);
            if(temp.length() > max.length())
                max = temp;
            temp = expand(i,i+1,s);
            if(temp.length() > max.length())
                max = temp;
        }
        
        return max;
    }
    
    public String expand( int i, int j, String s)
    {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j))
        {
            i--;
            j++;
        }
        
        return s.substring(i + 1,j);
    }
}