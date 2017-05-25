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
        if(root == null)
            return;
        
        TreeLinkNode start = root;
        
        while(start != null)
        {
            TreeLinkNode cur = start;
            TreeLinkNode helper = null;
            start = null;
            
            while(cur != null)
            {
                if(cur.left != null)
                {
                    if(start == null)
                        start = cur.left;
                    if(helper == null)
                        helper = cur.left;
                    else
                    {
                        helper.next = cur.left;
                        helper = helper.next;
                    }
                }
                
                if(cur.right != null)
                {
                    if(start == null)   
                        start = cur.right;
                    if(helper == null)
                        helper = cur.right;
                    else
                    {
                        helper.next = cur.right;
                        helper = helper.next;
                    }
                }
                
                cur = cur.next;
            }
        }
    }
}