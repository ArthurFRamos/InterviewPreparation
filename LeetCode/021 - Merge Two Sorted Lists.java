/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode current = null;
	        ListNode temp = null;
	        ListNode first = null;

	        while(l1 != null || l2 != null)
	        {

	                if(l1 != null && ((l2 == null) || (l1.val < l2.val)))
	                {
	                    temp = new ListNode(l1.val); 
	                    l1 = l1.next;   
	                }
	         

	                else if(l2 != null &&((l1 == null) || (l2.val <= l1.val)))
	            {
		                   
	        	   temp = new ListNode(l2.val);
		                    
	        	   l2 = l2.next;
	            }  
	           
	            if(current == null)
	            {
	                current = temp;
	                first = current;
	            }
	            else
	            {
	                current.next = temp;
	                current = current.next;
	            }
	        }
	        
	        return first;
	    }
}