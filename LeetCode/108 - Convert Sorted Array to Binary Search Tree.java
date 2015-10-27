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
    public TreeNode sortedArrayToBST(int[] nums) {
         if(nums == null || nums.length == 0)
            return null;
        
        TreeNode root = new TreeNode(nums[(0 + nums.length - 1)/2]);
        setChildren(root,0,nums.length - 1, nums);
        
        return root;
    }
    
   public void setChildren(TreeNode current, int begin,int end, int[] nums)
    {
        if(begin == end)
            return;
            
        int position = (begin + end)/2;
        
        if(position != begin)
        {
            current.left = new TreeNode (nums[(begin + position - 1)/2]);
            setChildren(current.left,begin, position - 1, nums);
        }
        if(position != end)
        {
            current.right = new TreeNode(nums[(position + 1 + end)/2]);
            setChildren(current.right,position + 1, end,nums);   
        }
    }
}