package Persistencia;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import Dominio.Entidades.Paciente;
import Dominio.Entidades.Slot;

public class SlotDAO {
	public static ArrayList<Slot> selectSlotsSingAsignar() throws SQLException {
		Vector huecoslibres = GestorBaseDatos.getInstancia().select("SELECT * FROM slot WHERE TIPOSLOT='clinica'AND DNIESPECIALISTA='FALSE'");
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
				boolean ocupado= (boolean) huecoindividual.get(6);
				huecos_libres.add(new Slot(inicio, fin, dia, id, dni, tiposlot, ocupado));
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
	/*
	 * public static int modificarSlot (String fecha, Paciente p, String inicio,
	 * String tipo, String dniesp) throws SQLException {
	 * 
	 * GestorBaseDatos.getInstancia().update("UPDATE slot SET " + "tiposlot='" +
	 * tipo + "' WHERE DNIESPECIALISTA='"+ dniesp+"' AND INICIO='"+inicio+"'");
	 * 
	 * 
	 * }
	 */
}
