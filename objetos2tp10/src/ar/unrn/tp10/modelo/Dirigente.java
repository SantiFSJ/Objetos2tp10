package ar.unrn.tp10.modelo;

public class Dirigente implements PersonaDelFutbol{
	private String insulto;
	private String nombre;
	
	public Dirigente(String nombre,String insulto) {
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
