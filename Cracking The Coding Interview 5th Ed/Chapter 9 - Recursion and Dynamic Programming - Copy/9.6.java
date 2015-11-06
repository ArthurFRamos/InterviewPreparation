public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        
        StringBuffer buffer = new StringBuffer();
        
        if(n <= 0)
        {
            parenthesis.add("");
            return parenthesis;
        }
        
        generateHelper(n,n,buffer, parenthesis);
        
        return parenthesis;
    }
    
    private void generateHelper(int right, int left, StringBuffer buffer, List<String> list)
    {
        if(right == 0 && left == 0)
            list.add(buffer.toString());
        
        if(left > 0)
        {
            buffer.append("(");
            generateHelper(right,left - 1, buffer, list);
        }
        if(right > left)
        {
            buffer.append(")");
            generateHelper(right - 1, left, buffer, list);
        }
        
        if(buffer.length() > 0)
            buffer.deleteCharAt(buffer.length() - 1);
    }
    
}