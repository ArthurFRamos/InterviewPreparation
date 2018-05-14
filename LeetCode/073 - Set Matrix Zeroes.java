public class Solution {
    
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> flags = new HashSet<>();
        
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                if(matrix[i][j] == 0)
                    flags.add(i * matrix[i].length + j);
                    
            }
        }
        
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                int temp = matrix[i].length * i + j;
                if(matrix[i][j] == 0 && flags.contains(temp))
                    setZeros(i,j,matrix);
            }
        }
    }
    
    private void setZeros(int i, int j, int[][] matrix)
    {
        for(int k = 0; k < matrix[i].length; k++)
            matrix[i][k] = 0;
        
        for(int k = 0; k < matrix.length; k++)
            matrix[k][j] = 0;
    }
    
}
