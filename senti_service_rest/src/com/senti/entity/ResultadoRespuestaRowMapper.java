package com.senti.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ResultadoRespuestaRowMapper implements RowMapper<Respuesta>{
		@Override
		public Respuesta mapRow(ResultSet row, int rowNum) throws SQLException {
			Respuesta respuesta = new Respuesta();
			respuesta.setDescRpta(row.getString("desc_rpta")); 
			return respuesta;
		}


}
