class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int pos = -1;
        int max = -1;
        
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] > max)
            {
                max = A[i];
                pos = i;
            }
        }
        
        return pos;
    }
}