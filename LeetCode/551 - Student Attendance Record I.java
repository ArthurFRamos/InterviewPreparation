public class Solution {
    public boolean checkRecord(String s) {
        int absentCount = 0;
        int consecutiveLate = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) =='A')
            {
                absentCount++;
                consecutiveLate = 0;
            }
            else if(s.charAt(i) == 'L')
            {
                if(consecutiveLate == 2)
                    return false;
                    
                consecutiveLate++;
            }
            
            else
                consecutiveLate = 0;
        }
        
        if(absentCount > 1)
            return false;
        
        return true;
    }
}