public class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] != '.')
                {
                    char temp = board[i][j];
                    board[i][j] = '.';
                    if(!isValid(temp,i,j,board))
                        return false;
                    board[i][j] = temp;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid(char x, int row, int col, char[][] board)
    {
        for(int i = 0; i < board[0].length; i++)
        {
            if(board[row][i] == x)
                return false;
        }
        
        for(int i = 0; i < board.length; i++)
        {
            if(board[i][col] == x)
                return false;
        }
        
        int beginRow = row - (row % 3);
        int beginCol = col - (col % 3);
        
        for(int i = beginRow; i < beginRow + 3; i++)
        {
            for(int j = beginCol; j < beginCol + 3; j++)
            {
                if(board[i][j] == x)
                    return false;
            }
        }
        
        return true;
        
    }
    
}