package VistaEstatica.Dominio.Entidades;

import java.util.Vector;
import Design_Model.VistaEstatica.Dominio.Entidades.Slot;

public class Agenda {
	public Especialista _especialista;
	public Cita _unnamed_Cita_;
	public Vector<Slot> _slot = new Vector<Slot>();
	public Horario _horarios;
	public Calendario _calendario;
	public TipoAgenda _tipo_agenda;
}