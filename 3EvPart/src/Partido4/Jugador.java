package Partido4;

import java.util.Scanner;

public class Jugador extends Persona {
	// ATRIBUTOS

	// CONSTRUCTOR
	public Jugador(String _nombre, double _alturaM, double _pesoKg, double _imc) {
		this.aNombre = _nombre;
		this.aAlturaM = _alturaM;
		this.aPesoKg = _pesoKg;
		this.aImc = _imc;
	}

	// ESTADO DE LOS JUGADORES
	@Override
	public void Estado() {
		if (aImc < 18) {
			System.out.println("el estado del jugador es Bajo Peso");
		} else if (aImc >= 18 && aImc < 22) {
			System.out.println("el estado del jugador es Peso normal");
		} else if (aImc > 22 && aImc < 25) {
			System.out.println("el estado del jugador es Sobrepeso");
		} else {
			System.out.println("Buff, algo raro pasa, ¿eres deportista? Consulta al médico o al informático");
		}
	}

	// MOSTRAR DATOS
	@Override
	public void MostrarDatos() {
		System.out.println("Nombre :" + aNombre + "\nAltura: " + aAlturaM + "\nPeso: " + aPesoKg + "\nIMC: " + aImc);
	}
	public static void ElegirJugador(Jugador[] Jugadores) {
		Scanner teclado = new Scanner(System.in);// TECLADO
		String sContinuar;	
		do {
			System.out.println("¿Seguir mostrando datos?(\"continuar\" para seguir)");
			sContinuar = teclado.nextLine();
			System.out.println("Posición del jugador en el Array");
			int posicion = teclado.nextInt();
			teclado.nextLine(); // PARA EVITAR UN SALTO DE LÍNEA(PUEDE PASAR CON INT O DOUBLE)
			Jugadores[posicion-1].MostrarDatos();
		} while (sContinuar.equals("continuar"));
	}
	// INSERTAR DATOS
	public static void GuardarJugadores(Jugador[] Jugadores) {
		Scanner teclado = new Scanner(System.in);// TECLADO
		boolean bEsLetra;
		String sNombre;
		double dAltura, dPeso, dImc;
		for (int i = 1; i <= Jugadores.length; i++) {
			System.out.println("¿Dejar de insertar datos?(\"salir\" para salir)");
			String salir = teclado.nextLine();
			
			// IF PARA PARAR DE INSERTAR DATOS
			if (salir.equals("salir")) {
				i = 26;// PARA SALIR DEL FOR
			} else {
				// INSERTAR DATOS POR CONSOLA
				do {
					System.out.println("Nombre(solo letras)");
					sNombre = teclado.nextLine();
					bEsLetra=Utilidades.SoloLetras(sNombre);// APLICO METODO SACADO DE INTERNET
				} while (!bEsLetra);// ES LO MISMO QUE "bEsLetra==false"
				do {
					System.out.println("Altura(de 0.1 a 3 metros)");
					dAltura = teclado.nextDouble();
				} while (dAltura<0.1||dAltura>3);// ALTURA DE 0.1 A 3 METROS
				
				do {
					System.out.println("Peso(de 1 a 500 Kg)");
					dPeso = teclado.nextDouble();
				} while (dPeso<1||dPeso>500);// PESO DE 1 A 500 KG
				
				do {
					System.out.println("IMC(de 15 a 50 Kg/m²)");
					dImc = teclado.nextDouble();
					teclado.nextLine(); // PARA EVITAR UN SALTO DE LÍNEA(PUEDE PASAR CON INT O DOUBLE)
				} while (dImc<15||dImc>50);// IMC DE 15 A 50 KG/M²
				
				Jugadores[i - 1] = new Jugador(sNombre, dAltura, dPeso, dImc);
			}

		}

	}
	
}