package com.ies.baroja;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;



public class Libro {

	public static void main(String[] args) {
		try {
			// 1. Creaci?n del objeto Document.
			DocumentBuilderFactory documentFactory=DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			
			// 2. Creaci?n de los elementos, atributos y textos.
			Element elementLibro = document.createElement("libro");
			Element elementTitulo = document.createElement("titulo");
			Attr attributeDisponible =document.createAttribute("disponiblePapel");
			attributeDisponible.setValue("true");
			Text textTitulo =document.createTextNode("LENGUAJES DE MARCAS Y ...");
			
			// 3. Establecimiento de las relaciones.
			elementTitulo.appendChild(textTitulo);
			elementLibro.appendChild(elementTitulo);
			elementLibro.setAttribute("disponibleDigital", "true");
			elementLibro.setAttributeNode(attributeDisponible);
			document.appendChild(elementLibro);
			
			// Imprimir
			imprimirXml(document);
		}
		catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
		catch (TransformerConfigurationException tce) {
			tce.printStackTrace();
		}
		catch (TransformerException te) {
			te.printStackTrace();
		}
	}
	
	private static void imprimirXml(Document document2print) 
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
