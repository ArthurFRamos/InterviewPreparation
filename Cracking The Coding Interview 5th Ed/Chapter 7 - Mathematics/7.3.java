public class Line {

	class Point
	{
		double x;
		double y;
	}
		
	public double slope;
	public Point basePoint;
	private final double EPS = 0.000001;
	
	public Line(Point first, Point second)
	{
		this.slope = (first.x - second.x )/ (first.y - second.y);
		this.basePoint = first;
	}
	
	public boolean checkPoint(Point point)
	{
		double diff = Math.abs((point.y - basePoint.y) - slope*(point.x - basePoint.x));  
		if(diff < EPS)
			return true;
		return false;
	}
	
	public boolean checkIntersection (Line other)
	{
		double diff = this.slope - other.slope;
		diff = Math.abs(diff);
		
		if(diff > EPS)
			return true;
		else
			return checkPoint(other.basePoint);
	}	
}
