/**
 * TODO
 * @author ColinFischer
 * Date Last Modified: 8 March 2017
 */
public class TriangularTargets
{
	
	/**
	 * TODO
	 */
	class Coordinate
	{
		private double xVal, yVal;
		
		/**
		 * TODO
		 */
		public Coordinate(double x, double y)
		{
			xVal = x;
			yVal = y;
		}
		
		/**
		 * TODO
		 */
		public double getX()
		{
			return xVal;
		}
		
		/**
		 * TODO
		 */
		public double getY()
		{
			return yVal;
		}
	}
	
	private Coordinate[] coords;
	private double area;
	
	/**
	 * TODO
	 */
	public TriangularTargets(double d11, double d12, double d21,
								double d22, double d31, double d32)
	{
		coords = new Coordinate[]{new Coordinate(d11,d12),
									new Coordinate(d21,d22),
									new Coordinate(d31,d32)};
		area = calcArea(coords[0], coords[1], coords[2]);
	}
	
	/**
	 * TODO
	 */
	private double calcArea(Coordinate c1, Coordinate c2, Coordinate c3)
	{
		double sides[], area;
		sides = new double[]{calcLength(c1,c2), calcLength(c1,c3), calcLength(c2,c3)};
		double sP = (sides[0]+sides[1]+sides[2])/2.0;
		area = Math.sqrt(sP*(sP-sides[0])*(sP-sides[1])*(sP-sides[2]));
		return area;
	}
	
	/**
	 * TODO
	 */
	private double calcLength(Coordinate c1, Coordinate c2)
	{
		double lX = c1.getX()-c2.getX();
		double lY = c1.getY()-c2.getY();
		return Math.sqrt((lX*lX)+(lY*lY));
	}
	
	/**
	 * TODO
	 */
	public double getArea()
	{
		return area;
	}
	
	public boolean isInTarget(double d1, double d2)
	{
		Coordinate target = new Coordinate(d1, d2);
		double totalArea = calcArea(target, coords[0], coords[1])+
							calcArea(target, coords[0], coords[2])+
							calcArea(target, coords[1], coords[2]);
		return (Math.round(totalArea*100000)/100000.0)==
				(Math.round(area*100000)/100000.0);
	}
}