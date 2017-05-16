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
    public int closestValue(TreeNode root, double target) {
        TreeNode current = root;
        
        if(current == null)
            return 0;
            
        double distance = Double.MAX_VALUE;
        int closest = 0;
        
        while(current != null)
        {
            double curDis = Math.abs(target - current.val);
            
            if(curDis < distance)
            {
                distance = curDis;
                closest = current.val;
            }
            
            if(target > current.val)
                current = current.right;
            else
                current = current.left;
        }
        
        return closest;
    }
}