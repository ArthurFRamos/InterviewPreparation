public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x == 0 || y == 0)
            return z == 0;
            
        if(x + y  < z)
            return false;
            
        
        return z % GCD(x,y) == 0;
    }
    
    private int GCD(int x, int y)
    {
        if(x < y)
        {
            int temp = x;
            x = y;
            y = temp;
        }
        
        if(x % y == 0)
            return y;
        else
            return GCD(x - y, y);
    }
}