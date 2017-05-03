public class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[][] map = new int[amount + 1][coins.length];
        
        for(int i = 0; i < amount + 1; i++)
            for(int j = 0; j < coins.length; j++)
                map[i][j] = -1;
        
        Arrays.sort(coins);
        
        int ans = coinChange(coins.length - 1, coins, amount, map);
        if(ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }
    
    public int coinChange(int index, int[] coins, int amount, int[][] map)
    {
        if(amount == 0)
        {
            map[amount][index] = 0;
            return 0;
        }
        
        if(map[amount][index] != -1)
            return map[amount][index];
            
        if(index == 0)
        {
            if(amount % coins[index] != 0)
            {
                map[amount][0] = Integer.MAX_VALUE;
                return Integer.MAX_VALUE;
            }
            
            map[amount][0] = amount/coins[index];
            return map[amount][0];
        }
        
        int amountRemaining = amount;
        int minimum = Integer.MAX_VALUE;
        int usedCoins = 0;
        
        while(amountRemaining >= 0)
        {
            int current = coinChange(index - 1, coins, amountRemaining, map);
            if(current != Integer.MAX_VALUE)
                current += usedCoins;
                
            if(current < minimum)
                minimum = current;
                
            amountRemaining -= coins[index];
            usedCoins++;
        }
        
        map[amount][index] = minimum;
        
        return minimum;
    }
    
}