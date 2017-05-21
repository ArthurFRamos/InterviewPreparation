public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int begin = 0;
        int end = nums1.length;
        
        while(begin <= end)
        {
            int i = (begin + end)/2;
            int j = (nums1.length + nums2.length + 1)/2 - i;
            
            if( j < 0)
                end = i - 1;
            else if(j > nums2.length || (i != nums1.length && j != 0 && nums2[j- 1] > nums1[i]))
                begin = i + 1;
            else if (j != nums2.length && (i != 0 && nums1[i-1] > nums2[j]))
                end = i - 1;
            else
            {
                int mod = (nums1.length + nums2.length) % 2;
                int value1 = (i == nums1.length) ? Integer.MAX_VALUE : nums1[i];
                int value2 = (j == nums2.length) ? Integer.MAX_VALUE : nums2[j];
                
                if(i == 0)
                {
                    if(mod == 1)
                        return nums2[j - 1];
                    else
                        return ((double)(Math.min(value2,value1)  + nums2[j-1]))/2;
                }
                if(j == 0)
                {
                    if(mod == 1)
                        return nums1[i-1];
                    else
                        return ((double)(Math.min(value1,value2) + nums1[i-1])/2);
                }
                
                if(mod == 1)
                    return Math.max(nums2[j-1], nums1[i-1]);
                else
                    return ((double)(Math.min(value1, value2) + Math.max(nums1[i-1],nums2[j-1])))/2;
            }
        }
        
        return -1;
    }
}