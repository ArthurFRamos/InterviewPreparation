class MyStack {
 // Push element x onto stack.
    private Queue<Integer> first;
    private Queue<Integer> second;
    
    public void push(int x) {
        if(first == null && second == null)
        {
            first = new LinkedList<Integer>();
            second = new LinkedList<Integer>();
        }
        
        if(first.isEmpty())
           copyHelper();
        
        
        first.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        top();
        second.poll();
        
    }
    
    private void popHelper()
    {
        if(first.isEmpty())
            return;
        
        int temp = first.peek();
        first.poll();
        popHelper();
        
        second.add(temp);
        
    }
    
    private void copyHelper()
    {
    	if(second.isEmpty())
    		return;
    	int temp = second.peek();
    	second.poll();
    	copyHelper();
    	first.add(temp);
    }

    // Get the top element.
    public int top() {
        if(second.isEmpty())
            popHelper();
        
        return second.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(first == null && second == null)
        {
            first = new LinkedList<Integer>();
            second = new LinkedList<Integer>();
        }
        
        return first.isEmpty() && second.isEmpty();
    }
}