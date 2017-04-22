public class Solution {
    
    public int jump(int[] nums) {
        
        if(nums.length == 0)
            return 0;
        

        HashSet<Integer> flags = new HashSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);

        
        LinkedList<Integer> queue = new LinkedList<>();

        flags.add(0);
        queue.add(0);
        
        while(!queue.isEmpty())
        {
            int current = queue.poll();

            if(current == nums.length -1)
                return map.get(current);
            
            int jump = nums[current];
            
            if(jump + current + 1 >= nums.length)
                return map.get(current) + 1;
            for(int i = current + jump; i > current; i--)
            {
                if(!flags.contains(i))
                {
                    flags.add(i);
                    map.put(i, map.get(current) + 1);
                    queue.add(i);
                }
            }
        }
        
        return -1;
    }
}