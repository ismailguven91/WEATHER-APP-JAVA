package model;

public class weatherBean {

	private String cityStr;

	private String countryStr;

	private String cloudsStr;

	private String temp;

	private String timeStr;

	public weatherBean(String cityStr, String countryStr) {

		this.cityStr = cityStr;
		this.countryStr = countryStr;

	}

	//////// CITY
	public String getCityStr() {
		return cityStr;
	}

	//////// COUNTRY
	public String getCountryStr() {
		return countryStr;
	}

	//////// CLOUDS
	public String getCloudsStr() {
		return cloudsStr;
	}

	public void setCloudsStr(String cloudsStr) {
		this.cloudsStr = cloudsStr;
	}

	//////// TIME
	public String getTimeStr() {
		return timeStr;
	}

	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}

	//////// TEMP
	public String getTemp() {
		return temp;
	}

	public void setTemp(String string) {
		this.temp = string;
	}

}