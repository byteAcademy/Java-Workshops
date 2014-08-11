package com.byteconsulting.workshop.java.web.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byteconsulting.workshop.java.util.Formatter;
import com.byteconsulting.workshop.java.util.DataValidation;
import com.byteconsulting.workshop.java.util.DataConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Servlet implementation class CashflowCalculationAction
 */
public class CashflowCalculationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CashflowCalculationAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * fetch values from jsp pages
		 */
		String balanceInputStr = request.getParameter("balanceInput");
		String couponInputStr = request.getParameter("couponInput");
		String principal1Str = request.getParameter("principal1");
		String principal2Str = request.getParameter("principal2");
		String principal3Str = request.getParameter("principal3");
		String principal4Str = request.getParameter("principal4");
		/**
		 * remove all the ',' in the input string
		 * Trim the userinput string into the valid format for constructing the num
		 */
		String trimBalanceStr = DataValidation.trimStr(balanceInputStr);
		String trimCouponStr = DataValidation.trimStr(couponInputStr);
		String trimPrincipal1 = DataValidation.trimStr(principal1Str);
		String trimPrincipal2 = DataValidation.trimStr(principal2Str);
		String trimPrincipal3 = DataValidation.trimStr(principal3Str);
		String trimPrincipal4 = DataValidation.trimStr(principal4Str);
		/**
		 * Validation processes go into here
		 * Convert String type to corresponding variable types
		 */
		BigDecimal balanceInput = new BigDecimal("0");
		BigDecimal couponInput = new BigDecimal("0");
		BigDecimal principal1 = new BigDecimal("0");
		BigDecimal principal2 = new BigDecimal("0");
		BigDecimal principal3 = new BigDecimal("0");
		BigDecimal principal4 = new BigDecimal("0");
		if(DataValidation.isValidBigDecimalValue(new BigDecimal(trimBalanceStr))){
			balanceInput = new BigDecimal(trimBalanceStr);
		}else{
			//Throw exception here...
		}
		if(DataValidation.isValidBigDecimalValue(new BigDecimal(trimCouponStr))){
			couponInput = new BigDecimal(trimCouponStr);
		}else{
			//Throw exception here...
		}
		if(DataValidation.isValidBigDecimalValue(new BigDecimal(trimPrincipal1))){
			principal1 = new BigDecimal(trimPrincipal1);
		}else{
			//Throw exception here...
		}
		if(DataValidation.isValidBigDecimalValue(new BigDecimal(trimPrincipal1))){
			principal2 = new BigDecimal(trimPrincipal2);
		}else{
			//Throw exception here...
		}
		if(DataValidation.isValidBigDecimalValue(new BigDecimal(trimPrincipal1))){
			principal3 = new BigDecimal(trimPrincipal3);
		}else{
			//Throw exception here...
		}
		if(DataValidation.isValidBigDecimalValue(new BigDecimal(trimPrincipal1))){
			principal4 = new BigDecimal(trimPrincipal4);
		}else{
			//Throw exception here...
		}
		
		//calculation
		BigDecimal principal5 = balanceInput.subtract(principal1.add(principal2.add(principal3.add(principal4))));
		BigDecimal balance1 = balanceInput.subtract(principal1);
		BigDecimal balance2 = balance1.subtract(principal2);
		BigDecimal balance3 = balance2.subtract(principal3);
		BigDecimal balance4 = balance3.subtract(principal4);
		BigDecimal coupon1 = DataConverter.percentageToNum(couponInput).multiply(balanceInput);
		BigDecimal coupon2 = DataConverter.percentageToNum(couponInput).multiply(balance1);
		BigDecimal coupon3 = DataConverter.percentageToNum(couponInput).multiply(balance2);
		BigDecimal coupon4 = DataConverter.percentageToNum(couponInput).multiply(balance3);
		BigDecimal coupon5 = DataConverter.percentageToNum(couponInput).multiply(balance4);
		BigDecimal avgLife = principal1.multiply(new BigDecimal("1")).add(principal2.multiply(new BigDecimal("2")).add(principal3.multiply(new BigDecimal("3")).add(principal4.multiply(new BigDecimal("4")).add(principal5.multiply(new BigDecimal("5")))))).divide(balanceInput, 2, RoundingMode.HALF_UP);
		
		//set the attribute
		request.setAttribute("balanceInput", Formatter.formatCredit(new BigDecimal(DataValidation.trimStr(balanceInputStr))));
		request.setAttribute("couponInput", couponInputStr);
		request.setAttribute("balance", Formatter.formatCredit(new BigDecimal(DataValidation.trimStr(balanceInputStr))));
		request.setAttribute("principal1", Formatter.formatCredit(principal1));
		request.setAttribute("principal2", Formatter.formatCredit(principal2));
		request.setAttribute("principal3", Formatter.formatCredit(principal3));
		request.setAttribute("principal4", Formatter.formatCredit(principal4));
		request.setAttribute("principal5", Formatter.formatCredit(principal5));
		request.setAttribute("balance1", Formatter.formatCredit(balance1));
		request.setAttribute("balance2", Formatter.formatCredit(balance2));
		request.setAttribute("balance3", Formatter.formatCredit(balance3));
		request.setAttribute("balance4", Formatter.formatCredit(balance4));
		request.setAttribute("coupon1", Formatter.formatCredit(coupon1));
		request.setAttribute("coupon2", Formatter.formatCredit(coupon2));
		request.setAttribute("coupon3", Formatter.formatCredit(coupon3));
		request.setAttribute("coupon4", Formatter.formatCredit(coupon4));
		request.setAttribute("coupon5", Formatter.formatCredit(coupon5));
		request.setAttribute("avgLife", Formatter.formatCredit(avgLife));
		
		request.getRequestDispatcher("CashflowCalculator.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
