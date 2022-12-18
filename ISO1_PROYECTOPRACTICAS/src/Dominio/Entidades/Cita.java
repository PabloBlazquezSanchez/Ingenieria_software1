package Dominio.Entidades;

public class Cita {
	private Especialista especialista;
		private Agenda agenda;
	private Paciente paciente;
	private Slot slot;
	
	public Cita(Especialista especialista, Agenda agenda, Paciente paciente, Slot slot) {
		this.especialista = especialista;
		this.agenda = agenda;
		this.paciente = paciente;
		this.slot = slot;
	}
	
	public Especialista getEspecialista() {
		return especialista;
	}

	public void setEspecialista(Especialista especialista) {
		this.especialista = especialista;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	
	
	
}

