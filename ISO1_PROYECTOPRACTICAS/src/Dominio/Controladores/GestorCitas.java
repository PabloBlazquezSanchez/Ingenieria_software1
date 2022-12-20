package Dominio.Controladores;

import Persistencia.CitaDAO;
import Dominio.Entidades.Paciente;
import Dominio.Entidades.Slot;
import Dominio.Entidades.Especialista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Dominio.Entidades.Cita;

public class GestorCitas {
	public CitaDAO citaDAO;

	public void solicitarCita(Date fecha, Paciente p, Especialista especialista) {

	}

	public static Date[] solicitarHoras(String fecha, String tipoespecialista) throws SQLException {
		System.out.println(fecha + " " + tipoespecialista);
		System.out.println(fecha + " " + tipoespecialista);
		ArrayList<Slot> slots = CitaDAO.selectSlotsSingAsignar();
		// Get the slots with the same date and type of specialist
		ArrayList<Slot> slotsFiltrados = new ArrayList<Slot>();
		Date[] horas = null;

		// Filter the slots by the fecha and tipoespecialista
		for (int i = 0; i < slots.size(); i++) {
			if (slots.get(i).getDia().equals(fecha)) {
				// && slots.get(dni).equals(tipoespecialista)
				slotsFiltrados.add(slots.get(i));
			}
			// Pass slotsFiltrados to an array of strings
			 horas = new Date[slotsFiltrados.size()];
			for (int j = 0; j < slotsFiltrados.size(); j++) {
				horas[j] = slotsFiltrados.get(j).getHoraInicio();
				System.out.println(horas[j]);
			}
		}
		return horas;

	}

	public void anularCita(Paciente aPaciente, Cita aCita) { // No entra en los casos de uso seleccionados.
	}

	public ArrayList<Cita> leerCitas() {
		throw new UnsupportedOperationException();
	}
}