public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        int max = 0;
        int temp = 0;
        char currentChar;
        int lastEqual = -1;
        
        for(int i = 0; i < s.length(); i++)
        {
            currentChar = s.charAt(i);
            
            if(map.containsKey(currentChar))
            {
                int current = map.get(currentChar);
                
                if(current < lastEqual)
                    temp++;   
                else
                {
                    temp = i - current;
                    lastEqual = current;   
                }
            }
            else
                temp++;
                
            if(temp > max)
                max = temp;
            
            map.put(currentChar,i);
        }
        
        return max;
    }
}