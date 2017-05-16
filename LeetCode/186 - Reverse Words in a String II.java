public class Solution {
    public void reverseWords(char[] s) {
        
        if(s.length == 0)
            return;
        reverse(0, s.length - 1, s);
        
        int begin = 0;
        int end = 0;
        
        while(end < s.length)
        {
            while(end < s.length && s[end] != ' ')
                end++;
            
            reverse(begin, end - 1,s);
            end++;
            begin = end;
        }
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