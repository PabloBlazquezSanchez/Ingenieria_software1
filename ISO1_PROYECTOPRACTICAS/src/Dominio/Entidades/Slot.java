package Dominio.Entidades;

import java.util.Date;

import Dominio.Entidades.Cita;

public class Slot {
	private Date horaInicio;
	private Date horaFin;
	private int id;
	private Date dia;
	private String tipoSlot;
	private String dniespc;
	private boolean ocupado;
	
	
	public Slot(Date horaInicio, Date horaFin, Date dia, int id,String dniespc, String tipoSlot, boolean ocupado) {
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.id = id;
		this.dia = dia;
		this.tipoSlot = tipoSlot;
		this.dniespc = dniespc;
		this.ocupado=ocupado;
	}
	
	
	public boolean getOcupado() {
		return ocupado;
	}


	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}


	public Date getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Date getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public String getTipoSlot() {
		return tipoSlot;
	}
	public void setTipoSlot(String tipoSlot) {
		this.tipoSlot = tipoSlot;
	}
	public String getDniespc() {
		return dniespc;
	}
	public void setDniespc(String dniespc) {
		this.dniespc = dniespc;
	}
	
	

}