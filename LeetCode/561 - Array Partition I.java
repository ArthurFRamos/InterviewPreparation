public class Solution {
    public int arrayPairSum(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++)
            heap.add(nums[i]);
        
        while(!heap.isEmpty())
        {
            sum += heap.poll();
            heap.poll();
        }
        
        return sum;
    }
}