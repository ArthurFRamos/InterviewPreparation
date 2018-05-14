public class Solution {
    
    private HashSet<Integer> flags = new HashSet<>();
    private ArrayList<List<Integer>> permutations = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        int[] helper = new int[nums.length];
        calc(nums,helper,0);
        
        return permutations;
    }
    
    public void calc(int[] nums, int[] helper, int index)
    {
        
        if(index == nums.length)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            
            for(int i = 0; i < helper.length; i++)
                temp.add(helper[i]);    
            
            permutations.add(temp);
            return;
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if(!flags.contains(i))
            {
                helper[index] = nums[i];
                flags.add(i);
                calc(nums,helper, index + 1);
                flags.remove(i);
            }
        }
    }
}
