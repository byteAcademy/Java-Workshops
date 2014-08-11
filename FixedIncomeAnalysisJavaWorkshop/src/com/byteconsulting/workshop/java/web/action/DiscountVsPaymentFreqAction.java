package com.byteconsulting.workshop.java.web.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byteconsulting.workshop.java.util.BondUtil;
import com.byteconsulting.workshop.java.util.DataConverter;
import com.byteconsulting.workshop.java.util.DataValidation;

import java.math.BigDecimal;

/**
 * Servlet implementation class DiscountVsPaymentFreqAction
 */
public class DiscountVsPaymentFreqAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiscountVsPaymentFreqAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bondPriceStr = request.getParameter("bondPrice");
		String bondParStr = request.getParameter("bondPar");
		String couponRateStr = request.getParameter("couponRate");
		String paymentFreqStr = request.getParameter("paymentFreq");
		String couponPaymentStr = request.getParameter("couponPayment");
		String settlementDateStr = request.getParameter("settlementDate");
		String maturityDateStr = request.getParameter("maturityDate");
		
		/**
		 * Variable Value and Type Validation here
		 */
		BigDecimal bondPrice = new BigDecimal("0");
		BigDecimal bondPar = new BigDecimal("0");
		BigDecimal couponRate = new BigDecimal("0");
		Integer paymentFreq = new Integer(0);
		BigDecimal couponPayment = new BigDecimal("0");
		java.util.Date settlementDate = new java.util.Date();
		java.util.Date maturityDate = new java.util.Date();
		
		if(DataValidation.isValidBigDecimalValue(new BigDecimal(bondPriceStr))){
			bondPrice = new BigDecimal(bondPriceStr);
		}else{
			//exception...
		}
		if(DataValidation.isValidBigDecimalValue(new BigDecimal(bondParStr))){
			bondPar = new BigDecimal(bondParStr);
		}else{
			//exception...
		}
		if(DataValidation.isValidBigDecimalValue(new BigDecimal(couponRateStr))){
			couponRate = new BigDecimal(couponRateStr);
		}else{
			//exception...
		}
		if(DataValidation.isNumber(paymentFreqStr)){
			paymentFreq = new Integer(paymentFreqStr);
		}else{
			//exception...
		}
		if(DataValidation.isValidBigDecimalValue(new BigDecimal(couponPaymentStr))){
			couponPayment = new BigDecimal(couponPaymentStr);
		}else{
			//exception...
		}
		try{
			if(DataValidation.isValidDateFormat1(settlementDateStr)||DataValidation.isValidDateFormat2(settlementDateStr)){
				settlementDate = BondUtil.StringToDate(settlementDateStr);
			}else{
				//exception...
			}
			if(DataValidation.isValidDateFormat1(maturityDateStr)||DataValidation.isValidDateFormat2(maturityDateStr)){
				maturityDate = BondUtil.StringToDate(maturityDateStr);
			}else{
				//exception...
			}
		}catch(Exception e){
			//catch exception process here...
		}
		
		//Calculation here
		BigDecimal yield = BondUtil.YieldToMaturity(settlementDate, maturityDate, bondPrice, couponRate, bondPar, couponPayment, new Integer(paymentFreq));
		BigDecimal duration = BondUtil.Duration(settlementDate, maturityDate, bondPrice, bondPar, DataConverter.percentageToNum(yield), couponPayment, new Integer(paymentFreq));
		
		request.setAttribute("bondPrice", bondPriceStr);
		request.setAttribute("bondPar", bondParStr);
		request.setAttribute("couponRate", couponRateStr);
		request.setAttribute("paymentFreq", paymentFreqStr);
		request.setAttribute("couponPayment", couponPaymentStr);
		request.setAttribute("settlementDate", settlementDateStr);
		request.setAttribute("maturityDate", maturityDateStr);
		request.setAttribute("yieldToMaturity", yield);
		request.setAttribute("duration", duration);
		
		request.getRequestDispatcher("DiscountVsPaymentFreq.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
