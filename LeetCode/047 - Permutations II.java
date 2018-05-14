public class Solution {
    
    private ArrayList<List<Integer>> permutations = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        permute(0,nums);
        
        return permutations;
        
    }
    
    private void permute(int index, int nums[])
    {
        if(index == nums.length)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            
            for(int i = 0; i < nums.length; i++)
                temp.add(nums[i]);
            
            permutations.add(temp);
        } 
        
        HashSet<Integer> flags = new HashSet<>();
        
        for(int i = index; i < nums.length; i++)
        {
            if(flags.contains(nums[i]))
                continue;
            flags.add(nums[i]);
            swap(index,i,nums);
            permute(index + 1, nums);
            swap(index,i,nums);
        }
        
    }
    
    private void swap(int i, int j, int[] nums)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    
}
