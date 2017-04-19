public class Solution {
    public TreeNode invertTree(TreeNode root) {
        mirror(root);
        
        return root;
    }
    
    public void mirror(TreeNode node)
    {
        if(node == null)
            return;
        
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;
        
        mirror(node.left);
        mirror(node.right);
    }
}