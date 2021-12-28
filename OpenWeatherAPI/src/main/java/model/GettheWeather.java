package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Gettheweather {

	// public String URL =
	// "http://api.openweathermap.org/data/2.5/weather?q=malmö,se&APPID=099eff339f56d6a29a9823857b2f2671&mode=xml";

	public static void getWeather(weatherBean wBean) throws IOException {

		// Build the API call URL by adding city+country into a URL
		String URLtoSend = "http://api.openweathermap.org/data/2.5/weather?q=" + wBean.getCityStr() + ","
				+ wBean.getCountryStr() + "&APPID=099eff339f56d6a29a9823857b2f2671&mode=xml";

		// print and test in a browser
		System.out.println(URLtoSend);

		// Set the URL that will be sent
		URL line_api_url = new URL(URLtoSend);

		// Create a HTTP connection to sent the GET request over
		HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();
		linec.setDoInput(true);
		linec.setDoOutput(true);
		linec.setRequestMethod("GET");

		// Make a Buffer to read the response from the API
		BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));

		// a String to temp save each line in the response
		String inputLine;

		// a String to save the full response to use later
		String ApiResponse = "";

		// loop through the whole response
		while ((inputLine = in.readLine()) != null) {

			// System.out.println(inputLine);
			// Save the temp line into the full response
			ApiResponse += inputLine;
		}
		in.close();

		// print the response
		System.out.println(ApiResponse);

		// Call a method to make a XMLdoc out of the full response
		Document doc = convertStringToXMLDocument(ApiResponse);

		// normalize the XML response
		doc.getDocumentElement().normalize();
		// check that the XML response is OK by getting the Root element
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		// Create a Node list that gets everything in a tag
		NodeList nListclouds = doc.getElementsByTagName("clouds");
		NodeList nListtemperature = doc.getElementsByTagName("temperature");
		NodeList nListlastupdate = doc.getElementsByTagName("lastupdate");
		NodeList nListweather = doc.getElementsByTagName("weather");


		///////////// CLOUDS
		for (int i = 0; i < nListclouds.getLength(); i++) {
			// Save a node of the current list id
			Node node = nListclouds.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				// set the current node as an Element
				Element eElement = (Element) node;
				// get the content of an attribute in element
				String XMLclouds = eElement.getAttribute("name");
				// and print it
				//System.out.println("clouds " + wBean.getCityStr() + " is now a " + XMLclouds);
				// save it
				wBean.setCloudsStr(XMLclouds);

			}

		}
		
		///////////// ICON
		for (int i = 0; i < nListweather.getLength(); i++) {
			// Save a node of the current list id
			Node node = nListweather.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				// set the current node as an Element
				Element eElement = (Element) node;
				// get the content of an attribute in element
				String XMLweather = eElement.getAttribute("icon");
				// and print it
				//System.out.println("clouds " + wBean.getCityStr() + " is now a " + XMLweather);
				// save it
				wBean.setIcon(XMLweather);

			}

		}
		///////////// TEMP
		for (int i = 0; i < nListtemperature.getLength(); i++) {
			// Save a node of the current list id
			Node node = nListtemperature.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				// set the current node as an Element
				Element eElement = (Element) node;
				// get the content of an attribute in element
				String XMLtemperature = eElement.getAttribute("value");
				// and print it
				//System.out.println("temp " + wBean.getCityStr() + " is now a " + XMLtemperature);

				// convert String to float
				double tempInKelvin = Double.parseDouble(XMLtemperature);

				double celciusConvert = -273.15;
				//System.out.println("test: " + tempInKelvin + celciusConvert);
				double tempInCelcius = tempInKelvin + celciusConvert;
				//System.out.println("test: " + tempInCelcius);
				//System.out.println("test tempInCelcius: " + tempInCelcius);

				int places = 3;
				DecimalFormat df = new DecimalFormat();
				df.setMaximumFractionDigits(places);
				//System.out.println("test 2 digits: " + df.format(tempInCelcius));

				wBean.setTemp(df.format(tempInCelcius));

			}
		}
		/////////////TIME
		for (int i = 0; i < nListlastupdate.getLength(); i++) {
			// Save a node of the current list id
			Node node = nListlastupdate.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				// set the current node as an Element
				Element eElement = (Element) node;
				// get the content of an attribute in element
				String XMLlastupdate = eElement.getAttribute("value");
				// and print it
				System.out.println("search " + wBean.getCityStr() + " time " + XMLlastupdate);
				// save it
				
		        String[] arrayOfTime = XMLlastupdate.split("T");
	
		        String Date=arrayOfTime[0];
		        
		        String Time =arrayOfTime[1];
		        	System.out.println(Date);
		        	System.out.println(Time);
		           
				wBean.setTimeStr(arrayOfTime[1]);


			}

		}

	}

	// Method the makes a XML doc out of a string, if it is in a XML format.
	private static Document convertStringToXMLDocument(String xmlString) {
		// Parser that produces DOM object trees from XML content
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// API to obtain DOM Document instance
		DocumentBuilder builder = null;
		try {
			// Create DocumentBuilder with default configuration
			builder = factory.newDocumentBuilder();

			// Parse the content to Document object
			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}