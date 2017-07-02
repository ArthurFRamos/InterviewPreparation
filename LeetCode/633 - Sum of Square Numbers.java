public class Solution {
    
    private HashSet<Integer> numbers = new HashSet<>();
    
    
    public boolean judgeSquareSum(int c) {
        int n = (int)Math.sqrt(c);
        
        for(int i = 0; i <= n; i++)
            numbers.add(i*i);
        
        for(int i = 0; i <= n; i++)
            if(numbers.contains(c - i*i))
                return true;
        return false;
    }
}