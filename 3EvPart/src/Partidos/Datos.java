package Partidos;

import java.util.Scanner;

//Adjunta el código que crea un array de tamaño 25 con los datos de 5 Jugadores
public class Datos {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);//teclado
		int n;// para elegir jugador del cual se mostraran los datos
		Personas[] Jugador = new Jugadores[25];// array de jugadores
		// datos insertados y guardados a mano
		Personas jugador1 = new Jugadores("02022323L", "Elvis", "Nieto", "23/08/1995", "Leganes", "Zimbawe", 23, 0,
				"Panatinaikos", "MCO", "Comentarios...");
		Personas jugador2 = new Jugadores("23636564P", "Jacobo", "Ludo", "05/01/1984", "Leganes", "Israel", 34, 6,
				"Panatinaikos", "MCO", "Comentarios...");
		Personas jugador3 = new Jugadores("68438168K", "Armando", "Bronca", "03/08/1985", "Leganes", "Rumania", 33, 7,
				"Panatinaikos", "MCO", "Comentarios...");
		Personas jugador4 = new Jugadores("65415936H", "Zacarias", "Flores", "16/04/1982", "Leganes", "Escocia", 36, 3,
				"Panatinaikos", "MCO", "Comentarios...");
		Personas jugador5 = new Jugadores("36948952R", "Víctor", "Tazo", "20/10/1997", "Leganes", "Perú", 21, 4,
				"Panatinaikos", "MCO", "Comentarios...");
		Jugador[0] = jugador1;
		Jugador[1] = jugador2;
		Jugador[2] = jugador3;
		Jugador[3] = jugador4;
		Jugador[4] = jugador5;
		// For para insertar datos por consola
		for (int i = 6; i <= Jugador.length; i++) {
			System.out.println("¿Dejar de insertar datos?(\"si\" para salir)");
			String salir = teclado.nextLine();
			// if para dejar de insertar datos
			if (salir.equals("si")) {
				i = 26;// para salir del for
			} else {
				// Insertas datos por consola y se guarda dentro del array
				System.out.println("Jugador " + i);
				System.out.println("DNI(String)");
				String sDni = teclado.nextLine();
				System.out.println("Nombre(String)");
				String sNombre = teclado.nextLine();
				System.out.println("Apellido(String)");
				String sApellido = teclado.nextLine();
				System.out.println("Fecha de nacimiento(dd/mm/yyyy)");
				String sFechaNac = teclado.nextLine();
				System.out.println("Ciudad(String)");
				String sCiudad = teclado.nextLine();
				System.out.println("País(String)");
				String sPais = teclado.nextLine();
				System.out.println("Edad(Int)");
				int iEdad = teclado.nextInt();
				System.out.println("Dorsal(Int)");
				int iDorsal = teclado.nextInt();
				teclado.nextLine(); // Para evitar un salto de linea tras un Int o un Double
				System.out.println("Equipo(String)");
				String sEquipo = teclado.nextLine();
				System.out.println("Posición(String)");
				String sPosicion = teclado.nextLine();
				System.out.println("Comentario(String)");
				String sComentario = teclado.nextLine();
				Jugador[i - 1] = new Jugadores(sDni, sNombre, sApellido, sFechaNac, sCiudad, sPais, iEdad, iDorsal,
						sEquipo, sPosicion, sComentario);
			}
		}
		// Elige el jugador del cual quieres ver los datos
		System.out.println("Datos de jugador(1 al 25)");
		n = teclado.nextInt();
		Jugador[n - 1].mostrarDatos();
	}
}
