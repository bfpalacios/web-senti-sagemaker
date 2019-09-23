package com.senti.entity;

public class Respuesta {
	private int idRpta;
	private int idPreg;
    private int idEnc;
    private int flagSenti ;
    private String descRpta;
	public int getIdRpta() {
		return idRpta;
	}
	public void setIdRpta(int idRpta) {
		this.idRpta = idRpta;
	}
	public int getIdPreg() {
		return idPreg;
	}
	public void setIdPreg(int idPreg) {
		this.idPreg = idPreg;
	}
	public int getIdEnc() {
		return idEnc;
	}
	public void setIdEnc(int idEnc) {
		this.idEnc = idEnc;
	}
	public String getDescRpta() {
		return descRpta;
	}
	public void setDescRpta(String descRpta) {
		this.descRpta = descRpta;
	}
	public int getFlagSenti() {
		return flagSenti;
	}
	public void setFlagSenti(int flagSenti) {
		this.flagSenti = flagSenti;
	}
     

}
