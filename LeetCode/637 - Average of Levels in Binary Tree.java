/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    private HashMap<Integer, Double> value = new HashMap<>();
    private HashMap<Integer, Integer> quantity = new HashMap<>();
    
    public List<Double> averageOfLevels(TreeNode root) 
    {
        
        calculate(root,1);
        
        ArrayList<Double> ans = new ArrayList<>();
        for(int i = 1; value.containsKey(i); i++)
        {
            double v = value.get(i);
            int q = quantity.get(i);
            
            ans.add(v/q);
        }
        
        return ans;
    }
        
    public void calculate(TreeNode node, int level)
    {
        if(node == null)
            return;
        
        if(!value.containsKey(level))
        {
            value.put(level,(double)node.val);
            quantity.put(level, 1);
        }
        
        else
        {
            double v = value.get(level);
            value.put(level, v + node.val);
            int q = quantity.get(level);
            quantity.put(level, q + 1);
        }
        
        calculate(node.left, level + 1);
        calculate(node.right, level + 1);
    }
    
}