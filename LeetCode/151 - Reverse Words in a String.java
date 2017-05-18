public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        s = removeExtraSpaces(s);
        
        char[] temp = s.toCharArray();
        
        if(temp.length == 0)
        	return "";
        reverse(0, temp.length - 1,temp);
        
        int begin = 0;
        
        for(int i = 0; i < temp.length; i++)
        {
            if(temp[i] == ' ')
            {
                reverse(begin, i - 1, temp);
                begin = i + 1;
            }
        }
        
        reverse(begin, temp.length - 1, temp);
        
        StringBuffer helper = new StringBuffer();
        
        for(int i = 0; i < temp.length; i++)
        	helper.append(temp[i]);
        
        return helper.toString();
    }
    
    private String removeExtraSpaces(String s)
    {
        StringBuffer buffer = new StringBuffer();
        
        for(int i = 0; i < s.length(); i++)
        {
            char temp = s.charAt(i);
            if(temp != ' ')
            {
                buffer.append(temp);
                continue;
            }
            
            if(s.charAt(i + 1) == ' ')
                continue;
            buffer.append(' ');
        }
        
        return buffer.toString();
    }
    
    private void reverse(int begin, int end, char[] s)
    {
        for(int i = 0; i <= (end - begin)/2; i++)
        {
            char temp = s[begin + i];
            s[begin + i] = s[end - i];
            s[end - i] = temp;
        }
    }    
}