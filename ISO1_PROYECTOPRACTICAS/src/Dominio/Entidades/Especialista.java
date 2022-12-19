package Dominio.Entidades;

import java.util.Vector;

public class Especialista extends Empleado {
	public Especialista(String nombre, String apellidos, String dni, String nombreUsuario, String contrasena,
			long telefono, Rol rol) {
		super(nombre, apellidos, dni, nombreUsuario, contrasena, telefono, rol);
		this.citas=citas;
		this.agenda=agenda;
	}
	public Vector<Cita> citas = new Vector<Cita>();
	public Agenda agenda;
}