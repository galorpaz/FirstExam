
public class Traffic {
	public static boolean isTrafficJam(Point[] pointsArr1, Point[] pointsArr2) {
		int length = pointsArr1.length;
		double radius = 10; 
		boolean[] isSlow = new boolean[length];
		int slowDriversNum = countSlowDrivers(pointsArr1, pointsArr2, isSlow);		
		if (slowDriversNum >=3) {
			for (int i=0; i<length-3; i++) {
				if (isSlow[i] == true) {
					for (int j=i+1; j<length-2; j++) {
						if (isSlow[j] == true) {
							for (int k=j+1; k<length; k++) {
								if (pointsArr2[i].isInRadius(pointsArr2[j], radius)
										&& pointsArr2[i].isInRadius(pointsArr2[k], radius) 
										&& pointsArr2[j].isInRadius(pointsArr2[k], radius)) {
									return true;
								}
							}
						}
					}
				}
			}
		}
		
		return false;
		
	}
	
	public static int countSlowDrivers(Point[] pointsArr1, Point[] pointsArr2, boolean[] isSlow) {	
		int speed = 5;
		int count = 0;
		int length =  pointsArr1.length;	
		
		
		for (int i=0; i< length ; i++) {
			double distance = WazeUserUtils.calcDistance(pointsArr1[i], pointsArr2[i]);
			if (WazeUserUtils.calcSpeed(5, distance) < speed) {
				isSlow[i] = true;
				count++;
			}
		}
		return count;
	}

}
