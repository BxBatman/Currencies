package pl.parser.nbp;

import java.util.ArrayList;

//this class do calculations like average,mean and deviation
public class Calculations {

	public static double mean(ArrayList dev) {

		double total = 0;

		for (int i = 0; i < dev.size(); i++) {
			double help = (double) dev.get(i);
			total += help;
		}

		double mean = total / dev.size();
		return mean;
	}

	public static void dev(ArrayList dev, double mean) {

		for (int i = 0; i < dev.size(); i++) {
			double help = (double) dev.get(i);
			double summary;
			summary = Math.pow((help - mean), 2);
			dev.set(i, summary);
		}

	}

	public static void dev2(double buy_sum, ArrayList dev) {
		double sum = 0;
		for (int i = 0; i < dev.size(); i++) {
			double help = (double) dev.get(i);
			sum += help;
		}

		sum /= dev.size();
		sum = Math.sqrt(sum);
		buy_sum /= (double) Data.getCounter();
		System.out.println("Average for purchase amount: " + buy_sum);
		System.out.println("Standard deviation: " + sum);

	}

}
