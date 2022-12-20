package Dominio.Controladores;

import java.sql.SQLException;

import Dominio.Entidades.Empleado;
import Dominio.Entidades.Paciente;
import Persistencia.EmpleadoDAO;
import Persistencia.PacienteDAO;

public class GestorUsuarios {

	public static boolean loginEmpleado(String NombreUsuario, String Contrasena) throws SQLException {
		boolean autentificado = false;
		Empleado e = new Empleado(null, null, null, NombreUsuario, Contrasena, 0, null);
		Empleado e2 = EmpleadoDAO.selectEmpleado(e);
		if (e.get_nombreUsuario().equals(e2.get_nombreUsuario()) && e.get_contrasena().equals(e2.get_contrasena())) {
			autentificado = true;
		}
		return autentificado;
	}

	public static boolean loginPaciente(String nombre, String id) throws SQLException {
		boolean autentificado = false;
		Paciente p = new Paciente(nombre, null, id, null, null, 0, null, null);
		Paciente p2 = PacienteDAO.selectPaciente(p);
		if (p.get_dni().equals(p2.get_dni()) && p.get_nombre().equals(p2.get_nombre())) {
			autentificado = true;
		}
		return autentificado;

	}

	public static Paciente ObtenerDatosPaciente(String nombre, String id) throws SQLException {
		boolean autentificado = false;
		
		Paciente p = new Paciente(nombre, null, id, null, null, 0, null, null);
		Paciente p2 = PacienteDAO.selectPaciente(p);
		Paciente p3=null;
		if (p.get_dni().equals(p2.get_dni()) && p.get_nombre().equals(p2.get_nombre())) {
			p3=p2;
		}
		return p3;

	}
	public void registrarPaciente() { //No entra en los casos de uso seleccionados
		throw new UnsupportedOperationException();
	}

}