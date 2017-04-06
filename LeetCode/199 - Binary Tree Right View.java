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
    
     public class NodeLevel
     {
         TreeNode node;
         int level;
         NodeLevel(TreeNode node, int level)
         {
             this.node = node;
             this.level = level;
         }
     }
    
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        
        if(root == null)
            return values;
            
        LinkedList<NodeLevel> queue = new LinkedList<>();
        NodeLevel rootL = new NodeLevel(root,1);
        queue.add(rootL);
        
        while(!queue.isEmpty())
        {
            NodeLevel current = queue.poll();
            if(current.node.left != null)
                queue.add(new NodeLevel(current.node.left, current.level + 1));
            if(current.node.right != null)
                queue.add(new NodeLevel(current.node.right, current.level + 1));
            if(queue.peekFirst() == null || queue.peekFirst().level != current.level)
                values.add(current.node.val);
            
        }
        
        return values;
    }
}