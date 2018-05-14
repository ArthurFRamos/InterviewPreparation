class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i++)
            invertRow(A[i]);
        
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < A[i].length; j++)
                A[i][j] = (A[i][j] + 1)%2;
        
        return A;
    }
    
    public void invertRow(int[] row)
    {
        int temp = 0;
        
        for(int i = 0; i < row.length/2; i++)
        {
            temp = row[i];
            row[i] = row[row.length - 1 - i];
            row[row.length - 1 - i] = temp;
        }
    }
}