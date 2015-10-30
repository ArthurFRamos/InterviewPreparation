/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private TreeNode current;
    private TreeNode root;
    
    public BSTIterator(TreeNode root) {
        this.root = root;
        current = null;
    }
    
     private TreeNode getLastParent(TreeNode current, TreeNode target)
    {
        
        TreeNode lastParent = null;
        TreeNode possibleParent = null;
        if(current == null)
            return null;
        if(current == target)
            return null;
            
        if(target.val < current.val)
        {
            lastParent = current;
            possibleParent = getLastParent(current.left, target);
        }
        else
            possibleParent = getLastParent(current.right, target);
        
        
        if(possibleParent != null)
            return possibleParent;
        return lastParent;
    }

    private TreeNode getMin(TreeNode current)
    {
        if(current.left == null)
            return current;
        else
            return getMin(current.left);
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(root == null)
            return false;
            
        return (peekNext() != null);
    }

    /** @return the next smallest number */
    public int next() {
        current = peekNext();
        return current.val;
    }
    
    private TreeNode peekNext()
    {
        if(current == null)
            return getMin(root);
        if(current.right != null)
            return getMin(current.right);
        else
            return getLastParent(root,current);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */