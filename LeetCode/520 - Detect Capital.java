public class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 0 || word.length() == 1)
            return true;
        
        boolean allCapitals = true;
        
        for(int i = 0; i < word.length(); i++)
        {
            
            boolean lowerCase = isLowerCase(word.charAt(i));
            
            if(lowerCase)
            {
                if(allCapitals && i >= 2)
                    return false;
                    
                allCapitals = false;
            }
            
            else
            {
                if(!allCapitals && i >= 1)
                    return false;
            }
        }
        
        return true;
    }
    
    private boolean isLowerCase(char letter)
    {
        char helper = 'Z';
        
        if(Character.compare(letter,helper) > 0)
            return true;
            
        return false;
    }
}