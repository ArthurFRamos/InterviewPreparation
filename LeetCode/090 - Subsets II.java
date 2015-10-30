public class Solution {
    
    private HashSet<ArrayList<Integer>> map;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        map = new HashSet<ArrayList<Integer>>();
        return generateN(nums, nums.length);
    }
    
     public List<List<Integer>> generateN(int [] nums, int n)
    {
        List<List<Integer>> previous = new ArrayList<>();
        
        if(n == 0)
        {
            previous.add(new ArrayList<Integer>());
            return previous;
            
        }
        
        previous = generateN(nums, n-1);
        
        List<List<Integer>> current = new ArrayList<>();
        
        current.addAll(previous);
        
        ArrayList<Integer> temp;
        
        for(int i = 0; i < previous.size(); i++)
        {
            temp = new ArrayList<Integer>();
            
            for(int j = 0; j < previous.get(i).size(); j++)
                temp.add(previous.get(i).get(j));
            
            temp.add(nums[n-1]);
            if(!map.contains(temp))
            {
                current.add(temp);
                map.add(temp);   
            }
        }
        return current;
    }
}