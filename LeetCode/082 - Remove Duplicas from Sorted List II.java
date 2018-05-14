/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    private boolean toRemove = false;
    
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
            
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        
        ListNode current = newHead;
        
        while(current != null)
        {
            ListNode temp = remove(current.next);
            if(toRemove)
                current.next = temp;
            else
                current = current.next;
        }
        
        return newHead.next;
    }
    
    private ListNode remove(ListNode current)
    {
        toRemove = false;
        
        while(current != null)
        {
            if(current.next == null)
                return null;
            
            if(current.next.val != current.val)
                return current.next;
            toRemove = true;
            current = current.next;
        }
        
        return null;
    }
}
