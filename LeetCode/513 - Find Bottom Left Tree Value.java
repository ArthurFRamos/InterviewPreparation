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
    
    HashMap<TreeNode, Integer> map;
    private int highestLevel = 0;
    
    public int findBottomLeftValue(TreeNode root) {
        map = new HashMap<>();
        
        addLevels(root,1);
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        TreeNode current = null;
        
        while(!queue.isEmpty())
        {
            current = queue.poll();
            if(map.get(current) == highestLevel)
                return current.val;
            if(current.left != null)
                queue.add(current.left);
            if(current.right != null)
                queue.add(current.right);
        }
        
        return -1;
    }
    
    private void addLevels(TreeNode node, int level)
    {
        if(node == null)
            return;
        
        if(level > highestLevel)
            highestLevel = level;
        
        map.put(node,level);
        addLevels(node.left, level + 1);
        addLevels(node.right, level + 1);
    }
    
}