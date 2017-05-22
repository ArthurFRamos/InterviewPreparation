public class Solution {
    public int findLHS(int[] nums) {
        int biggest = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            map.put(nums[i],0);
            map.put(nums[i] - 1, 0);
            map.put(nums[i] + 1, 0);
        }
            
        for(int i = nums.length - 1; i >= 0; i--)
        {
            map.put(nums[i], map.get(nums[i]) + 1);
            
            
            int current = Math.max(map.get(nums[i] + 1), map.get(nums[i] - 1));
            if(current != 0)
                current += map.get(nums[i]);
                
            if(current > biggest)
                biggest = current;
        }
        
        return biggest;
    }
}