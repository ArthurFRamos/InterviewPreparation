public class RandomizedSet {
    public class ListNode
    {
        public ListNode next;
        public int val;
    
        public ListNode(int val)
        {
            this.val = val;
        }
    }
    
    public class LinkedListImp
    {
        public int size = 0;
        public ListNode root;
        public HashMap<Integer, ListNode> map;
        public ListNode last;
        
        public LinkedListImp()
        {
            map = new HashMap<>();
            root = null;
            last = null;
        }
        
        public void add (int val)
        {
            this.add(new ListNode(val));
        }
        private void add(ListNode node)
        {
            if(root == null)
            {
                root = node;
                last = node;
                map.put(node.val,null);
                return;
            }
            
            map.put(node.val,last);
            last.next = node;
            last = last.next;
        }
        
        public void remove(int val)
        {
            ListNode previous = map.get(val);
            map.remove(val);
            if(previous == null)
            {
                if(root == last)
                {
                    root = null;
                    last = null;
                    return;
                }
            
                root = root.next;
                map.put(root.val,null);
                return;
            }
            
            if(previous.next == last)
                last = previous;
            
            previous.next = previous.next.next;
            
            if(previous.next != null)
                map.put(previous.next.val, previous);
        }
        
        public boolean contains(int val)
        {
            return map.containsKey(val);
        }
        
        public int getRandom()
        {
            ArrayList<Integer> values = new ArrayList<>(map.keySet());
            Random r = new Random();
            int toGet = r.nextInt(values.size());
            
            ListNode previous = map.get(values.get(toGet));
            if(previous == null)
                return root.val;
            
            return previous.next.val;
        }
    }
    /** Initialize your data structure here. */

    private LinkedListImp list;
    public RandomizedSet() {
        list = new LinkedListImp();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(list.contains(val))
            return false;
        list.add(val);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!list.contains(val))
            return false;
        
        list.remove(val);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.getRandom();
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */