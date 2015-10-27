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
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
            
        return helper(root, 1);
    }
    
    private int helper(TreeNode current, int depth)
    {
        if(current == null)
            return Integer.MAX_VALUE;
            
        if(current.left == null && current.right == null)
            return depth;
            
        return Math.min(helper(current.left, depth + 1), helper(current.right, depth + 1));
    }
}