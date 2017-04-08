public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        
        for(int i = 0; i <= numbers.length; i++)
        {
            int current = numbers[i];
            ans[0] = i + 1;
            ans[1] = binarySearch(i + 1, numbers.length - 1, numbers,current, target);
            if(ans[1] != -1)
                return ans;
        }
        
        return ans;
    }
    
    private int binarySearch(int begin, int end, int[] numbers, int current, int target)
    {
        while(begin <= end)
        {
            int mid = (begin + end)/2;
            
            if(current + numbers[mid] > target)
                end = mid - 1;
            else if(current + numbers[mid] < target)
                begin = mid + 1;
            else
                return mid + 1;
        }
        
        return -1;
    }
    
    
}