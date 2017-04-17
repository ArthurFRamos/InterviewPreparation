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
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        
        passTree(root);
        
        return root.val;
    }
    
    public void passTree(TreeNode node)
    {
        if(node == null)
            return;
            
        passTree(node.left);
        passTree(node.right);
        
        int firstCalculation = 0;
        
        int temp = (node.left == null) ? 0 : node.left.val;
        firstCalculation += temp;
        temp = (node.right == null) ? 0 : node.right.val;
        firstCalculation += temp;
        
        int secondCalculation = 0;
        if(node.left != null)
        {
            temp = (node.left.left == null) ? 0 : node.left.left.val;
            secondCalculation += temp;
            temp = (node.left.right == null) ? 0 : node.left.right.val;
            secondCalculation += temp;
        }
        
        if(node.right != null)
        {
            temp = (node.right.left == null) ? 0 : node.right.left.val;
            secondCalculation += temp;
            temp = (node.right.right == null) ? 0 : node.right.right.val;
            secondCalculation += temp;
        }
        
        node.val = Math.max(firstCalculation, node.val + secondCalculation);
    }
    
    
}