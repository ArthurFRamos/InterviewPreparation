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
    
    private HashMap<Integer,Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
            
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i],i);
        
        return buildTree(0, inorder.length - 1, 0, preorder.length - 1,preorder);
    }
    
    private TreeNode buildTree(int inStart, int inEnd, int preStart, int preEnd, int[] preorder)
    {
        if(inStart > inEnd || preStart > preEnd)
            return null;
        TreeNode current = new TreeNode(preorder[preStart]);
        int pos = map.get(current.val);
        current.left = buildTree(inStart, pos - 1, preStart + 1, (pos - inStart) + preStart,preorder);
        current.right = buildTree(pos + 1, inEnd, preStart + (pos - inStart) + 1, preEnd, preorder);
        
        return current;
        
    }
}