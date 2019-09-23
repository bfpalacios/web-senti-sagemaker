package com.senti.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RespuestaRowMapper implements RowMapper<Respuesta>{
	@Override
	public Respuesta mapRow(ResultSet row, int rowNum) throws SQLException {
		Respuesta respuesta = new Respuesta();
		respuesta.setIdRpta(row.getInt("id_rpta"));
		respuesta.setIdEnc(row.getInt("id_enc"));
		respuesta.setIdPreg(row.getInt("id_preg"));
		respuesta.setDescRpta(row.getString("desc_rpta")); 
		return respuesta;
	}

}
