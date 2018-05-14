 public class Solution {
    
    private int ways = 0;
    private int[] dp;
    
    public int numDecodings(String s) {
         dp = new int[s.length() + 1];
         
         if(s.length() == 0 || s.charAt(0) == '0')
            return 0;
        
         
         dp[0] = 1;
         dp[1] = 1;
         
         for(int i = 1; i < s.length(); i++)
         {
            char temp = s.charAt(i);
            
            if(temp == '0')
            {
                if(s.charAt(i-1) != '1' && s.charAt(i-1) != '2')
                    return 0;
                    
                dp[i+ 1] = dp[i - 1];
            }
            else if(s.charAt(i - 1) == '1')
                dp[i+1] = dp[i] + dp[i-1];
            else if(s.charAt(i-1) == '2' && temp < '7')
                dp[i+1] = dp[i] + dp[i-1];
            else
                dp[i+1] = dp[i];
         }
         
         return dp[s.length()];
    }
}
