package Persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import Dominio.Entidades.Calendario;

public class CalendarioDAO {

	public static Calendario selectCalendario() throws SQLException {
		Vector datosLaborable = GestorBaseDatos.getInstancia()
				.select("SELECT dia FROM calendario WHERE LABORABLE='true'");
		ArrayList<Date> diaslaborables = new ArrayList<Date>();

		Vector datosnolaborables = GestorBaseDatos.getInstancia()
				.select("SELECT dia FROM calendario WHERE LABORABLE='false'");
		ArrayList<Date> diasnolaborables = new ArrayList<Date>();

		if (datosLaborable.isEmpty()) {
			System.out.println("Error");
		} else {
				diaslaborables.addAll(datosLaborable);

				diasnolaborables.addAll(datosLaborable);
	
		}
		Calendario c = new Calendario(diaslaborables, diasnolaborables);

		return c;
	}

	public int nuevoCalendario(Calendario aC) {
		throw new UnsupportedOperationException();
	}
}