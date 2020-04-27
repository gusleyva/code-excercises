package com.exercises.matrix.sunshades;

public class SheepSunshades {

	public static void main(String[] args) {
		
	}
	
	/**
	 * At least 2 sheeps
	 * Not same coordenates
	 * @param x
	 * @param y
	 * @return
	 */
	public static int solution(int[] x, int[] y) {
		//return maximum value of D (Distance)
		int l = x.length;
		int maxD = -1;
		int currentX = x[0];
		int currentY = y[0];
		for(int i = 1; i < l; i++) {
			int maxX = 0;
			int maxY = 0;
			int tmpX = x[i];
			int tmpY = y[i];
			
			int distanceX = Math.abs(tmpX) - Math.abs(currentX);
			int distanceY = Math.abs(tmpY) - Math.abs(currentY);
			
			maxX = getMaxValue(distanceX);
			maxY = getMaxValue(distanceY);
			
			
			if(maxX > 0 && maxY > 0) {
				
			}
		}
		
		
		return 0;
	}
	
	public static int getMaxValue(int distance) {
		int max = 0;
		if(distance != 0) {
			int finalXD = Math.abs(distance) / 2;
			max = max > finalXD ? finalXD : max;
		}
		return max;
	}
}
