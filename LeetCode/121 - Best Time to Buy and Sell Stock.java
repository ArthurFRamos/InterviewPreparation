public class Solution {
    public int maxProfit(int[] prices) {
        
        int maximum = 0;
        
        for(int i = prices.length - 1; i >= 0; i--)
        {
            int temp = prices[i];
            prices[i] = maximum - temp;
            if(temp > maximum)
                maximum = temp;
        }
        
        maximum = 0;
        
        for(int i = 0; i < prices.length; i++)
        {
            if(prices[i] > maximum)
                maximum = prices[i];
        }
        
        return maximum;
    }
}