package com.ies.baroja;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Pract7 {
	public static void main(String[] args) {
		try {
			// 1. Creación del objeto Document.
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();

			// 2. Creación de los elementos, atributos y textos.
			Element elementLibro = document.createElement("libro");
			Element elementTitulo = document.createElement("titulo");
			Attr attributeDisponible = document.createAttribute("disponiblePapel");
			attributeDisponible.setValue("true");
			Text textTitulo = document.createTextNode("LENGUAJES DE MARCAS Y ...");

			// 3. Establecimiento de las relaciones.
			elementTitulo.appendChild(textTitulo);
			elementLibro.appendChild(elementTitulo);
			elementLibro.setAttribute("disponibleDigital", "true");
			elementLibro.setAttributeNode(attributeDisponible);
			document.appendChild(elementLibro);

			// Imprimir
			Utilidades.imprimirXml(document);
			// Guardamos documento
			guardarDocument(document);
		} catch (ParserConfigurationException | TransformerException | IOException e) {
			e.printStackTrace();
		}
	}

	private static void guardarDocument (Document document)
			throws IOException, TransformerException {
			DOMSource domSource = new DOMSource (document);
			FileWriter fileWriter = new FileWriter (new File ("src\\ejemplosxml\\Practica7.xml"));
			StreamResult streamResult = new	StreamResult (fileWriter);
			TransformerFactory transformerFactory =	TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer ();
			transformer.setOutputProperty (OutputKeys. INDENT, "yes");
			transformer.transform (domSource, streamResult);
			fileWriter.close();
			}

}
