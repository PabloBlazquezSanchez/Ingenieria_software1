package Dominio.Entidades;

import java.util.Vector;
import Design_Model.VistaEstatica.Dominio.Entidades.Cita;
import Design_Model.VistaEstatica.Dominio.Entidades.Nomina;

public class Especialista extends Empleado {
	public Vector<Cita> citas = new Vector<Cita>();
	public Vector<Nomina> nomina = new Vector<Nomina>();
	public Agenda agenda;
}