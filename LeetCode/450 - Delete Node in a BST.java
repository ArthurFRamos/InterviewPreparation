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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
            
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.right = root;
        newRoot.left = root;
        TreeNode next = null;
        TreeNode toRemove = null;
        TreeNode current = newRoot;
        
        while(current != null)
        {
            if(current.right != null && current.right.val == key)
            {
                toRemove = current.right;
                break;   
            }
            
            else if (current.left != null && current.left.val == key)
            {
                toRemove = current.left;
                break;   
            }
            
            if(key >= current.val)
            {
                current = current.right;
            }
            else
                current = current.left;
        
        }
        
        if(toRemove == null)
            return root;
            
        if(toRemove.left == null)
            next = toRemove.right;
        else if(toRemove.right == null)
            next = toRemove.left;
        else
        {
            next = getLowest(toRemove);
            if(toRemove.right.val != next.val)
                next.right = toRemove.right;
            next.left = toRemove.left;
        }   
        
        if(toRemove == current.right)
            current.right = next;
        else
            current.left = next;
        return newRoot.right;
    }
    
    private TreeNode getLowest(TreeNode toRemove)
    {
        TreeNode current = toRemove.right;
        TreeNode previous = null;
        
        while(current.left != null)
        {
            previous = current;
            current = current.left;
        }
        
        if(previous != null)
            previous.left = current.right;
        return current;
    }
}