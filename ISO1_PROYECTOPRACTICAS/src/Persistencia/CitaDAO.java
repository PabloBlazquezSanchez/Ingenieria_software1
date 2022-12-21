package Persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import Dominio.Entidades.Cita;
import Dominio.Entidades.Especialista;
import Dominio.Entidades.Paciente;
import Dominio.Entidades.Slot;

public class CitaDAO {
	public static ArrayList<Slot> selectSlotsSingAsignar() throws SQLException {
		Vector huecoslibres = GestorBaseDatos.getInstancia().select("SELECT * FROM slot WHERE TIPOSLOT='sin_asignar'");
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

	public static String selectCitaAnterior(String dnipaciente, String especialidad) throws SQLException {
		Vector citasanteriores = GestorBaseDatos.getInstancia()
				.select("SELECT * FROM cita WHERE DNIPACIENTE='" + dnipaciente+"'");
		String dni = "";
		System.out.println(citasanteriores.size());
		for (int i = 0; i < citasanteriores.size(); i++) {

			Vector cita = (Vector) citasanteriores.get(i);
			if (cita.get(3).toString().toLowerCase().equals(especialidad)) {
				dni = (String) cita.get(2);
			}
		}
		return dni;
	}

	public int nuevaCita(Cita aC) {
		throw new UnsupportedOperationException();
	}

	public static int nuevaCita(String dnipac, String dniesp, String especialidad, int id) throws SQLException {
		return GestorBaseDatos.getInstancia().insert("INSERT INTO cita (IDSLOT, DNIPACIENTE, DNITRABAJADOR, TIPOCITA) VALUES ('"
				+id+"', '"
				+ dnipac+"', '"
				+ dniesp+"', '"
				+ especialidad+"')");
		
	}
}