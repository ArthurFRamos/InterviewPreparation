public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length == 0)
            return 1;
        int n = dungeon.length - 1;
        int m = dungeon[0].length - 1;
        
        dungeon[n][m] = (-dungeon[n][m]) <= 0 ? 1 : -dungeon[n][m] + 1;
        
        for(int i = m - 1; i >= 0; i--)
        {
            dungeon[n][i] = dungeon[n][i + 1] - dungeon[n][i];
            if(dungeon[n][i] <= 0)
                dungeon[n][i] = 1;
        }
        
        for(int i = n - 1; i >= 0; i--)
        {
            dungeon[i][m] = dungeon[i+1][m] - dungeon[i][m];
            if(dungeon[i][m] <= 0)
                dungeon[i][m] = 1;
        }
        
        for(int i = n - 1; i >=0; i--)
        {
            for(int j = m - 1; j >= 0; j--)
            {
                dungeon[i][j] = Math.min(dungeon[i+1][j], dungeon[i][j+1]) - dungeon[i][j];
                if(dungeon[i][j] <= 0)
                    dungeon[i][j] = 1;
            }
        }
        
        return dungeon[0][0];   
    }
}