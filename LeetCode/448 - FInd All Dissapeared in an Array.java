public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++)
        {
            int temp = Math.abs(nums[i]) - 1;
            
            if(nums[temp] > 0)
                nums[temp] = -nums[temp];
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > 0)
                list.add(i + 1);
        }
        
        return list;
        
    }
}