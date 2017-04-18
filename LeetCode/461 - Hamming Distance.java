public class Solution {
    public int hammingDistance(int x, int y) {
        int distance = 0;
        
        for(int i = 0; i < 32; i++)
        {
            if(getFirstBit(x) != getFirstBit(y))
                distance++;  
            
            x >>= 1;
            y >>= 1;
        }
        
        return distance;
    }
    
    private int getFirstBit(int x)
    {
        return x & 1;
    }
}