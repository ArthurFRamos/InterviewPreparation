class MyQueue {
    
    private Stack<Integer> first;
    private Stack<Integer> second;
    
    // Push element x to the back of queue.
    public void push(int x) {
      if(first == null && second == null)
      {
          first = new Stack<Integer>();
          second = new Stack<Integer>();
      }
      
      if(first.isEmpty())
      {
          while(!second.isEmpty())
          {
              first.push(second.peek());
              second.pop();
          }
      }
      
      first.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        
      this.peek();
      second.pop();
        
    }

    // Get the front element.
    public int peek() {
      if(first == null && second == null)
      {
          first = new Stack<Integer>();
          second = new Stack<Integer>();
      }
      
        if(second.isEmpty())
        {
          while(!first.isEmpty())
          {
              second.push(first.peek());
              first.pop();
          } 
        }
        
        return second.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(first == null && second == null)
            return true;
        
        return (first.isEmpty() && second.isEmpty());
    }
}