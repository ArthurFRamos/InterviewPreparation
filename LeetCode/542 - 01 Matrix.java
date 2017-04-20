public class Solution {
    
    private ArrayList<ArrayList<Integer>> helper = new ArrayList<ArrayList<Integer>>();
    
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        
        for(int i = 0; i < matrix.size(); i++)
        {
            helper.add(new ArrayList<Integer>());
            
            for(int j = 0; j < matrix.get(i).size(); j++)
            {
                if(matrix.get(i).get(j) == 1)
                    helper.get(i).add(-1);
                else
                {
                    helper.get(i).add(0);
                    stack.push(i*matrix.get(0).size() + j);
                }
            }
        }
        
        calculate(stack,1);
        
        for(int i = 0; i < matrix.size(); i++)
        {
            for(int j = 0; j < matrix.get(i).size(); j++)
            {
                if(helper.get(i).get(j) != -1)
                    matrix.get(i).set(j,helper.get(i).get(j));
            }
        }
        
        return matrix;
    }
    
    private void calculate(LinkedList<Integer> stack, int value)
    {
        LinkedList<Integer> newStack = new LinkedList<Integer>();
        int col = helper.get(0).size();
        
        while(!stack.isEmpty())
        {
            int current = stack.pop();
            int i = current/helper.get(0).size();
            int j = current%helper.get(0).size();
            
            if(i - 1 >= 0 && helper.get(i-1).get(j) == -1)
            {
                helper.get(i-1).set(j,value);
                newStack.push((i-1) *col + j);  
            }
            if(i + 1 < helper.size() && helper.get(i+1).get(j) == -1)
            {
                helper.get(i+1).set(j,value);
                newStack.push((i+1)*col + j);   
            }
            if(j -1 >= 0 && helper.get(i).get(j-1) == -1)
            {
                helper.get(i).set(j-1, value);
                newStack.push(current - 1);
            }
            
            if(j + 1 < helper.get(0).size() && helper.get(i).get(j+1) == -1)
            {
                helper.get(i).set(j+1,value);
                newStack.push(current + 1);
            }
        }
        
        if(!newStack.isEmpty())
            calculate(newStack, value + 1);
    }
    
}