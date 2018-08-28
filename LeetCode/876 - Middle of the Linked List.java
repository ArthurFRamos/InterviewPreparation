/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null)
            return null;
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        
        while(fastPointer != null && fastPointer.next != null)
        {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        
        return slowPointer;
    }
}