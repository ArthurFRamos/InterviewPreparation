public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int pos1 = m -1;
        int pos2 = n - 1;
        
        int currentPos = nums1.length -1;
        
        while(pos1 >= 0 && pos2 >= 0)
        {
            if(nums1[pos1] >= nums2[pos2])
            {
                nums1[currentPos] = nums1[pos1];
                pos1--;
            }
            else
            {
                nums1[currentPos] = nums2[pos2];
                pos2--;
            }
            currentPos--;
        }
        
        while(pos2 >= 0)
            nums1[currentPos--] = nums2[pos2--];
        
    }
}