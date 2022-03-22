package Partido4;

public class Principal {

	public static void main(String[] args) {
		Jugador[] Jugadores = new Jugador[25];// ARRAY DE JUGADORES
		Jugador.GuardarJugadores(Jugadores);
		Jugador.ElegirJugador(Jugadores);
	}

}
