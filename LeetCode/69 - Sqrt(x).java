public class Solution {
    public int mySqrt(int x) {
        if(x < 0)
            return x;
        if(x == 0 || x == 1)
            return x;
        
        int result =  BinarySearchTree(x);
        if(result * result > x)
            result -= 1;
        return result;
    }
    
    public int BinarySearchTree(int target)
    {
        int start = 0;
        int end = Integer.MAX_VALUE;
        long mid = 0;
        while(start < end)
        {
            mid = (start + end)/2;
            
            if(mid*mid < target)
                start = (int)mid + 1;
            else if(mid*mid > target)
                end = (int)(mid - 1);
            else
                return (int)mid;
        }
        return (int)start;
    }
}