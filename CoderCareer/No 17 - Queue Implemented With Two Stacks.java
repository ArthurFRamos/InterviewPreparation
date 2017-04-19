import java.util.LinkedList;
import java.util.Stack;

public class QueueWithStacks<T> {
	
	private Stack<T> addStack;
	private Stack<T> removeStack;
	
	public QueueWithStacks()
	{
		this.addStack = new Stack<>();
		this.removeStack = new Stack<>();
	}
	
	public void add(T element)
	{
		if(addStack.isEmpty() && !removeStack.isEmpty())
		{
			while(!removeStack.isEmpty())
			{
				T current = removeStack.pop();
				addStack.push(current);
			}
		}
		addStack.push(element);
	}
	
	private void buildRemoveStack()
	{
		while(!addStack.isEmpty())
		{
			T current = addStack.pop();
			removeStack.push(current);
		}
	}
	public T poll()
	{
		if(addStack.isEmpty() && removeStack.isEmpty())
			return null;
		
		if(!removeStack.isEmpty())
			return removeStack.pop();
		
		buildRemoveStack();
		
		return removeStack.pop();
	}
	
	public T peek()
	{
		if(addStack.isEmpty() && removeStack.isEmpty())
			return null;
		if(!removeStack.isEmpty())
			return removeStack.peek();
		
		buildRemoveStack();
		
		return removeStack.peek();
	}
	
	public static void main(String[] args)
	{
		QueueWithStacks<Integer> q = new QueueWithStacks<>();
		q.add(2);
		q.add(3);
		q.add(1);
		q.poll();
		q.poll();
		System.out.println(q.peek());
	}
}
