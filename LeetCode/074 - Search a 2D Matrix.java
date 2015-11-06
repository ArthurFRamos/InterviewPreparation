public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
            
        int col = matrix[0].length - 1;
        int row = 0;
        
        while(col >= 0 && row < matrix.length)
        {
            if(target == matrix[row][col])
                return true;
            if(target < matrix[row][col])
                col--;
            else
                row++;
        }
        
        return false;
    }
}