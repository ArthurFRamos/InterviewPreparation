public class Solution {
    public int MinEatingSpeed(int[] piles, int H) {
        int max = -1;
        foreach(var p in piles)
            if(p > max)
                max = p;
        
        int begin = 1;
        int end = max;
        
        while(begin != end)
        {
            int mid = (begin + end)/2;
            int hours = _CheckHour(piles,mid);
            if(hours > H)
                begin = mid + 1;
            else
                end = mid;
        }
        
        return begin;
    }
    
    private int _CheckHour(int[] piles, int rate)
    {
        int hours = 0;
        foreach(var p in piles)
        {
            hours += p/rate;
            if(p % rate != 0)
                hours += 1;
        }
        
        return hours;
    }
}