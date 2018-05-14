/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
            
        return merge(0,lists.length - 1, lists);
    }
    
    public ListNode merge(int a, int b, ListNode[] lists)
    {
        if(a == b)
            return lists[a];
        int mid = (a + b)/2;
        
        ListNode left = merge(a, mid, lists);
        ListNode right = merge(mid + 1, b, lists);
        
        return mergeLists(left,right);
    }
    private ListNode mergeLists(ListNode a, ListNode b)
    {
        ListNode newHead = new ListNode(-1);
        ListNode current = newHead;
        
        while(a != null || b != null)
        {
            if(a == null)
            {
                current.next = b;
                b = b.next;   
            }
            
            else if(b == null)
            {
                current.next = a;
                a = a.next;
            }
            
            else if(a.val <=  b.val)
            {
                current.next = a;
                a = a.next;
            }
            else
            {
                current.next = b;
                b = b.next;
            }
            
            current = current.next;
        }
        
        return newHead.next;
    }
}
