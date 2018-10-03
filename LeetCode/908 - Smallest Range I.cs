public class Solution {
    public int SmallestRangeI(int[] A, int K) {
        var min = int.MaxValue;
        var max = int.MinValue;
        
        foreach(var n in A)
        {
            if(n < min)
                min = n;
            if(n > max)
                max = n;
        }
        
        var diff = max - min;
        K = Math.Abs(K);
        
        if(diff <= 2*K)
            return 0;
        
        return (diff - 2*K);
    }
}