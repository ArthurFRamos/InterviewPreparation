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
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> largest = new ArrayList<>();
        HashMap<TreeNode, Integer> level = new HashMap<>();
        
        if(root == null)
            return largest;
            
        LinkedList<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        int currentLevel = 1;
        level.put(root,1);
        int maximum = Integer.MIN_VALUE;
        
        while(!queue.isEmpty())
        {
            TreeNode current = queue.poll();
            
            int temp = level.get(current);
            if(temp != currentLevel)
            {
                currentLevel = temp;
                largest.add(maximum);
                maximum = current.val;
            }
            else
            {
                if(current.val > maximum)
                    maximum = current.val;
            }
            
            if(current.left != null)
            {
                level.put(current.left, currentLevel + 1);
                queue.add(current.left);
            }
            if(current.right != null)
            {
                level.put(current.right, currentLevel + 1);
                queue.add(current.right);
            }
        }
        
        largest.add(maximum);
        
        return largest;
    }
}