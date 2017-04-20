public class Solution {
    public int findContentChildren(int[] g, int[] s) {
         quicksort(g);
         quicksort(s);
         
         int index = 0;
         int satisfiedChildren = 0;
         
         for(int i = 0; i < s.length && index < g.length; i++)
         {
             if(s[i] >= g[index])
             {
                satisfiedChildren++;
                index++;  
             }
         }
         
         return satisfiedChildren;
    }
    
    private void quicksort(int[] nums)
    {
        quicksort(0,nums.length - 1, nums);
    }
    private void quicksort(int left, int right, int[] nums)
    {
        if(left < right)
        {
            int index = partition(left,right,nums);
            
            if(left < index - 1)
                quicksort(left, index -1, nums);
            if(right > index)
                quicksort(index, right, nums);
        }
    }
    private int partition(int left, int right, int[] nums)
    {
        int pivot = nums[(left + right)/2];
        
        while(left <= right)
        {
            while(nums[left] < pivot)
                left++;
            while(nums[right] > pivot)
                right--;
            
            if(left <= right)
            {
                swap(left,right,nums);
                left++;
                right--;
            }
        }
        
        return left;
    }
    
    private void swap(int i, int j, int[] nums)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}