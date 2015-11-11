public class Solution {
    
 public String shortestPalindrome(String s) {
        
        StringBuffer buffer = new StringBuffer();
        
        buffer.append(s);
        buffer.append("*");
        buffer.append(reverse(s));
        
        int[] pi = computePrefix(buffer.toString());
        
        int offset = pi[buffer.length() - 1] + 1;
        
        StringBuffer ans = new StringBuffer();
        
        String temp = buffer.toString();
        
        for(int i = s.length() + 1; i < temp.length() - offset; i++)
            ans.append(temp.charAt(i));
        
        ans.append(s);
        
        return ans.toString();
    }
    
    private int[] computePrefix(String p)
    {
        int m = p.length();
        
        int[] pi = new int[m];
        
        pi[0] = - 1;
        
        int k = -1;
        
        for(int q = 1; q < m; q++)
        {
            while(k > -1 && p.charAt(k + 1) != p.charAt(q))
                k = pi[k];
            
            if(p.charAt(k + 1) == p.charAt(q))
                k = k + 1;
            
            pi[q] = k;
        }
        
        return pi;
    }
    
    private String reverse(String s)
    {
        StringBuffer buffer = new StringBuffer();
        
        for(int i = s.length() - 1; i >= 0; i--)
            buffer.append(s.charAt(i));
        
        return buffer.toString();
    }
    
    
}