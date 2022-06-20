package ar.unrn.tp10.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseImpl {
	private Connection dbConn;

	private static String url = "jdbc:mysql://localhost:3306/objetos2_tp10";
	protected static String user = "root";
	protected static String password = "";

	public void guardarInsulto(String nombreJugador, String insulto, String nombreArbitro) throws SQLException {

		this.dbConn = DriverManager.getConnection(url, user, password);

		PreparedStatement st = dbConn
				.prepareStatement("insert into insultos(nombre_jugador, insulto, nombre_arbitro)values(?,?,?)");
		try {
			st.setString(1, nombreJugador);
			st.setString(2, insulto);
			st.setString(3, nombreArbitro);
			st.executeUpdate();
		} finally {
			st.close();
		}

	}
}
