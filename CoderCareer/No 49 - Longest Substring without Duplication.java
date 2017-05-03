public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() == 0)
            return 0;
            
        int length = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        
        int start = 0;
        int currentLength = 0;
        
        for(int i = 0; i < s.length(); i++)
        {

            char temp = s.charAt(i);
            
            if(map.containsKey(temp))
            {
                int pos = map.get(temp);
                if(pos >= start)
                {
                    start = pos + 1;
                    currentLength = (i - start) + 1;
                }
                else
                    currentLength++;
            }
            else
                currentLength++;
            
            map.put(temp,i);
            
            if(currentLength > length)
                length = currentLength;
        }
        
        return length;
    }
}