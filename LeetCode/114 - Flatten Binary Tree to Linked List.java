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
    
    TreeNode current = null;
    
    public void flatten(TreeNode root) {
        preOrder(root);
        TreeNode current = root;
        
        //Everything that is on the left is put on the right, left becomes null
        while(current != null)
        {
            current.right = current.left;
            current.left = null;
            current = current.right;
        }
    }
    
    //Pre order transversal of the tree, constructing the linked list on the left, since we still need the information on the right.
    public void preOrder(TreeNode node)
    {
        if(node == null)
            return;
            
        if(current == null)
            current = node;
        else
        {
            current.left = node;
            current = current.left;   
        }
            
        preOrder(node.left);
        preOrder(node.right);
    }
}