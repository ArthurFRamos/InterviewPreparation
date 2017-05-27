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
    int small = 0;
    int smallest = 0;
    
    public int kthSmallest(TreeNode root, int k) {
            findSmallest(root,k);
            
            return smallest;
    }
    
    private void findSmallest(TreeNode node, int k)
    {
        if(node == null)
            return;
        findSmallest(node.left, k);
        small++;
        
        if(small == k)
        {
            smallest = node.val;
            return;
        }
        
        findSmallest(node.right,k);
    }
}