class ListNode<T>
{
	public T val;
	public ListNode<T> next;
	
	public ListNode(T val)
	{
		this.val = val;
		this.next = null;
	}
}

public class LinkedList<T> {

	ListNode<T> head;
	
	public LinkedList()
	{
		head = null;
	}
	
	public void add(T val)
	{
		if(head == null)
		{
			head = new ListNode<T>(val);
			return;
		}
		
		ListNode<T> current = head;
		
		while(current.next != null)
			current = current.next;
		
		current.next = new ListNode<T>(val);
	}
	
	public void remove(T val)
	{
		if(head.val.equals(val))
		{
			head = null;
			return;
		}
		
		ListNode<T> current = head;
				
		while(!current.next.val.equals(val))
			current = current.next;
		
		current.next = current.next.next;
	}	
}