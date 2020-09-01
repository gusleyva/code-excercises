package com.exercises.binary;

import java.math.BigInteger;

public class BinaryAppend {
	
	public long FindBigNum(long n) {
		System.out.println("");
		System.out.println("Input: " + n);
	    StringBuilder binaryRepresentation = new StringBuilder();
	    for(Long i = 1l; i <= n; i++){
	    	System.out.println("Binary representation of " + i + " : " + Long.toBinaryString(i));
	        binaryRepresentation.append(Long.toBinaryString(i));
	    }
	    System.out.println("Concatenated string: " + binaryRepresentation.toString());
	    //System.out.println("Binary representation: " + binaryRepresentation.toString());
	    long longRepresentation = parseLong(binaryRepresentation.toString(), 2);
	    //System.out.println("longRepresentation: " + l);
	    return longRepresentation;   
	}
	
	public long parseLong(String s, int base){
	    return new BigInteger(s, base).longValue();
	}        
}
