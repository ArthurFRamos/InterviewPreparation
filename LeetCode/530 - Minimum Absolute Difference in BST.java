/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
                
    getNodes(root);
    Collections.sort(list);
    int min = Integer.MAX_VALUE;
        
        for(int i = list.size() - 1; i > 0; i--)
        {
            int current = list.get(i) - list.get(i-1);
            if(current < min)
                min = current;
        }
        
        return min;
    }
    
    public void getNodes (TreeNode node)
    {
        if(node == null)
            return;
        
        list.add(node.val);
        getNodes(node.left);
        getNodes(node.right);
    }
}