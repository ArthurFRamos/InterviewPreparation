public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0)
            return 0;
        
        if(needle.length() == 0)
            return 0;
        
        int[] lsp = buildLSP(needle);
        
        int index = 0;
        int skip = 0;
        
        while(index < haystack.length())
        {
            boolean found = true;
            for(int i = skip; i < needle.length(); i++)
            {
                if(index == haystack.length())
                    return -1;
                    
                if(haystack.charAt(index) != needle.charAt(i))
                {
                    found = false;
                    if(i == 0)
                        index++;
                    else
                        skip = lsp[i-1];
                    break;
                }
                index++;
            }
            
            if(found)
                return index - needle.length();
            
        }
        
        return -1;
    }
    
    private int[] buildLSP(String needle)
    {
        int[] lsp = new int[needle.length()];
        
        int i = 0;
        
        for(int j = 1; j < needle.length(); j++)
        {
            boolean notEqual = false;
            
            if(needle.charAt(j) == needle.charAt(i))
            {
                lsp[j] = i + 1;
                i++;
                continue;
            }
            
            while(needle.charAt(j) != needle.charAt(i))
            {
                if(i == 0)
                {
                    notEqual = true;
                    break;
                }
                
                i = lsp[i-1];
            }
            
            if(!notEqual)
            {
                lsp[j] = i + 1;
                i++;   
            }
            
        }
        
        return lsp;
    }
    
}