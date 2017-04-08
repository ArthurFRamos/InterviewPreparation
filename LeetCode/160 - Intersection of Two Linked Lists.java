/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        
        int lenA = len(headA);
        int lenB = len(headB);
        int diff = Math.abs(lenA - lenB);
        
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        
        for(int i = 0; i < diff; i++)
        {
            if(lenA > lenB)
                pointerA = pointerA.next;
            else if(lenB > lenA)
                pointerB = pointerB.next;
        }
        
        while(pointerA != null)
        {
            if(pointerA.val == pointerB.val)
                return pointerA;
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }
        
        return null;
    }
    
    public int len(ListNode headA)
    {
        int len = 0;
        ListNode current = headA;
        while(current != null)
        {
            len++;
            current = current.next;
        }
        
        return len;
    }
}