public class Solution {
    
    public class PointComparator implements Comparator<int[]>
    {
        public int compare(int[] a, int [] b)
        {
            int compare = Integer.compare(a[0], b[0]);
            
            if(compare != 0)
                return compare;
            
            return Integer.compare(b[1],a[1]);
        }
    }
    public int findMinArrowShots(int[][] points) {
        
        int arrows = 0;
        
        if(points.length == 0)
            return 0;
            
        Arrays.sort(points, new PointComparator());
        
        int index = 0;
        int begin = 0;
        int end = 0;
        
        while(index < points.length)
        {
            int tempIndex = index;
            begin = points[index][0];
            end = points[index][1];
            
            for(int i = index + 1; i < points.length; i++)
            {
                int temp = points[i][0];
                if(temp >= begin && temp <= end)
                {
                    end = Math.min(end, points[i][1]);
                    tempIndex = i;   
                }
            }
            
            arrows++;
            index = tempIndex + 1;
        }
        
        return arrows;
    }
}