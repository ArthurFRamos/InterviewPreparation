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
    
    private boolean found = false;
    private TreeNode ans = null;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inOrderTraversal(root,p);
        
        return ans;
    }
    
    public void inOrderTraversal(TreeNode node, TreeNode p)
    {
        if(ans != null)
            return;
        if(node == null)
            return;
        
        inOrderTraversal(node.left, p);
        
        if(found && ans == null)
        {
            ans = node;
            return;
        }
        
        if(node.val == p.val)
            found = true;
            
        inOrderTraversal(node.right,p);
    }
}