public class Solution {
    boolean[][] flags;
    private boolean exist = false;
    
    public boolean exist(char[][] board, String word) {
        exist = false;
        
        if(board.length == 0)
            return false;
        if(word.length() == 0)
            return true;
            
        flags = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < flags.length; i++)
            for(int j = 0; j < flags[i].length; j++)
                flags[i][j] = false;
                
            for(int i = 0; i < board.length; i++)
                for(int j = 0; j < board[i].length; j++)
                {
                    if(word.charAt(0) == board[i][j])
                    {
                        flags[i][j] = true;
                        exist = helper(i,j,1,word,board);
                        if(exist)
                            return true;
                        flags[i][j] = false;
                    }
                        
                }
                
        return false;        
    }    
    
    private boolean helper(int x, int y, int pos, String word, char[][] board)
    {
        
        if(pos == word.length())
            return true;
            
        if(x > 0)
        {
            if(board[x-1][y] == word.charAt(pos) && !flags[x-1][y])
            {
                flags[x-1][y] = true;
                exist = exist || helper(x-1,y,pos + 1, word, board);
                flags[x-1][y] = false;
            }
        }
        
        if(x < board.length - 1)
        {
            if(board[x+1][y] == word.charAt(pos) && !flags[x+1][y])
            {
                flags[x+1][y] = true;
                exist = exist || helper(x+1,y,pos + 1, word, board);
                flags[x+1][y] = false;
            }
        }
        
        if(y > 0)
        {
            if(board[x][y-1] == word.charAt(pos) && !flags[x][y-1])
            {
                flags[x][y-1] = true;
                exist = exist || helper(x,y-1,pos + 1, word, board);
                flags[x][y-1] = false;
            }
        }
        
        if(y < board[0].length - 1)
        {
            if(board[x][y+1] == word.charAt(pos) && !flags[x][y+1])
            {
                flags[x][y+1] = true;
                exist = exist || helper(x,y+1,pos + 1, word, board);
                flags[x][y+1] = false;
            }
        }
        
        return exist;
    }
}