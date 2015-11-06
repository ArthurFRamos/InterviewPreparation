public class Solution {
    public void moveZeroes(int[] nums) {
        int first = 0;
        int second = 0;
        
        while(second < nums.length && first < nums.length)
        {
            if(first > second)
                second = first;
            if(nums[first] == 0)
            {
                for(int i = second; i < nums.length; i++)
                {
                    if(nums[i] != 0)
                    {
                        swap(nums,first,i);
                        second = i + 1;
                        break;
                    }
                }
            }
            first++;
            
        }
    }
    
    private void swap(int[] nums, int posA, int posB)
    {
        int temp = nums[posA];
        nums[posA] = nums[posB];
        nums[posB] = temp;
    }
}