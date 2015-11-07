/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
    	if(lists.length == 0)
    		return null;
    	
    	PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>()
    			{
    				public int compare(ListNode n1, ListNode n2)
    				{
    					return n1.val - n2.val;
    				}
    			});
    	
    	for(int i = 0; i < lists.length; i++)
    	{
    		if(lists[i] != null)
	    		heap.add(lists[i]);
    	}
    	
    	ListNode newHead = null;
    	ListNode current = null;
    	
    	while(!heap.isEmpty())
    	{
    		ListNode temp = heap.poll();
    		
    		if(newHead == null)
    		{
    			newHead = new ListNode(temp.val);
    			current = newHead;
    		}
    		else
    		{
    			current.next = new ListNode(temp.val);
    			current = current.next;
    		}
    		
    		if(temp.next != null)
    			heap.add(temp.next);
    	}
    	
    	return newHead;
    }
}