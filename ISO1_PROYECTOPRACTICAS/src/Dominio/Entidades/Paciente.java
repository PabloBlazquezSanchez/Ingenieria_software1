package Dominio.Entidades;

import java.util.Vector;

public class Paciente extends Usuario {
	private String id;
	private String tarjSanitaria;
	public Vector<Cita> cita = new Vector<Cita>();
	
	public Paciente(String nombre, String apellidos, String dni, String nombreUsuario, String contrasena, long telefono,
			Rol rol, Vector<Cita> cita) {
		super(nombre, apellidos, dni, nombreUsuario, contrasena, telefono, rol);
		this.id=dni;
		this.cita=cita;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTarjSanitaria() {
		return tarjSanitaria;
	}

	public void setTarjSanitaria(String tarjSanitaria) {
		this.tarjSanitaria = tarjSanitaria;
	}

	public Vector<Cita> getCita() {
		return cita;
	}

	public void setCita(Vector<Cita> cita) {
		this.cita = cita;
	}

}