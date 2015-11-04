public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> answer = evaluate(0, input.length() - 1, input);
        Collections.sort(answer);
        return answer;
    }
    
    public List<Integer> evaluate(int begin, int end, String exp)
    {
        String current = exp.substring(begin, end + 1);
        List<Integer> currentList = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        if(checkOp(current))
        {
            currentList.add(Integer.parseInt(current));
            return currentList;
        }
        
        for(int i = begin; i <= end; i++)
        {
            char temp = exp.charAt(i);
            
            if(temp == '+' || temp == '*' || temp == '-')
            {
                left = evaluate(begin, i - 1, exp);
                right = evaluate(i + 1, end, exp);
                
                for(int j = 0; j < left.size(); j++)
                {
                    for(int z = 0; z < right.size(); z++)
                    {
                        if(temp == '+')
                            currentList.add(left.get(j) + right.get(z));
                        else if(temp == '*')
                            currentList.add(left.get(j) * right.get(z));
                        else
                            currentList.add(left.get(j) - right.get(z));
                    }
                }
            }
        }
        return currentList;
    }
    
    private boolean checkOp(String exp)
    {
        for(int i = 0; i < exp.length(); i++)
        {
            if(exp.charAt(i) =='+' || exp.charAt(i) == '*' || exp.charAt(i) == '-')
                return false;
        }
        
        return true;
    }
    
}