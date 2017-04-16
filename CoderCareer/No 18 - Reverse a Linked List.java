public class Solution {
    private ListNode newRoot;
	private ListNode current;
	
	public ListNode reverseList(ListNode root)
	{
	    if(root == null)
	        return null;
	        
		reverse(root);
		root.next = null;
		
		return newRoot;
	}
	
	private void reverse(ListNode node)
	{
		if(node == null)
			return;
		
		reverse(node.next);
		
		if(node.next == null)
		{
			newRoot = node;
			current = node;
		}
		else
		{
			current.next = node;
			current = current.next;
		}
	}
}
