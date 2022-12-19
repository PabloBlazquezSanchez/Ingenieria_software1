package Dominio.Controladores;

import java.sql.SQLException;

import Dominio.Entidades.Empleado;
import Dominio.Entidades.Paciente;
import Persistencia.EmpleadoDAO;
import Persistencia.PacienteDAO;

public class GestorUsuarios {

	public void loginEmpleado(String NombreUsuario, String Contrasena) {
		boolean autentificado = false;
		Empleado e = new Empleado(null, null, null, NombreUsuario, Contrasena, 0, null);
		Empleado e = EmpleadoDAO.selectEmpleado(e);
		if (p.get_dni().equals(p2.get_dni())&&p.get_nombre().equals(p2.get_nombre())) {
			autentificado = true;}
		return autentificado;
	
	}

	public static boolean loginPaciente(String nombre, String id) throws SQLException {
		boolean autentificado = false;
		Paciente p = new Paciente(nombre, null, id, null, null, 0, null, null);
		Paciente p2 = PacienteDAO.selectPaciente(p);
		if (p.get_dni().equals(p2.get_dni())&&p.get_nombre().equals(p2.get_nombre())) {
			autentificado = true;}
		return autentificado;

	}


	public void registrarPaciente() {
		throw new UnsupportedOperationException();
	}

}