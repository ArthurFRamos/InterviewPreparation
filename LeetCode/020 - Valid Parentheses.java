public class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0)
            return true;
        
        LinkedList<Character> stack = new LinkedList<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            char temp = s.charAt(i);
            
            if(temp == ']' || temp == '}' || temp == ')')
            {
                if(stack.isEmpty())
                    return false;
                char current = stack.pop();
                
                if(temp == ']' && current != '[')
                    return false;
                if(temp == '}' && current != '{')
                    return false;
                if(temp == ')' && current != '(')
                    return false;
            }
            else
                stack.push(temp);
        }
        
        return stack.isEmpty();
    }
}
