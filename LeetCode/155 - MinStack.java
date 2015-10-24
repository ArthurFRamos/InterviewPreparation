class MinStack {
    private Stack<Integer> elements = null;
    private Stack<Integer> minStack = null;
    private int min = Integer.MAX_VALUE;
    
    public void push(int x) {
        if(elements == null)
            elements = new Stack<Integer>();
        if(minStack == null)
            minStack = new Stack<Integer>();
            
        if(x <= min )
        {
            min = x;
            minStack.push(x);
        }
        elements.push(x);
    }

    public void pop() {
        if(elements.isEmpty())
            return;
            
        int x = elements.pop();
        
        if(x == min)
        {
            minStack.pop();
            if(!minStack.isEmpty())
                min = minStack.peek();   
            else
                min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return elements.peek();
    }

    public int getMin() {
        
        return minStack.peek();
    }
}
