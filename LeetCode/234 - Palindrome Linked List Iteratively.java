/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        if(head.next == null)
            return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode newHead = reverseList(slow.next);
        
        while(newHead != null)
        {
            if(head.val != newHead.val)
                return false;
            head = head.next;
            newHead = newHead.next;
        }
        
        return true;
        
        
    }
    
    private ListNode reverseList(ListNode head)
    {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;
        
        while(current != null)
        {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        return previous;
    }
}