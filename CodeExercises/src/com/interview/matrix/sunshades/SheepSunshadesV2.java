package com.interview.matrix.sunshades;

public class SheepSunshadesV2 {

	//https://app.codility.com/programmers/task/sheep_and_sunshades/
	public static void main(String[] args) {
		int[] x = new int[] {0,0,10,10};
		int[] y = new int[] {0,10,0,10};
		System.out.println("Given X=[0, 0, 10, 10] and Y=[0, 10, 0, 10], max distance: " + solution(x, y));
		
		x = new int[] {1, 1, 8};
		y = new int[] {1, 6, 0};
		System.out.println("Given X=[1, 1, 8] and Y=[1, 6, 0], max distance: " + solution(x, y));
	}
	
	public static int solution(int[] x, int[] y) {
		
		int l = x.length;
		int maxDistance = -1;
		for(int i = 0; i < l; i++) {
			int posX = x[i];
			int posY = y[i];
			for(int j = i + 1; j <  l; j++) {
				int tmpX = x[j];
				int tmpY = y[j];
				
				if(posX == tmpX) { //same X [0, ?], [0,?]
					int distY = Math.abs(tmpY) - Math.abs(posY); //10 - 0, 0 - 0
					maxDistance = getMaxDistance(distY, maxDistance);
				}else if(posY == tmpY){ // same Y [?, 0], [?, 0]
					int distX = Math.abs(tmpX) - Math.abs(posX);
					maxDistance = getMaxDistance(distX, maxDistance);
				}
				
				if(maxDistance == 0) { //same position X and Y
					return 0;
				}
			}
		}
		
		return maxDistance;
	}
	
	public static int getMaxDistance(int dist, int maxDistance) {
		dist = dist > 0 && maxDistance != 0 ? (Math.abs(dist) / 2): 0;
		
		return maxDistance < 0 || maxDistance > dist ? dist : maxDistance;
	}
}
