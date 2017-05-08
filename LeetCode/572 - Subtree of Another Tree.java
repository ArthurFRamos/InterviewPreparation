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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null)
            return (t == null);
        return pass(s,t);
        
    }
    
    private boolean pass(TreeNode s, TreeNode t)
    {
        if(s == null || t == null)
            return false;
        
        if(compare(s,t))
            return true;
        return pass(s.left,t) || pass(s.right,t); 
    }
    
    private boolean compare(TreeNode s, TreeNode t)
    {
        if(s == null)
            return (t == null);
        if(t == null)
            return false;
        if(s.val != t.val)
            return false;
        return compare(s.left,t.left) && compare(s.right, t.right);
    }
    
}