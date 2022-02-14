package com.ies.baroja;

import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class Utilidades {
	
	public static void imprimirXml(Document document2print) 
			throws TransformerConfigurationException, TransformerException {
				
		DOMSource domSource = new DOMSource(document2print);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.transform(domSource, result);
		
		System.out.println("XML de(minombre) a String: \n" + writer.toString());
			
	}

}
