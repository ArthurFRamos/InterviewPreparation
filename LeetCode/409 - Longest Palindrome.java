public class Solution {
    
    private HashMap<Character, Integer> map = new HashMap<>();
    
    public int longestPalindrome(String s) {
        boolean addOne = false;
        int len = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            Character current = s.charAt(i);
            
            if(map.containsKey(current))
            {
                int temp = map.get(current);
                map.put(current, temp + 1);
            }
            else
                map.put(current,1);
        }
        
        Iterator<Character> it = map.keySet().iterator();
        
        while(it.hasNext())
        {
            int temp = map.get(it.next());
            if(temp % 2 != 0)
            {
                addOne = true;
                len += temp - 1;
            }
            else
                len += temp;
        }
        
        return (addOne) ?  len + 1 : len;
    }
}