package Dominio.Controladores;

import Dominio.Entidades.Horario;
import Dominio.Entidades.Calendario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Dominio.Entidades.Agenda;
import Dominio.Entidades.Slot;
import Persistencia.CalendarioDAO;

public class GestorAgenda {

	public static String[] obtenerDatosCalendarioLaborable() throws SQLException {
		Calendario c = CalendarioDAO.selectCalendario();
		String[] fechas= new String[c.getDias_laborables().size()];
		ArrayList<Date> dias_laborables=  c.getDias_laborables();
	String h=dias_laborables.toString().replaceAll("[\\[\\](){}]", "");
	h.split(", ");

			
			
		return h.split(", ");
		
	}
	
	public void obtenerDatosHorarios(Horario aHorarios) {
		throw new UnsupportedOperationException();
	}

	public void obtenerDatosCalendarios(Calendario aCalendarios) {
		

	}

	public void solicitarValidacion() {
		throw new UnsupportedOperationException();
	}

	public Agenda crearAgenda(Slot aSlot, Horario aHorarios, Calendario aCalendario) {
		throw new UnsupportedOperationException();
	}

	public void rellenarAgenda(Agenda aAgenda) {
		throw new UnsupportedOperationException();
	}
}