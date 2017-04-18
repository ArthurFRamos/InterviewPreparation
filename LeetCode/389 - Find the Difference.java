public class Solution {
    
    private HashMap<Character,Integer> map = new HashMap<>();
    
    public char findTheDifference(String s, String t) {
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
        
        for(int i = 0; i < t.length(); i++)
        {
            Character current = t.charAt(i);
            
            if(!map.containsKey(current))
                return current;
            int temp = map.get(current);
            
            map.put(current, temp - 1);
        }
        
        Iterator<Character> it = map.keySet().iterator();
        
        while(it.hasNext())
        {
            Character current = it.next();
            int temp = map.get(current);
            
            if(temp != 0)
                return current;
        }
        
        return ' ';
    }
}