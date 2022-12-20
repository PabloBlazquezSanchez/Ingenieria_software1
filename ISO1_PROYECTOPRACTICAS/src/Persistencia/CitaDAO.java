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

	public Cita selectCita(Date aFecha, Especialista aEspAsignado, Paciente aPaciente) {
		throw new UnsupportedOperationException();
	}

	public int nuevaCita(Cita aC) {
		throw new UnsupportedOperationException();
	}
}