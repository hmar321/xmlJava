package com.ies.baroja;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Resuelta5_1 {

	public static void main(String[] args) {
		
		Document document = Utilidades.procesarArchivo("src\\ejemplosxml\\Resuelta5-1.xml");
		Element nodoRaiz = document.getDocumentElement();
		NodeList listaLibros = nodoRaiz.getChildNodes (); 
		for (int i = 0; i <listaLibros.getLength() ; i++) {
			Node libroActual = listaLibros.item(i);
			if (libroActual.getNodeType () == Node.ELEMENT_NODE) {
				Element elementLibroActual = (Element) libroActual;
				boolean hayDigital = Boolean.parseBoolean (elementLibroActual.getAttribute ("digital"));
				if (hayDigital) {
					System.out.println (elementLibroActual.getElementsByTagName("titulo").
					item (0).
					getTextContent());
				}
			}
		}
	}
}

