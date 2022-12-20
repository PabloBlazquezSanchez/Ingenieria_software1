package Dominio.Entidades;

import java.util.Date;

public class Horario {
	private String inicio;
	private String fin;
	public Horario(String inicio, String fin) {
		this.inicio = inicio;
		this.fin = fin;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	
	
	
}