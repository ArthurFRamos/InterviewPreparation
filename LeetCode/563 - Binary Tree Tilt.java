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
    
    int tilt = 0;
    
    public int findTilt(TreeNode root) {
        calculate(root);
        
        return tilt;
    }
    
    public int calculate(TreeNode node)
    {
        if(node == null)
            return 0;
        int sumLeft = calculate(node.left);
        int sumRight = calculate(node.right);
        
        tilt += Math.abs(sumLeft - sumRight);
        
        return node.val + sumLeft + sumRight;
    }
}