public class Solution {
    
	class Point {
		   int x;
		      int y;
		      Point() { x = 0; y = 0; }
		      Point(int a, int b) { x = a; y = b; }
		  }
	
    class Line
    {
        public double slope;
        public Point basePoint;
        double EPS = 0.00001;
        
        public Line(Point p1, Point p2)
        {
            if(p1.x - p2.x == 0)
                slope = Integer.MAX_VALUE;
            else    
                slope = (double)((p2.y - p1.y))/((p2.x - p1.x));
            basePoint = p1;
        }
        
        public boolean pointOnLine(Point p)
        {
        	if(slope == Integer.MAX_VALUE)
        		return p.x == basePoint.x;
            return Math.abs((p.y - basePoint.y) - slope*(p.x - basePoint.x)) < EPS;
        }
        
    }
    
		public int maxPoints(Point[] points) {
			
			int maxPoints = 0;
			int currentNumber;
			Point currentPoint = null;
			if(points.length == 1)
				return 1;
			
			for(int i = 0; i < points.length; i++)
			{
				currentPoint = points[i];
				for(int j = i + 1; j < points.length; j++)
				{
					currentNumber = 0;
					Line currentLine = new Line(currentPoint,points[j]);
					
					for(int z = 0; z < points.length; z++)
					{
						if(currentLine.pointOnLine(points[z]))
							currentNumber++;
					}
					
					if(currentNumber > maxPoints)
						maxPoints = currentNumber;
				}
			}
			
			return maxPoints;
		}
	}