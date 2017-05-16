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
    private int maxPath = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        maxSum(root);
        
        return maxPath;
    }
    
    private int maxSum(TreeNode node)
    {
        if(node == null)
            return 0;
        
        int current = node.val;
        
        int left = maxSum(node.left);
        
        if(left > 0)
            current += left; 
            
        int right = maxSum(node.right);
        if(right > 0)
            current += right;
            
        if(current > maxPath)
            maxPath = current;
        
        int max = Math.max(left,right);
        if(max < 0)
            max = 0;
            
        return node.val + max;
    }
    
}