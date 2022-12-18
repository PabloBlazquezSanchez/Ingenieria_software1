package Dominio.Entidades;

import java.util.Date;

import Dominio.Entidades.Cita;

public class Slot {
	private Date fechaInicio;
	private Date fechaFin;
	public Agenda agenda;
	public Cita cita;
	public TipoSlot tipoSlot;
}