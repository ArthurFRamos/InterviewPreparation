public class Solution {
    
    HashMap<Integer,Integer> map;
    
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            int temp = lisHelper(i,nums);
            if(temp > max)
                max = temp;
        }
        
        return max;
    }
    
    private int lisHelper(int value, int[] nums)
    {
        if(map.containsKey(value))
            return map.get(value);
            
        int max = 1;
        
        for(int i = value + 1; i < nums.length; i++)
        {
            if(i == value)
                continue;
            if(nums[value] < nums[i])
            {
                int temp = 1 + lisHelper(i,nums);
                if(temp > max)
                    max = temp;
            }
        }
        
        map.put(value,max);
        
        return max;
    }
}