package com.ies.baroja;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class ProcesarXml {

	public static void main(String[] args) {
		Utilidades.procesarArchivo("src\\ejemplosxml\\practica2.xml");
	}
}
