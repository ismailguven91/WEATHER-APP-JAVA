<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.weatherBean" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>Weather Forecast</title>
</head>
<body>

<h1>Weather Forecast</h1>

	<%
	weatherBean wBean = (weatherBean) request.getAttribute("wBean");
	out.print("The weather in " + wBean.getCityStr() + " is now a " + wBean.getCloudsStr()+".");
	

	%>



</body>
</html>