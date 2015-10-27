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
        if(root == null || p == null || q == null)
            return null;
        if(check(root,p,q) != 2)
            return null;
        
        return lowestHelper(root, p, q);
    }
    
    private TreeNode lowestHelper(TreeNode current, TreeNode p, TreeNode q)
    {
         if(current == p || current == q)
            return current;
            
         int count = check(current.left, p,q);
         
         if(count == 2)
             return lowestHelper(current.left, p, q);
         else if(count == 1)
            return current;
        else
            return lowestHelper(current.right, p, q);
    }
    
    private int check(TreeNode current, TreeNode p, TreeNode q)
    {
        int count = 0;
        
        if(current == null)
            return 0;
        if(current == p || current == q )
            count = 1;
        
        return count + check(current.left, p, q) + check(current.right, p, q);
    }
}
