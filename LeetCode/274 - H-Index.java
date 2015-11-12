public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        
        int hIndex = 0;
        
        for(int i = 0; i < citations.length; i++)
        {
            int current = Math.min(citations[i], citations.length - i);
            
            if(current > hIndex)
                hIndex = current;
        }
        
        return hIndex;
    }
}