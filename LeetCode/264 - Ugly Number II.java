public class Solution {
    public int nthUglyNumber(int n) {
        if(n == 0)
            return 0;
            
        if(n == 1)
            return 1;
        int count = 1;
        
        LinkedList<Long> queue2 = new LinkedList<Long>();
        LinkedList<Long> queue3 = new LinkedList<Long>();
        LinkedList<Long> queue5 = new LinkedList<Long>();
        
        queue2.add(2l);
        queue3.add(3l);
        queue5.add(5l);
        
        long minimum = 0;
        
        while(count != n)
        {
            count++;
            
            minimum = Math.min(queue2.peek(),Math.min(queue3.peek(),queue5.peek()));
            
            if(minimum == queue2.peek())
            {
                queue2.add(minimum*2);
                queue3.add(minimum*3);
                queue2.poll();
            }
            else if(minimum == queue3.peek())
            {
                queue3.add(minimum*3);
                queue3.poll();
            }
            else
            {
                queue5.poll();
            }
            
            queue5.add(minimum*5);
        }
        
        return (int)minimum;
    }
}