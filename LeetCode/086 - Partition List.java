/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
    
        if(head == null)
            return null;
            
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        
        ListNode current = newHead;
        ListNode head2 = null;
        ListNode current2 = null;
        
        while(current.next != null)
        {
            if(current.next.val >= x)
            {
                if(head2 == null)
                {
                    head2 = new ListNode(current.next.val);
                    current2 = head2;
                }
                else
                {
                    current2.next = new ListNode(current.next.val);
                    current2 = current2.next;
                }
                current.next = current.next.next;
            }
            else
                current = current.next;
        }
        
        current.next = head2;
        head = newHead.next;
        
        return head;
    }
}