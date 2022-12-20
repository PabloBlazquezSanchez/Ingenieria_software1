package Persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import Dominio.Entidades.Calendario;
import Dominio.Entidades.Horario;

public class HorarioDAO {

	public static Horario selectHorario(String fechatext) throws SQLException {

		Vector horasLaborable = GestorBaseDatos.getInstancia()
				.select("SELECT * FROM horario WHERE DIA='" + fechatext + "'");
		Horario h = null;
		horasLaborable = (Vector) horasLaborable.get(0);

		if (horasLaborable.isEmpty()) {
			System.out.println("Error");
		} else {
			String inicio = (String) horasLaborable.get(1);
			String fin = (String) horasLaborable.get(2);
			h = new Horario(inicio, fin);
		}
		return h;
	}

	public int nuevoHorario(Horario aH) {
		throw new UnsupportedOperationException();
	}
}