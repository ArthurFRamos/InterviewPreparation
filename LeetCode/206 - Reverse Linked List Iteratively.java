/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
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