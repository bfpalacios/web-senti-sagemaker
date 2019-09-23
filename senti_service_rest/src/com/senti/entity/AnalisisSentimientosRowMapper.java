package com.senti.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AnalisisSentimientosRowMapper implements RowMapper<Respuesta>{
	@Override
	public Respuesta mapRow(ResultSet row, int rowNum) throws SQLException {
		Respuesta respuesta = new Respuesta();
		respuesta.setIdRpta(row.getInt("id_rpta"));
		respuesta.setFlagSenti(row.getInt("flag_senti"));
		respuesta.setDescRpta(row.getString("desc_rpta")); 
		return respuesta;
	}

}
