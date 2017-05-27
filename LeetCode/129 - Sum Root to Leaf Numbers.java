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
    private int totalSum = 0;
    
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
            
        path(root, new StringBuffer());
        
        return totalSum;
    }
    
    private void path(TreeNode node, StringBuffer current)
    {
        current.append(node.val);
        
        if(node.left == null && node.right == null)
            totalSum += Integer.parseInt(current.toString());
        
        if(node.left != null)
            path(node.left, new StringBuffer(current.toString()));
        if(node.right != null)
            path(node.right, new StringBuffer(current.toString()));
    }
}