package com.ies.baroja;

public class Actfo1 {

	public static void main(String[] args) {
		Utilidades.GenerarPDF("src\\xml\\actfo1.xsl", "src\\xml\\actfo1.xml", "src\\output\\actfo1.pdf");

		String sArchivoXml = "src\\xml\\actfo2.xsl";
		String sPOFSalida = "src\\output\\actfo2.png";

		try {
			Utilidades.generarPdf(sArchivoXml, sPOFSalida);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error al convertir el archivo");
		}
		System.out.println("Fin Actividad resuelta 62");
		
		Utilidades.GenerarPDF("src\\xml\\actfo4.xsl", "src\\xml\\actfo4.xml", "src\\output\\actfo4.pdf");
	}
	
}
