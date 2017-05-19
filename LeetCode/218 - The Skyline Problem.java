public class Solution
{
    
    public class PointComparator implements Comparator<int[]>
    {
        public int compare (int[] a, int[] b)
        {
            if(a[0] < b[0])
                return -1;
            else if (a[0] > b[0])
                return 1;
            else
            {
                if(a[1] < b[1])
                    return -1;
                else if (a[1] > b[1])
                    return 1;
                else
                    return 0;
            }
        }
    }
    
	public List<int[]> getSkyline(int[][] buildings) {
        ArrayList<int[]> points = new ArrayList<>();
        ArrayList<int[]> pair = new ArrayList<>();
        
        for(int i = 0; i < buildings.length; i++)
        {
            pair.add(new int[] {buildings[i][0], -buildings[i][2]});
            pair.add(new int[] {buildings[i][1], buildings[i][2]});
        }
        
        Collections.sort(pair, new PointComparator());
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        int previous = 0;
        heap.add(0);
        
        for(int i = 0; i < pair.size(); i++)
        {
            int[] temp = pair.get(i);
            
            if(temp[1] < 0)
                heap.add(-temp[1]);
            else
                heap.remove(temp[1]);
            
            int current = heap.peek();
            
            if(current == previous)
                continue;
                
            previous = current;
            points.add(new int[] {temp[0], current});
        }
        
        return points;
    }
}