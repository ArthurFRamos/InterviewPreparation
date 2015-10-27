/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int min = 1;
        int max = n;
       int current = min;
       
       while(min <= max)
       {
           current = min +(max - min)/2;
           
           if(isBadVersion(current))
               max = current - 1;
            else
                min = current + 1;
       }
        return min;
    }
}