public class LRUCache {
    
    public class ListNode
    {
        int pos;
        int value;
        ListNode next;
        
        public ListNode(int pos, int value)
        {
            this.pos = pos;
            this.value = value;
            next = null;
        }
    }
    
    private ListNode head;
    private HashMap<Integer,ListNode> map;
    private int size = 0;
    private int capacity;
    private ListNode last;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new ListNode(-1,-1);
        this.map = new HashMap<>();
        this.last = head;
    }
    
    public void printList()
    {
        ListNode current = head;
        
        while(current != null)
        {
            System.out.print(current.pos + " ");
            current = current.next;   
        }
        
        System.out.println("");
    }
    public int get(int key) {
        if(capacity == 0)
            return -1;
        
        if(!map.containsKey(key))
            return -1;
        if(capacity == 1)
            return last.value;
            
        ListNode previous = map.get(key);
        
        if(previous.next == last)
            return last.value;
        
        map.put(key,last);
        ListNode temp = previous.next;
        previous.next = previous.next.next;
        
        last.next = temp;
        last = last.next;
        last.next = null;
        map.put(previous.next.pos,previous);

        return last.value;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key))
        {
            ListNode temp = map.get(key);
            temp.next.value = value;
            get(key);
            return;
        }
            
        if(capacity == 0)
            return;
        if(size == capacity)
        {
            map.remove(head.next.pos);
            head.next = head.next.next;
    
            if(head.next != null)
                map.put(head.next.pos,head);
            else
                last = head;
            size--;
        }
        
        map.put(key,last);
        last.next = new ListNode(key,value);
        last = last.next;
        size++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */