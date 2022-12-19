package Persistencia;

import java.sql.SQLException;
import java.util.Vector;
import Dominio.Entidades.Paciente;

public class PacienteDAO extends UsuarioDAO {

	public static Paciente selectPaciente(Paciente p) throws SQLException {
		Vector datosPaciente = GestorBaseDatos.getInstancia()
				.select("SELECT * FROM paciente WHERE dni='" + p.get_dni() + "'");
		datosPaciente = (Vector) datosPaciente.get(0);
		if (datosPaciente.isEmpty()) {
			System.out.println("Error");
		} else {
			String nombre = (String) datosPaciente.get(1);
			String apellido = (String) datosPaciente.get(2);
			String dni = (String) datosPaciente.get(0);
			p = new Paciente(nombre, apellido, dni, null, null, 0, null, null);
		}
		return p;
	}

	public int updatePaciente(Paciente p) throws SQLException {
		return GestorBaseDatos.getInstancia().update("UPDATE paciente SET " + "nombre='" + p.get_nombre() + "', "
				+ "apellido=" + p.get_apellidos() + ", " + "dni=" + p.get_dni() + "' WHERE dni='" + p.get_dni());
	}

	public int deletePaciente(Paciente p) throws SQLException {
		return GestorBaseDatos.getInstancia().delete("DELETE FROM paciente WHERE nombre='" + p.get_nombre() + "'");
	}
}