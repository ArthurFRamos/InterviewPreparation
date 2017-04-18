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
    
    int total = 0;
    
    
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        
        find(root,0,sum);
        
        root(root,sum);
        
        return total;
    }
    
    public void root(TreeNode node, int target)
    {
        if(node == null)
            return;
        find(node.right, 0, target);
        find(node.left,0, target);
        root(node.right,target);
        root(node.left,target);
    }
    
    
    public void find(TreeNode node, int sum, int target)
    {
        
        if(node == null)
            return;
        sum += node.val;
        
        if(sum == target)
            total++;
        
        find(node.right,sum,target);
        find(node.left,sum,target);
    }
    
}