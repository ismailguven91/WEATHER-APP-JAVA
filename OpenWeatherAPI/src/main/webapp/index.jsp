<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<% 
Cookie[] cookies = request.getCookies();
int i = 0;
for (Cookie cookie : cookies ) {


if(cookies[i].getName().equals("stad")){
	RequestDispatcher rd = request.getRequestDispatcher("CookieServlet");
	rd.forward(request, response);	  
	  
}
  i++;
}

%>
	<nav class="navbar navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp"> <img src="img/sun.jpg"
				alt="" width="30" height="24" class="d-inline-block align-text-top">
				Weather Forecast

			</a>
		</div>
	</nav>


<!--
	<div class="container">
		<form action="OWservlet" method="get">
			<div class="row justify-content-md-center">

				<div class="col-4">
					<input type="text" class="form-control" placeholder="City"
						aria-label="City" name="city">
				</div>
				
				<div class="col-4">
					<input type="text" class="form-control" placeholder="Country"
						aria-label="Country" name="country">
				</div>

			</div>
			
			
			<div class="row justify-content-md-center">
				<div class="col-5"></div>
				<div class="col-2">
					<input class="btn btn-primary" type="submit" value="Check weather"  />
				</div>
				<div class="col-5"></div>
			</div>
		</form>

	</div>
	
-->

	    <div class="container">
        <div class="row">
          <div class="col">
            
          </div>
          <div class="col">
			<h1>Country and City</h1>
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
                <div class="card-body">
			<h3>Weather in City</h3>
			<p class="card-text">Temperature in celcius</p>
			<h4>Time</h4>
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