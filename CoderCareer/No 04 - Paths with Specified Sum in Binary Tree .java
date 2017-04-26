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
    
    private ArrayList<List<Integer>> paths = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return paths;
            
        LinkedList<Integer> path = new LinkedList<>();
        path.add(root.val);
        getPath(path,root,sum,root.val);
        
        return paths;
    }
    
    private void getPath(LinkedList<Integer> path, TreeNode node, int current, int sum)
    {
        if(node.left == null && node.right == null)
        {
           // System.out.println(sum);
            if(current == sum)
            {
                LinkedList<Integer> toAdd = new LinkedList<>();
                Iterator<Integer> it = path.iterator();
                
                while(it.hasNext())
                    toAdd.push(it.next());
                paths.add(toAdd);
            }
            return;
        }
        
        if(node.left != null)
        {
            path.push(node.left.val);
            getPath(path,node.left,current,sum + node.left.val);
            path.pop();
        }
        
        if(node.right != null)
        {
            path.push(node.right.val);
            getPath(path,node.right,current,sum + node.right.val);
            path.pop();
        }
    }
}