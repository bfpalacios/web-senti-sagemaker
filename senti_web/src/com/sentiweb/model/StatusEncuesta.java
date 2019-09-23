package com.sentiweb.model;

public class StatusEncuesta {
	private String area;
	private int pendiente;
	private int respondido;
	private int totalEncuestar;
	
	
	
	public StatusEncuesta(String area, int pendiente, int respondido, int totalEncuestar) {
		super();
		this.area = area;
		this.pendiente = pendiente;
		this.respondido = respondido;
		this.totalEncuestar = totalEncuestar;
	}
	public StatusEncuesta() {
		super();
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getPendiente() {
		return pendiente;
	}
	public void setPendiente(int pendiente) {
		this.pendiente = pendiente;
	}
	public int getRespondido() {
		return respondido;
	}
	public void setRespondido(int respondido) {
		this.respondido = respondido;
	}
	public int getTotalEncuestar() {
		return totalEncuestar;
	}
	public void setTotalEncuestar(int totalEncuestar) {
		this.totalEncuestar = totalEncuestar;
	}
	
	
	
	
	

}
