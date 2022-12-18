package Dominio.Controladores;

import Capa_Persistencia.AgenteBD;

public class GestorUsuario {
	public int update() throws Exception {
		return 0;
	}

	public static boolean autenticar(String login, String password) throws Exception {
		boolean autenticado = false;
		if (AgenteBD.read(login, password) != null)
			autenticado = true;
		return autenticado;
	}

	public static boolean nuevoUsuario(String login, String password) throws Exception {
		boolean insertado = false;
		if (AgenteBD.insert(login, password) == 1)
			insertado = true;
		return insertado;
	}

	public static boolean eliminarUsuario(String login, String password) throws Exception {
		boolean eliminado = false;
		if (AgenteBD.delete(login, password) == 1)
			eliminado = true;
		return eliminado;
	}
}
