package com.senti.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AreaRowMapper implements RowMapper<Area> {

	@Override
	public Area mapRow(ResultSet row, int rowNum) throws SQLException {
		Area area = new Area();
		area.setCantidad(row.getInt("contador")); 
		area.setDesArea(row.getString("nom_area"));  
		return area;
	}

}
