package Partido4;

public class Utilidades {
	// MÉTODO SACADO DE INTERNET PARA DETECTAR CUANDO UN CADENA TIENE SOLO LETRAS
			public static boolean SoloLetras(String cadena) {
			    for (int x = 0; x < cadena.length(); x++) {
			        char c = cadena.charAt(x);
			        // Si no está entre a y z, ni entre A y Z, ni es un espacio
			        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' '|| c == 'ñ'|| c == 'Ñ')) {
			            return false;
			        }
			    }
			    return true;
			}
}
