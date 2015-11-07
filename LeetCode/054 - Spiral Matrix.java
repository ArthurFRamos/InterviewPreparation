public class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> spiral = new ArrayList<Integer>();
        
        if(matrix.length == 0)
            return spiral;
            
        boolean[][] flags = new boolean[matrix.length][matrix[0].length];
        
        path(flags,0,0,spiral,matrix,0);
        
        return spiral;
    }
    
    private void path(boolean[][] flags, int row, int column, List<Integer> list, int[][] matrix, int direction)
    {
        if(row < 0 || column < 0 || row == flags.length || column == flags[0].length || flags[row][column])
            return;
        
        flags[row][column] = true;
        list.add(matrix[row][column]);
        
        if(direction == 0)
        {
            path(flags,row, column + 1, list, matrix,0);
            path(flags,row + 1,column, list, matrix,1);
        }
        
        else if(direction == 1)
        {
            path(flags,row + 1, column, list, matrix,1);
            path(flags,row,column -1, list, matrix,2);
        }
        
        else if(direction == 2)
        {
            path(flags,row, column -1, list, matrix,2);
            path(flags,row -1,column, list, matrix,3);
        }
        else
        {
            path(flags,row-1, column , list, matrix,3);
            path(flags,row,column+1, list, matrix,0);
        }
    }
}