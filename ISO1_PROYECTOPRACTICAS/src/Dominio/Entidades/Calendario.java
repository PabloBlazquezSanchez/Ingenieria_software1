package Dominio.Entidades;

import java.util.ArrayList;
import java.util.Date;

public class Calendario {
	private ArrayList<Date> dias_laborables;
	private ArrayList<Date> dias_festivos;
	
	public Calendario(ArrayList<Date> dias_laborables, ArrayList<Date> dias_festivos) {
		super();
		this.dias_laborables = dias_laborables;
		this.dias_festivos = dias_festivos;
	}
	
	public ArrayList<Date> getDias_laborables() {
		return dias_laborables;
	}
	public void setDias_laborables(ArrayList<Date> dias_laborables) {
		this.dias_laborables = dias_laborables;
	}
	public ArrayList<Date> getDias_festivos() {
		return dias_festivos;
	}
	public void setDias_festivos(ArrayList<Date> dias_festivos) {
		this.dias_festivos = dias_festivos;
	}

}