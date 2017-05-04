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
    
    private HashMap<TreeNode,Integer> map = new HashMap<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<List<Integer>> traversal = new ArrayList<>();
        
        if(root == null)
            return traversal;
        
        queue.add(root);
        int currentLevel = 0;
        map.put(root,0);
        
        ArrayList<Integer> level = new ArrayList<>();
        while(!queue.isEmpty())
        {
            TreeNode temp = queue.poll();
            int tempLevel = map.get(temp);
            if(tempLevel != currentLevel)
            {
                currentLevel = tempLevel;
                traversal.add(level);
                level = new ArrayList<>();
            }
            
            level.add(temp.val);
            
            if(temp.left != null)
            {
                map.put(temp.left, tempLevel + 1);
                queue.add(temp.left);
            }
            
            if(temp.right != null)
            {
                map.put(temp.right, tempLevel + 1);
                queue.add(temp.right);
            }
        }
        
        if(level.size() != 0)
            traversal.add(level);
        return traversal;
    }
}