package com.byteconsulting.workshop.java.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class DataValidation {
  //trim a java string into proper format to form a number
	public static String trimStr(String s){
		return s.trim().replaceAll(",", "");
	}
	//validate a string to see if we can format it into a number
	public static boolean isNumber(String s) {
		if(s != null) {
			String alphaNumeric = "1234567890";
			String[] sAlpha = s.split("");
			for(int i=0; i< sAlpha.length; i++){
				if(alphaNumeric.indexOf(sAlpha[i].toUpperCase()) == -1){
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isValidBigDecimalValue(BigDecimal val1) {
		if(val1==null) return false;
		Double val = Double.valueOf(val1.doubleValue());
		if((new Double(val)).isInfinite() || val.isNaN()) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean isValidDateFormat1(String date) throws java.text.ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy"); // 08/01/2014
		Date testDate = null;
		try{
			testDate = sdf.parse(date);
		}catch (ParseException e){
			return false;
		}
		if(!sdf.format(testDate).equals(date)){
			return false;
		}
		return true;
	}
	
	public static boolean isValidDateFormat2(String date) throws java.text.ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");// 8/1/2014
		Date testDate = null;
		try{
			testDate = sdf.parse(date);
		}catch (ParseException e){
			return false;
		}
		if(!sdf.format(testDate).equals(date)){
			return false;
		}
		return true;
	}
}
