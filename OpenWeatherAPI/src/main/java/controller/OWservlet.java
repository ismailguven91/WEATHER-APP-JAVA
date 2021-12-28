package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Gettheweather;
import model.weatherBean;

/**
 * Servlet implementation class OWservlet
 */
@WebServlet("/OWservlet")
public class OWservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OWservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String cityStr = request.getParameter("city");
		String countryStr = request.getParameter("country");

		Cookie ck = new Cookie("stad", cityStr +"5"+ countryStr);
		ck.setMaxAge(3600);

		//Add cookie to response
		response.addCookie(ck);

		//Create a new Beam (Object)
		weatherBean wBean = new weatherBean(cityStr, countryStr);

		//Use the bean to search API
		Gettheweather.getWeather(wBean);

		//Add a bean to the request
		request.setAttribute("wBean", wBean);

		RequestDispatcher rd = request.getRequestDispatcher("showWeather.jsp");
		rd.forward(request, response);
		
		
		//LÄGGA TILL FLEW COOKIES. GÖR EN COOKIE SOM
		
		//SKAPA EN METOD SOM SPLITTAR SÖKNINGARNA, SPARA DOM I EN BEAN I EN ARRAYLIST
		
		//I INDEX. KOLLA FÖRST.... SKAPA EN COOKIES SOM INNEHÅLLER 1 OCH 0. FRÅGA OM DET FINNS EN STATE. FORM. SERVLET.

	}

}