public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
            
        boolean[][] flags = new boolean[grid.length][grid[0].length];
        int islands = 0;
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(!flags[i][j] && grid[i][j] == '1')
                {
                    fillGrid(flags,i,j,grid);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    public void fillGrid (boolean[][] flags, int n, int m, char[][] grid)
    {
        if(n < 0 || m < 0 || n >= grid.length || m >= grid[0].length)
            return;
        
        if(grid[n][m] == '1' && !flags[n][m])
        {
            flags[n][m] = true;
            fillGrid(flags,n -1, m, grid);
            fillGrid(flags,n +1, m, grid);
            fillGrid(flags,n , m-1, grid);
            fillGrid(flags,n , m+1, grid);
        }
    }
}