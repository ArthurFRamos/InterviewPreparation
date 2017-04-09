public class Solution {
    public String shortestPalindrome(String s) {
        //To find the shortest palindrome, we need to calculate the longest prefix that is also a suffix of s + reverse(s). 
        //That way, the longest prefix that is also a suffix is a palindrome!
        //Then, we just need to complete. 
        
        if(s.isEmpty())
            return "";
        
        StringBuffer buffer = new StringBuffer(s);
        StringBuffer reverseBuffer = new StringBuffer(s);
        buffer.append("#");
        reverseBuffer.reverse();
        buffer.append(reverseBuffer);
    
        int[] lsp = buildLSP(buffer.toString());
        
        int longestPrefix = lsp[buffer.toString().length() - 1];
        
        buffer = new StringBuffer();
        
        for(int i = s.length() - 1; i >= longestPrefix; i--)
            buffer.append(s.charAt(i));
        
        buffer.append(s);
        
        return buffer.toString();
        
    }
    
    private int[] buildLSP(String s)
    {
        int[] lsp = new int[s.length()];
        
        int i = 0;
        
        for(int j = 1; j < lsp.length; j++)
        {
            if(s.charAt(j) == s.charAt(i))
            {
                lsp[j] = i + 1;
                i++;
            }
            else
            {
                boolean notEqual = false;
                
                while(s.charAt(j) != s.charAt(i) && !notEqual)
                {
                    if(i == 0)
                        notEqual = true;
                    else
                        i = lsp[i  -1];
                }
                
                if(!notEqual)
                {
                    lsp[j] = i + 1;
                    i++;
                }
                
            }
        }
        
        return lsp;
    }
}