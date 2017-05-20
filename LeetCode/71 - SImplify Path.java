public class Solution {
    public String simplifyPath(String path) {
        
        if(path.length() == 0)
            return "";
        
        path = removeRedundancy(path);
        
        if(path.charAt(path.length() - 1) != '/')
            path = path + '/';
        
        StringBuffer buffer = new StringBuffer();
        
        for(int i = 0; i < path.length(); i++)
        {
            char temp = path.charAt(i);
            if(temp == '/' && i == path.length() - 1)
                continue;
            if(temp == '/' && i + 3 < path.length())
            {
                if(path.charAt(i+1) == '.' && path.charAt(i + 2) == '.' && path.charAt(i + 3) == '/')
                {
                    buffer = new StringBuffer(removeLast(buffer.toString()));
                    i = i + 2;
                    continue;
                }
            }
            
            if(temp == '/' && i + 2 < path.length())
            {
                if(path.charAt(i + 1) == '.' && path.charAt(i + 2) == '/')
                {
                    i++;
                    continue;   
                }
            }
            
            buffer.append(temp);
        }
        
        if(buffer.length() == 0)
            return "/";
            
        return buffer.toString();
    }
    
    private String removeLast(String path)
    {
        if(path.length() == 0)
            return "";
        
        for(int i = path.length() - 1; i >= 0; i--)
            if(path.charAt(i) == '/')
                return path.substring(0, i);
        
        return "";
                
    }
    private String removeRedundancy(String path)
    {
        StringBuffer buffer = new StringBuffer();
        
        for(int i = 0; i < path.length(); i++)
        {
            char temp = path.charAt(i);
            
            if(temp == '/' && i != path.length() - 1)
            {
                if(path.charAt(i + 1) == '/')
                    continue;
            }
            
            buffer.append(temp);
        }
        
        return buffer.toString();
    }
    
}