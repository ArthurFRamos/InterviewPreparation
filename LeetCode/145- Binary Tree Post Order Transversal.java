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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if(root == null)
            return list;
            
        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode current;
        
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            current = stack.pop();
            
            if(visited.contains(current) || (current.left == null && current.right == null))
                list.add(current.val);
                
            else
            {
                visited.add(current);
                
                stack.push(current);
                
                if(current.right != null)
                    stack.push(current.right);
                    
                if(current.left != null)
                    stack.push(current.left);
            }
        }
        return list;
    }
}