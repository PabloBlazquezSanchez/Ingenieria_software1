package Dominio.Entidades;

import java.util.Vector;
import Dominio.Entidades.Cita;

public class Agenda {
	public Especialista especialista;
	public Cita Cita;
	public Vector<Slot> slot = new Vector<Slot>();
	public Horario horario;
	public Calendario calendario;
	public TipoAgenda tipo_agenda;

	public Agenda(Especialista especialista, Dominio.Entidades.Cita cita, Vector<Slot> slot, Horario horario,
			Calendario calendario, TipoAgenda tipo_agenda) {
		this.especialista = especialista;
		Cita = cita;
		this.slot = slot;
		this.horario = horario;
		this.calendario = calendario;
		this.tipo_agenda = tipo_agenda;
	}

	public Especialista getEspecialista() {
		return especialista;
	}

	public void setEspecialista(Especialista especialista) {
		this.especialista = especialista;
	}

	public Cita getCita() {
		return Cita;
	}

	public void setCita(Cita cita) {
		Cita = cita;
	}

	public Vector<Slot> getSlot() {
		return slot;
	}

	public void setSlot(Vector<Slot> slot) {
		this.slot = slot;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	public TipoAgenda getTipo_agenda() {
		return tipo_agenda;
	}

	public void setTipo_agenda(TipoAgenda tipo_agenda) {
		this.tipo_agenda = tipo_agenda;
	}

}