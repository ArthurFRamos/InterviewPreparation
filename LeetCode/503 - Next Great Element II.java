public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] cycle = new int[nums.length * 2];
        int[] answer = new int[nums.length];
        
        for(int i = 0; i < answer.length; i++)
            answer[i] = -1;
        
        for(int i = 0; i < nums.length; i++)
        {
            cycle[i] = nums[i];
            cycle[i + nums.length] = nums[i];
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0;  i < cycle.length; i++)
        {
            while(!stack.isEmpty())
            {
                int current = stack.peek();
                if(cycle[i] > cycle[current])
                {
                    if(current < answer.length)
                        answer[current] = cycle[i];
                    stack.pop();
                }
                else
                    break;
            }
            
            stack.add(i);
        }
        
        return answer;
    }
}