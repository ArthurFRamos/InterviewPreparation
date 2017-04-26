public class Solution {

    HashSet<ArrayList<Integer>> flags = new HashSet<>();
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        ArrayList<List<Integer>> solutions = new ArrayList<List<Integer>>();
        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            
            temp = solution(nums[i],i,nums);
            if(temp != null)
            {
                for(int j = 0; j < temp.size(); j++)
                {
                        current = temp.get(j);
                        current.add(nums[i]);
                        Collections.sort(current);
                        
                        if(!flags.contains(current))
                        {
                            solutions.add(current);
                            flags.add(current);
                        }
                }
            }
        }
        
        return solutions;
    }
    
    private ArrayList<ArrayList<Integer>> solution(int target, int targetPos, int[] nums)
    {
        int begin = 0;
        int end = nums.length - 1;
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        ArrayList<Integer> sol = new ArrayList<>();
        while(begin < end)
        {
            if(begin == targetPos)
            {
                begin++;
                continue;   
            }
            
            if(end == targetPos)
            {
                end--;
                continue;   
            }
            
            if(nums[begin] + nums[end] == -target)
            {
                sol.add(nums[begin]);
                sol.add(nums[end]);
                solutions.add(sol);
                sol = new ArrayList<>();
                begin++;
            }
            
            else if(nums[begin] + nums[end] < -target)
                begin++;
            else
                end--;
        }
        
        return solutions;
    }
    
}
