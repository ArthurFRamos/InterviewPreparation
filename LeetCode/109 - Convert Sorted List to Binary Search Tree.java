/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        
        ListNode current = head;
        
        while(current != null)
        {
            list.add(current);
            current = current.next;
        }
        
        return convert(0,list.size() - 1, list);
    }
    
    public TreeNode convert(int start, int end, ArrayList<ListNode> list)
    {
         if(start > end)
            return null;
            
        int mid = (start + end)/2;
        
        TreeNode current = new TreeNode(list.get(mid).val);

        current.left =  convert(start, mid - 1, list);
        current.right = convert(mid + 1, end, list);
        
        return current;
    }
    
}