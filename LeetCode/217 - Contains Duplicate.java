public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> map = new HashSet<Integer>();
        
        for(int i  : nums)
        {
            if(map.contains(i))
                return true;
            else map.add(i);
        }
        
        return false;
        
    }
}