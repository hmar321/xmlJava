package com.ies.baroja;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Practica6SAX {
	public static void main(String[] args) {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser;
		try {
			System.out.println("Iniciando procesamiento SAX");
			saxParser = saxParserFactory.newSAXParser();
			Handler6 handler = new Handler6();
			File fichero = new File ("src\\ejemplosxml\\Practica6.xml");
			saxParser.parse(fichero, handler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	private static class Handler6 extends DefaultHandler{
		private StringBuffer sb;

		@Override
		public void startDocument() throws SAXException {
			System.out.println("Inicio del documento");
		}

		@Override
		public void startElement(String url, String localName,String qName, Attributes atts) throws SAXException {
		
			if (qName.equals("username")){ 
				sb = new StringBuffer();
			}
			
		}
		
		@Override
		public void characters (char[] ch, int start, int length) throws SAXException { 
			if (sb != null) {
				sb.append (Arrays.copyOfRange (
				ch, start, start + length));
			}
		}

		@Override

		public void endElement(String url, String localName,String qName) throws SAXException {
			if (qName.equals("username")) { 
				System.out.println (sb);
			}
		
			}

		@Override
		public void endDocument() throws SAXException {

		System.out.println("Final del documento");

		}
	}
	
}



