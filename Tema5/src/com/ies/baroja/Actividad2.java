package com.ies.baroja;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Actividad2 {

	public static void main(String[] args) {

		Document document = Utilidades.procesarArchivo("src\\ejemplosxml\\Actividad1.xml");
		Element nodoRaiz = document.getDocumentElement();
		NodeList listaPersonas = nodoRaiz.getChildNodes();
		for (int i = 0; i < listaPersonas.getLength(); i++) {
			Node personaActual = listaPersonas.item(i);
			if (personaActual.getNodeType() == Node.ELEMENT_NODE) {
				Element elementPersonaActual = (Element) personaActual;
				boolean esMayor = Boolean.parseBoolean(elementPersonaActual.getAttribute("mayor"));
				if (esMayor) {
					System.out.println(elementPersonaActual.getElementsByTagName("nombre").item(0).getTextContent());
				}
			}
		}
	}

}
