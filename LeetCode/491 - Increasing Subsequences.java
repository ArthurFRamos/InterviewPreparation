public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        ArrayList<List<Integer>> sequences = new ArrayList<>();
        HashSet<List<Integer>> flags = new HashSet<>();
        
        if(nums.length == 0 || nums.length == 1)
            return sequences;
            
        ArrayList<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        flags.add(first);
        ArrayList<List<Integer>> addLists = new ArrayList<>();
        sequences.add(first);
        for(int i = 1; i < nums.length; i++)
        {
            Iterator<List<Integer>> it = sequences.iterator();
            int current = nums[i];
            addLists = new ArrayList<>();
            while(it.hasNext())
            {
                List<Integer> temp = it.next();
                int toAdd = temp.get(temp.size() - 1);
                if(toAdd <= current)
                {
                    ArrayList<Integer> newList  = new ArrayList<>();
                    for(int j = 0; j < temp.size(); j++)
                        newList.add(temp.get(j));
                    newList.add(current);
                    
                    if(!flags.contains(newList))
                    {
                        flags.add(newList);                        
                        addLists.add(newList);
                    }
                }
            }
            
            first = new ArrayList<>();
            first.add(nums[i]);
            addLists.add(first);
            sequences.addAll(addLists);
        }
        
        for(int i = 0; i < sequences.size(); i++)
        {
            if(sequences.get(i).size() == 1)
            {
                sequences.remove(i);
                i--;   
            }
        }
        
        return sequences;
    }
}