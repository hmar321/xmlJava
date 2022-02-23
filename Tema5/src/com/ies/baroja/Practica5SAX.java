package com.ies.baroja;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Practica5SAX {
	public static void main(String[] args) {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser;
		try {
			System.out.println("Iniciando procesamiento SAX");
			saxParser = saxParserFactory.newSAXParser();
			DefaultHandler handler = new XMLSAXManager();
			File fichero = new File ("src\\ejemplosxml\\Resuelta5-1.xml");
			saxParser.parse(fichero, handler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
