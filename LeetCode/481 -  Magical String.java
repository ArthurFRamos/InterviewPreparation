public class Solution {
    public int magicalString(int n) {
        StringBuffer buffer = new StringBuffer("122");
        
        if(n == 1 || n == 2 || n == 3)
            return 1;
        boolean isOne = true;
        
        int numberOfOnes = 1;
        
        for(int i = 2; buffer.length() < n; i++)
        {
            int current = Character.getNumericValue(buffer.charAt(i));
            
            String temp = null;
            
            if(isOne)
            {
                if(current == 1)
                {
                    temp = "1";
                    numberOfOnes++;
                }
                else
                {
                    temp = "11";
                    numberOfOnes += 2;   
                }
            }
            else
            {
                if(current == 1)
                    temp = "2";
                else
                    temp = "22";
            }
           
            buffer.append(temp);
            
            isOne = !isOne;
        }
        
        
        if(buffer.length() > n && buffer.charAt(n) == '1')
            numberOfOnes -= 1;
        
        return numberOfOnes;
    }
}
