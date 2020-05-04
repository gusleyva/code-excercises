package com.exercises.trees.maxearn;

public class Knapsack {

	public static void main(String[] args) {
		Items i1 = new Items(2, 6);
		Items i2 = new Items(2, 10);
		Items i3 = new Items(3, 12);
		
		Items[] arrItems = new Items[3];
		arrItems[0] = i1;
		arrItems[1] = i2;
		arrItems[2] = i3;
		
		System.out.println("max earn: " + solution(arrItems, 5));
		
	}
	
	/**
	 *  n * n
	 * @param arrItems
	 * @param maxW
	 * @return
	 */
	public static int solution(Items[] arrItems, int maxW) {
		int currentW = 0;
		int currentProfit = 0;
		
		while(currentW <= maxW) {
			int tmpMaxProfit = 0;
			int tmpCurrentW = currentW;
			for(int i = 0; i < arrItems.length; i++) {
				Items item = arrItems[i];
				int tmpW = item.weight + currentW;
				int tmpV = item.value;
				
				if(tmpW <= maxW && tmpV > tmpMaxProfit) {
					tmpCurrentW = tmpW;
					tmpMaxProfit = tmpV;
					//System.out.printf("tmpMaxProfit: [%d], tmpCurrentW: [%d] \n", tmpMaxProfit, tmpCurrentW);
				}
			}
			
			//System.out.printf("BEFORE: currentProfit: [%d], currentW: [%d] \n", currentProfit, currentW);
			currentProfit += tmpMaxProfit;
			currentW += tmpCurrentW;
			//System.out.printf("AFTER: currentProfit: [%d], currentW: [%d] \n", currentProfit, currentW);
		}
		
		return currentProfit;
	}
	
	
	public static int knapsack(Items[] arrItems, int maxW) {
		return knapsack(arrItems, maxW, 0);
	}
	
	public static int knapsack(Items[] arrItems, int maxW, int i) {
		if(i == arrItems.length) return 0;
		
		if(maxW - arrItems[i].weight < 0)
			return knapsack(arrItems, maxW, i++);
		
	
		//Find the max including and not including current item
		return Math.max(knapsack(arrItems, maxW - arrItems[i].weight, i++) + arrItems[i].value,
				knapsack(arrItems, maxW, i++));
	}
}

class Items{
	int weight;
	int value;
	Items(int weight, int value){
		this.weight = weight;
		this.value = value;
	}
}
