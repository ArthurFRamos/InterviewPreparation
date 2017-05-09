public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            if(stack.isEmpty())
            {
                stack.add(nums[i]);
                continue;   
            }
            
            
            while(!stack.isEmpty() && stack.peek() < nums[i])
                map.put(stack.pop(),nums[i]);
            
            stack.add(nums[i]);
        }
        
        int[] result = new int[findNums.length];
        
        for(int i = 0; i < findNums.length; i++)
        {
            if(!map.containsKey(findNums[i]))
                result[i] = -1;
            else
                result[i] = map.get(findNums[i]);
        }
        
        return result;
    }
}