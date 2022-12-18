package Dominio.Entidades;

public class Usuario {
	private String nombre;
	private String apellidos;
	private String dni;
	private String nombreUsuario;
	private String contrasena;
	private long _telefono;
	public Rol rol;
	public String get_nombre() {
		return nombre;
	}
	public void set_nombre(String nombre) {
		this.nombre = nombre;
	}
	public String get_apellidos() {
		return apellidos;
	}
	public void set_apellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String get_dni() {
		return dni;
	}
	public void set_dni(String dni) {
		this.dni = dni;
	}
	public String get_nombreUsuario() {
		return nombreUsuario;
	}
	public void set_nombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String get_contrasena() {
		return contrasena;
	}
	public void set_contrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public long get_telefono() {
		return _telefono;
	}
	public void set_telefono(long telefono) {
		this._telefono = telefono;
	}
	public Rol get_rol() {
		return rol;
	}
	public void set_rol(Rol rol) {
		this.rol = rol;
	}
	public Usuario(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	

}