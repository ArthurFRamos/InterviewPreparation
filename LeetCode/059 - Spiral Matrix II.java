public class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        
        
        path(0,0,matrix,0,1);
        
        
        return matrix;
    }
    
     private void path(int row, int column, int[][] matrix, int direction, int pos)
    {
        if(row < 0 || column < 0 || row == matrix.length || column == matrix[0].length || matrix[row][column] != 0)
            return;
        
        matrix[row][column] = pos;

        
        if(direction == 0)
        {
            path(row, column + 1, matrix,0,pos + 1);
            path(row + 1,column, matrix,1, pos + 1);
        }
        
        else if(direction == 1)
        {
            path(row + 1, column, matrix,1, pos + 1);
            path(row,column -1, matrix,2, pos + 1);
        }
        
        else if(direction == 2)
        {
            path(row, column -1, matrix,2, pos + 1);
            path(row -1,column, matrix,3, pos + 1);
        }
        else
        {
            path(row-1, column ,  matrix,3, pos + 1);
            path(row,column+1,  matrix,0, pos + 1);
        }
    }
}