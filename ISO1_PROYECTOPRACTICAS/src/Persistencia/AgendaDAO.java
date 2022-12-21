package Persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import Dominio.Entidades.Agenda;
import Dominio.Entidades.Slot;

public class AgendaDAO {

	public Agenda selectAgenda() {
		throw new UnsupportedOperationException();
	}

	public int nuevaAgenda(Agenda aA) {
		throw new UnsupportedOperationException();
	}

	public static int modificarAgenda(String dniesp, String fecha, int id) throws SQLException {
		Vector huecoslibres = GestorBaseDatos.getInstancia()
				.select("SELECT SLOTS FROM agenda WHERE DNIESPECIALISTA='" + dniesp + "'AND DIA='" + fecha + "'");
		Vector huecoindividual = (Vector) huecoslibres.get(0);
		String slots = (String) huecoindividual.get(0);
		String nuevoSlot = slots + ", " + id;
		return GestorBaseDatos.getInstancia().update("UPDATE agenda SET SLOTS='" + nuevoSlot
				+ "' WHERE DNIESPECIALISTA='" + dniesp + "'AND DIA='" + fecha + "'") + 1;
	}
}