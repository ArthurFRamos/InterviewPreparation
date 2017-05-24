public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        int n = nums.length;
        
        for(int i = 0; i < nums.length; i++)
        {
            int temp = nums[i];
            
            if(temp > 2 * n)
                temp -= 2 * n;
            else if(temp > n)
                temp -= n;
            
            nums[temp - 1] += n;
        }
        
        ArrayList<Integer> l = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > 2 * n)
                l.add(i + 1);
        }
        
        return l;
    }
}