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
    private ArrayList<List<Integer>> lists = new ArrayList<>();
    private ArrayList<Integer> current = new ArrayList<>();
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        if(root == null)
            return lists;
            
        while(!isLeaf(root))
        {
            current = new ArrayList<>();
            removeLeafs(root);
            lists.add(current);
        }
        
        current = new ArrayList<>();
        current.add(root.val);
        lists.add(current);
        
        return lists;
    }
    
    private void removeLeafs(TreeNode node)
    {
        if(node == null)
            return;
            
        if(isLeaf(node.left))
        {
            current.add(node.left.val);
            node.left = null;   
        }
        
        if(isLeaf(node.right))
        {
            current.add(node.right.val);
            node.right = null;
        }
        
        removeLeafs(node.left);
        removeLeafs(node.right);
    }
    private boolean isLeaf(TreeNode node)
    {
        if(node == null)
            return false;
        
        return (node.left == null && node.right == null);
    }
}