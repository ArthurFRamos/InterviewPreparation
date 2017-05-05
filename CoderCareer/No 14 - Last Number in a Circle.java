public class Solution {
    
    HashMap<Character, Integer> map = new HashMap<>();
    
    public int firstUniqChar(String s) {
        
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
        
        for(int i = 0; i < s.length(); i++)
        {
            Character current = s.charAt(i);
            if(map.get(current) == 1)
                return i;
        }
        
        return -1;
        
    }
}