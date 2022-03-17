package Partidos;

import java.util.Scanner;
/*String dni, 
 * String nombre, 
 * String apellido, 
 * String fechaNacimiento, 
 * String ciudad, 
 * String pais,
	int edad, 
	int dorsal, 
	String equipo, 
	String posicion, 
	String comentario*/
public class Datos {
	public static void main(String[]args) {
		Jugadores jugador1 = new Jugadores("02022323L", "Ambrosio", 
				"Dlune", "23/08/1995" , "Leganes", "Zimbawe", 23, 0,
				"Panatinaikos", "MCO", "Comentarios...");
		Jugadores jugador2 = new Jugadores("23636564P", "Alonso", 
				"Castro", "05/01/1984" , "Leganes", "Israel", 34, 6,
				"Panatinaikos", "MCO", "Comentarios...");
		Jugadores jugador3 = new Jugadores("68438168L", "Pedro", 
				"Preda", "03/08/1985" , "Leganes", "Zimbawe", 33, 7,
				"Panatinaikos", "MCO", "Comentarios...");
		Jugadores jugador4 = new Jugadores("02022323L", "manuel", 
				"Dlune", "23/08/1995" , "Leganes", "Zimbawe", 23, 3,
				"Panatinaikos", "MCO", "Comentarios...");
		Jugadores jugador5 = new Jugadores("02022323L", "Ambrosio", 
				"Dlune", "23/08/1995" , "Leganes", "Zimbawe", 23, 4,
				"Panatinaikos", "MCO", "Comentarios...");
		Jugadores[] Jugador=new Jugadores[25];
		Jugador[0]=jugador1;
		jugador1.mostrarDatos();
	}
}
