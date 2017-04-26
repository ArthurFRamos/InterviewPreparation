public class MedianFinder {

    /** initialize your data structure here. */
    
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    private void rebalance()
    {
        if(minHeap.size() - maxHeap.size() == 2)
        {
            int current = minHeap.poll();
            maxHeap.add(current);
        }
        else if(maxHeap.size() - minHeap.size() == 2)
        {
            int current = maxHeap.poll();
            minHeap.add(current);
        }
    }
    
    public void addNum(int num) {
        
        if(minHeap.size() == 0)
            minHeap.add(num);
        else if(num >= minHeap.peek())
            minHeap.add(num);
        else
            maxHeap.add(num);
            
        rebalance();
    }
    
    public double findMedian() {
        if(maxHeap.size() == 0)
        {
            if(minHeap.size() == 0)
                return 0;
            return minHeap.peek();
        }
        
        if((minHeap.size() + maxHeap.size())%2 == 0)
            return ((double)(minHeap.peek() + maxHeap.peek())/2);
        if(minHeap.size() > maxHeap.size())
            return minHeap.peek();
        
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */