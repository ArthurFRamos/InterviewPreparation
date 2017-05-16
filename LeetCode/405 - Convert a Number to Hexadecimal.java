public class Solution {
    
    private HashMap<Integer,Character> map = new HashMap<>();
    
    public String toHex(int num) {
        if(num == 0)
            return "0";
        
        long helper = 0;
        map.put(10,'a');
        map.put(11,'b');
        map.put(12,'c');
        map.put(13,'d');
        map.put(14,'e');
        map.put(15,'f');
        
        if(num < 0)
        {
            long mult = 1;
            
            for(int i = 0; i < 32; i++ )
            {
                helper = helper + mult* getBit(num,i);
                mult = mult * 2;
            }
        }
        
        StringBuffer buffer = new StringBuffer();
        
        if(helper == 0)
            helper = num;
            
        while(helper != 0)
        {
            long temp = helper % 16;
            if(temp >= 10)
                buffer.append(map.get((int)temp));
            else
                buffer.append(temp);
            
            helper = helper/16;
        }
        
        return buffer.reverse().toString();
        
    }
    
    private int getBit(int num, int pos)
    {
        if((num & (1 << pos)) == 0)
            return 0;
        
        return 1;
    }
}