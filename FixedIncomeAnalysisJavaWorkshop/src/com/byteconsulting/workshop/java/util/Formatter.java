package com.byteconsulting.workshop.java.util;

import java.math.BigDecimal;

public class Formatter {
		//Used to format the numbers - inserting comma
		public static String formatCredit(BigDecimal a){
			a = a.setScale(2, BigDecimal.ROUND_HALF_UP);
			StringBuilder sb = new StringBuilder(a.toString());
			int pos = sb.length()-3;
			while(pos>0){
				sb.insert(pos, ",");
				pos = pos-3;
			}
			sb.deleteCharAt(sb.length()-4);
			return sb.toString();
		}
}
