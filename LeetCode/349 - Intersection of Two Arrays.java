public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> flags = new HashSet<>();
        HashSet<Integer> added = new HashSet<>();
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums1.length; i++)
            flags.add(nums1[i]);
        for(int i = 0; i < nums2.length; i++)
        {
            if(flags.contains(nums2[i]) && !added.contains(nums2[i]))
            {
                added.add(nums2[i]);
                list.add(nums2[i]);
            }
        }
        
        int[] ans = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        
        return ans;
    }
}