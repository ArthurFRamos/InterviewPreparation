public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],i);
            else
            {
                int temp = map.get(nums[i]);
                
                if(i - temp <= k)
                    return true;
                map.put(nums[i],i);
            }
        }
        
        return false;
    }
}