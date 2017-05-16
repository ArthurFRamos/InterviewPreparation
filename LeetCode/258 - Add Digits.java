public class Solution {
    
  /*  public int addDigits(int num) {
        String temp = Integer.toString(num);
        int current = 0;
        while(temp.length() != 1)
        {
            for(int i = 0; i < temp.length(); i++)
                current += Character.getNumericValue(temp.charAt(i)); 
            temp = Integer.toString(current);
            
            current = 0;
        }
        
        return Character.getNumericValue(temp.charAt(0));
        
    }*/
    
    public int addDigits(int num)
    {
        if(num == 0)
            return 0;
        if(num % 9 == 0)
            return 9;
        return num % 9;
    }
}