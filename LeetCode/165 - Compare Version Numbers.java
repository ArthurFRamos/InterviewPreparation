public class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1.equals("") && version2.equals(""))
            return 0;
            
        version1 = removeLeadingZeros(version1);
        version2 = removeLeadingZeros(version2);
        String bp1 = getBeforePoint(version1);
        String bp2 = getBeforePoint(version2);
        
        int compare = compare(bp1,bp2);
        
        if(compare != 0)
            return compare;
        if(bp1.length() == version1.length())
            version1 = "";
        else
            version1 = version1.substring(bp1.length() + 1, version1.length());
        
        if(bp2.length() == version2.length())
            version2 = "";
        else
            version2 = version2.substring(bp2.length() + 1, version2.length());
        
        return compareVersion(version1, version2);
    }
    
        
    private String getBeforePoint(String version)
    {
        StringBuffer buffer = new StringBuffer();
        
        for(int i = 0; i < version.length(); i++)
        {
            char temp = version.charAt(i);
            if(temp == '.')
                break;
            buffer.append(temp);
        }
        
        return buffer.toString();
    }
    
    private int compare (String a, String b)
    {
        if(a.length() < b.length())
            return -1;
        if(a.length() > b.length())
            return 1;
        
        for(int i = 0; i < a.length(); i++)
        {
            if(a.charAt(i) < b.charAt(i))
                return -1;
            if(a.charAt(i) > b.charAt(i))
                return 1;
        }
        
        return 0;
    }
    
    private String removeLeadingZeros(String a)
    {
        if(a.length() == 0)
            return "";
            
        for(int i = 0; i < a.length(); i++)
        {
            if(a.charAt(i) != '0')
                return a.substring(i, a.length());
        }
        return "";
    }
    
}