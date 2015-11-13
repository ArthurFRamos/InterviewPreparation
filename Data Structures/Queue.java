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

public class Queue<T> {

	private ListNode<T> first;
	private ListNode<T> last;
	private int size;
	
	public Queue()
	{
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	public void add(T val)
	{
		ListNode<T> current = new ListNode<T>(val);
		
		size++;
		
		if(first == null)
		{
			first = current;
			last = current;
			return;
		}
		
		last.next = current;
		last = last.next;
	}
		
	public T poll()
	{
		if(this.isEmpty())
			return null;
		
		size--;
		
		T value  = first.val;
		first = first.next;
		
		if(first == null)
			last = null;
		
		return value;
	}
	
	public T peek()
	{
		if(this.isEmpty())
			return null;
		
		return first.val;
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
