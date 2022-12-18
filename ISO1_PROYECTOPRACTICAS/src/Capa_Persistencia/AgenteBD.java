package Capa_Persistencia;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import org.apache.derby.jdbc.EmbeddedDriver;

import Dominio.Usuario;
import Persistencia.BDConstantes;

public class AgenteBD {
	// instancia del agente
	protected static AgenteBD mInstancia = null;
	// Conexion con la base de datos
	protected static Connection mBD;
	// Identificador ODBC de la base de datos
	private static String url = "jdbc:mysql://localhost:3307/practicabd?user=alumno&password=alumno";
	// Driven para conectar con bases de datos MySQL
	private static String driver = "com.mysql.jdbc.Driver";

	// Constructor
	private AgenteBD() throws Exception {
		conectar();

	}

	// Implementacion del patron singleton
	// Este patron de diseño permite implementar clases de las cuales
	// solo existir una instancia
	// http://es.wikipedia.org/wiki/Singleton
	public static AgenteBD getAgente() throws Exception {
		if (mInstancia == null) {
			mInstancia = new AgenteBD();
		}
		return mInstancia;
	}

	public static void crearBaseDatosSinoExiste() {
		Connection conn = null;
		PreparedStatement pstmt;
		Statement stmt;
		ResultSet rs = null;
		String createSQL = "create table usuario (login varchar(30) not null, pass varchar(30) not null, constraint primary_key primary key (login))";

		try {
			Driver derbyEmbeddedDriver = new EmbeddedDriver();
			DriverManager.registerDriver(derbyEmbeddedDriver);
			conn = DriverManager.getConnection(BDConstantes.CONNECTION_STRING, BDConstantes.DBUSER,
					BDConstantes.DBPASS);
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.execute(createSQL);

			pstmt = conn.prepareStatement("insert into usuario (login, pass) values(?,?)");
			pstmt.setString(1, "alumno");
			pstmt.setString(2, "alumno");
			pstmt.executeUpdate();

			rs = stmt.executeQuery("select * from usuario");
			while (rs.next()) {
				System.out.printf("%s - pass: %s\n", rs.getString(1), rs.getString(2));
			}

			// stmt.execute("drop table usuario");

			conn.commit();

		} catch (SQLException ex) {
			System.out.println("in connection" + ex);
		}

		try {
			DriverManager.getConnection("jdbc:derby:;shutdown=true");
		} catch (SQLException ex) {
			if (((ex.getErrorCode() == 50000) && ("XJ015".equals(ex.getSQLState())))) {
				System.out.println("Derby shut down normally");
			} else {
				System.err.println("Derby did not shut down normally");
				System.err.println(ex.getMessage());
			}
		}
	}

	// Metodo para realizar la conexion a la base de datos
	private void conectar() throws Exception {
		Class.forName(driver);
		mBD = DriverManager.getConnection(url);
	}

	// Metodo para desconectar de la base de datos
	public void desconectar() throws Exception {
		mBD.close();
	}

	// Metodo para realizar una eliminacion en la base de datos

	public static int delete(String mLogin, String mPassword) throws Exception {
		Driver derbyEmbeddedDriver = new EmbeddedDriver();
		DriverManager.registerDriver(derbyEmbeddedDriver);
		Connection mBD = DriverManager.getConnection(
				"" + BDConstantes.DRIVER + ":" + BDConstantes.DBNAME + ";create=false", BDConstantes.DBUSER,
				BDConstantes.DBPASS);
		PreparedStatement stmt = mBD
				.prepareStatement("DELETE FROM Usuario WHERE login=\'" + mLogin + "\' AND pass=\'" + mPassword + "\'");
		int res = stmt.executeUpdate();
		stmt.close();
		mBD.close();
		return res;
	}

	public static int insert(String mLogin, String mPassword) throws Exception {
		Driver derbyEmbeddedDriver = new EmbeddedDriver();
		DriverManager.registerDriver(derbyEmbeddedDriver);
		Connection mBD = DriverManager.getConnection(
				"" + BDConstantes.DRIVER + ":" + BDConstantes.DBNAME + ";create=false", BDConstantes.DBUSER,
				BDConstantes.DBPASS);
		PreparedStatement stmt = mBD
				.prepareStatement("INSERT INTO Usuario VALUES('" + mLogin + "','" + mPassword + "')");
		int res = stmt.executeUpdate();
		stmt.close();
		mBD.close();
		return res;
	}

	// Metodo para realizar una eliminacion en la base de datos
	public int update(String SQL) throws SQLException, Exception {
		conectar();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	public static Usuario read(String login, String password) throws Exception {
		String l, g;
		Usuario u = null;
		Vector<Object> aux = null;
		Driver derbyEmbeddedDriver = new EmbeddedDriver();
		DriverManager.registerDriver(derbyEmbeddedDriver);
		Connection mBD = DriverManager.getConnection(
				"" + BDConstantes.DRIVER + ":" + BDConstantes.DBNAME + ";create=false", BDConstantes.DBUSER,
				BDConstantes.DBPASS);
		String SQL_Consulta = "SELECT login, pass FROM Usuario WHERE login = '" + login + "' AND pass = '" + password
				+ "'";
		Vector<Object> vectoradevolver = new Vector<Object>();
		Statement stmt = mBD.createStatement();
		ResultSet res = stmt.executeQuery(SQL_Consulta);
		while (res.next()) {
			aux = new Vector<Object>();
			aux.add(res.getObject(1));
			aux.add(res.getObject(2));
			vectoradevolver.add(aux);
		}
		stmt.close();
		mBD.close();
		aux = new Vector<Object>();
		if (vectoradevolver.size() == 1) {
			aux = (Vector<Object>) vectoradevolver.elementAt(0);
			u = new Usuario((String) aux.elementAt(0), (String) aux.elementAt(1));
		}
		return u;
	}

	public Vector<Object> select(String SQL) throws SQLException, Exception {
		/*
		 * Metodo para realizar una busqueda o seleccion de informacion enla base de
		 * datos El mŽtodo select develve un vector de vectores, donde cada uno de los
		 * vectores que contiene el vector principal representa los registros que se
		 * recuperan de la base de datos.
		 */

		Vector<Object> vectoradevolver = new Vector<Object>();
		conectar();
		Statement stmt = mBD.createStatement();
		ResultSet res = stmt.executeQuery(SQL);
		while (res.next()) {
			Vector<Object> v = new Vector<Object>();
			v.add(res.getObject(1));
			v.add(res.getObject(2));
			vectoradevolver.add(v);
		}
		stmt.close();
		desconectar();
		return vectoradevolver;

	}
}
