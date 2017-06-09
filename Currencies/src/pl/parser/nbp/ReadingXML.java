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
		ArrayList dev = new ArrayList<Double>();
		double sum = 0;
		int counter = 0;
	for (int i = 0; i < list.size(); i++) {

	try {
		String a = (String) list.get(i);
		String c = "c";
		URL url = new URL("http://www.nbp.pl/kursy/xml/" + a + ".xml");
		String numbers = a.substring(a.length() - 6, a.length());
		Integer liczba = Integer.parseInt(numbers);
		if (liczba >= Data.getDate_start_i() && liczba <= Data.getDate_end_i()
				&& a.toLowerCase().indexOf(c.toLowerCase()) != -1) {
			
			if(liczba == Data.getDate_end_i()) {
				break;
			}
			counter++;
			System.out.println(numbers);

			InputStream fXmlFile = url.openStream();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("pozycja");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					String kod = eElement.getElementsByTagName("kod_waluty").item(0).getTextContent();
					if (kod.equals(Data.getCurrency())) {
						System.out.println(" ");
						System.out.println("----------------------------");

						System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

						System.out.println("Kod waluty : " + Data.getCurrency());
						NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);

						String kupno = eElement.getElementsByTagName("kurs_kupna").item(0).getTextContent();
						double myNumber = nf.parse(kupno).doubleValue();
						sum += myNumber;

						System.out.println("Kurs kupna : " + kupno);

								String sprzedaz = eElement.getElementsByTagName("kurs_sprzedazy").item(0)
										.getTextContent();
								double myNumber2 = nf.parse(sprzedaz).doubleValue();
								dev.add(myNumber2);
								System.out.println("Kurs sprzedazy : " + sprzedaz);
							}
						}

					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	double mean;
	mean=Calculations.mean(sum,dev);
	Calculations.dev(dev, mean);
	Calculations.dev2(dev);
	}
}
