package pl.parser.nbp;

import java.util.ArrayList;

public class Calculations {

	public static double mean(double sum,ArrayList dev) {
		
		sum/=Data.getCounter();
		
		
		double total = 0;

		for(int i = 0; i < dev.size(); i++){
			double help = (double)dev.get(i);
			System.out.println(help);
		   total +=  help;
		}

		double mean = total / dev.size();
		return mean;
	}

	public static void dev(ArrayList dev,double mean) {

		for(int i = 0; i < dev.size(); i++){
			double help = (double)dev.get(i);
			double summary;
			  summary  = Math.pow((help-mean),2);
			  dev.set(i, summary);
			}
		
	}
	
	public static void dev2(ArrayList dev) {
		double sum=0;
		for(int i = 0; i < dev.size(); i++){
			double help = (double)dev.get(i);
			sum+=help;
		}
		sum/=dev.size();
		sum=Math.sqrt(sum);
		System.out.println(sum);
		
		
	}
	
}
