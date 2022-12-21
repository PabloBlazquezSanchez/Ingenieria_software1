package Dominio.Controladores;

import Dominio.Entidades.Horario;
import Dominio.Entidades.Calendario;
import Dominio.Entidades.Empleado;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Dominio.Entidades.Agenda;
import Dominio.Entidades.Slot;
import Persistencia.AgendaDAO;
import Persistencia.CalendarioDAO;
import Persistencia.CitaDAO;
import Persistencia.HorarioDAO;
import Persistencia.SlotDAO;

public class GestorAgenda {

	public static String[] obtenerDatosCalendarioLaborable() throws SQLException {
		Calendario c = CalendarioDAO.selectCalendario();
		String[] fechas = new String[c.getDias_laborables().size()];
		ArrayList<Date> dias_laborables = c.getDias_laborables();
		String h = dias_laborables.toString().replaceAll("[\\[\\](){}]", "");
		h.split(", ");
		return h.split(", ");

	}

	public static void obtenerDatosHorariosDia(String fechatext) throws SQLException {
		Horario h = HorarioDAO.selectHorario(fechatext);

	}

	public void obtenerDatosCalendarios(Calendario aCalendarios) {

	}

	public Agenda crearAgenda(Slot aSlot, Horario aHorarios, Calendario aCalendario) {
		throw new UnsupportedOperationException();
	}

	public static int rellenarAgenda(Empleado e, String dia, String fecha, String anotacion) throws SQLException {
		int id = SlotDAO.obtenerID("sin_asignar", dia, fecha, "sin_asignar");
		int resultado = 0;
		System.out.println(resultado);
		resultado = +SlotDAO.configurado(id, "clinica");
		if (anotacion == null) {
			resultado = +AgendaDAO.modificarAgenda(e.get_dni(), fecha, id);
			System.out.println(resultado);
			return resultado;
		} else {
			resultado = +AgendaDAO.modificarAgendaDomicilio(e.get_dni(), fecha, id, anotacion);
			System.out.println(resultado);
			return resultado;
		}
	}
}