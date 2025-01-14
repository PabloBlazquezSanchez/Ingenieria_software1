package Persistencia;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import org.apache.derby.jdbc.EmbeddedDriver;

public class GestorBaseDatos {

	private static GestorBaseDatos instancia = null;
	protected static Connection mBD;

	public GestorBaseDatos() throws SQLException {
		conectarBD();
	}

	public static GestorBaseDatos getInstancia() throws SQLException {
		if (instancia == null) {
			instancia = new GestorBaseDatos();
		}
		return instancia;
	}

	public static Connection conectarBD() throws SQLException {
		Driver derbyEmbeddedDriver = new EmbeddedDriver();
		DriverManager.registerDriver(derbyEmbeddedDriver);
		mBD = DriverManager.getConnection("" + BDConstantes.DRIVER + ":" + BDConstantes.DBNAME + ";create=false",
				BDConstantes.DBUSER, BDConstantes.DBPASS);
		return mBD;
	}

	public static void desconectarBD() throws SQLException {
		mBD.close();
		instancia = null;
	}

	public Vector<Object> select(String sql) throws SQLException {
		System.out.println(sql);
		conectarBD();

		Vector<Object> vectoradevolver = new Vector<Object>();
		Statement stmt = mBD.createStatement();
		ResultSet res = stmt.executeQuery(sql);
		int nColumnas = res.getMetaData().getColumnCount();

		while (res.next()) {
			Vector<Object> v = new Vector<Object>();
			for (int i = 1; i < nColumnas + 1; i++)
				v.add(res.getObject(i));
			vectoradevolver.add(v);
		}
		stmt.close();
		desconectarBD();
		return vectoradevolver;
	}

	public int insert(String sql) throws SQLException {
		return executeInsertUpdateDelete(sql);
	}

	public int update(String sql) throws SQLException {
		return executeInsertUpdateDelete(sql);
	}

	public int delete(String sql) throws SQLException {
		return executeInsertUpdateDelete(sql);
	}
	
	public int executeInsertUpdateDelete(String sql) throws SQLException {
		System.out.println(sql);
		PreparedStatement stmt = mBD.prepareStatement(sql);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectarBD();
		return res;
	}

	public static void crearBaseDeDatos() throws Exception {
		try {
			Connection connection = DriverManager.getConnection(BDConstantes.CONNECTION_STRING, BDConstantes.DBUSER,
					BDConstantes.DBPASS);
			System.out.println("New derby database created");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}