package com.bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ies.baroja.Utilidades;

public class Actividad4 {
	private static String sConsulta = "SELECT matricula, modelo, marca FROM vehiculos;";
	public static void main (String[] args){ 
		listarVehiculos();
	}
	public static void listarVehiculos(){
		try
		{
			//primero conectamos a la bbdd
			ConexionBBDD miConexion = new ConexionBBDD();
			miConexion.conectar();
			//lanzamos la consulta
			ResultSet rsResultado= miConexion.ejecutarSentencia(sConsulta);
			if (rsResultado != null) {
				String matricula, modelo, marca;
				//si hay resultado recuperamos los datos(como un FETCH de un CURSOR)
				System.out.println("matricula \t modelo \t marca");
				while (rsResultado.next()) 
				{
					matricula = rsResultado.getString("matricula");
					modelo = rsResultado.getString("modelo");
					marca = rsResultado.getString("marca");
					System.out.println(matricula+"\t\t"+modelo+"\t\t"+marca);
				}
			}
			else {
				System.out.println("La consulta no devuelve resultados");
			}
			miConexion.desconectar();
			
		}catch (SQLException sqlex) {
			System.out.println("Error: "+sqlex.getMessage());
		}
	}
	
	private static void guardarVehiculos() {

		try {
			String sInsert="insert into vehiculos (matricula,modelo,marca) values (?,?,?)";
			// 1-conectamos a la BBDD
			ConexionBBDD miConexion = new ConexionBBDD();
			miConexion.conectar();
			// 2-leer el archivo xml
			Document document = Utilidades.procesarArchivo("src\\ejemplosxml\\Actividad5.xml");
			// 3-recorrer los nodos del xml
			// 3.1-obtener nodo raiz <vehiculos>
			Element nodoRaiz = document.getDocumentElement();
			// 3.2-obtener la lista de vehiculos (NodeList)
			NodeList listaLibros = nodoRaiz.getChildNodes();
			// 3.3-con un for recorrer la lista de vehiculos
			for (int i = 0; i < listaLibros.getLength(); i++) {
				// 3.4-Obtenemos el elemento <vehiculo>
				Node libroActual = listaLibros.item(i);
				if (libroActual.getNodeType() == Node.ELEMENT_NODE) {
					Element elementLibroActual = (Element) libroActual;
					boolean hayDigital = Boolean.parseBoolean(elementLibroActual.getAttribute("digital"));
					if (hayDigital) {
						System.out.println(elementLibroActual.getElementsByTagName("titulo").item(0).getTextContent());
					}
					// 3.3-con un for recorrer la lista de vehiculos
				}
			}
		} catch(Exception sqlex) {
			System.out.println("Error "+sqlex.getMessage());
		}
	}

}
