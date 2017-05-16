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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<TreeNode> flags = new HashSet<>();
        
        if(root == null)
            return list;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.empty())
        {
            TreeNode current = stack.peek();
            while(current.left != null && !flags.contains(current.left))
            {
                stack.add(current.left);
                current = current.left;   
            }
            list.add(current.val);
            stack.pop();
            flags.add(current);
            
            if(current.right != null)
                stack.add(current.right);
        }
        
        return list;
    }
}