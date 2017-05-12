public class Solution {
    
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    
    public Solution(int[] nums) {
        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(nums[i]))
            {
                ArrayList<Integer> temp = map.get(nums[i]);
                temp.add(i);
            }
            else
            {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(nums[i],temp);
            }
        }
    }
    
    public int pick(int target) {
        ArrayList<Integer> temp = map.get(target);
        Random r = new Random();
        int random = r.nextInt(temp.size());
        
        return temp.get(random);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */