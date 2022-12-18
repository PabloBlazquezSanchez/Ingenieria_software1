package VistaEstatica.Dominio.Controladores;

import VistaEstatica.Persistencia.CitaDAO;
import VistaEstatica.Dominio.Entidades.Paciente;
import VistaEstatica.Dominio.Entidades.Especialista;
import VistaEstatica.Dominio.Entidades.Cita;

public class GestorCitas {
	public CitaDAO _citaDAO;

	public void solicitarCita(Date aFecha, Paciente aPaciente, Especialista aEspecialista) {
		throw new UnsupportedOperationException();
	}

	public void anularCita(Paciente aPaciente, Cita aCita) {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Cita> leerCitas() {
		throw new UnsupportedOperationException();
	}
}