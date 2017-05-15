public class Solution {
    private HashMap<Integer,ArrayList<Integer>> children = new HashMap<>();
    
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < pid.size(); i++)
        {
            if(!children.containsKey(ppid.get(i)))
            {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(pid.get(i));
                children.put(ppid.get(i),temp);
            }
            
            else
            {
                ArrayList<Integer> temp = children.get(ppid.get(i));
                temp.add(pid.get(i));
            }
        }
        
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(kill);
        
        while(!queue.isEmpty())
        {
            int current = queue.poll();
            ans.add(current);
            ArrayList<Integer> temp = children.get(current);
            for(int i = 0; temp != null && i < temp.size(); i++)
                queue.add(temp.get(i));
        }
        
        return ans;
    }
}