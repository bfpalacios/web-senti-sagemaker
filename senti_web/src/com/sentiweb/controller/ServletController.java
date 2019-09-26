package com.sentiweb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senti.entity.Respuesta;
import com.senti.persistence.dao.DaoEntity;
import com.sentiweb.aws.ApiGatewayClient;
import com.sentiweb.model.RespuestaEncuesta;
import com.sentiweb.model.StatusEncuesta;

/**
 * Servlet implementation class ServletController
 */
@WebServlet({ "/ServletController", "/index.do", "/tables.do", "/procesar.do" })
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String servletPath=request.getServletPath();
		
		if(servletPath.equalsIgnoreCase("/index.do")) {			
			diagramaPastel(request, response);			
			
			request.getRequestDispatcher("index.jsp").forward(request, response);return;
		}
		
		
		if(servletPath.equalsIgnoreCase("/tables.do")) {
			statusEncuesta(request, response);
			
			request.getRequestDispatcher("tables.jsp").forward(request, response);return;
		}
		
		if(servletPath.equalsIgnoreCase("/procesar.do")) {
			procesarEncuesta(request, response);
 
			request.getRequestDispatcher("index.jsp").forward(request, response);return;
		}
		
		
		
		
		
	}
	
	private void procesarEncuesta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<RespuestaEncuesta> listRespuestas=new ArrayList<RespuestaEncuesta>();
		//request.setAttribute("flagProcesoRequest", 1);

		int flagSenti =0;
		Object idEncuestaSessionObj=request.getSession().getAttribute("idEncuestaSession");
		
		if(idEncuestaSessionObj==null) {
			request.getSession().setAttribute("idEncuestaSession",1);
			idEncuestaSessionObj=request.getSession().getAttribute("idEncuestaSession");
		}		
		
		Integer idEncuestaSession=(Integer)idEncuestaSessionObj;		
		
		System.out.println("idEncuestaSession Procesar.do: "+idEncuestaSession);
		
		if(idEncuestaSession==1) {
			
			//leer Respuestas de MYSQL

			//List<Respuesta> respuestaList=DaoEntity.GetRespuestasbyIdEncAndIdPreg(idEncuestaSession, 1);
			List<Respuesta> respuestaList =DaoEntity.GetAllRecomendaciones();
			List<Respuesta> respuestaSentimientoList =DaoEntity.GetAllRespuestas(); 
			 
			//invocar sagemaker 
			for (Respuesta respuesta : respuestaSentimientoList) {
				flagSenti = ApiGatewayClient.obtenerEstadoSentimientoSagemaker(respuesta.getDescRpta()); 
				
				//actualizar base de datos el flag_senti respuesta
				
				DaoEntity.UpdateRespuestasSagemakerSisSenti(flagSenti, respuesta.getIdRpta(), respuesta.getIdPreg());
			}
			 
			//diagramaPastel(request, response);	 
			
		}else if(idEncuestaSession==2) {
			//listStatusEncuesta.add(new StatusEncuesta("Proyectos", 2, 3, 5));
			//request.getSession().setAttribute("statusEncuestasSession", listStatusEncuesta);
		}else {
			//listStatusEncuesta.add(new StatusEncuesta("Proyectos", 3, 3, 6));
			//request.getSession().setAttribute("statusEncuestasSession", listStatusEncuesta);
		}
	}
	
	private void statusEncuesta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<StatusEncuesta> listStatusEncuesta=new ArrayList<StatusEncuesta>();
		
		Object idEncuestaSessionObj=request.getSession().getAttribute("idEncuestaSession");
		
		if(idEncuestaSessionObj==null) {
			request.getSession().setAttribute("idEncuestaSession",1);
			idEncuestaSessionObj=request.getSession().getAttribute("idEncuestaSession");
		}		
		
		Integer idEncuestaSession=(Integer)idEncuestaSessionObj;	
		
		System.out.println("idEncuestaSession Tables.do: "+idEncuestaSession);
		
		if(idEncuestaSession==1) {			
			//Obtener base de datos status de encuestas respondidas			
			
			listStatusEncuesta.add(new StatusEncuesta("Proyectos", 3, 1, 4));
			request.getSession().setAttribute("statusEncuestasSession", listStatusEncuesta);
		}else if(idEncuestaSession==2) {
			//Obtener base de datos status de encuestas respondidas	
			
			listStatusEncuesta.add(new StatusEncuesta("Proyectos", 2, 3, 5));
			request.getSession().setAttribute("statusEncuestasSession", listStatusEncuesta);
		}else {
			//Obtener base de datos status de encuestas respondidas	
			
			listStatusEncuesta.add(new StatusEncuesta("Proyectos", 3, 3, 6));
			request.getSession().setAttribute("statusEncuestasSession", listStatusEncuesta);
		}
		
	}
	
	
	private void diagramaPastel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idEncuesta=request.getParameter("idEncuesta");
		
		if(idEncuesta!=null) {
			Integer id=Integer.parseInt(idEncuesta);
			request.getSession().setAttribute("idEncuestaSession", id);
		}
		
		String positivo="";
		String negativo="";
		String totalEncuestado="";
		//List<String> recomendaciones=new ArrayList<String>();
		
		Object idEncuestaSessionObj=request.getSession().getAttribute("idEncuestaSession");
		
		if(idEncuestaSessionObj!=null) {
			Integer idEncuestaSession=(Integer)idEncuestaSessionObj;
			
			
			double posSentimiento = DaoEntity.GetAnalisisSisSenti(idEncuestaSession, 1, 1).size();
			//Buscar DiagramaPastel de la encuesta idEncuesta				
			double negSentimiento = DaoEntity.GetAnalisisSisSenti(idEncuestaSession, 1, 0).size();
			
			
			int totalPastel = DaoEntity.GetAnalisisSisSenti(idEncuestaSession, 1, 1).size() + DaoEntity.GetAnalisisSisSenti(idEncuestaSession, 1, 0).size();;
			double total = posSentimiento + negSentimiento;

			System.out.println("total"+ total);
			System.out.println("posSentimiento"+ posSentimiento);
			System.out.println("negSentimiento"+ negSentimiento);
			double porcentajePositivo 	= (posSentimiento/total)*100;
			double porcentajNegtivo 	= (negSentimiento/total)*100;
			
			
			porcentajePositivo = redondearDecimales(porcentajePositivo, 0);
			porcentajNegtivo = redondearDecimales(porcentajNegtivo, 0);
			

			System.out.println("porcentajePositivo " + porcentajePositivo);
			System.out.println("porcentajNegtivo " + negSentimiento/total);
			positivo=String.valueOf(porcentajePositivo);
			System.out.println("POSITIVO "+positivo );
			negativo=String.valueOf(porcentajNegtivo);

			System.out.println("NEGA "+negativo );

			request.getSession().setAttribute("positivoSession", positivo); 
			request.getSession().setAttribute("negativoSession", negativo); 
			//Buscar Recomendaciones de la encuesta idEncuesta
			

			//List<Respuesta> respuestaList=DaoEntity.GetRespuestasbyIdEncAndIdPreg(idEncuestaSession, 2);
			List<Respuesta> respuestaList=DaoEntity.GetAllRecomendaciones();
			List<Respuesta> respuestaPositivasList=DaoEntity.GetAnalisisSisSenti(1,1,1);
			List<Respuesta> respuestaNegativasList=DaoEntity.GetAnalisisSisSenti(1,1,0);
			

			request.getSession().setAttribute("recomendacionesSession", respuestaList);
			request.getSession().setAttribute("respuestasPositivasSession", respuestaPositivasList);
			request.getSession().setAttribute("respuestasNegativasSession", respuestaNegativasList);
			 
			request.getSession().setAttribute("totalEncuestadoSession", totalPastel);
			
			/*if(idEncuestaSession==1) {
				//Buscar DiagramaPastel de la encuesta idEncuesta				
				positivo="100";
				negativo="0";				
				request.getSession().setAttribute("positivoSession", positivo);
				request.getSession().setAttribute("negativoSession", negativo);
				//Buscar Recomendaciones de la encuesta idEncuesta
				
				recomendaciones.add("recomendacion pos1");
				recomendaciones.add("recomendacion pos2");
				recomendaciones.add("recomendacion pos3");
				recomendaciones.add("recomendacion pos4");
				request.getSession().setAttribute("recomendacionesSession", recomendaciones);
				
				//Listar total encuestados
				totalEncuestado="4";
				request.getSession().setAttribute("totalEncuestadoSession", totalEncuestado);
			}else if(idEncuestaSession==2) {
				//Buscar DiagramaPastel de la encuesta idEncuesta				
				positivo="0";
				negativo="100";				
				request.getSession().setAttribute("positivoSession", positivo);
				request.getSession().setAttribute("negativoSession", negativo);
				//Buscar Recomendaciones de la encuesta idEncuesta
				
				recomendaciones.add("recomendacion nega1");
				recomendaciones.add("recomendacion nega2");
				recomendaciones.add("recomendacion nega3");
				recomendaciones.add("recomendacion nega4");
				recomendaciones.add("recomendacion nega5");
				request.getSession().setAttribute("recomendacionesSession", recomendaciones);
				
				//Listar total encuestados
				totalEncuestado="5";
				request.getSession().setAttribute("totalEncuestadoSession", totalEncuestado);
			}else {
				//Buscar DiagramaPastel de la encuesta idEncuesta				
				positivo="15";
				negativo="85";				
				request.getSession().setAttribute("positivoSession", positivo);
				request.getSession().setAttribute("negativoSession", negativo);
				//Buscar Recomendaciones de la encuesta idEncuesta
				
				recomendaciones.add("recomendacion mix1");
				recomendaciones.add("recomendacion mix2");
				recomendaciones.add("recomendacion mix3");
				recomendaciones.add("recomendacion mix4");
				recomendaciones.add("recomendacion mix5");
				recomendaciones.add("recomendacion mix6");
				request.getSession().setAttribute("recomendacionesSession", recomendaciones);
				
				//Listar total encuestados
				totalEncuestado="6";
				request.getSession().setAttribute("totalEncuestadoSession", totalEncuestado);
			}*/
		}
	}
	
	public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
