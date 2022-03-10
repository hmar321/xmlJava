package com.ies.baroja;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Actividad3 {

	public static void main(String[] args) {
		try {
			// 1. Creación del objeto Document.
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();

			// 2. Creación de los elementos, atributos y textos.
			Element elementPaises = document.createElement("paises");
			Element elementPais1 = document.createElement("pais");
			Element elementPais2 = document.createElement("pais");
			Element elementPais3 = document.createElement("pais");
			Element elementP1Ciudad1 = document.createElement("ciudad");
			Element elementP1Ciudad2 = document.createElement("ciudad");
			Element elementP2Ciudad1 = document.createElement("ciudad");
			Element elementP2Ciudad2 = document.createElement("ciudad");
			Element elementP2Ciudad3 = document.createElement("ciudad");
			Element elementP2Ciudad4 = document.createElement("ciudad");
			Element elementP2Ciudad5 = document.createElement("ciudad");
			Text textP1Ciu1 = document.createTextNode("Buenos Aires");
			Text textP1Ciu2 = document.createTextNode("Rosario");
			Text textP2Ciu1 = document.createTextNode("Guadalajara");
			Text textP2Ciu2 = document.createTextNode("Monterrey");
			Text textP2Ciu3 = document.createTextNode("Cacun");
			Text textP2Ciu4 = document.createTextNode("Merida");
			Text textP2Ciu5 = document.createTextNode("Ciudad de Mexico");
			

			// 3. Establecimiento de las relaciones.
			elementPaises.appendChild(elementPais1);
			elementPais1.setAttribute("nombre", "Argentina");
			elementPais1.appendChild(elementP1Ciudad1);
			elementPais1.appendChild(elementP1Ciudad2);
			elementP1Ciudad1.appendChild(textP1Ciu1);
			elementP1Ciudad2.appendChild(textP1Ciu2);
			elementPaises.appendChild(elementPais2);
			elementPais2.setAttribute("nombre", "Mexico");
			elementPais2.appendChild(elementP2Ciudad1);
			elementPais2.appendChild(elementP2Ciudad2);
			elementPais2.appendChild(elementP2Ciudad3);
			elementPais2.appendChild(elementP2Ciudad4);
			elementPais2.appendChild(elementP2Ciudad5);
			elementP2Ciudad1.appendChild(textP2Ciu1);
			elementP2Ciudad2.appendChild(textP2Ciu2);
			elementP2Ciudad3.appendChild(textP2Ciu3);
			elementP2Ciudad4.appendChild(textP2Ciu4);
			elementP2Ciudad5.appendChild(textP2Ciu5);
			elementPaises.appendChild(elementPais3);
			elementPais3.setAttribute("nombre", "Colombia");
			document.appendChild(elementPaises);			
			// Imprimir
			Utilidades.imprimirXml(document);
			// Guardamos documento
			// ejemplo de ruta "src\\ejemplosxml\\nombre.xml"
			String ruta="src\\ejemplosxml\\Actividad3.xml";
			Utilidades.guardarDocument(document,ruta);
		} catch (ParserConfigurationException | TransformerException | IOException e) {
			e.printStackTrace();
		}
	}	
	
}
