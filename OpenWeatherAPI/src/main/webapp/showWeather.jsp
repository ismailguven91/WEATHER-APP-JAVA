<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.weatherBean"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="styles.css">
<meta charset="UTF-8">
<title>Weather Forecast</title>
</head>
<body>

	<nav class="navbar navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp"> <img src="img/sun.jpg"
				alt="" width="30" height="24" class="d-inline-block align-text-top">
				Weather Forecast
			</a>
		</div>
	</nav>



	<%
	weatherBean wBean = (weatherBean) request.getAttribute("wBean");

	String Time = wBean.getTimeStr();
	String Country = wBean.getCountryStr();
	String City = wBean.getCityStr();
	String Temp = wBean.getTemp();
	String Clouds = wBean.getCloudsStr();
	String Icon = wBean.getIcon();
	String IconNumber = wBean.getIconNumber();
	String IconValue = wBean.getIconValue();
	%>

	
	    <div class="container">
        <div class="row">
          <div class="col">
            
          </div>
          <div class="col">
			<h1><%=Country + "/" + City%></h1>
          </div>
          <div class="col">
            
          </div>
        </div>
      </div>

      <div class="container">
        <div class="row">
          <div class="col">
            
          </div>
          <div class="col">
            <div class="card" style="width: 18rem;">
                <img src="img/sun.jpg" class="card-img-top" alt="sun.jpg">
                <%=Icon + IconNumber + IconValue%>
                <div class="card-body">
			<h3><%="Weather in " + City%></h3>
			<p class="card-text"><%="Temperature " + Temp + " celcius and " + Clouds%></p>
			<h4><%=Time%></h4>
                </div>
                <form action="OWservlet" method="get">
                    <div class="row justify-content-md-center">
        
                        <div class="row-5">
                            <input type="text" class="form-control" placeholder="City"
                                aria-label="City" name="city">
                        </div>
                        <div class="row-5">
                            <input type="text" class="form-control" placeholder="Country"
                                aria-label="Country" name="country">
                        </div>
        
                    </div>
                    <div class="row justify-content-md-center">
                        <div class="row-3"></div>
                        <div class="col-6"><input class="btn btn-primary" type="submit" value="Check weather" />
                        </div>
                    </div>
                </form>
            </div>
          </div>
          <div class="col">
            
          </div>
        </div>
</div>
	


	











</body>
</html>