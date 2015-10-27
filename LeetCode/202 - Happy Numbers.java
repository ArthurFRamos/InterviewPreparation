public class Solution {
    
    HashSet<Integer> cycle;
    
    public boolean isHappy(int n) {
        cycle = new HashSet<Integer>();
        Integer intN = n;
        Integer sum = 0;
        Integer temp = 0;
        String current = intN.toString();
        Character helper = null;
        while(sum != 1)
        {
            sum = 0;
            for(int i = current.length() - 1; i >= 0; i--)
            {
                helper = new Character(current.charAt(i));
                sum += (int)Math.pow(Integer.parseInt(helper.toString()),2);
                
            }
            
            if(cycle.contains(sum))
            	break;
            
            cycle.add(sum);
            current = sum.toString();
        }
        
        if(sum == 1)
            return true;
            
        return false;
        
    }

    public static void main(String [] args)
    {
    	Solution sol = new Solution();
    	sol.isHappy(19);
    }
}