public class Solution {
  

  
    private int highest = 0;
    private ArrayList<Integer> values = new ArrayList<>(); 
    private HashMap<Integer,Integer> map = new HashMap<>();
    
    public int[] findMode(TreeNode root) {
        if(root == null)
            return new int[0];
        
        modeCalc(root);
        
        Iterator<Integer> it  = map.keySet().iterator();
        
        while(it.hasNext())
        {
            int current = map.get(it.next());
            if(current > highest)
                highest = current;
        }
        
        it = map.keySet().iterator();
        
        while(it.hasNext())
        {
            int currentKey = it.next();
            if(map.get(currentKey) == highest)
                values.add(currentKey);
        }
        
        int ans[] = new int[values.size()];
        
        for(int i = 0; i < values.size(); i++)
            ans[i] = values.get(i);
        
        return ans;
      
    }
    
    private void modeCalc(TreeNode node)
    {
        if(node == null)
            return;
        if(map.containsKey(node.val))
        {
            int value = map.get(node.val);
            map.put(node.val,value + 1);
        }
        else
            map.put(node.val,1);
        
        modeCalc(node.left);
        modeCalc(node.right);
        
    }
}