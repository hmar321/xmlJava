package com.ies.baroja;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.xmlgraphics.util.MimeConstants;

public class Utilidades {

	public static void GenerarPDF(String rutasxl, String rutaxml, String rutaGuardado) {

		try {
			// Nombre del archivo FO
			File xsltFile = new File(rutasxl);
			// Archivo XML que proveer? de datos
			StreamSource xmlSource = new StreamSource(new File(rutaxml));
			FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
			FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
			OutputStream out;
			// Archivo PDF
			out = new FileOutputStream(rutaGuardado);
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
			TransformerFactory factory = TransformerFactory.newInstance();
			Result res = new SAXResult(fop.getDefaultHandler());
			Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));
			transformer.transform(xmlSource, res);
			out.close();
			System.out.println("PDF generado correctamente en la carpeta output");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void GenerarPNG(String rutasxl,String rutaxml,String rutaGuardado) {

		try {
			// Nombre del archivo FO
			File xsltFile = new File(rutasxl);
			// Archivo XML que proveer? de datos
			StreamSource xmlSource = new StreamSource(new File(rutaxml));
			FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
			FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
			OutputStream out;
			// Archivo PNG
			out = new FileOutputStream(rutaGuardado);
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PNG, foUserAgent, out);
			TransformerFactory factory = TransformerFactory.newInstance();
			Result res = new SAXResult(fop.getDefaultHandler());
			Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));
			transformer.transform(xmlSource, res);
			out.close();
			System.out.println("PNG generado correctamente en la carpeta output");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public static void generarPdf (String xmlEntrada, String archivoSalida) throws TransformerConfigurationException,
	FileNotFoundException, FOPException, TransformerException, IOException {
	//archivo XML que proveer? de datos
	StreamSource xmlSource = new StreamSource(new File(xmlEntrada));
	FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
	FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
	OutputStream out;
	//Archivo PDF
	out = new FileOutputStream(archivoSalida);
	Fop fop = fopFactory.newFop(MimeConstants.MIME_PNG,foUserAgent,out);
	TransformerFactory factory = TransformerFactory.newInstance();
	Transformer transformer = factory.newTransformer();
	Result res = new SAXResult (fop.getDefaultHandler());
	transformer.transform(xmlSource, res);
	out.close();
	System.out.println("Archivo generado correctamente en la carpeta output");
	}
}
