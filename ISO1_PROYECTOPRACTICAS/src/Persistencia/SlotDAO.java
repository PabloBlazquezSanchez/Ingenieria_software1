package Persistencia;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import Dominio.Entidades.Paciente;
import Dominio.Entidades.Slot;

public class SlotDAO {
	public static ArrayList<Slot> selectSlotsClinica() throws SQLException {
		Vector huecoslibres = GestorBaseDatos.getInstancia()
				.select("SELECT * FROM slot WHERE TIPOSLOT='clinica' AND OCUPADO='false'");
		ArrayList<Slot> huecos_libres = new ArrayList<Slot>();
		if (huecoslibres.isEmpty()) {
			System.out.println("Error");
		} else {
			for (int i = 0; i < huecoslibres.size(); i++) {
				Vector huecoindividual = (Vector) huecoslibres.get(i);
				Date inicio = (Date) huecoindividual.get(0);
				Date fin = (Date) huecoindividual.get(1);
				Date dia = (Date) huecoindividual.get(2);
				String dni = (String) huecoindividual.get(3);
				String tiposlot = (String) huecoindividual.get(4);
				int id = (Integer) huecoindividual.get(5);
				huecos_libres.add(new Slot(inicio, fin, dia, id, dni, tiposlot));
			}
		}
		return huecos_libres;
	}

	public static int obtenerID(String dniespecialista, String inicio, String dia) throws SQLException {
		Vector<Object> id_slot = GestorBaseDatos.getInstancia()
				.select("SELECT id FROM slot WHERE TIPOSLOT='clinica' AND DNIESPECIALISTA='" + dniespecialista
						+ "' AND INICIO='" + inicio + "' AND DIA='" + dia + "'");
		Vector huecoindividual = (Vector) id_slot.get(0);
		int id = (int) huecoindividual.get(0);
		return id;

	}

	public static int ocupado(int id) throws SQLException {
		return GestorBaseDatos.getInstancia().update("UPDATE slot SET OCUPADO='true' WHERE ID=" + id + "") + 1;
	}

	public static ArrayList<Slot> selectSinAsignar(String fecha) throws SQLException {
		Vector huecoslibres = GestorBaseDatos.getInstancia().select("SELECT * FROM slot WHERE TIPOSLOT='sin_asignar' AND OCUPADO='false' AND DIA='"+fecha+"'");
		ArrayList<Slot> huecos_libres = new ArrayList<Slot>();
		if (huecoslibres.isEmpty()) {
			System.out.println("Error");
			return null;
		} else {
			for (int i = 0; i < huecoslibres.size(); i++) {
				Vector huecoindividual = (Vector) huecoslibres.get(i);
				Date inicio = (Date) huecoindividual.get(0);
				Date fin = (Date) huecoindividual.get(1);
				Date dia = (Date) huecoindividual.get(2);
				String dni = (String) huecoindividual.get(3);
				String tiposlot = (String) huecoindividual.get(4);
				int id = (Integer) huecoindividual.get(5);
				huecos_libres.add(new Slot(inicio, fin, dia, id, dni, tiposlot));
			}
		}
		return huecos_libres;
	}
}
