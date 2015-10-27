public class Solution {
    
    private HashMap<Integer,Integer> hash;
    
    public int majorityElement(int[] nums) {
        hash = new HashMap<Integer,Integer>();
        int maxCount = 0;
        int maxNum = -1;
        
        Integer tempCount = null;
        
        for(int i = 0; i < nums.length; i++)
        {
            tempCount = hash.get(nums[i]);
            if(tempCount == null)
                tempCount = 1;
            else
                tempCount = new Integer(tempCount + 1);
            hash.put(nums[i],tempCount);
            if(tempCount > maxCount)
            {
                maxNum = nums[i];
                maxCount = tempCount;   
            }
        }
        
        return maxNum;
    }
}