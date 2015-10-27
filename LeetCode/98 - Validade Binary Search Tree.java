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
    public boolean isValidBST(TreeNode root) {
        
        if(root == null)
            return true;
        
        return helper(root.left, null, root.val) && helper(root.right,root.val,null);
    }
    
    public boolean helper(TreeNode current, Integer min, Integer max)
    {
        if(current == null)
            return true;
        if(min != null)
        {
            if(current.val <= min)
                return false;
        }
        
        if(max != null)
        {
            if(current.val >= max)
                return false;
        }
        
        return helper(current.left, min, current.val) && helper(current.right,current.val,max);
        
    }
    
    
}