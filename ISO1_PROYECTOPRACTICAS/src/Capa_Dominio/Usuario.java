package Capa_Dominio;

import Capa_Persistencia.AgenteBD;
import Persistencia.BDConstantes;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import org.apache.derby.jdbc.EmbeddedDriver;

public class Usuario {

	public String mLogin;

	public String mPassword;

	// Constructor para la creaci�n de un objeto Usuario vacio
	public Usuario() {
		this.mLogin = null;
		this.mPassword = null;
	}

	// Constructor para la creaci�n de un Usuario
	public Usuario(String login, String password) {
		this.mLogin = login;
		this.mPassword = password;
	}

	public String getmLogin() {
		return mLogin;
	}

	public void setmLogin(String mLogin) {
		this.mLogin = mLogin;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}
}
