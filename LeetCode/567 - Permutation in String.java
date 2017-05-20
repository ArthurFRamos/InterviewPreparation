public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s1.length(); i++)
        {
            char temp = s1.charAt(i);
            if(!map.containsKey(temp))
                map.put(temp,1);
            else
                map.put(temp, map.get(temp) + 1);
        }
        
        String first = s2.substring(0,s1.length());
        for(int i = 0; i < first.length(); i++)
        {
            char temp = first.charAt(i);
            if(!map.containsKey(temp))
                map.put(temp, -1);
            else
                map.put(temp, map.get(temp) - 1);
        }
        
        if(checkZero(map))
            return true;
        
        int offset = s1.length() - 1;
        
        for(int i = 1; i + offset < s2.length(); i++)
        {
                char previous = s2.charAt(i - 1);
                map.put(previous, map.get(previous) + 1);
                
                char cur = s2.charAt(i + offset);
                if(!map.containsKey(cur))
                    map.put(cur,-1);
                else
                    map.put(cur, map.get(cur)  - 1);
            
                if(checkZero(map))
                    return true;
        }
        
        return false;
    }
    
    private boolean checkZero(HashMap<Character,Integer> map)
    {
        Iterator<Character> it = map.keySet().iterator();
        
        while(it.hasNext())
        {
            if(map.get(it.next()) != 0)
                return false;
        }
        
        return true;
    }
}