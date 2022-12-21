package Dominio.Controladores;

import Persistencia.CitaDAO;
import Persistencia.EmpleadoDAO;
import Persistencia.SlotDAO;
import Dominio.Entidades.Paciente;
import Dominio.Entidades.Slot;
import Dominio.Entidades.Especialista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Dominio.Entidades.Cita;
import Dominio.Entidades.Empleado;

public class GestorCitas {
	public CitaDAO citaDAO;

	public static Date[] solicitarHoras(String fecha, String tipoespecialista, Paciente p) throws SQLException {
		System.out.println(fecha + " " + tipoespecialista);
		System.out.println(fecha + " " + tipoespecialista);
		ArrayList<Slot> slots = SlotDAO.selectSlotsClinica();
		ArrayList<Slot> slotsFiltrados = new ArrayList<Slot>();
		Date[] horas = null;
		boolean clave = false;
		Empleado e = null;

		String dniesp = CitaDAO.selectCitaAnterior(p.get_dni(), tipoespecialista);
		if (dniesp.isEmpty()) {
			e = EmpleadoDAO.AsignarEmpleado(tipoespecialista);
			clave = true;
		}

		for (int i = 0; i < slots.size(); i++) {
			String fechaslot = slots.get(i).getDia().toString();
			String dnisslot = slots.get(i).getDniespc().toString();
			if ((fechaslot.equals(fecha) && dnisslot.equals(dniesp))
					|| clave && fechaslot.equals(fecha) && e.get_dni().equals(dnisslot)) {
				System.out.println(dnisslot + " " + " " + dniesp);
				slotsFiltrados.add(slots.get(i));
			}
			// Pass slotsFiltrados to an array of strings
			horas = new Date[slotsFiltrados.size()];
			for (int j = 0; j < slotsFiltrados.size(); j++) {
				horas[j] = slotsFiltrados.get(j).getHoraInicio();
			}
		}
		return horas;

	}

	public static Date[] huecossinasignar(String fecha) throws SQLException {
		ArrayList<Slot> slots = SlotDAO.selectSinAsignar(fecha);
		Date[] horas = null;
		if (slots == null) {
			horas = new Date[0];
			return horas;
		} else {
			for (int i = 0; i < slots.size(); i++) {
				horas = new Date[slots.size()];
				for (int j = 0; j < slots.size(); j++) {
					horas[j] = slots.get(j).getHoraInicio();
				}
			}
		}
		return horas;

	}

	public void anularCita(Paciente aPaciente, Cita aCita) { // No entra en los casos de uso seleccionados.
		throw new UnsupportedOperationException();
	}

	public ArrayList<Cita> leerCitas() { // No entra en los casos de uso seleccionados.
		throw new UnsupportedOperationException();
	}

	public static int generarCita(String fecha, String especialidad, Paciente p, String inicio) throws SQLException {
		Empleado e = null;
		String dniesp = CitaDAO.selectCitaAnterior(p.get_dni(), especialidad);
		if (dniesp.isEmpty()) {
			System.out.println(especialidad);
			e = EmpleadoDAO.AsignarEmpleado(especialidad);
			dniesp = e.get_dni();
		}
		int id = SlotDAO.obtenerID(dniesp, inicio, fecha);
		int resultado = 0;
		resultado = +CitaDAO.nuevaCita(p.get_dni(), dniesp, especialidad, id);
		System.out.println(resultado);
		resultado = +SlotDAO.ocupado(id);
		System.out.println(resultado);
		return resultado;
	}
}