/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
            
        ListNode firstPointer = head;
        ListNode secondPointer = head;
        
        for(int i = 0; i < n; i++)
            secondPointer = secondPointer.next;
        
        if(secondPointer == null)
            head = head.next;
        
        while(secondPointer != null && secondPointer.next != null)
        {
            secondPointer = secondPointer.next;
            firstPointer = firstPointer.next;
        }
        
        if(head == null)
            return null;
        
        firstPointer.next = firstPointer.next.next;
        
        return head;
    }
}