import java.util.Random;

/**
 * @author Administrator
 *
 */
public class GPS {
	
	public static Point getCurrentLocation() {
		Random r = new Random();
		double rangeMin = 20;
		double rangeMax = 50;
		double xRandomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
		double yRandomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
		Point p = new Point(xRandomValue, yRandomValue);
		return p;		
	}
}
