Comparison method violates its general contract!/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class Solution {

     public class IntervalComparator implements Comparator<Interval>
     {
         public int compare (Interval a, Interval b)
         {
             if(a.start < b.start)
                return -1;
             else if (a.start > b.start)
                return 1;
             
             return 0;
         }
     }
    public List<Interval> merge(List<Interval> intervals) {
        
        ArrayList<Interval> ans = new ArrayList<>();
        if(intervals.size() == 0)
            return ans;
            
        if(intervals.size() == 1)
            return intervals;
        Collections.sort(intervals, new IntervalComparator());
        
        int helper = 1;
        
        Interval current = intervals.get(0);
        
        while(helper < intervals.size())
        {
            Interval temp = intervals.get(helper);
            if(temp.start > current.end)
            {
                ans.add(current);
                current = temp;
            }
            else
            {
                if(temp.end > current.end)
                    current.end = temp.end;
            }
            
            helper++;
        }
        
        ans.add(current);
        
        return ans;
    }
}