public class Solution {
    public int lengthOfLastWord(String s) {
        int posLastSpace = -1;
        
        for(int i = s.length() - 1; i >= 0; i--)
        {
            if(s.charAt(i) != ' ')
            {
                s = s.substring(0, i+1);
                break;   
            }
            if(i == 0)
                s = "";
        }
        
        if(s.equals(""))
            return 0;
        
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) == ' ')
                posLastSpace = i;
    
        if(posLastSpace == -1) return s.length();
        
        return (s.length() - posLastSpace) - 1;
    }
}