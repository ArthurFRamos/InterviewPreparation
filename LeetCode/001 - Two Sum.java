public class Solution {
    

    
    public int[] twoSum(int[] nums, int target) {
        
        HashSet<Integer> map = new HashSet<Integer>();
        
        int firstNum = -1;
        int secondNum = -1;
        
        for(int i = 0; i < nums.length; i++)
            map.add(nums[i]);
     
        for(int i = 0; i < nums.length; i++)
        {
            if(map.contains(target - nums[i]))
            {
                if(target - nums[i] == nums[i])
                {
                    if(checkDuplicate(nums[i],nums))
                    {
                         firstNum = i + 1;
                         secondNum = target - nums[i];
                         break;
                    }
                }
                else
                {
                    firstNum = i + 1;
                    secondNum = target - nums[i];
                    break;
                }
       
            }
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if(secondNum == nums[i] && (i + 1) != firstNum)
            {
                secondNum = i + 1;
                break;   
            }
        }
        
        return (firstNum > secondNum) ?  new int[] {secondNum, firstNum} : new int[] {firstNum, secondNum};
    }
    
    private boolean checkDuplicate(int x, int nums[])
    {
        int count = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == x)
                count++;
        }
        
        return (count == 2) ? true : false;
    }

}