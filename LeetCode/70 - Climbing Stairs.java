public class Solution {
    public int climbStairs(int n) {
        int[] poss = new int[2];
        
        poss[0] = 1;
        poss[1] = 1;
        
        int result = 1;
        
        for(int i = 2; i <= n; i++)
        {
            result = poss[0] + poss[1];
            
            poss[1] = poss[0];
            poss[0] = result;
        }
        
        return result;
    }
}