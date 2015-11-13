/*class ListNode<T>
{
	public T val;
	public ListNode<T> next;
	
	public ListNode(T val)
	{
		this.val = val;
		this.next = null;
	}
}*/

public class Stack<T> {

	private ListNode<T> top;
	private int size;
	
	public Stack()
	{
		this.size = 0;
		this.top = null;
	}
	
	public void push(T val)
	{
		size++;
		ListNode<T> current = new ListNode<T>(val);
		
		if(top == null)
		{
			top = current;
			return;
		}
		
		current.next = top;
		top = current;
	}
	
	public T pop()
	{
		if(this.isEmpty())
			return null;
		
		T value = top.val;
		top = top.next;
		
		size--;
		return value;
	}
	
	public T peek()
	{
		if(this.isEmpty())
			return null;
		
		return top.val;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public int size()
	{
		return this.size;
	}
}
