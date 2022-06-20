package ar.unrn.tp10.persistencia;

import java.io.File;
//import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileImpl {
	public void archivar(String nombreJugador, String insulto, String nombreArbitro) throws IOException {
		File miArchivo = new File("RegistroDeInsultos.txt");

		miArchivo.createNewFile();
		//FileOutputStream oFile = new FileOutputStream(miArchivo, true);

		FileWriter myWriter = new FileWriter(miArchivo, true);
		myWriter.write("El jugador "+nombreJugador+" le dijo al arbitro "+nombreArbitro+" el siguiente insulto: "+insulto);
		myWriter.close();

	}
}
