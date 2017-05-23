/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode currentLevel = root;
        
        TreeLinkNode current;
        
        while(currentLevel != null)
        {
            current = currentLevel;
            
            while(current != null)
            {
                if(current.left != null)
                    current.left.next = current.right;
                if(current.right != null && current.next != null)
                    current.right.next = current.next.left;
                current = current.next;
            }
            
            currentLevel = currentLevel.left;
        }
    }
}