public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        if(n == 0)
            return true;
            
        for(int i = 0; i < flowerbed.length; i++)
        {
            if(flowerbed[i] == 1)
                continue;
                
            if(check(flowerbed,i))
            {
                flowerbed[i] = 1;
                n--;
                if(n == 0)
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean check(int[] flowerbed, int pos)
    {
        return checkAdj(flowerbed, pos - 1) && checkAdj(flowerbed, pos + 1);
    }
    private boolean checkAdj(int[] flowerbed, int pos)
    {
        if(pos < 0)
            return true;
        if(pos >= flowerbed.length)
            return true;
        if(flowerbed[pos] == 0)
            return true;
        
        return false;
    }
    
}