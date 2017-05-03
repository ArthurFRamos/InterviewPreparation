public class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        
        int currentSum = 0;
        int ways = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            currentSum += nums[i];
            
            int temp = currentSum - k;
            
            if(map.containsKey(temp))
                ways += map.get(temp);
            if(!map.containsKey(currentSum))
                map.put(currentSum,0);
            map.put(currentSum, map.get(currentSum) + 1);
        }
        
        return ways;
    }
}