package com.ies.baroja;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class practica4 {

	public static void main(String[] args) {
		Document document = Utilidades.procesarArchivo("src\\ejemplosxml\\practica4.xml");
		procesarDocumentoAlternativo(document);
		imprimirMenoresde(document,40);
		contarEmpleados(document);
	}
	private static void procesarDocumentoAlternativo(Document document)	{
		// 1 obtener nodo raiz (listaempleados)
		Element nodoRaiz = document.getDocumentElement();
		// 2 Obtener la lista de empleados (NodeList)
		NodeList listaEmpleados = nodoRaiz.getElementsByTagName("empleado");
		// 3 con un for recorrer la lista de empleados
		for (int i = 0; i < listaEmpleados.getLength(); i++) {
			// 4 Obtenemos el elemento <empleado>
			Element elementEmpleadoActual = (Element) listaEmpleados.item(i);
			// 5 ahora de empleado obtenemos el nombre
			String sNombre = elementEmpleadoActual.getElementsByTagName("nombre").item(0).getTextContent();
			// 6 lo mostramos por consola
			System.out.println(sNombre);
		}	
	}
	
	private static void imprimirMenoresde(Document document,int edad) {
		Element nodoRaiz = document.getDocumentElement();
		NodeList listaEmpleados = nodoRaiz.getElementsByTagName("empleado");
		for (int i = 0; i < listaEmpleados.getLength(); i++) {
			Element elementEmpleadoActual = (Element) listaEmpleados.item(i);
			String sNombre = elementEmpleadoActual.getElementsByTagName("nombre").item(0).getTextContent();
			int edadempleado = Integer.parseInt (elementEmpleadoActual.getAttribute("edad"));
			if (edadempleado < edad) {
				System.out.println(sNombre+" es tiene "+edadempleado+" años.");
			}
		}	
	}
	
	private static void contarEmpleados(Document document) {
		Element nodoRaiz = document.getDocumentElement();
		NodeList listaEmpleados = nodoRaiz.getElementsByTagName("empleado");
		System.out.println("Total empleados: "+listaEmpleados.getLength());
	}	
}
	

