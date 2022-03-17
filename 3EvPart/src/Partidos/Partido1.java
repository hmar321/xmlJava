package Partidos;

/*
 Adjunta el código java que guarde en un array para las notas de 6 módulos, de las 3 evaluaciones de 30 personas de primer y  un array para las notas de 6 módulos, 
 de las 2 evaluaciones de 30 personas de segundo  curso.

(1 punto) Las notas las tiene que pedir por teclado, de todos los alumnos de cada módulo en cada evaluación de cada curso. 
Además de las notas, en la primera celda del array se guarda el nombre del alumno

(1 punto) Las notas tienen que ser un nº entero entre 1 y 10 o una “C”. Si el usuario no introduce la nota correctamente, 
se vuelve a pedir por teclado informando al usuario de la nota que tiene que volver a introducir: 
“Nota errónea, vuelve  a introducir la nota del alumno "Luis" del módulo 1 de la evaluación 2 del curso 1”. Si el alumno convalida, 
pone una "C" y tiene que aparecer una "C" en las 3 evaluaciones.
(1 punto) Visualización
*/
import java.util.Scanner;

public class Partido1 {

	public static void main(String[] args) {
		String notas1[][][] = new String[30][6][4];//array para los de primero
		String notas2[][][] = new String[30][6][3];//array para los de segundo
		Scanner entrada = new Scanner(System.in);
		int evaluacion, modulo, alumno, iNota, curso, valor1, valor2, valor3, media;
		String nombre, sNota;
		evaluacion = 1;//para la evaluacion
		modulo = 1;//para el modulo
		alumno = 1;//para el alumno
		for (curso = 1; curso <= 2; curso++) {// for para cada curso
			for (alumno = 1; alumno <= 30; alumno++) {// for para los 30 alumnos
				System.out.println("Nombre del alumno");// nombre del alumno
				nombre = entrada.nextLine();
				notas1[alumno - 1][0][0] = nombre;// se guarda el nombre
				for (modulo = 1; modulo <= 6; modulo++) {// for para los modulos
					for (evaluacion = 1; evaluacion <= 3; evaluacion++) {// for para cada evaluacion
						do {// do while para asegurar que la nota es correcta 
							System.out.println("Curso " + curso + " NOTA del alumno " + alumno + " " + nombre + " modulo "
											+ modulo + " evaluacion " + evaluacion + " (1 al 10 o bien la letra c)");
							sNota = entrada.nextLine();// pregunto por la nota
							if (sNota.equals("c")) {// si convalida
								if (curso == 1) {// y estamos en el primer curso
									notas1[alumno - 1][modulo - 1][evaluacion] = sNota;// todas las notas 
									notas1[alumno - 1][modulo - 1][evaluacion + 1] = sNota;// del modulo
									notas1[alumno - 1][modulo - 1][evaluacion + 2] = sNota;// son c
									evaluacion = 3;// pasa salir del for de las evaluaciones
								} else {// si no estamos en el primer curso estaremos en el segundo
									notas2[alumno - 1][modulo - 1][evaluacion] = sNota;// todas las notas a c
									notas2[alumno - 1][modulo - 1][evaluacion + 1] = sNota;
									evaluacion = 3;// pasa salir del for de las evaluaciones
								}
							} else {// si no convalida se pasa la nota a int y se comprueba que sea correcta
								if (esNumerico(sNota)) {// si es numerico
									iNota = Integer.parseInt(sNota);// paso la nota a int
									if (iNota > 10 || iNota < 1) {// si no es correcta
										sNota = "0";// utilizo esta variable para impedir que se salga del for
										System.out.println("Has cometido algun error repite la nota.");// aviso
									} else {// si es correcta continuas y guardo la nota
										if (curso == 1) {// si estamos en el primer curso
											notas1[alumno - 1][modulo - 1][evaluacion] = sNota;// guardo en el array del primer curso
											System.out.println("Continua");
										} else {// si no
											notas2[alumno - 1][modulo - 1][evaluacion] = sNota;// guardo en el array del segundo curso
											System.out.println("Continua");
											while (evaluacion == 2) {// como estamos en el curso 2 no hay 3ra evaluacion
												evaluacion = 3;// nos salimos del for

											}
										}
									}
								}else {// aviso de que no se sale del do while
									sNota = "0";
									System.out.println("Utiliza los parametros recomendados (1 al 10)(letra c)");
								}
							}
						} while (sNota.equals("0"));// el proceso se repite mientras avise y puede dar error si el usuario no utiliza los parametros aconsejados
					}
					// por cada modulo
					if (curso == 1) {// si estamos en primero
						valor1 = Integer.parseInt(notas1[alumno - 1][modulo - 1][1]);
						valor2 = Integer.parseInt(notas1[alumno - 1][modulo - 1][2]);
						valor3 = Integer.parseInt(notas1[alumno - 1][modulo - 1][3]);
						media = (valor1 + valor2 + valor3) / 3;// paso todos los datos a int y hago la media
						System.out.println("Las notas de " + notas1[alumno - 1][0][0] + ", alumno " + alumno
								+ ", del módulo " + modulo + " del curso 1 son: " + valor1 + "," + valor2 + "," + valor3
								+ ". Y la media es un " + media + ".");
					} else {// estaremos en segundo
						valor1 = Integer.parseInt(notas2[alumno - 1][modulo - 1][1]);
						valor2 = Integer.parseInt(notas2[alumno - 1][modulo - 1][2]);
						media = (valor1 + valor2) / 2;// paso todos los datos a int y hago la media
						System.out.println("Las notas de " + notas2[alumno - 1][0][0] + ", alumno " + alumno
								+ ", del módulo " + modulo + " del curso 1 son: " + valor1 + "," + valor2
								+ ". Y la media es un " + media + ".");
					}
				}
			}

		}
	}
	private static boolean esNumerico(String texto){// metodo para ver si es un numero
		try {
			Integer.parseInt(texto);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
}

