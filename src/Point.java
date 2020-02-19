/**
 * Document: Administrator
 * Date: 2019-11-05
 * Author: Administrator
 */

/**
 * @author Administrator
 *
 */
public class Point implements MyComparable{
	
	private double x;
	private double y;
		
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public boolean isInRadius(Point otherPoint, double radius) {
		if (WazeUserUtils.calcDistance(this, otherPoint) <= radius) {
			return true;
		}
		return false;
	}
	
	static double calcDirection(Point first, Point second) {
		double dx = second.getX() - first.getX();
		double dy = second.getY() - second.getY();
		if (dy == 0) {
			return 0;
		}
		return dx/dy;
		
	}
	
	public boolean equals(Point other) {
		if (this.x == other.x && this.y == other.y) {
			return true;
			
		}
		return false;
	}
	
	public static boolean isEqualDirection(double m1, double m2, double epsilon) {
		if (Math.abs(m1-m2) < epsilon) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Object other) {
		// TODO Auto-generated method stub
		
		return 0;
	}
}
