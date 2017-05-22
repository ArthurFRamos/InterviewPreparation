public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = new int[][] {p1,p2,p3,p4};
        
        return permute(0,points);
    }
    
    private boolean permute(int index, int[][] points)
    {
        if(index == 4)
            return checkDistances(points) && checkVectors(points);
        
        for(int i = index; i < points.length; i++)
        {
            swap(i,index,points);
            if(permute(index + 1, points))
                return true;
            swap(i,index,points);
        }
        
        return false;
    }
    
    private double distance(int[] p1, int[] p2)
    {
        return (double)(Math.sqrt(Math.pow((p2[1] - p1[1]),2) + Math.pow((p2[0] -p1[0]),2)));
    }
    
    private boolean checkAngle(int[] v1, int[] v2)
    {
        return (v1[0]*v2[0] + v1[1]*v2[1] == 0);
    }
    
    private boolean checkDistances(int[][] points)
    {
        double current = distance(points[0],points[1]);
        if(equalEPS(current,0))
            return false;
    
        for(int i = 1; i <5; i++)
        {
            double temp = distance(points[i%4], points[(i+1)%4]);
            System.out.println(temp);
            if(!equalEPS(current,temp))
                return false;
        }
        
        return true;
    }
    
    private boolean checkVectors(int[][] points)
    {
        int[] past = new int[]{(points[1][0] - points[0][0]), (points[1][1] - points[0][1])};
        
        for(int i = 1; i < 5; i++)
        {
            int[] current = new int[] {(points[(i+1) % 4][0] - points[i%4][0]), (points[(i+1) % 4][1] - points[i%4][1])};
            if(!checkAngle(current,past))
                return false;
            past = current;
        }
        
        return true;
    }
    
    private boolean equalEPS(double a, double b)
    {
        return Math.abs(a - b) < 0.00000001;
    }
    
    private void swap(int i,int j, int[][] points)
    {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
    
}