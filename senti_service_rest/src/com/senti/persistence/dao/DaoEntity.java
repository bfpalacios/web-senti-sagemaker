package com.senti.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.senti.entity.AnalisisSentimientosRowMapper;
import com.senti.entity.Area;
import com.senti.entity.AreaRowMapper;
import com.senti.entity.Respuesta;
import com.senti.entity.RespuestaRowMapper;
import com.senti.entity.ResultadoRespuestaRowMapper;
import com.senti.persistence.Conexion;

public class DaoEntity {

	public DaoEntity() {

	}
	
	//ME LISTA LAS RECOMENDACIONES 
	public static List<Respuesta> GetRespuestasbyIdEncAndIdPreg(int idEnc, int idPreg) {
		List<Respuesta> list = new ArrayList<Respuesta>();

		JdbcTemplate jdbcTemplate = Conexion.getConnection();

		String sql = "SELECT id_rpta, id_enc, id_preg, desc_rpta FROM RESPUESTA WHERE id_enc = ? and id_preg=?";
		RowMapper<Respuesta> rowMapper = new RespuestaRowMapper();
		list = jdbcTemplate.query(sql, rowMapper, idEnc, idPreg);

		return list;

	}
	
	//ME LISTA LAS RECOMENDACIONES 
	public static List<Respuesta> GetAllRespuestas() {
				
				int idPreg = 1;
				List<Respuesta> list = new ArrayList<Respuesta>();

				JdbcTemplate jdbcTemplate = Conexion.getConnection();

				String sql = "SELECT id_rpta, id_enc, id_preg, desc_rpta FROM RESPUESTA WHERE id_preg=?";
				RowMapper<Respuesta> rowMapper = new RespuestaRowMapper();
				list = jdbcTemplate.query(sql, rowMapper, idPreg);

				return list;

			}
	
	//ME LISTA LAS RECOMENDACIONES 
	public static List<Respuesta> GetAllRecomendaciones() {
			
			int idPreg = 2;
			List<Respuesta> list = new ArrayList<Respuesta>();

			JdbcTemplate jdbcTemplate = Conexion.getConnection();

			String sql = "SELECT id_rpta, id_enc, id_preg, desc_rpta FROM RESPUESTA WHERE id_preg=?";
			RowMapper<Respuesta> rowMapper = new RespuestaRowMapper();
			list = jdbcTemplate.query(sql, rowMapper, idPreg);

			return list;

		}
		
	
	//obtiene todas las recomendaciones
	//idPreg = 2
	public static List<Respuesta> GetRecomendaciones() {
		List<Respuesta> list = new ArrayList<Respuesta>();
		
		int idPreg =2;
		JdbcTemplate jdbcTemplate = Conexion.getConnection();

		String sql = "SELECT  desc_rpta FROM RESPUESTA WHERE id_preg=?";
		RowMapper<Respuesta> rowMapper = new RespuestaRowMapper();
		list = jdbcTemplate.query(sql, rowMapper,idPreg);

		return list;

	}


	public static List<Area> GetEncuestaByRespondieron(int idArea, int idEnc) {
		JdbcTemplate jdbcTemplate = Conexion.getConnection();

		String sql = "select count(*)/2 as contador, a.nom_area from RESPUESTA r  inner join AREA a ON r.id_area=a.id_area  "
				+ "where id_enc=? and a.id_area=?";
		RowMapper<Area> rowMapper = new AreaRowMapper();
		return jdbcTemplate.query(sql, rowMapper, idEnc, idArea);

	}

	// 2.1.seccion
	public static String GetEncuestaByPendiente(int idEnc, int idPreg) {
		JdbcTemplate jdbcTemplate = Conexion.getConnection();

		// cuantos han respodido al momento
		String sql = "SELECT count(*) as contador from RESPUESTA where flag_senti=? and id_enc=? and id_preg=? ";
		RowMapper<String> rowMapper = new BeanPropertyRowMapper<String>(String.class);
		String contador = jdbcTemplate.queryForObject(sql, rowMapper, idEnc, idPreg);
		// String contador = long.toString(contador1);

		return contador;

	}

	public static List<Area> GetRespuestasEncuestaByPendiente(int idArea, int idEnc) {

		JdbcTemplate jdbcTemplate = Conexion.getConnection();

		String sql = "SELECT count(*) as contador, a.nom_area from ENCUESTADOS e\n"
				+ "inner join COLABORADOR c ON c.id_colab=e.id_colab\n" + "inner join AREA a ON a.id_area=c.id_area\n"
				+ "where id_enc=? and a.id_area=?" + "";
		RowMapper<Area> rowMapper = new AreaRowMapper();
		return jdbcTemplate.query(sql, rowMapper, idEnc, idArea);

	}
	
	

	//TOTAL A ENCUESTAR POR ÁREA POR ID_ENC

