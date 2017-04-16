
public class Solution {

	public class ListNode
	{
		public ListNode next;
		public int val;

		public ListNode(int val)
		{
			this.val = val;
			this.next = null;
		}
	}

	 

	public ListNode kthFromEnd (ListNode root, int k)
	{
		if(root == null)
			return null;

		ListNode helper = root;

		for(int i = 0; i < k; i++)
			helper = helper.next;

		ListNode current = root;

		while(helper != null)
		{
			current = current.next;
			helper = helper.next;
		}

		return current;
	}
}
