public class MinStack {

    /** initialize your data structure here. */
    private int minimum;
    Stack<Integer> stack;
    Stack<Integer> min;
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
        minimum = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x <= minimum)
        {
            min.push(x);
            minimum = x;
        }
        
        stack.push(x);
    }
    
    public void pop() {
        if(stack.empty())
            return;
            
        int current = stack.pop();
        if(current == min.peek())
        {
            min.pop();
            if(min.empty())
                minimum = Integer.MAX_VALUE;
            else
                minimum = min.peek();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public Integer getMin() {
        if(min.empty())
            return null;
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */