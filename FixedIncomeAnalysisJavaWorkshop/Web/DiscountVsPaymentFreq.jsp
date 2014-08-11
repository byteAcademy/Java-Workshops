<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Byte Academy Workshop</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<%@ include file="Header.html"%>
	<div id="body">
	<br>
	<form action="DiscountVsPaymentFreqAction" name="discount" method="POST">
	<table id="shadow" style="font-family: arial; color: #333333; font-size: 14px; padding: 20px">
		<tr style="font-size: 16px; height: 50px">
			<td style="width: 220px">
				<b>Discounting<br>
				Semi Annual</b>
			</td>
			<td style="width: 170px">
				<b>Payments<br>
				Semi Annual</b>
			</td>
		</tr>
		<tr style="height: 15px">
			<td>
				&nbsp;
			</td>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr style="height: 28px">
			<td style="text-align: left">
				<b>Bond price</b>
			</td>
			<td>
				<input type="text" id="bondPrice" name="bondPrice" style="font-family: arial; text-align: right" <%if(request.getAttribute("bondPrice")!=null){ %>value="<%=request.getAttribute("bondPrice")%>"<%}else{ %>value="97.89"<%} %>>&nbsp;&nbsp;
			</td>
		</tr>
		<tr style="height: 28px">
			<td style="text-align: left">
				<b>Bond par value</b>
			</td>
			<td>
				<input type="text" id="bondPar" name="bondPar" style="font-family: arial; text-align: right" <%if(request.getAttribute("bondPar")!=null){ %>value="<%=request.getAttribute("bondPar")%>"<%}else{ %>value="100"<%} %>>&nbsp;&nbsp;
			</td>
		</tr>
		<tr style="height: 28px">
			<td style="text-align: left">
				<b>Annual Coupon Rate</b>
			</td>
			<td>
				<input type="text" id="couponRate" name="couponRate" style="font-family: arial; text-align: right" <%if(request.getAttribute("couponRate")!=null){ %>value="<%=request.getAttribute("couponRate")%>"<%}else{ %>value="6"<%} %>>%
			</td>
		</tr>
		<tr style="height: 28px">
			<td style="text-align: left">
				<b>Payment Frequency</b>
			</td>
			<td>
				<input type="text" id="paymentFreq" name="paymentFreq" style="font-family: arial; text-align: right" <%if(request.getAttribute("paymentFreq")!=null){ %>value="<%=request.getAttribute("paymentFreq")%>"<%}else{ %>value="2"<%} %>>&nbsp;&nbsp;
			</td>
		</tr>
		<tr style="height: 28px">
			<td style="text-align: left">
				<b>Coupon Payment</b>
			</td>
			<td>
				<input type="text" id="couponPayment" name="couponPayment" style="font-family: arial; text-align: right" <%if(request.getAttribute("couponPayment")!=null){ %>value="<%=request.getAttribute("couponPayment")%>"<%}else{ %>value="3.00"<%} %>>&nbsp;&nbsp;
			</td>
		</tr>
		<tr style="height: 28px">
			<td style="text-align: left">
				<b>Settlement date</b>
			</td>
			<td>
				<input type="text" id="settlementDate" name="settlementDate" style="font-family: arial; text-align: right" <%if(request.getAttribute("settlementDate")!=null){ %>value="<%=request.getAttribute("settlementDate")%>"<%}else{ %>value="1/1/2014"<%} %>>&nbsp;&nbsp;
			</td>
		</tr>
		<tr style="height: 28px">
			<td style="text-align: left">
				<b>Maturity Date</b>
			</td>
			<td>
				<input type="text" id="maturityDate" name="maturityDate" style="font-family: arial; text-align: right" <%if(request.getAttribute("maturityDate")!=null){ %>value="<%=request.getAttribute("maturityDate")%>"<%}else{ %>value="1/1/2019"<%} %>>&nbsp;&nbsp;
			</td>
		</tr>
		<tr style="height: 15px">
			<td>
				&nbsp;
			</td>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr style="height: 56px">
			<td style="text-align: left; border: 1px solid black">
				<b>YTM</b><br>
				<input type="text" id="YTM" name="YTM" style="text-align:right; background-color: #FFFFD6" <%if(request.getAttribute("yieldToMaturity")!=null){ %>value="<%=request.getAttribute("yieldToMaturity") %>"<%}else{} %>>%
			</td>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr style="height: 56px">
			<td style="text-align: left; border: 1px solid black">
				<b>Duration</b><br>
				<input type="text" id="duration" name="duration" style="text-align:right; background-color: #FFFFD6" <%if(request.getAttribute("duration")!=null){ %>value="<%=request.getAttribute("duration") %>"<%}else{} %>>
			</td>
			<td style="text-align: center">
				<button onclick="document.discount.submit();">Calculate</button>
			</td>
		</tr>
	</table>
	</form>
	</div>
	<div id="footer">
		<%@ include file="Footer.html"%>
	</div>
	
</body>
</html>
