package Dominio.Controladores;

import Persistencia.CitaDAO;
import Dominio.Entidades.Paciente;
import Dominio.Entidades.Especialista;

import java.util.ArrayList;
import java.util.Date;

import Dominio.Entidades.Cita;

public class GestorCitas {
	public CitaDAO citaDAO;

	public void solicitarCita(Date fecha, Paciente paciente, Especialista especialista) {
	}

	public void anularCita(Paciente aPaciente, Cita aCita) { //No entra en los casos de uso seleccionados.
	}

	public ArrayList<Cita> leerCitas() {
		throw new UnsupportedOperationException();
	}
}