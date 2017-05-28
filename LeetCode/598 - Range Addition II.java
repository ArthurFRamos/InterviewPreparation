public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minLine = m;
        int minCol = n;
        
        for(int i = 0; i < ops.length; i++)
        {
            if(ops[i][0] < minLine)
                minLine = ops[i][0];
            if(ops[i][1] < minCol)
                minCol = ops[i][1];
        }
        
        return minCol * minLine;
    }
}