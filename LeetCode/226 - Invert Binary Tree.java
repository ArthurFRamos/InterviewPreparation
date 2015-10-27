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
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        
        return root;
    }
    
    public void invert(TreeNode current)
    {
        if(current == null)
            return;
            
        TreeNode temp = current.left;

        current.left = current.right;
        current.right = temp;
        
        invert(current.left);
        invert(current.right);
    }
}