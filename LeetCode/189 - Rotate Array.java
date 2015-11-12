public class Solution {
    public void rotate(int[] nums, int k) {
        
        k %= nums.length;
        
        reverse(0,nums.length,nums);
        
        reverse(0,k,nums);
        
        reverse(k, nums.length,nums);
   
    }
    
    private void reverse(int begin, int end, int[] nums)
    {
        for(int i = begin; i < (begin + end)/2; i++)
            swap(i, (begin + end) - 1 - i,nums);
        
    }
    
    private void swap(int x, int y, int[] nums)
    {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}