package Exercises;

public class CoinChange {

	private int[] coins = {25,10,5,1};
	private int total;
	
	public CoinChange(int[] coins, int total)
	{
		this.total = total;
	}
	
	private int numberOfChanges()
	{
		int[][] change = new int[total + 1][coins.length];
		
		return coinChange(change,0,total);
	}
	
	private int coinChange(int[][] change, int index, int amount)
	{
		if(change[amount][index] > 0)
		{
			return change[amount][index];
		}
		
		if(index == change.length - 1)
			return 1;
		
		int ways = 0;
		
		for(int i = 0; i*coins[index] <= amount; i++)
			ways += coinChange(change,index + 1, amount - i*coins[index]);
		
		change[amount][index] = ways;
		
		return ways;
	}
	
}
