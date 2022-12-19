package Dominio.Controladores;

import java.sql.SQLException;

import Dominio.Entidades.Paciente;
import Persistencia.PacienteDAO;

public class GestorUsuarios {

	public void loginEmpleado(String aNombreUsuario, String aContrase) {
		throw new UnsupportedOperationException();
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