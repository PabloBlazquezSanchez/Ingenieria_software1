package Persistencia;

import java.sql.SQLException;
import java.util.Vector;

import Dominio.Entidades.Empleado;
import Dominio.Entidades.Paciente;
import Dominio.Entidades.Rol;

public class EmpleadoDAO extends UsuarioDAO {

	public static Empleado selectEmpleado(Empleado e) throws SQLException {
		Vector datosEmpleado = GestorBaseDatos.getInstancia()
				.select("SELECT * FROM empleado WHERE nombreusario'" + e.get_nombreUsuario() + "'");
		datosEmpleado = (Vector) datosEmpleado.get(0);

		if (datosEmpleado.isEmpty()) {
			System.out.println("Error");
		} else {
			String nombre = (String) datosEmpleado.get(1);
			String apellido = (String) datosEmpleado.get(2);
			String dni = (String) datosEmpleado.get(0);
			Rol rol = (Rol) datosEmpleado.get(4);
			String nombreusuario= (String) datosEmpleado.get(5);
			String contrasena = (String) datosEmpleado.get(6);
			e = new Empleado(nombre, apellido, dni, nombreusuario, contrasena, 0, rol);
		}
		return e;
	}
}