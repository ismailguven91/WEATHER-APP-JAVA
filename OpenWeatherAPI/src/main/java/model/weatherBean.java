package model;


public class weatherBean {

	private String cityStr;

	private String countryStr;

	private String cloudsStr;

	private String temp;

	private String timeStr;
	
	private String icon;
	
	private String iconNumber;
	
	private String iconValue;
	

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

	////////ICON icon
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	////////ICON number
	public String getIconNumber() {
		return iconNumber;
	}

	public void setIconNumber(String iconNumber) {
		this.iconNumber = iconNumber;
	}	////////ICON value
	public String getIconValue() {
		return iconValue;
	}

	public void setIconValue(String iconValue) {
		this.iconValue = iconValue;
	}

	

}