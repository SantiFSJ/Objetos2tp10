package ar.unrn.tp10.aspectos;

import java.io.IOException;
import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import ar.unrn.tp10.modelo.Arbitro;
import ar.unrn.tp10.modelo.Jugador;
import ar.unrn.tp10.modelo.PersonaDelFutbol;
import ar.unrn.tp10.persistencia.DataBaseImpl;
import ar.unrn.tp10.persistencia.FileImpl;

@Aspect
public class Registracion {
	@Before("execution(* ar.unrn.tp10.modelo.*.insultarA(..))")
		public void registrar(JoinPoint joinPoint) {
		PersonaDelFutbol personaDelFutbol = (PersonaDelFutbol) joinPoint.getThis();
		Arbitro unArbitro = (Arbitro) joinPoint.getArgs()[0];
		System.out.print("Registración: El jugador "
		+ personaDelFutbol.nombre()
		+ " le dijo " + personaDelFutbol.insulto() 
		+ " al árbitro " + unArbitro.nombre());
	}
	
	@Before("execution(* ar.unrn.tp10.modelo.*.insultarA(..))")
	public void registrarEnArchivo(JoinPoint joinPoint) {
		PersonaDelFutbol personaDelFutbol = (PersonaDelFutbol) joinPoint.getThis();
		Arbitro unArbitro = (Arbitro) joinPoint.getArgs()[0];
		FileImpl archivador = new FileImpl();
		try {
			archivador.archivar(personaDelFutbol.nombre(), personaDelFutbol.insulto(), unArbitro.nombre());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Before("execution(* ar.unrn.tp10.modelo.*.insultarA(..))")
	public void registrarEnBaseDeDatos(JoinPoint joinPoint) {
		PersonaDelFutbol personaDelFutbol = (PersonaDelFutbol) joinPoint.getThis();
		Arbitro unArbitro = (Arbitro) joinPoint.getArgs()[0];
		DataBaseImpl mySql = new DataBaseImpl();
		try {
			mySql.guardarInsulto(personaDelFutbol.nombre(), personaDelFutbol.insulto(), unArbitro.nombre());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
