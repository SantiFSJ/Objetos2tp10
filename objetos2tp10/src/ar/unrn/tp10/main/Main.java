package ar.unrn.tp10.main;

import ar.unrn.tp10.modelo.Arbitro;
import ar.unrn.tp10.modelo.Dirigente;
import ar.unrn.tp10.modelo.Jugador;
import ar.unrn.tp10.modelo.Tecnico;

public class Main {

	public static void main(String[] args) {
		Arbitro pitana = new Arbitro("Pitana");
		Jugador messi = new Jugador("Messi","nefasto");
		Tecnico scaloni = new Tecnico("Scaloni","impresentable");
		Dirigente tapia = new Dirigente("Tapia","vendido");
		messi.insultarA(pitana);
		scaloni.insultarA(pitana);
		tapia.insultarA(pitana);
	}

}
