package com.ies.baroja;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class ProcesarXml {

	public static void main(String[] args) {
		procesarArchivo("src\\ejemplosxml\\practica2.xml");
		
	}

	private static void procesarArchivo(String nombreArchivo) {
		DocumentBuilderFactory fabrica;
		DocumentBuilder constructor;
		Document documentXML;
		
		try {
			File fichero=new File(nombreArchivo);
			fabrica = DocumentBuilderFactory.newInstance();
			System.out.println("Procesando "+nombreArchivo);
			
			constructor=fabrica.newDocumentBuilder();
			documentXML=constructor.parse(fichero);
			
			Utilidades.imprimirXml(documentXML);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	


}
