public class Solution {
    public int countPrimes(int n) {
        boolean[] flags = sieve(n-1);
        
        int count = 0;
        
        for(int i = 2; i < flags.length; i++)
        {
            if(flags[i])
                count++;
        }
        
        return count;
    }
    
    public boolean[] sieve(int n)
    {
        boolean [] flags = new boolean[n + 1];
        
        for(int i = 0; i < flags.length; i++)
            flags[i] = true;
        
        int prime = 2;
        
        for(int i = prime; i <= Math.sqrt(n+1); i++)
        {
            crossPrimes(prime,flags);
            
            if(prime > flags.length)
                break;
            
            prime = getNextPrime(prime,flags); 
        }
        
        return flags;
    }
    
    private void crossPrimes(int prime, boolean[] flags)
    {
        for(int i = prime*prime; i < flags.length; i += prime)
            flags[i] = false;
    }
    
    private int getNextPrime(int prime, boolean[] flags)
    {
        int next = prime;
        
        for(int i = next + 1; i < flags.length; i++)
            if(flags[i] == true)
            {
                next = i;
                break;
            }
        return next;
    }