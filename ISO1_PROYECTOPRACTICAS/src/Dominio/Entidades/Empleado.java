package Dominio.Entidades;

public class Empleado extends Usuario {

	private String correroAsociado;
	private String iBAN;

	public Empleado(String nombre, String apellidos, String dni, String nombreUsuario, String contrasena, long telefono,
			Rol rol) {
		super(nombre, apellidos, dni, nombreUsuario, contrasena, telefono, rol);
		this.iBAN = iBAN;
		this.correroAsociado = correroAsociado;
	}

	public String getCorreroAsociado() {
		return correroAsociado;
	}

	public void setCorreroAsociado(String correroAsociado) {
		this.correroAsociado = correroAsociado;
	}

	public String getiBAN() {
		return iBAN;
	}

	public void setiBAN(String iBAN) {
		this.iBAN = iBAN;
	}

}