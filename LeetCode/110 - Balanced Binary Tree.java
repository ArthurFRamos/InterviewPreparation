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
    private boolean balanced;
    
    public boolean isBalanced(TreeNode root) {
        balanced = true;
        
        if(root == null)
            return true;
        
        helperBalanced(root);
        
        return balanced;
        

    }
    
    public int helperBalanced(TreeNode current)
    {
        if(current == null)
            return 0;
        
        int left = helperBalanced(current.left);
        int right = helperBalanced(current.right);
        
        if(Math.abs(left - right) > 1)
            balanced = false;
        
        return 1 + Math.max(left,right);
    }
}