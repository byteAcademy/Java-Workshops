package com.byteconsulting.workshop.java.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DataConverter {
  //convert percentage format to number
	public static BigDecimal percentageToNum(BigDecimal num){
		return num.divide(new BigDecimal("100"), 6, RoundingMode.HALF_UP);
	}
	//convert number format into percentage
	public static BigDecimal numToPercentage(BigDecimal num){
		return num.multiply(new BigDecimal("100"));
	}
}
