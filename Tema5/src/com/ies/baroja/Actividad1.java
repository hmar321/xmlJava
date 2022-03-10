package com.ies.baroja;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class Actividad1 {

	public static void main(String[] args) {
		try {
			// 1. Creación del objeto Document.
			DocumentBuilderFactory documentFactory=DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			
			// 2. Creación de los elementos, atributos y textos.
			Element elementBingo = document.createElement("bingo");
			Element elementBola1 = document.createElement("bola");
			Element elementBola2 = document.createElement("bola");
			Element elementBola3 = document.createElement("bola");
			Element elementBola4 = document.createElement("bola");
			Element elementBola5 = document.createElement("bola");
			Element elementBola6 = document.createElement("bola");
			
			// 3. Establecimiento de las relaciones.
			elementBingo.appendChild(elementBola1);
			elementBingo.appendChild(elementBola2);
			elementBingo.appendChild(elementBola3);
			elementBingo.appendChild(elementBola4);
			elementBingo.appendChild(elementBola5);
			elementBingo.appendChild(elementBola6);
			elementBola1.setAttribute("numero", "1");
			elementBola2.setAttribute("numero", "2");
			elementBola3.setAttribute("numero", "3");
			elementBola4.setAttribute("numero", "4");
			elementBola5.setAttribute("numero", "5");
			elementBola6.setAttribute("numero", "6");
			document.appendChild(elementBingo);
			
			// Imprimir
			Utilidades.imprimirXml(document);
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

}
