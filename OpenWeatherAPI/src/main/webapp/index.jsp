<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>Weather Forecast</title>
</head>

<body>


<h1>Weather Forecast</h1>


 <form action="OWservlet" method="get">  
    City:<input type="text" name="city"/><br/>  
    Country (Language code):<input type="text" name="country"/><br/>  
    
    <input type="submit" value="Check the weather"/>  
    </form>  




</body>
</html>