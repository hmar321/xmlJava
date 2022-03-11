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

	public static void main(String[] args) {
		//listarVehiculos();
		guardarVehiculos();
	}

	public static void listarVehiculos() {
		try {
			// primero conectamos a la bbdd
			ConexionBBDD miConexion = new ConexionBBDD();
			miConexion.conectar();
			// lanzamos la consulta
			ResultSet rsResultado = miConexion.ejecutarSentencia(sConsulta);
			if (rsResultado != null) {
				String matricula, modelo, marca;
				// si hay resultado recuperamos los datos(como un FETCH de un CURSOR)
				System.out.println("matricula \t modelo \t marca");
				while (rsResultado.next()) {
					matricula = rsResultado.getString("matricula");
					modelo = rsResultado.getString("modelo");
					marca = rsResultado.getString("marca");
					System.out.println(matricula + "\t\t" + modelo + "\t\t" + marca);
				}
			} else {
				System.out.println("La consulta no devuelve resultados");
			}
			miConexion.desconectar();

		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		}
	}

	private static void guardarVehiculos() {

		try {

			// 1-conectamos a la BBDD
			ConexionBBDD miConexion = new ConexionBBDD();
			miConexion.conectar();
			// 2-leer el archivo xml
			Document document = Utilidades.procesarArchivo("src\\ejemplosxml\\Actividad4.xml");
			// 3-recorrer los nodos del xml
			// 3.1-obtener nodo raiz <vehiculos>
			Element nodoRaiz = document.getDocumentElement();
			// 3.2-obtener la lista de vehiculos (NodeList)
			NodeList listaVehiculos = nodoRaiz.getChildNodes();
			// 3.3-con un for recorrer la lista de vehiculos
			for (int i = 0; i < listaVehiculos.getLength(); i++) {
				// 3.4-Obtenemos el elemento <vehiculo>
				Node vehiculoActual = listaVehiculos.item(i);
				if (vehiculoActual.getNodeType() == Node.ELEMENT_NODE) {
					Element elementvehiculoActual = (Element) vehiculoActual;
					// 3.5-ahora del elementVehiculoActual obtenemos matricula modelo y marca
					String sMatricula = elementvehiculoActual.getElementsByTagName("matricula").item(0)
							.getTextContent();
					String sModelo = elementvehiculoActual.getElementsByTagName("modelo").item(0).getTextContent();
					String sMarca = elementvehiculoActual.getElementsByTagName("marca").item(0).getTextContent();
					// 3.6-llamamos al método insertarVehiculo pasamos la sentencia y los 3
					// atributos
					String sInsert = "insert into vehiculos (matricula,modelo,marca) values ('"+ sMatricula + "','"
							+ sModelo + "','" + sMarca + "');";
					int iRes = miConexion.insertarVehiculo(sInsert,sMatricula,sMarca,sModelo);
					System.out.println(iRes);
				}

			}
		} catch (Exception sqlex) {
			System.out.println("Error " + sqlex.getMessage());
		}
	}

}
