import java.util.concurrent.TimeUnit;

public class WazeUserTrip {
	
	private String name;
	private Point destination;
	private Point source;
	
	public WazeUserTrip(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Point getDestination() {
		return destination;
	}
	public void setDestination(Point destination) {
		this.destination = destination;
	}
	public Point getSource() {
		return source;
	}
	public void setSource(Point source) {
		this.source = source;
	}
	
	public void checkSpeedLimit(double speedLimt) {
		while (!GPS.getCurrentLocation().equals(this.destination)) {
			
			long tFirst = System.currentTimeMillis();
			Point first = GPS.getCurrentLocation();
			
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {		
				e.printStackTrace();
			}
			
			long tSecond = System.currentTimeMillis();
			Point second = GPS.getCurrentLocation();
			
			double tDiff = WazeUserUtils.convertMillisToSeconds(tSecond-tFirst);
			double distance = WazeUserUtils.calcDistance(first, second);
			
			if (WazeUserUtils.calcSpeed(tDiff, distance)  > speedLimt) {
				System.out.println("Over Speed Limit");
			}		
			System.out.println("Speed Is leagle");
		}
		System.out.println("destination reached");
	}
	
	public void findCarPoolers(WazeUserTrip [][] carpoolers, double myDir, Point curLocation) {
		WazeUserTrip carPooler;
	
		for (int i = 0; i < carpoolers.length; i++) {
			for (int j = 0; j < carpoolers[i].length; j++) {
				carPooler = carpoolers[i][j]; 
				if (carPooler != null) {
					double dirToCarPoller = Point.calcDirection(curLocation, carPooler.source);
					if (dirToCarPoller == myDir && carPooler.getDestination() == this.destination) {
						System.out.println("You have carpooler: "+ carPooler.name + "peek up location:"+ carPooler.getSource());
					}
				}
			}
		}
	}
	
	
	
	
}
