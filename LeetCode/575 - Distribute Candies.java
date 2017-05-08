public class Solution {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> kinds = new HashSet<>();
        int nKinds = 0;
        
        for(int i = 0; i < candies.length; i++)
        {
            if(!kinds.contains(candies[i]))
            {
                kinds.add(candies[i]);
                nKinds++;
            }
        }
        
        return Math.min(nKinds, candies.length/2);
    }
}