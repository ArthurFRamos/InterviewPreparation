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
    
    
    
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList<String>();
        
        if(root == null)
            return paths;
        
        StringBuffer buffer = new StringBuffer();
        
        helper(buffer,paths,root);
        
        return paths;
    }
    
    private void helper(StringBuffer buffer, ArrayList<String> list, TreeNode current)
    {
        if(current == null)
            return;
            
       Integer temp = current.val;
       
       if(current.left == null && current.right == null)
       {
            buffer.append(current.val);
            list.add(buffer.toString());
            buffer.delete(buffer.length() - temp.toString().length(),buffer.length());
            return;
       }

       buffer.append(current.val);
       buffer.append("->");
       
       helper(buffer,list,current.left);
       helper(buffer,list,current.right);
       buffer.delete(buffer.length() - temp.toString().length() - 2,buffer.length());
    }
    
}