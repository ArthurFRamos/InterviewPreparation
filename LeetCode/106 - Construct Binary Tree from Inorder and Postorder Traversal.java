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
    
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0)
            return null;
        
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i],i);
        
        
        return buildTree(0,inorder.length - 1,inorder,postorder);
    }
    
    private TreeNode buildTree(int begin, int end, int[] inorder, int[] postorder)
    {
        TreeNode current = new TreeNode(postorder[end]);
        int newEnd = begin - 1;
        int rootPos = map.get(postorder[end]);
        
        for(int i = begin; i <end; i++)
        {
            int temp = map.get(postorder[i]);
            if(temp < rootPos)
                newEnd++;
        }
        
        if(newEnd >= begin)
            current.left = buildTree(begin, newEnd, inorder,postorder);
        if(newEnd + 1 != end)
            current.right = buildTree(newEnd + 1, end - 1, inorder,postorder);

        return current;
    }
}