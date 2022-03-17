package Partidos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Personas {

	// ATRIBUTOS
	// Usamos PROTECTED, que indica que es un atributo o método
	// visible para las clases hijas y no desde otra clase

	protected String dni;
	protected String nombre;
	protected String apellido;
	protected String fechaNacimiento;
	protected String ciudad;
	protected String pais;
	protected int edad;

	// MÉTODO CONSTRUCTOR
	public Personas(String dni, String nombre, String apellido, /* LocalDate */String fechaNacimiento, String ciudad,
			String pais, int edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudad = ciudad;
		this.pais = pais;
		this.edad = edad;

	}

	// MÉTODO PARA CALCULAR LA EDAD: (sacado de internet)
	// No funciona al ser FechaNacimiento LocalDate
	public int edad(String[] fechaNacimiento) {
		Date fechaActual = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String hoy = formato.format(fechaActual);
		String[] dat1 = fechaNacimiento;
		String[] dat2 = hoy.split("/");
		int anos = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
		int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
		if (mes < 0) {
			anos = anos - 1;
		} else if (mes == 0) {
			int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
			if (dia > 0) {
				anos = anos - 1;
			}
		}
		return anos;
	}
}
