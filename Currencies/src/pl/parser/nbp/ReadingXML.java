package pl.parser.nbp;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class ReadingXML {
	public static Document read(ArrayList list) {
		Document doc = null;
		for (int i = 0; i < list.size(); i++) {

			String a = (String) list.get(i);
			String c = "c";

			URL url = null;
			try {
				url = new URL("http://www.nbp.pl/kursy/xml/" + a + ".xml");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			int cnt = 0;
			String last_six = a.substring(a.length() - 6, a.length());

			Integer number = Integer.parseInt(last_six);

			if (number >= Data.getDate_start_i() && number <= Data.getDate_end_i()
					&& a.toLowerCase().indexOf(c.toLowerCase()) != -1) {
				cnt++;
				System.out.println(last_six);
			}
			Data.setCounter(cnt);
			
			try {
				InputStream fXmlFile = url.openStream();
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				doc = dBuilder.parse(fXmlFile);

				doc.getDocumentElement().normalize();

				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return doc;
	}
}
