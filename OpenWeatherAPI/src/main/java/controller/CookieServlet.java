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
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CookieServlet() {
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

		Cookie[] cookies = request.getCookies();

		for (int i = 0; i < cookies.length; i++) {

			if (cookies[i].getName().equals("stad")) {

				cookies[i].getValue();
				System.out.println("test Value: " + cookies[i].getValue());

				String valueOfInputUser = cookies[i].getValue();

				String[] splitArray = valueOfInputUser.split("5");

				String valueCity = splitArray[0];
				String valueCountry = splitArray[1];

				weatherBean wBean = new weatherBean(valueCity, valueCountry);

				Gettheweather.getWeather(wBean);

				request.setAttribute("wBean", wBean);

				RequestDispatcher rd = request.getRequestDispatcher("showWeather.jsp");
				rd.forward(request, response);

			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
