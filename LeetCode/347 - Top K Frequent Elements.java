public class Solution {
    
    public class NumberFrequency implements Comparable<NumberFrequency>
    {
        public int number = 0;
        public int frequency = 0;
        
        public NumberFrequency(int n, int f)
        {
            number = n;
            frequency = f;
        }
        
        public int compareTo(NumberFrequency other)
        {
            if(frequency < other.frequency)
                return -1;
            if(frequency > other.frequency)
                return 1;
            
            return 0;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> frequency = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(!frequency.containsKey(nums[i]))
                frequency.put(nums[i],1);
            else
                frequency.put(nums[i], frequency.get(nums[i]) + 1);
        }
        
        PriorityQueue<NumberFrequency> heap = new PriorityQueue<>();
        
        Iterator<Integer> keys = frequency.keySet().iterator();
        
        while(keys.hasNext())
        {
            Integer current = keys.next();
            heap.add(new NumberFrequency(current,frequency.get(current)));
            if(heap.size() > k)
                heap.poll();
        }
        
        
        for(int i = 0; i < k; i++)
            ans.add(heap.poll().number);
        
        return ans;
    }
}