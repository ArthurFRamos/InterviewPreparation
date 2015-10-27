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
    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if(root == null)
            return list;
            
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode current;
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            current = stack.pop();
            
            list.add(current.val);
 
            if(current.right != null)
                stack.push(current.right);
                
            if(current.left != null)
                stack.push(current.left);
                
        }
        
        return list;
    }
}