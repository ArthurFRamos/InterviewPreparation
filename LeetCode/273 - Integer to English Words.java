public class Solution {
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
            
        String[] helper = new String[4];
        helper[1] = "Thousand";
        helper[2] = "Million";
        helper[3] = "Billion";
        
        HashMap<Integer,String> map = new HashMap<>();
        
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7,"Seven");
        map.put(8,"Eight");
        map.put(9,"Nine");
        map.put(10,"Ten");
        map.put(11,"Eleven");
        map.put(12,"Twelve");
        map.put(13,"Thirteen");
        map.put(14,"Fourteen");
        map.put(15,"Fifteen");
        map.put(16,"Sixteen");
        map.put(17,"Seventeen");
        map.put(18,"Eighteen");
        map.put(19,"Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70,"Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        
        String temp = Integer.toString(num);
        int size = temp.length() - 1;
        char[] number = temp.toCharArray();
        StringBuffer buffer = new StringBuffer();
        boolean addedNumber = false;
        
        for(int i = 0; i < number.length; i++)
        {
            int current = Character.getNumericValue(number[i]);
            
            int mod = (size - i) % 3;
            
            if(mod == 2)
            {
                addedNumber = false;
                if(current == 0)
                    continue;
                buffer.append(map.get(current));
                buffer.append(" Hundred ");
                addedNumber = true;
            }
            
            else if(mod == 1)
            {
                if(current == 0)
                    continue;
                    
                if(current == 1)
                {
                    current = current * 10 + Character.getNumericValue(number[i+1]);
                    i = i + 1;   
                      
                    buffer.append(map.get(current));
                    buffer.append(" ");
                    
                    int div = (size - i) / 3;
                
                    if(div != 0)
                    {
                        buffer.append(helper[div]);
                        buffer.append(" ");
                    }
                }
                else
                {
                    current = current * 10;
                    buffer.append(map.get(current));
                    buffer.append(" ");
                }
                
                addedNumber = true;
            }
            
            else
            {
                if(current != 0)
                {
                    buffer.append(map.get(current));
                    buffer.append(" ");
                    addedNumber = true;
                }
                
                if(!addedNumber)
                    continue;
                    
                int div = (size - i) / 3;
                
                if(div != 0)
                {
                    buffer.append(helper[div]);
                    buffer.append(" ");
                }
                
            }
        }
        
        if((buffer.charAt(buffer.length() -1) == ' '))
            buffer.deleteCharAt(buffer.length() - 1);
            
        return buffer.toString();
    }
}