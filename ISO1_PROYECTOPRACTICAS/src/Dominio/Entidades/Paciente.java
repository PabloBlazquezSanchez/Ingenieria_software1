package Dominio.Entidades;

import java.util.Vector;
import Design_Model.VistaEstatica.Dominio.Entidades.Cita;

public class Paciente extends Usuario {
	
	private String _id;
	private String _tarjSanitaria;
	public Vector<Cita> cita = new Vector<Cita>();
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String get_tarjSanitaria() {
		return _tarjSanitaria;
	}
	public void set_tarjSanitaria(String _tarjSanitaria) {
		this._tarjSanitaria = _tarjSanitaria;
	}


	public Vector<Cita> get_citas() {
		return cita;
	}
	public void set_citas(Vector<Cita> _citas) {
		this.citas = _citas;
	}
	public Paciente(String _id, String nombre, String apellido) {
		super(nombre, apellido);
		this._id = _id;
	}
}