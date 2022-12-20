package Dominio.Controladores;

import Persistencia.CitaDAO;
import Dominio.Entidades.Paciente;
import Dominio.Entidades.Especialista;

import java.util.ArrayList;
import java.util.Date;

import Dominio.Entidades.Cita;

public class GestorCitas {
	public CitaDAO citaDAO;

	public void solicitarCita(Date fecha, Paciente p, Especialista especialista) {

	}

	public static String[] solicitarHoras(String fecha, String tipoespecialista) {
		System.out.println(fecha + " " + tipoespecialista);
		String[] pepe=new String[1];
		pepe[1]="bie";
		return pepe;

	}

	public void anularCita(Paciente aPaciente, Cita aCita) { // No entra en los casos de uso seleccionados.
	}

	public ArrayList<Cita> leerCitas() {
		throw new UnsupportedOperationException();
	}
}