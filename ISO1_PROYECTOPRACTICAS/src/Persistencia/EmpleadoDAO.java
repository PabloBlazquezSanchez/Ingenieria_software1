package Persistencia;

import java.sql.SQLException;
import java.util.Vector;

import Dominio.Entidades.Empleado;
import Dominio.Entidades.Paciente;
import Dominio.Entidades.Rol;

public class EmpleadoDAO extends UsuarioDAO {

	public static Empleado selectEmpleado(Empleado e) throws SQLException {
		Vector datosEmpleado = GestorBaseDatos.getInstancia()
				.select("SELECT * FROM empleado WHERE NOMBREUSUARIO='" + e.get_nombreUsuario() + "'");
		datosEmpleado = (Vector) datosEmpleado.get(0);
		System.out.println(datosEmpleado);
		if (datosEmpleado.isEmpty()) {
			System.out.println("Error");
		} else {
			String nombre = (String) datosEmpleado.get(1);
			String apellido = (String) datosEmpleado.get(2);
			String dni = (String) datosEmpleado.get(0);
			String rols = (String) datosEmpleado.get(3);
			Rol rol = null;
			for (Rol d : Rol.values()) {
				if (d.equals(rols)) {
					rol = d;
				}
			}

			String nombreusuario = (String) datosEmpleado.get(4);
			String contrasena = (String) datosEmpleado.get(5);
			e = new Empleado(nombre, apellido, dni, nombreusuario, contrasena, 0, rol);
		}
		return e;
	}
}