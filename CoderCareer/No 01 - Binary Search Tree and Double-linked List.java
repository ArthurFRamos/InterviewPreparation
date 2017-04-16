public class Solution {
    
    TreeNode current = null;
    TreeNode newRoot = null;
    
    public void toLinkedList(TreeNode root) 
    {
        inOrder(root);
        //newRoot is the header of the list.
        while(newRoot != null)
        {
            System.out.println(newRoot.val);
            newRoot = newRoot.right;
        }
    }
    
    //To transform the tree in a sorted Linked List, we should traverse the tree in order.
    public void inOrder(TreeNode node)
    {
        if(node == null)
            return;
            
        inOrder(node.left);
        
        if(current == null)
        {
            current = node;
            newRoot = node;
        }
        
        else
        {
            node.left = current;
            current.right = node;
            current = node;
        }
        
        inOrder(node.right);
    }
}
