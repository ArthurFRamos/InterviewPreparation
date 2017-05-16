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
    
    public class Pair{
     
     int min;
     int max;
    
        public Pair(int min, int max)
        {
            this.min = min;
            this.max = max;
        }
    }    
    
    private HashMap<TreeNode, Pair> map = new HashMap<>();
    private int largest = Integer.MIN_VALUE;
    
    public int largestBSTSubtree(TreeNode root) {
        if(root == null)
            return 0;
         getSize(root);
         
         return largest;
    }
    
    private int getSize(TreeNode node)
    {
        if(node.left == null && node.right == null)
        {
            map.put(node, new Pair(node.val,node.val));
            if(1 > largest)
                largest = 1;
            return 1;
        }
        
        int left = 0;
        int right = 0;
        int min = node.val;
        int max = node.val;
        
        if(node.left != null)
        {
            left = getSize(node.left);
    
            Pair temp = map.get(node.left);

            if(temp.max >= node.val)
            {
                left = 0;
                right = 0;
                min = Integer.MIN_VALUE;
                max = Integer.MAX_VALUE;   
            }
            else
                min = temp.min;
        }
        
        if(node.right != null)
        {
            right = getSize(node.right);
            Pair temp = map.get(node.right);
            
            if(temp.min <= node.val || min == Integer.MIN_VALUE)
            {
                left = 0;
                right = 0;
                min = Integer.MIN_VALUE;
                max = Integer.MAX_VALUE;
            }
            else
                max = temp.max;
        }
        
        map.put(node, new Pair(min,max));

        if(left == 0 && right == 0)
            return 0;
            
        if(1 + left + right > largest)
            largest = 1 + left + right;
        
        return 1 + left + right;
    }
    
}