package Partidos;

public class Jugadores extends Personas {

	// ATRIBUTOS
	protected int dorsal;
	protected String equipo;
	protected String posicion;
	protected String comentario;

	public Jugadores(String dni, String nombre, String apellido, String fechaNacimiento, String ciudad, String pais,
			int edad, int dorsal, String equipo, String posicion, String comentario) {
		super(dni, nombre, apellido, fechaNacimiento, ciudad, pais, edad);
		this.dorsal = dorsal;
		this.equipo = equipo;
		this.posicion = posicion;
		this.comentario = comentario;

	}

	// Sobre escrito del metodo heredado añadiendo los nuevos atributos
	@Override
	public void mostrarDatos() {
		System.out.println("DNI: " + dni + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nFecha de nacimiento: "
				+ fechaNacimiento + "\nCiudad :" + ciudad + "\nPais: " + pais+"\nEdad: " + edad);
		System.out.println("Dorsal: " + dorsal + "\nEquipo: " + equipo + "\nPosición: " + posicion+"\nComentario: " + comentario);
	}

}