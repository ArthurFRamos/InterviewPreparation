/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<Integer, Integer> min = new HashMap<>();
    HashMap<Integer, Integer> max = new HashMap<>();
    
    public int widthOfBinaryTree(TreeNode root) {
        min.put(1,1);
        max.put(1,1);
        if(root == null)
            return 0;
        root.val = 1;
        
        int maxDiff = 1;
        calc(1, root.val, root);
        
        int level = 1;
        while(min.containsKey(level))
        {
            int diff = max.get(level) - min.get(level) + 1;
            if(diff > maxDiff)
                maxDiff = diff;
            level++;
        }
        
        return maxDiff;
    }
    
    public void calc(int level, int value, TreeNode node)
    {
        if(node == null)
            return;
        node.val = value;
        if(!min.containsKey(level))
            min.put(level,value);
        if(!max.containsKey(level))
            max.put(level,value);
        
        if(min.get(level) > value)
            min.put(level,value);
        if(max.get(level) < value)
            max.put(level,value);
        
        calc(level + 1, (2*value) - 1, node.left);
        calc(level + 1, (2*value), node.right);
    }
    
}