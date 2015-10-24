public class Solution {
    public int reverse(int x) {
        if(x == 0) return 0;
        if(x == 1 <<31) return 0;
        Integer temp;
        StringBuffer reverse = new StringBuffer();
        if(x < 0)
            reverse.append("-");
        x = Math.abs(x);
        
        while(x!= 0)
        {
            temp = x %10;
            reverse.append(temp.toString());
            x /=10;
        }
        
        long helper = Long.parseLong(reverse.toString());
        if(helper > Integer.MAX_VALUE || helper < 1 <<31)
            return 0;
        else
            return (int)helper;
            
    }
}