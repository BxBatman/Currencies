package pl.parser.nbp;

import java.util.Scanner;

public class Data {
	private static String currency;
	private static String date_start;
	private static String date_end;

	private static Integer date_start_i;
	private static Integer date_end_i;
	
	private static int counter;

	static Scanner in = new Scanner(System.in);

	public static void enterValues() {
		System.out.println("Enter the typ of currency");
		System.out.println("You can enter only USD,EUR,CHF,GBP in big letters");
		String cur = "";

		do {

			currency = in.nextLine();
			if (!cur.equals("USD") && !currency.equals("EUR") && !currency.equals("CHF") && !currency.equals("GBP")) {
				System.out.println("Wrong");
				System.out.println("You can enter only USD,EUR,CHF,GBP in big letters");
			}
		} while (!currency.equals("USD") && !currency.equals("EUR") && !currency.equals("CHF")
				&& !currency.equals("GBP"));

		System.out.println("Enter the start date");
		System.out.println("In format like this example");
		System.out.println("03-01-2017(day-month-year) enter like this 170103");
		do {
			date_start = in.nextLine();
			if (date_start.length() != 6) {
				System.out.println("You entered too short or too long value. Remember to enter date in good format");
				System.out.println("03-01-2017(day-month-year) enter like this 170103");
			}
		} while (date_start.length() != 6);

		date_start_i = Integer.parseInt(date_start);

		System.out.println("Enter the end date");
		System.out.println("In format like this example");
		System.out.println("03-01-2017(day-month-year) enter like this 170103");
		do {
			date_end = in.nextLine();
			if (date_start.length() != 6) {
				System.out.println("You entered too short or too long value . Remember to enter date in good format");

				System.out.println("03-01-2017(day-month-year) enter like this 170103");
			}
			date_end_i = Integer.parseInt(date_end);
			if (date_end_i < date_start_i) {
				System.out.println("You  entered the end date which is before start date");
			}
		} while (date_end.length() != 6 || date_end_i < date_start_i);

	}

	

	public static Integer getDate_start_i() {
		return date_start_i;
	}
	
	public static Integer getDate_end_i() {
		return date_end_i;
	}
	
	public static void setCounter(int counter_h) {
		counter = counter_h;
	}
	
	public static int getCounter() {
		return counter;
	}
	
}
