public class Solution {
    
    private boolean[] flags;
    int marked = 0;
    public int countPrimes(int n) {
        flags = new boolean[n >> 1];
        
        if(n <= 2)
            return 0;
        
        for(int i = 3; i <= Math.sqrt(n); i += 2)
            if(!flags[i >> 1])
                crossOut(i,n);
                
        return (n - 1) - (marked + ((n-1) >> 1));
    }
    
    private void crossOut(int prime, int n)
    {
        
        for(int i = prime * prime; i < n; i += prime)
        {
            if(i % 2 == 0)
                continue;
                
            int temp = i >> 1;
            
            if(!flags[temp])
            {
                marked++;
                flags[temp] = true;
            }
        }
    }
    
}