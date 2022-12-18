package Persistencia;

import java.sql.SQLException;
import java.util.Vector;
import Dominio.Entidades.*;

public class PacienteDAO {
	public static Paciente select() throws SQLException {
		Vector<Object> aux = null;
		Vector<Object> aux2 = null;
		Paciente paciente = null;
		
		String selectsql = "select * from PACIENTE";
		aux = GestorBaseDatos.select(selectsql);
		if(aux.isEmpty()) {
			System.out.println("Error.");
		}else {
			aux2 = (Vector<Object>) aux.elementAt(0);
			paciente = new Paciente((String)aux2.elementAt(0), (String)aux2.elementAt(1), (String)aux2.elementAt(2));
		}
		return paciente;
		
	}

}
