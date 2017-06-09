package pl.parser.nbp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadingXML {
	public static ArrayList load() {
	ArrayList list = new ArrayList<String>();

		try {
		
			URL urlDir = new URL("http://www.nbp.pl/kursy/xml/dir.txt");
			BufferedReader in = new BufferedReader(new InputStreamReader(urlDir.openStream(), "utf-8"));
			Scanner ins = new Scanner(new InputStreamReader(urlDir.openStream(), "utf-8"));
			
			String inputLine;
			String a1 = in.readLine();
			String first = a1.substring(a1.length() - 11, a1.length());
			
			
			list.add(first);

			while ((inputLine = in.readLine()) != null)
				list.add(inputLine);

			in.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
