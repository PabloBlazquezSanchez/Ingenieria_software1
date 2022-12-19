package Dominio.Entidades;

public class MedicoCabecera extends Especialista {

	public MedicoCabecera(String nombre, String apellidos, String dni, String nombreUsuario, String contrasena,
			long telefono, Rol rol) {
		super(nombre, apellidos, dni, nombreUsuario, contrasena, telefono, rol);
	}
}