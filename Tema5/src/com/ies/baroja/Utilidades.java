package com.ies.baroja;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class Utilidades {
	
	/**
	 * Método imprimirXml
	 * @param document2print
	 * @throws TransformerConfigurationException
	 * @throws TransformerException
	 */
	public static void imprimirXml(Document document2print) 
			throws TransformerConfigurationException,TransformerException  {
		DOMSource domSource = new DOMSource(document2print);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.transform(domSource, result);
		System.out.println("XML IN String format is: \n" + writer.toString());		
	}
	
	/**
	 * Método procesarArchivo: dada la ruta de un xml devuelve un objeto Document 	
	 * @param nombreArchivo
	 * @return
	 */
	public static Document procesarArchivo(String nombreArchivo){
		DocumentBuilderFactory fabrica;
		DocumentBuilder constructor;
		Document documentoXML=null;
		File fichero=new File(nombreArchivo);
		fabrica= DocumentBuilderFactory.newInstance();
		System.out.println("Procesando "+nombreArchivo);
		try {
			constructor=
					fabrica.newDocumentBuilder();
			documentoXML=constructor.parse(fichero);					
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return documentoXML;
	}
	
	public static void guardarDocument (Document document,String ruta)
			throws IOException, TransformerException {
			DOMSource domSource = new DOMSource (document);
			FileWriter fileWriter = new FileWriter (new File (ruta));
			StreamResult streamResult = new	StreamResult (fileWriter);
			TransformerFactory transformerFactory =	TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer ();
			transformer.setOutputProperty (OutputKeys. INDENT, "yes");
			transformer.transform (domSource, streamResult);
			fileWriter.close();
			}

}
