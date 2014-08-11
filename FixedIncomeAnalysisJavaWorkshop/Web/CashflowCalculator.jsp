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
	<form action="CashflowCalculationAction" name="cashflow" method="POST">
	<br>
	<p id="field">Balance:&nbsp;&nbsp;<input type="text" name="balanceInput" <%if(request.getAttribute("balanceInput")!=null){ %>value="<%=request.getAttribute("balanceInput")%>"<%}else{ %>value="100,000,000.00"<%} %>/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Coupon Rate:&nbsp;&nbsp;<input type="text" name="couponInput" <%if(request.getAttribute("couponInput")!=null){ %>value="<%=request.getAttribute("couponInput")%>"<%}else{ %>value="6"<%} %>/>%</p>

	<table id="shadow" style="font-family: arial; color: #333333; font-size: 14px; padding: 20px">
		<tr>
			<th id="years">
				Years
			</th>
			<th>
				Balance
			</th>
			<th>
				Coupon
			</th>
			<th>
				Principal
			</th>
		</tr>
		<tr>
			<td id="years">
				0
			</td>
			<td>
				<input type="text" name="balance" <%if(request.getAttribute("balance")!=null){ %>value="<%=request.getAttribute("balance")%>"<%}else{ %>value="100,000,000.00"<%} %> readonly id="readonly"/>
			</td>
			<td>
				<input type="text" name="coupon0" value="0" readonly id="readonly"/>
			</td>
			<td>
				<input type="text" name="principal0" value="0" readonly id="readonly"/>
			</td>
		</tr>
		<tr>
			<td id="years">
				1
			</td>
			<td>
				<input type="text" name="balance1" <%if(request.getAttribute("balance1")!=null){ %>value="<%=request.getAttribute("balance1")%>"<%}else{ %>value="100,000,000.00"<%} %> readonly id="readonly"/>
			</td>
			<td>
				<input type="text" name="coupon1" <%if(request.getAttribute("coupon1")!=null){ %>value="<%=request.getAttribute("coupon1")%>"<%}else{ %>value="6,000,000.00"<%} %> readonly id="readonly"/>
			</td>
			<td>
				<input type="text" name="principal1" <%if(request.getAttribute("principal1")!=null){ %>value="<%=request.getAttribute("principal1")%>"<%}else{ %>value="0"<%} %>/>
			</td>
		</tr>
		<tr>
			<td id="years">
				2
			</td>
			<td>
				<input type="text" name="balance2" <%if(request.getAttribute("balance2")!=null){ %>value="<%=request.getAttribute("balance2")%>"<%}else{ %>value="100,000,000.00"<%} %> readonly id="readonly"/>
			</td>
			<td>
				<input type="text" name="coupon2" <%if(request.getAttribute("coupon2")!=null){ %>value="<%=request.getAttribute("coupon2")%>"<%}else{ %>value="6,000,000.00"<%} %> readonly id="readonly"/>
			</td>
			<td>
				<input type="text" name="principal2" <%if(request.getAttribute("principal2")!=null){ %>value="<%=request.getAttribute("principal2")%>"<%}else{ %>value="0"<%} %>/>
			</td>
		</tr>
		<tr>
			<td id="years">
				3
			</td>
			<td>
				<input type="text" name="balance3" <%if(request.getAttribute("balance3")!=null){ %>value="<%=request.getAttribute("balance3")%>"<%}else{ %>value="100,000,000.00"<%} %> readonly id="readonly"/>
			</td>
			<td>
				<input type="text" name="coupon3" <%if(request.getAttribute("coupon3")!=null){ %>value="<%=request.getAttribute("coupon3")%>"<%}else{ %>value="6,000,000.00"<%} %> readonly id="readonly"/>
			</td>
			<td>
				<input type="text" name="principal3" <%if(request.getAttribute("principal3")!=null){ %>value="<%=request.getAttribute("principal3")%>"<%}else{ %>value="0"<%} %>/>
			</td>
		</tr>
		<tr>
			<td id="years">
				4
			</td>
			<td>
				<input type="text" name="balance4" <%if(request.getAttribute("balance4")!=null){ %>value="<%=request.getAttribute("balance4")%>"<%}else{ %>value="100,000,000.00"<%} %> readonly id="readonly"/>
			</td>
			<td>
				<input type="text" name="coupon4" <%if(request.getAttribute("coupon4")!=null){ %>value="<%=request.getAttribute("coupon4")%>"<%}else{ %>value="6,000,000.00"<%} %> readonly id="readonly"/>
			</td>
			<td>
				<input type="text" name="principal4" <%if(request.getAttribute("principal4")!=null){ %>value="<%=request.getAttribute("principal4")%>"<%}else{ %>value="0"<%} %> />
			</td>
		</tr>
		<tr>
			<td id="years">
				5
			</td>
			<td>
				<input type="text" name="balance5" value="0" readonly id="readonly"/>
			</td>
			<td>
				<input type="text" name="coupon5" <%if(request.getAttribute("coupon5")!=null){ %>value="<%=request.getAttribute("coupon5")%>"<%}else{ %>value="6,000,000.00"<%} %> readonly id="readonly"/>
			</td>
			<td>
				<input type="text" name="principal5" <%if(request.getAttribute("principal5")!=null){ %>value="<%=request.getAttribute("principal5")%>"<%}else{ %>value="100,000,000.00"<%} %> readonly id="readonly"/>
			</td>
		</tr>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr style="height: 56px">
			<td colspan="2" style="text-align: left; border: 1px solid black">
				<b>Weighted Avg. Life</b>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="avgLife" name="avgLife" style="text-align:right; background-color: #FFFFD6" <%if(request.getAttribute("avgLife")!=null){ %>value="<%=request.getAttribute("avgLife") %>"<%}else{} %>>
			</td>
			<td>
			</td>
			<td style="text-align:right">
				<button onclick="document.cashflow.submit();">Calculate</button>
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
