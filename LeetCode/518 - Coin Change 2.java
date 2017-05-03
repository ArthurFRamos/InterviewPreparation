public class Solution {
    
    
    public int change(int amount, int[] coins) {
        if(amount == 0)
            return 1;
            
        if(coins.length == 0)
            return 0;
            
        int[][] map = new int[amount + 1][coins.length];
        
        for(int i = 0; i <= amount; i++)
            for(int j = 0; j < coins.length; j++)
                map[i][j] = -1;
        
        return coinChange(coins.length - 1, amount, coins, map);
    }
    
    private int coinChange(int index, int amount, int[] coins, int[][] map)
    {
        
        if(map[amount][index] != -1)
            return map[amount][index];
            
        int ways = amount % coins[index] == 0 ? 1 : 0;
        if(index == 0)
        {
            map[amount][index] = ways;
            return ways;
        }
        
        
        int amountRemaining = amount;
        
        while(amountRemaining > 0)
        {
            ways += coinChange(index - 1, amountRemaining, coins, map);
            amountRemaining -= coins[index];
        }
        
        map[amount][index] = ways;
        
        return ways;
    }
}