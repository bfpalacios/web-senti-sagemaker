package com.senti.persistence;

import java.util.ArrayList;
import java.util.List;

import org.mariadb.jdbc.Driver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.senti.entity.Respuesta;

public class Conexion {
	
	public static JdbcTemplate getConnection() {

		List<Respuesta> list=new ArrayList<Respuesta>();
		SimpleDriverDataSource ds=new SimpleDriverDataSource();
        ds.setDriver(new Driver());
        ds.setUrl("jdbc:mariadb://3.94.52.15:3306/sentiweb_db");
        ds.setUsername("encuestas");
        ds.setPassword("encuestas@2019.");
        
        return new JdbcTemplate(ds); 
        
	}

}
