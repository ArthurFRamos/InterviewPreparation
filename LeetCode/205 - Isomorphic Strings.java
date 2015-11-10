public class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character,Character> map = new HashMap<>();
        
        if(s.length() != t.length())
            return false;
        
        for(int i = 0; i < s.length(); i++)
        {
            if(!map.containsKey(s.charAt(i)))
            {
                if(map.containsValue(t.charAt(i)))
                    return false;
                    
                map.put(s.charAt(i),t.charAt(i));
                
            }
            else
            {
                char temp = map.get(s.charAt(i));
                if(t.charAt(i) != temp)
                    return false;
            }
        }
        
        return true;
    }
}