package VistaEstatica.Dominio.Entidades;

import java.util.Vector;
import Design_Model.VistaEstatica.Dominio.Entidades.Cita;
import Design_Model.VistaEstatica.Dominio.Entidades.Nomina;

public class Especialista extends Empleado {
	private int _telefono;
	public Vector<Cita> _citas = new Vector<Cita>();
	public Vector<Nomina> _nomina = new Vector<Nomina>();
	public Agenda _agenda;
}