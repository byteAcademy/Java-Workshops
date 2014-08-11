package com.byteconsulting.workshop.java.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BondUtil {
	//Number of days between two dates
	public static int dayCount(java.util.Date date1, java.util.Date date2){
		int noOfDays = 0;
		if(!date1.after(date2)){
			noOfDays = (int)((date2.getTime()-date1.getTime()) / (1000 * 60 * 60 * 24));
		}else{
			noOfDays = (int)((date1.getTime()-date2.getTime()) / (1000 * 60 * 60 * 24));
		}
		return noOfDays;
	}
	
	//Number of years between two dates
	public static int NumOfYears(java.util.Date date1, java.util.Date date2){
		int numOfYears = dayCount(date1, date2)/365;
		return numOfYears;
	}
	
	//Parse a String into a java.util.Date object
	public static java.util.Date StringToDate(String dateStr){
		Calendar cal1 = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			java.util.Date date = sdf.parse(dateStr);
			cal1.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal1.getTime();
	}
	
	//Calculate yield to maturity
	public static BigDecimal YieldToMaturity(java.util.Date settlementDate, java.util.Date maturityDate, BigDecimal bondPrice, BigDecimal rate, BigDecimal bondPar, BigDecimal redemption, Integer frequency){
		/**
		 * Approx Yield To Maturity formula
		 * (Coupon + (Face Value - Price)/Years to maturity)/((Face Value + Price)/2)
		 */
		BigDecimal apprYield = (redemption.multiply(new BigDecimal(frequency)).add((bondPar.subtract(bondPrice).divide(new BigDecimal(NumOfYears(settlementDate, maturityDate)), 8 , RoundingMode.HALF_UP)))).divide((bondPar.add(bondPrice)).divide(new BigDecimal("2"), 8, RoundingMode.HALF_UP), 8, RoundingMode.HALF_UP);
		
		/**
		 * Start refine iterations here
		 */
		int noOfYears = NumOfYears(settlementDate, maturityDate);
		int innerCount = frequency*noOfYears;
		String sign = ">";
		BigDecimal num = new BigDecimal("0.00001000");
		boolean change = false;
		
		/**
		 * According to Bond Price formula below:
		 * 
		 * Bond Price = Coupon/(1+yield)^1 + Coupon/(1+yield)^2 + ... + Coupon/(1+yield)^N + Bond Par/(1+yield)^N
		 * We use the approx yield to calculate the bond price and then compare to the real bond price.
		 * According to the result, we adjust the approx yield to make the calculated price closer to the real bond price.
		 * 
		 * We'll do 100 iterations to find the more accurate YTM here:
		 */
		
		for(int i=0;i<100;i++){
			BigDecimal presentPrice = new BigDecimal("0");
			for(int j=0;j<innerCount;j++){
				presentPrice = presentPrice.add(redemption.divide((new BigDecimal("1").add(apprYield.divide(new BigDecimal("2"), 8, RoundingMode.HALF_UP))).pow(j+1), 8, RoundingMode.HALF_UP));
			}
			presentPrice = presentPrice.add(bondPar.divide((new BigDecimal("1").add(apprYield.divide(new BigDecimal("2"), 8, RoundingMode.HALF_UP))).pow(innerCount), 8, RoundingMode.HALF_UP));
			if(i==0){
				if(presentPrice.compareTo(bondPrice)>0){
					apprYield = apprYield.add(num);
				}else if(presentPrice.compareTo(bondPrice)<0){
					num = num.multiply(new BigDecimal("-1"));
					apprYield = apprYield.add(num);
					sign = "<";
				}else{
					break;
				}
			}else if(i==1){
				if(presentPrice.compareTo(bondPrice)>0){
					if(sign.equals(">")){
						apprYield = apprYield.add(num);
					}else{
						num = num.divide(new BigDecimal("10"), 8, RoundingMode.HALF_UP);
						num = num.multiply(new BigDecimal("-1"));
						apprYield = apprYield.add(num);
						sign = ">";
						change = true;
					}
				}else if(presentPrice.compareTo(bondPrice)<0){
					if(sign.equals(">")){
						num = num.divide(new BigDecimal("10"), 8, RoundingMode.HALF_UP);
						num = num.multiply(new BigDecimal("-1"));
						apprYield = apprYield.add(num);
						sign = "<";
						change = true;
					}else{
						apprYield = apprYield.add(num);
					}
				}else{
					break;
				}
			}else{
				if(presentPrice.compareTo(bondPrice)>0){
					if(sign.equals(">")){
						if(change){
							if(num.compareTo(new BigDecimal("0"))>0){
								num = new BigDecimal("0.00000001");
							}else{
								num = new BigDecimal("0.00000001").multiply(new BigDecimal("-1"));
							}
							apprYield = apprYield.add(num);
						}else{
							apprYield = apprYield.add(num);
						}
					}else{
						if(num.compareTo(new BigDecimal("0"))>0){
							num = new BigDecimal("0.00000001");
						}else{
							num = new BigDecimal("0.00000001").multiply(new BigDecimal("-1"));
						}
						num = num.multiply(new BigDecimal("-1"));
						apprYield = apprYield.add(num);
						sign = ">";
						change = true;
					}
				}else if(presentPrice.compareTo(bondPrice)<0){
					if(sign.equals(">")){
						if(num.compareTo(new BigDecimal("0"))>0){
							num = new BigDecimal("0.00000001");
						}else{
							num = new BigDecimal("0.00000001").multiply(new BigDecimal("-1"));
						}
						num = num.multiply(new BigDecimal("-1"));
						apprYield = apprYield.add(num);
						sign = "<";
						change = true;
					}else{
						if(change){
							if(num.compareTo(new BigDecimal("0"))>0){
								num = new BigDecimal("0.00000001");
							}else{
								num = new BigDecimal("0.00000001").multiply(new BigDecimal("-1"));
							}
							apprYield = apprYield.add(num);
						}else{
							apprYield = apprYield.add(num);
						}
					}
				}else{
					break;
				}
			}
		}
		return apprYield.multiply(new BigDecimal("100")).setScale(3, RoundingMode.HALF_UP);
	}
	
	//calculate Bond Macaulay Duration 
	public static BigDecimal Duration(java.util.Date settlementDate, java.util.Date maturityDate, BigDecimal bondPrice, BigDecimal bondPar, BigDecimal yield, BigDecimal coupon, Integer frequency){
		BigDecimal duration = new BigDecimal("0");
		int noOfYears = NumOfYears(settlementDate, maturityDate);
		int loopCount = frequency*noOfYears;
		BigDecimal numerator = new BigDecimal("0");
		
		for(int i=0;i<loopCount;i++){
			numerator = numerator.add(new BigDecimal(i+1).multiply(coupon).divide(new BigDecimal("1").add(yield.divide(new BigDecimal(frequency), 8, RoundingMode.HALF_UP)).pow(i+1), 8, RoundingMode.HALF_UP));
		}
		numerator = numerator.add(new BigDecimal(loopCount).multiply(bondPar).divide(new BigDecimal("1").add(yield.divide(new BigDecimal(frequency), 8, RoundingMode.HALF_UP)).pow(loopCount), 8, RoundingMode.HALF_UP));
		
		duration = numerator.divide(bondPrice, 8, RoundingMode.HALF_UP);
		
		return duration.setScale(5, RoundingMode.HALF_UP);
	}
}
