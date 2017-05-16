public class TicTacToe {

    private int[][] matrix;
    private int left;
    
    public TicTacToe(int n) {
        matrix = new int[n][n];
        left = n *n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(left == 0)
            return 0;
        
        matrix[row][col] = player;
        
        if(row == col && checkDiagonal1(player))
            return player;
        if(row + col == matrix.length - 1 && checkDiagonal2(player))
            return player;
        if(checkLine(row,player) || checkColumn(col,player))
            return player;
        
        return 0;
    }
    
    private boolean checkLine(int i, int player)
    {
        for(int j = 0; j < matrix[i].length; j++)
        {
            if(matrix[i][j] != player)
                return false;
        }
        
        return true;
    }
    
    private boolean checkColumn(int j, int player)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            if(matrix[i][j] != player)
                return false;
        }
        
        return true;
    }
    
    private boolean checkDiagonal1(int player)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            if(matrix[i][i] != player)
                return false;
        }

        return true;
    }
    
    private boolean checkDiagonal2(int player)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            if(matrix[i][matrix.length - 1 - i] != player)
                return false;
        }
        
        return true;
    }
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */