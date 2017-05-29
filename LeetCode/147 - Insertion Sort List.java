/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        
        if(head == null)
            return null;
            
        ListNode newHead = new ListNode(head.val);
        
        ListNode current = head.next;
        
        while(current != null)
        {
            newHead = add(newHead, current);
            current = current.next;
        }
        
        return newHead;
    }
    
    private ListNode add(ListNode head, ListNode toAdd)
    {
        
       // System.out.println(toAdd.val);

        ListNode current = head;
        ListNode previous = null;
        toAdd = new ListNode(toAdd.val);
        
        while(current != null && current.val < toAdd.val)
        {
            previous = current;
            current = current.next;
        }
        
        if(previous == null)
        {
            toAdd.next = head;
            head = toAdd;
            return head;
        }
        
        previous.next = toAdd;
        toAdd.next = current;
        
        return head;
    }
}