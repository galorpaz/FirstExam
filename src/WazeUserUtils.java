
public class WazeUserUtils {
	
	public static double convertMillisToSeconds(long millis) {		
		return millis/1000;				
	}
	
	public static double calcDistance(Point first, Point second) {
		double xDiff = first.getX() - second.getX();
		double yDiff = first.getY() - second.getY();
		double distance = Math.sqrt( Math.pow(xDiff, 2) + Math.pow(yDiff, 2) );
		return distance;
	}	

	
	public static double calcSpeed(double time, double distance) {
		return distance/time;
	}
}
