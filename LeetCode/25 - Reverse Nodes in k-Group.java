/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = length(head);
        
        if(len < k)
            return head;
        
        ListNode remaining = null;
        ListNode newHead = null;
        ListNode temp = head;
        
        for(int i = 0; i < k - 1; i++)
            temp = temp.next;
        
        newHead = temp;
        
        if(len % k != 0)
        {
            ListNode current = head;
            for(int i = 0; i < len/k; i++)
            {
                for(int j = 0; j < k; j++)
                {
                    if((j == k - 1) && (i == len/k - 1))
                    {
                        remaining = current.next;
                        current.next = null;
                        break;
                    }
                    
                    current = current.next;
                }
            }
        }
        
        head = reverse(head);
        
        ListNode previous = remaining;
        ListNode current = head;
        
        while(current != null)
        {
            ListNode next = current;
            
            for(int i = 0; i < k; i++)
                next = next.next;
            
            ListNode helper = current;
            
            for(int i = 0; i < k - 1; i++)
                helper = helper.next;
            helper.next = previous;
            previous = current;
            current = next;
        }
        
        return newHead;
    }
    
    private int length(ListNode head)
    {
        int len = 0;
        
        ListNode current = head;
        
        while(current != null)
        {
            len++;
            current = current.next;
        }
        
        return len;
    }
    
    private ListNode reverse(ListNode head)
    {
        ListNode previous = null;
        ListNode current = head;
        
        while(current != null)
        {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        return previous;
    }
}