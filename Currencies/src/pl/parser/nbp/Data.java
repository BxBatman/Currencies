package pl.parser.nbp;

import java.util.Scanner;

public class Data {
	private String currency;
	private String data_start;
	private String data_end;
	Scanner in = new Scanner(System.in);
	
	public static void enterValues() {
		
		
	}
	
	public String getData_end() {
		return data_end;
	}
	
	public void setData_end(String data_end) {
		this.data_end = data_end;
	}
	
	
	public String getData_start() {
		return data_start;
	}
	
	public void setData_start(String data_start) {
		this.data_start = data_start;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
