package forex.model;


//step 1- Define beans to represent result data 
public class ForexBean {

	//input values
	private int pesoAmount;
	private String currency;
	
	//computed values
	private double convertedAmount;
	
	//constructor declaration
	public ForexBean(){ //default constructor		
	}

	public ForexBean(int pesoAmount, String currency) {
		this.pesoAmount = pesoAmount;
		this.currency = currency;
	}

	//setter and getter methods
	public int getPesoAmount() {
		return pesoAmount;
	}

	public void setPesoAmount(int pesoAmount) {
		this.pesoAmount = pesoAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
	
	//business logic implementation
	public void convertAmount() {
		switch (currency) {
			case "USD":
				convertedAmount = pesoAmount / 52.25;
				break;
			case "EUR":
				convertedAmount = pesoAmount / 58.7096;
				break;
			case "JPY":	
				convertedAmount = pesoAmount / 0.4936;
				break;
		}
	}
}
