package pl.parser.nbp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

//this class loads from the site every line and load them to arraylist
public class LoadingXML {
	public static ArrayList load() {
		ArrayList list = new ArrayList<String>();

		try {

			URL urlDir = new URL("http://www.nbp.pl/kursy/xml/dir.txt");
			BufferedReader in = new BufferedReader(new InputStreamReader(urlDir.openStream(), "utf-8"));
			
			String inputLine;
			//this one is for the first line because there are some garbage things at the front like '?'
			String a1 = in.readLine();
			String first = a1.substring(a1.length() - 11, a1.length()); 

			list.add(first);

			//loop which loads every line into list
			while ((inputLine = in.readLine()) != null)
				list.add(inputLine);

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
