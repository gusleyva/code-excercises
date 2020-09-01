package com.exercises.manipulation.string.gcd;

public class GreatestCommonDeno {
	
	public String greatestCommonDenoStr(String str1, String str2) {
		if(!(str1 + str2).equals(str2 + str1))
			return "";
		
		int len = str1.length();
	    int len2 = str2.length();
	    
		int gdcVal = gdc(len, len2);
		if (len < len2) {
	        return str1.substring(0, gdcVal);
	    }
		return str2.substring(0, gdcVal);
	}
	
	public int gdc(int a, int b) {
		if(b == 0) {
			return a;
		}else {
			return gdc(b, a % b);
		}
		
	}
}
