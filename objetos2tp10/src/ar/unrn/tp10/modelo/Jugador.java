package ar.unrn.tp10.modelo;

public class Jugador implements PersonaDelFutbol {
	private String insulto;
	private String nombre;
	
	public Jugador(String nombre,String insulto){
		this.nombre = nombre;
		this.insulto = insulto;
	}
	
	public void insultarA(Arbitro unArbitro) {
		unArbitro.escuchar(this.insulto());
	}
	
	public String insulto() {
		return this.insulto;
	}
	
	public String nombre() {
		return this.nombre;
	}
	
}
