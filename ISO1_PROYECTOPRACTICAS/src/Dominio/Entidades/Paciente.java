package Dominio.Entidades;

import java.util.Vector;
import Design_Model.VistaEstatica.Dominio.Entidades.Cita;

public class Paciente extends Usuario {
	
	private String _id;
	private String _tarjSanitaria;
	public Historial historial;
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
	public Historial get_historial() {
		return historial;
	}
	public void set_historial(Historial historial) {
		this.historial = historial;
	}
	public Vector<Cita> get_cita() {
		return cita;
	}
	public void set_cita(Vector<Cita> _cita) {
		this.cita = _cita;
	}
	public Vector<Cita> get_citas() {
		return _cita;
	}
	public void set_citas(Vector<Cita> _citas) {
		this._citas = _citas;
	}
	public Paciente(String _id, String nombre, String apellido) {
		super(nombre, apellido);
		this._id = _id;
	}
}