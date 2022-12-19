package Persistencia;

import java.sql.SQLException;
import java.util.Vector;

import Dominio.Entidades.Empleado;
import Dominio.Entidades.Paciente;
import Dominio.Entidades.Rol;

public class EmpleadoDAO extends UsuarioDAO {

	public static Empleado selectPaciente(Empleado e) throws SQLException {
		Vector datosEmpleado = GestorBaseDatos.getInstancia()
				.select("SELECT * FROM empleado WHERE dni='" + e.get_dni() + "'");
		datosEmpleado = (Vector) datosEmpleado.get(0);

		if (datosEmpleado.isEmpty()) {
			System.out.println("Error");
		} else {
			String nombre = (String) datosEmpleado.get(0);
			String apellido = (String) datosEmpleado.get(1);
			String dni = (String) datosEmpleado.get(2);
			Rol rol = (Rol) datosEmpleado.get(3);
			e = new Empleado(nombre, apellido, dni, null, null, 0, rol);
		}
		return e;
	}
}