package Partido4;

public class Utilidades {
	// M�TODO SACADO DE INTERNET PARA DETECTAR CUANDO UN CADENA TIENE SOLO LETRAS
			public static boolean SoloLetras(String cadena) {
			    for (int x = 0; x < cadena.length(); x++) {
			        char c = cadena.charAt(x);
			        // Si no est� entre a y z, ni entre A y Z, ni es un espacio
			        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' '|| c == '�'|| c == '�')) {
			            return false;
			        }
			    }
			    return true;
			}
}
