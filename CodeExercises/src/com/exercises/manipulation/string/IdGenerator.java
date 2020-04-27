package com.exercises.manipulation.string;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class IdGenerator {

	public static void main(String[] args) {
		System.out.printf("id: [%s]", getTransactionId());
	}
	
	protected static String getTransactionId() {
		StringBuilder transactionId = new StringBuilder();
		
		String currentDate = String.valueOf(new Date().getTime());
		System.out.printf("currentDate: [%s] \n", currentDate);
		transactionId.append(currentDate.substring(currentDate.length() - 8));
		
		String uuid = UUID.randomUUID().toString();
		String[] arrayUuId = uuid.split("-");
		for(String sectionUuId: arrayUuId) {
			transactionId.append("-").append(sectionUuId);
		}
		return transactionId.toString();
	}
}
