public class Solution {
    
    boolean solved;
    int positionsToFill;
    int counter;
    public void solveSudoku(char[][] board) {
        solved = false;
        if(board.length == 0)
            return;
        
        counter = 0;
        positionsToFill = 0;
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == '.')
                    positionsToFill++;
            }
        }
        backtrack(board);
    }
    
    
    private void backtrack(char[][] board)
    {
        if(counter == positionsToFill)
        {
            solved = true;
            return;   
        }
            
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == '.')
                {
                    for(int z = 1; z < 10; z++)
                    {
                        Integer temp = z;
                        char tempChar = temp.toString().charAt(0);
                        
                        if(isValid(tempChar,i,j,board))
                        {
                            board[i][j] = tempChar;
                            counter++;
                            backtrack(board);
                            
                            if(solved)
                                return;
                            
                            board[i][j] = '.';
                            counter--;
                        }
                    }
                    
                    return;
                }
            }
        }
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