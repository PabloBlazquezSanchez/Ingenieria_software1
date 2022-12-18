package Dominio.Entidades;

import java.util.Vector;
import Design_Model.VistaEstatica.Dominio.Entidades.Slot;
import Dominio.Entidades.Cita;

public class Agenda {
	public Especialista especialista;
	public Cita Cita;
	public Vector<Slot> slot = new Vector<Slot>();
	public Horario horario;
	public Calendario calendario;
	public TipoAgenda tipo_agenda;
}