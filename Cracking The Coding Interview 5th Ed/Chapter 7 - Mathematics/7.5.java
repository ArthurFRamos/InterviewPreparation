public class Square {

	class Point{

		double x;
		double y;

		public Point(double x, double y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	class Line {

		public double slope;
		public Point basePoint;
		private final double EPS = 0.00001;

		public Line(Point p1, Point p2)
		{
			if(p1.x - p2.x == 0)
				slope = Integer.MAX_VALUE;
			else    
				slope = (double)((p2.y - p1.y))/((p2.x - p1.x));
			basePoint = p1;
		}		
	}
	
	public Point p1;
	public Point p2;
	public Point p3;
	public Point p4;
	public Point middle;
	
	public Square(Point p1, Point p2, Point p3, Point p4)
	{
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		
		middle = new Point((p1.x + p2.x + p3.x + p4.x)/4,(p1.y + p2.y + p3.y + p4.y)/4);
		
	}
	
	public Line connectMiddles(Square other)
	{
		return new Line(this.middle, other.middle);
	}
	
}