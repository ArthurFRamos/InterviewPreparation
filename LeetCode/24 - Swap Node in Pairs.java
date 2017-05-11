/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        
        ListNode newHead = head.next;
        
        int len = length(head);
        
        ListNode last = null;
        
        if(len % 2 != 0)
        {
            ListNode current = head;
            while(current.next.next != null)
                current = current.next;
            last = current.next;
            current.next = null;
        }
        
        head = reverse(head);
        ListNode previous = last;
        ListNode current = head;
        
        while(current != null)
        {
            ListNode next = current.next.next;
            current.next.next = previous;
            previous = current;
            current = next;
        }
        
        return newHead;
    }
    
    private int length(ListNode head)
    {
        int len = 0;
        
        ListNode current = head;
        
        while(current != null)
        {
            len++;
            current = current.next;
        }
        
        return len;
    }
    
    private ListNode reverse(ListNode head)
    {
        ListNode previous = null;
        ListNode current = head;
        
        while(current != null)
        {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        return previous;
        
    }
}