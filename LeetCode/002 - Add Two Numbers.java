/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode first = l1;
        ListNode second = l2;
        int carryOver = 0;
        ListNode head = new ListNode(0);
        ListNode current = head;
        
        while(first != null || second != null)
        {
            if(first == null)
                first = new ListNode(0);
            if(second == null)
                second = new ListNode(0);
                
            int sum = first.val + second.val + carryOver;
            
            carryOver = sum/10;

            current.next = new ListNode(sum%10);
            
            current = current.next;
            
            if(first.next == null && second.next == null && carryOver != 0)
                current.next = new ListNode(carryOver);
            
            first = first.next;
            
            second = second.next;
        }
        
        return head.next;
        
    }
}