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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        
        return helper(root,0,sum);
    }
    
    private boolean helper(TreeNode current, int sum, int target)
    {
        if(current == null)
            return false;
            
        sum = sum + current.val;
        
        if(sum == target)
        {
            if(current.left == null && current.right == null)
                return true;
        }
        
        return helper(current.left,sum,target) || helper(current.right,sum,target);
        
    }
}