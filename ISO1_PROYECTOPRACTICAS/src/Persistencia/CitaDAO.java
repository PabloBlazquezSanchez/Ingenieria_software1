package Persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import Dominio.Entidades.Cita;
import Dominio.Entidades.Especialista;
import Dominio.Entidades.Paciente;
import Dominio.Entidades.Slot;
import persistencia.GestorBD;

public class CitaDAO {

	
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

	public static int nuevaCita(String dnipac, String dniesp, String especialidad, int id) throws SQLException {
		return GestorBaseDatos.getInstancia().insert("INSERT INTO cita (DNIPACIENTE, DNITRABAJADOR, TIPOCITA, IDSLOT) VALUES ('"
				+ dnipac+"', '"
				+ dniesp+"', '"
				+ especialidad+"', "
				+ id+"')");
		

	
	}
}