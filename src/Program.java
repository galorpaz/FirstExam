/**
 * @author Administrator
 *
 */
public class Program {

	/**
	 * @param args
	 */
	public static final int USER_NUMBER = 5;
	public static void main(String[] args) {
		
		testConvertMillisToSeconds();
		testCalsDistance();		
		testCalsSpeed();
		testIsInRadius();
		testCountSlowDrivers();
		testIsTraffic(false);
		testIsTraffic(true);
		testCheckSpeedLimit();
		

	}
	
	public static void testConvertMillisToSeconds () {
		long startTime = System.currentTimeMillis();		
		if (startTime/1000 == WazeUserUtils.convertMillisToSeconds(startTime))		
			System.out.println("test convertMillisToSeconds passed");
		System.out.println("test convertMillisToSeconds failed");
		
	}
	
	public static void testCalsDistance () {
		//case 1
		Point first = new Point(0, 2);
		Point second = new Point(0, 4);
		if (WazeUserUtils.calcDistance(first, second) == 2)
			System.out.println("test calcDistance passed");
		else
			System.out.println("test calcDistance failed");
		
		//case 2
		Point first2 = new Point(3, 0);
		Point second2 = new Point(6, 0);
		if (WazeUserUtils.calcDistance(first2, second2) == 3)		
			System.out.println("test calcDistance passed");
		else
			System.out.println("test calcDistance failed");

		//case 3
		Point first3 = new Point(1,1);
		Point second3 = new Point(0,0);
		if (Math.abs(WazeUserUtils.calcDistance(first3, second3) - Math.sqrt(2)) < 0.001)
			System.out.println("test calcDistance passed");
		else
			System.out.println("test calcDistance failed");
	}
	
	public static void testCalsSpeed () {
		WazeUserUtils.calcSpeed(0, 5);
		if (WazeUserUtils.calcSpeed(2, 8) == 4)
			System.out.println("test calcSpeed passed");
		else
			System.out.println("test calcDistance failed");
	}
	
	
	
	
	public static void testIsInRadius() {
		Point point = new Point(3.0, 3.0);
		Point otherPoint = new Point (4.0, 4.0);
		if (point.isInRadius(otherPoint, 1.5))
			System.out.println("test isInRadius passed");
		else
			System.out.println("test isInRadius failed");
		
	}
	
	public static void testCheckSpeedLimit() {
		WazeUserTrip t = new WazeUserTrip("Mika");
		t.setDestination(new Point(8,8));
		t.checkSpeedLimit(5);
	}
	
	public static void testCountSlowDrivers() {
		Point [] pointsArr1 = new Point [USER_NUMBER];
		Point [] pointsArr2 = new Point [USER_NUMBER];
		for (int i = 0; i < USER_NUMBER; i++) {
			pointsArr1[i] = new Point(1,1);
			pointsArr2[i] = new Point(2,2);
		}
		boolean[] isSlow = new boolean[USER_NUMBER];
		int count = Traffic.countSlowDrivers(pointsArr1, pointsArr2, isSlow);
		int isSlowCounter = 0;
		for (int i = 0; i < isSlow.length; i++) {
			if (isSlow[i] == true)
				isSlowCounter++;
		}
		if (count == isSlowCounter) {
			System.out.println("test CountSlowDrivers passes");
		} else
			System.out.println("test CountSlowDrivers failed");
		
	}
	
	public static void testIsTraffic(boolean isNegative) {
		Point [] pointsArr1 = new Point [USER_NUMBER];
		Point [] pointsArr2 = new Point [USER_NUMBER];
		int numberOfTrafficUsers = 3;;
		if (isNegative)
			numberOfTrafficUsers = 2;
		for (int i = 0; i < numberOfTrafficUsers; i++) {
			pointsArr1[i] = new Point(1,1);
			pointsArr2[i] = new Point(1,1);
		}
		
		for (int j = numberOfTrafficUsers; j < USER_NUMBER; j++) {
			pointsArr1[j] = new Point(1,1);
			pointsArr2[j] = new Point(30,30);
		}
		boolean trafficResult = Traffic.isTrafficJam(pointsArr1, pointsArr2);
		if (isNegative) {
			if (trafficResult)
				System.out.println("test IsTraffic failed");
			else
				System.out.println("test IsTraffic passes");	
		} else {
			if (trafficResult)
				System.out.println("test IsTraffic passes");
			else
				System.out.println("test IsTraffic failed");
		}
	}
	

}
