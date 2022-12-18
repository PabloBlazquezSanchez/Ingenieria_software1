package Dominio.Entidades;

public class Usuario {
	private String nombre;
	private String apellidos;
	private String dni;
	private String nombreUsuario;
	private String contrasena;
	private long telefono;
	public Rol rol;
	
	public Usuario(String nombre, String apellidos, String dni, String nombreUsuario, String contrasena, long telefono,
			Rol rol) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.telefono = telefono;
		this.rol = rol;
	}
	
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
		return telefono;
	}
	public void set_telefono(long telefono) {
		this.telefono = telefono;
	}
	public Rol get_rol() {
		return rol;
	}
	public void set_rol(Rol rol) {
		this.rol = rol;
	}
	
	

}