public class Solution {
    public int romanToInt(String s) {
        
        if(s.length() == 0)
            return 0;
            
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M', 1000);
        
        int value = 0;
        
        int end = s.length() - 1;
        
        while(end >= 0)
        {
            Character temp = s.charAt(end);
            value += map.get(temp);
            
            if(end - 1 >= 0)
            {
                Character temp2 = s.charAt(end - 1);
                if((temp == 'M' || temp == 'D') && temp2 == 'C')
                {
                    value -= 100;
                    end = end - 2;
                    continue;
                }
                
                if((temp == 'C' || temp == 'L') && temp2 == 'X')
                {
                    value -= 10;
                    end = end - 2;
                    continue;
                }
                
                if((temp == 'X' || temp == 'V') && temp2 == 'I')
                {
                    value -= 1;
                    end = end - 2;
                    continue;
                }
            }
            
            end = end - 1;
        }
        
        return value;
    }
}