public class Solution {
    
    class StringHelper implements Comparable<StringHelper>
    {
        String s;
        
        public StringHelper(String word)
        {
            s = word;
        }
        
        public int compareTo(StringHelper h)
        {
            if(s.length() < h.s.length())
                return -1;
                
            else 
                return 1;
        }
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        
        if(strs.length == 1)
            return strs[0];
        
        StringHelper [] helper = new StringHelper[strs.length];
        
        for(int i = 0; i < strs.length; i++)
            helper[i] = new StringHelper(strs[i]);
        
        Arrays.sort(helper);
        
        
        StringBuffer buffer = new StringBuffer();
        
        for(int i = 0; i < helper[0].s.length(); i++)
        {
            for(int j = 1; j < helper.length; j++)
            {
                if(helper[0].s.charAt(i) != helper[j].s.charAt(i))
                    return buffer.toString();
            }
            buffer.append(helper[0].s.charAt(i));
        }
        
        return buffer.toString();
    }
}