	public static List<Area> GetTotalAEncuestarPorAreaPorIdEnc(int idEnc) {

		JdbcTemplate jdbcTemplate = Conexion.getConnection();

		String sql = "SELECT count(*) as contador, a.nom_area from ENCUESTADOS e\n"
				+ "inner join COLABORADOR c ON c.id_colab=e.id_colab\r\n" + 
				"inner join AREA a ON a.id_area=c.id_area\n" 
				+ "where e.id_enc=? " + "";
		RowMapper<Area> rowMapper = new AreaRowMapper();
		return jdbcTemplate.query(sql, rowMapper, idEnc);

	}
	//TOTAL DE ENCUESTAS RESPONDIDAS POR ID_ENC 
	public static List<Area> GetTotalEncuestasRespondidasPorIdEnc(int idEnc) {

		JdbcTemplate jdbcTemplate = Conexion.getConnection();

		String sql = "SELECT count(*)/2 as contador, a.nom_area from RESPUESTA r\n"
				+ "inner join AREA a ON r.id_area=a.id_area\n" 
				+ "where r.id_enc=? " + "";
		RowMapper<Area> rowMapper = new AreaRowMapper();
		return jdbcTemplate.query(sql, rowMapper, idEnc);

	}

	// 3.1.seccion
	public static List<Respuesta> GetAllRespuestasSisSenti(int idEnc, int idPreg, int idArea) {
		JdbcTemplate jdbcTemplate = Conexion.getConnection();

		// cuantos han respodido al momento
		String sql = "select desc_rpta from RESPUESTA where id_enc=? and id_preg=? and id_area=? ";
		RowMapper<Respuesta> rowMapper = new ResultadoRespuestaRowMapper();
		return jdbcTemplate.query(sql, rowMapper, idEnc, idPreg, idArea);

	}

	// 3.2.seccion a --ANALISIS POSITIVOS , EJEMPLO: ENCUESTA =1
	// flag 0 negativo
	// flag 1 positivo
	public static List<Respuesta> GetAnalisisSisSenti(int idEnc, int idPreg, int flagsenti) {

		JdbcTemplate jdbcTemplate = Conexion.getConnection();

		// cuantos han respodido al momento
		String sql = "select id_rpta, flag_senti, desc_rpta from RESPUESTA "
				+ "where id_enc=? and id_preg=? AND flag_senti=?";
		RowMapper<Respuesta> rowMapper = new AnalisisSentimientosRowMapper();
		return jdbcTemplate.query(sql, rowMapper, idEnc, idPreg, flagsenti);

	}

	// 3.3. ACTUALIZAR LA RESPUESTA DESPUES DE ANALIZAR EL SAGEMAER
	public static void UpdateRespuestasSagemakerSisSenti(int flagSenti, int idRpta, int idPreg) {

		JdbcTemplate jdbcTemplate = Conexion.getConnection();

		// cuantos han respodido al momento
		String sql = "UPDATE RESPUESTA " + "SET flag_senti=? " + "WHERE id_rpta=? and id_preg=?";
		RowMapper<Respuesta> rowMapper = new AnalisisSentimientosRowMapper();
		jdbcTemplate.query(sql, rowMapper, flagSenti, idRpta, idPreg);

	}

	// 3.4 Servicio rest se se actualiza la base de datos _fin de la encuesta.
	public static void UpdateEncuestaSagemakerSisSenti(int flagFin, int idEnc) {

		JdbcTemplate jdbcTemplate = Conexion.getConnection();

		// cuantos han respodido al momento
		String sql = "UPDATE ENCUESTA " + "SET flag_fin=? " + "WHERE id_enc=? ";
		RowMapper<Respuesta> rowMapper = new AnalisisSentimientosRowMapper();
		jdbcTemplate.query(sql, rowMapper, flagFin, idEnc);

	}
	
	//3.5.Servicio rest se env�a id_encuesta y retorna el flag_fin
	public static String GetEncuestaResultadoe(int idEnc) {
			JdbcTemplate jdbcTemplate = Conexion.getConnection();

			// cuantos han respodido al momento
			String sql = "select e.flag_fin from ENCUESTA e where e.id_enc=? ";
			RowMapper<String> rowMapper = new BeanPropertyRowMapper<String>(String.class);
			String flagFin = jdbcTemplate.queryForObject(sql, rowMapper, idEnc);
			// String contador = long.toString(contador1);

			return flagFin;

		}

	public static void main(String[] args) {
		List<Respuesta> list = GetAnalisisSisSenti(3, 1, 0);

		for (Respuesta respuesta : list) {
			System.out.println(respuesta.getIdEnc());
			System.out.println(respuesta.getDescRpta());
		}

	}
	

	// 2.1.seccion
	public static String GetRespuestasbyFlagAndIdEncAndIdPreg(int flagSenti, int idEnc, int idPreg) {
		JdbcTemplate jdbcTemplate = Conexion.getConnection();

		// cuantos han respodido al momento
		String sql = "SELECT count(*) as contador from RESPUESTA where flag_senti=? and id_enc=? and id_preg=? ";
		RowMapper<String> rowMapper = new BeanPropertyRowMapper<String>(String.class);
		String contador = jdbcTemplate.queryForObject(sql, rowMapper, flagSenti, idEnc, idPreg);
		// String contador = long.toString(contador1);

		return contador;

	}

}
