/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return null;
        
        boolean stopOdd = false;
        boolean stopEven = false;
        
        ListNode pointerOdd = head;
        
        ListNode pointerEven = head.next;
        
        ListNode headEven = head.next;
        
        if(pointerEven == null)
            return head;
        
        while(!stopOdd || !stopEven)
        {
            if(!stopOdd)
            {
                if(pointerOdd.next == null || pointerOdd.next.next == null)
                    stopOdd = true;
                
                else
                {
                    pointerOdd.next = pointerOdd.next.next;
                    pointerOdd = pointerOdd.next;   
                }
            }
            
            if(!stopEven)
            {
                if(pointerEven.next == null || pointerEven.next.next == null)
                {
                    stopEven = true;
                    if(pointerEven.next != null)
                        pointerEven.next = null;
                }
                else
                {
                    pointerEven.next = pointerEven.next.next;
                    pointerEven = pointerEven.next;   
                }
            }
        }
        
        pointerOdd.next = headEven;
        
        return head;
    }
}