package pl.parser.nbp;

import java.io.InputStream;
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

public class MainClass {

	public static void main(String[] args) {
		ArrayList list = new ArrayList<String>();
		list = LoadingXML.load();
		Data.enterValues();
		ReadingXML.read(list);
		
		
		 
		
		
		
			
			

		}

	}


