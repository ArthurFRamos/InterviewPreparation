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
    
    int curSum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        calculate(root);
        return root;
    }
    
    //It is just an inverse in order transversal
    public void calculate(TreeNode node)
    {
        if(node == null)
            return;
        
        calculate(node.right);
        node.val += curSum;
        curSum = node.val;
        calculate(node.left);
    }
    
}