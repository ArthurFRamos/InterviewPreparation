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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(p == null || q == null)
            return null;
            
        boolean hasNodes = search(p.val,root) && search(q.val,root);
        
        if(!hasNodes)
            return null;
        
        return helper(root,p,q);
    }
    
    private boolean search(int val, TreeNode current)
    {
        while(current != null)
        {
            if(current.val == val)
                return true;
            if(current.val >= val)
                current = current.left;
            else
                current = current.right;
        }
        
        return false;
    }
    
    private TreeNode helper(TreeNode current, TreeNode p, TreeNode q)
    {
        
        if(current.val > p.val && current.val > q.val)
            return helper(current.left, p, q);
        else if(current.val < p.val && current.val < q.val)
            return helper(current.right, p, q);
        
        return current;
    }
}