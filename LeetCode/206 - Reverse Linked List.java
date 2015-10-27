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
        if(head == null) return null;
       return reverse(head,null);
    
    }
    
     public ListNode reverse (ListNode current, ListNode previous)
    {
    	ListNode head;
        if(current.next == null)
        {
            current.next = previous;
            return current;
        }
        
        else
            head = reverse(current.next, current);
        current.next = previous;
        
        return head;
    }
    
}