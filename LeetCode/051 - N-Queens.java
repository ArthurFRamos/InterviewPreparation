public class Solution {
    
    private int grid;
    
    public List<List<String>> solveNQueens(int n) {
        
        grid = n;

        int [] columns = new int[n];
        List<List<String>> lists = new ArrayList<>();
        
        backTrack(0,columns,lists);
        
        return lists;
    }
    
    private void backTrack(int row, int [] columns, List<List<String>> lists)
    {
        if(row == grid)
            lists.add(columnsToString(columns));
         
        else
        {
            for(int i = 0; i < grid; i++)
            {
                if(canPutQueen(columns,row,i))
                {
                    columns[row] = i;
                    backTrack(row + 1, columns, lists);   
                }
            }
        }
    }
    
    private boolean canPutQueen(int[] columns, int row, int column)
    {
        
        for(int i = 0; i < row; i++)
        {
            int current = columns[i];
            
            if(current == column)
                return false;
            
            int columnDistance = Math.abs(column - columns[i]);
            
            int rowDistance = row - i;
            
            if(columnDistance == rowDistance)
                return false;
        }
        
        return true;
    }
    
    private List<String> columnsToString(int[] columns)
    {
        StringBuffer buffer = new StringBuffer();
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < grid; i++)
        {
            for(int j = 0; j < grid; j++)
            {
                if(j == columns[i])
                    buffer.append("Q");
                else
                    buffer.append(".");
            }
            
            list.add(buffer.toString());
            buffer = new StringBuffer();
        }
        return list;
    }
}