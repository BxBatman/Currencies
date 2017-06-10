package pl.parser.nbp;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadingXML {
	public static void read(ArrayList list) {
		
		ArrayList dev = new ArrayList<Double>(); //arraylist for deviation
		double sum = 0;
		int counter = 0;
		
		
		for (int i = 0; i < list.size(); i++) {

			try {
				String a = (String) list.get(i);
				String c = "c"; // checking if first letter is c because i only
								// chose this xml's with typ c
				URL url = new URL("http://www.nbp.pl/kursy/xml/" + a + ".xml"); //loading every xml file
				
				String numbers = a.substring(a.length() - 6, a.length()); //just last 6 digits
				Integer liczba = Integer.parseInt(numbers); //parsing to Integer
				
				//this if checks if line is which is being loaded is in good range and its line with c at the front
				if (liczba >= Data.getDate_start_i() && liczba <= Data.getDate_end_i()
						&& a.toLowerCase().indexOf(c.toLowerCase()) != -1) {

					if (liczba == Data.getDate_end_i()) {
						break;
					}
					counter++;

					InputStream XmlFile = url.openStream();
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.parse(XmlFile);

					doc.getDocumentElement().normalize(); 
					//this is used to make sure that text node is in good representation
					

					NodeList nList = doc.getElementsByTagName("pozycja");

					for (int temp = 0; temp < nList.getLength(); temp++) {

						Node nNode = nList.item(temp);

						if (nNode.getNodeType() == Node.ELEMENT_NODE) {

							Element eElement = (Element) nNode;

							String code = eElement.getElementsByTagName("kod_waluty").item(0).getTextContent();
							if (code.equals(Data.getCurrency())) { //if currency equals the currency code in xml 

								NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH); // to read wih ',' from xml
								System.out.println("Loading..."); 

								String kupno = eElement.getElementsByTagName("kurs_kupna").item(0).getTextContent();
								double myNumber = nf.parse(kupno).doubleValue();
								sum += myNumber; //sum the values of purchase rate

								String sprzedaz = eElement.getElementsByTagName("kurs_sprzedazy").item(0)
										.getTextContent();
								double myNumber2 = nf.parse(sprzedaz).doubleValue();
								dev.add(myNumber2); //adding selling rates to list to calculate deviation later

							}
						}

					}

				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		
		if(counter == 0) {
			System.out.println("Not found,maybe wrong date");
		}
		
		
		Data.setCounter(counter);
		double mean;
		mean = Calculations.mean(dev);
		Calculations.dev(dev, mean);
		Calculations.dev2(sum, dev);
	}
}
