package VistaEstatica.Dominio.Controladores;

import Dominio.Entidades.Paciente;
import Persistencia.PacienteDAO;
import VistaEstatica.Persistencia.UsuarioDAO;

public class GestorUsuarios {
	public UsuarioDAO _usuarioDAO;

	public void loginEmpleado(String aNombreUsuario, String aContrase�a) {
		throw new UnsupportedOperationException();
	}

	public void loginPaciente(String aId, String aNombre) {
		throw new UnsupportedOperationException();
	}

	public void registrarPaciente() {
		throw new UnsupportedOperationException();
	}
	public Paciente selecPaciente() {
		return PacienteDAO.select();
	}
}