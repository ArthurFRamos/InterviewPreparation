public class Solution {
    
    class StringHelper implements Comparable<StringHelper>
    {
        private String base;
        
        public StringHelper(String word)
        {
            base = word;
        }
        
        public int compareTo (StringHelper other)
        {
            
            String temp1 = base + other.base;
            String temp2 = other.base + base;
            int compare = temp1.compareTo(temp2);
            
            if(compare > 0)
                return -1;
            else
                return 1;
        }
    }
    public String largestNumber(int[] nums) {
        ArrayList<StringHelper> list = new ArrayList<StringHelper>();
        
        for(int i = 0; i < nums.length; i++)
        {
            Integer temp = nums[i];
            list.add(new StringHelper(temp.toString()));
        }
        
        Collections.sort(list);
        
        StringBuffer buffer = new StringBuffer();
        
        for(StringHelper i : list)
            buffer.append(i.base);
        
        String largest = buffer.toString();
        
        if(largest.charAt(0) == '0')
            return "0";
        
        return largest;
    }
    
}