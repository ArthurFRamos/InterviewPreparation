/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int size = 1;
        
        if(head == null)
            return null;
            
        ListNode current = head;
        
        //Count size of the list and puts current pointer at the end
        while(current.next != null)
        {   
            size++;
            current = current.next;
        }
        
        //To deal with the case k >= size
        k %= size;
        
        //Puts the head of the list next to the tail. The idea is to use this to find the new head
        current.next = head;
        
        //We need to iterate size - k times to find the new head.
        for(int i = 0; i < size - k; i++)
            current = current.next;
        
        //Sets the new head
        head = current.next;
        
        //Current is the tail of our new list. Thus, this sets the null as the next node
        current.next = null;
        
        return head;
    }
}