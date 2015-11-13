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
    
    class TreeNodeLevel
    {
        public TreeNode node;
        public int level;
        
        public TreeNodeLevel(TreeNode node, int level)
        {
            this.node = node;
            this.level = level;
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null)
            return new ArrayList<>();
            
        Queue<TreeNodeLevel> queue = new LinkedList<TreeNodeLevel>();
        
        queue.add(new TreeNodeLevel(root,0));
        
        int currentLevel = 0;
        
        List<List<Integer>> list = new ArrayList<>();
        
        List<Integer> current = new ArrayList<Integer>();
        
        TreeNodeLevel node = queue.peek();
        
        while(!queue.isEmpty())
        {
            node = queue.poll();
            
            if(node.level != currentLevel)
            {
                currentLevel = node.level;
                list.add(current);
                current = new ArrayList<Integer>();
            }
            
            current.add(node.node.val);
            
            if(node.node.left != null)
                queue.add(new TreeNodeLevel(node.node.left,currentLevel + 1));
            if(node.node.right != null)
                queue.add(new TreeNodeLevel(node.node.right, currentLevel + 1));
        }
        
        list.add(current);
        
        return list;
    }
}