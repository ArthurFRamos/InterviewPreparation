public class Solution {
    public boolean wordPattern(String pattern, String str) {
        
        HashMap<Character,String> map =new HashMap<>();
        int position = 0;
        StringBuffer buffer;
        
        for(int i = 0; i < pattern.length(); i++)
        {
            buffer = new StringBuffer();
            
            char cur = pattern.charAt(i);
            
            position = getNextWord(str, position, buffer);
            
            
            
            if(map.containsKey(cur))
            {
                if(!buffer.toString().equals(map.get(cur)))
                    return false;
            }
            
            else
            {
            	if(map.containsValue(buffer.toString()))
            		return false;
            	
                map.put(cur,buffer.toString());
            }
        }
        
        if(position == str.length())
        	return true;
        
        return false;
        
    }
    
    private int getNextWord(String str, int position, StringBuffer buffer)
    {

        while(position < str.length() && str.charAt(position) == ' ')
            position++;
        
        for(int i = position; i < str.length() && str.charAt(i) != ' '; i++)
        {
            buffer.append(str.charAt(i));
            position = i;   
        }
        
        return position + 1;
        
            
    }
}