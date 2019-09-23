package com.sentiweb.model;

public class RespuestaEncuesta {
	private int id;
	private String respuesta;
	private int flagSentimiento;
	
	
	
	public RespuestaEncuesta(int id, String respuesta, int flagSentimiento) {
		super();
		this.id = id;
		this.respuesta = respuesta;
		this.flagSentimiento = flagSentimiento;
	}
	public RespuestaEncuesta(String respuesta, int flagSentimiento) {
		super();
		this.respuesta = respuesta;
		this.flagSentimiento = flagSentimiento;
	}
	public RespuestaEncuesta() {
		super();
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public int getFlagSentimiento() {
		return flagSentimiento;
	}
	public void setFlagSentimiento(int flagSentimiento) {
		this.flagSentimiento = flagSentimiento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
