package com.sentiweb.aws;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;

import com.amazonaws.http.HttpMethodName;

import com.amazonaws.util.StringInputStream;
import com.sentiweb.aws.adapters.GenericApiGatewayClient;
import com.sentiweb.aws.adapters.GenericApiGatewayClientBuilder;
import com.sentiweb.aws.adapters.GenericApiGatewayException;
import com.sentiweb.aws.adapters.GenericApiGatewayRequestBuilder;
import com.sentiweb.aws.adapters.GenericApiGatewayResponse;
import com.sentiweb.aws.entity.ProxyResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;


public class ApiGatewayClient {
	
	public  static final String ACCESS_KEY="AKIAWSSDTQJR72G54NXN";
	public  static final String SECRET_KEY="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";
	public  static final String END_POINT_PATH	="https://dujsdwnalf.execute-api.us-east-1.amazonaws.com";
	public  static final String RESOURCE_PATH	="/prod";
	public  static final String REGION			="us-east-1";
	public  static final String LABEL_POSITIVO	= "__label__Positivo";
	public  static int indicador = 3;
	
	public ApiGatewayClient() {

	}
	public static int obtenerEstadoSentimientoSagemaker(String analisisMensajeSentimiento){
	
		String endpointPath= END_POINT_PATH;
		String resourcePath=RESOURCE_PATH;
		String region=REGION;
		HttpMethodName methodName=HttpMethodName.POST;		
		
		//String unitarioPos = "buena apoyo de todos nosotros";
		//String unitario = "malo para la salud";
		String respuestaBaseDatos = "\""+analisisMensajeSentimiento+"\""; 

		String request="{\r\n" + 
				"  \"encuesta\": [\r\n"  
				 + respuestaBaseDatos+"\r\n"+ 
				"  ]\r\n" + 
				"}"; 
		 
		

		ProxyResponse proxyResponse=procesarApi(endpointPath, resourcePath, region, 
				methodName, request); 

		System.out.println("Codigo Rpta: "+proxyResponse.getCodeRpta());
		System.out.println("Mensaje Rpta: "+proxyResponse.getMsgRpta());
		
		  
		String respuestaPos = LABEL_POSITIVO;

		String[] palabras = proxyResponse.getMsgRpta().split("\\W+");
		for (String palabra : palabras) {
			
			//System.out.println("palabra ==>" + palabra);
		    if (respuestaPos.equals(palabra)) {
		        //System.out.println("Encontrado");
		        indicador = 1; 
		   } else indicador = 0;
		}
		
		System.out.println("resultado es "+indicador );
		
		return indicador;
	
	}	
	
	/*public static void main(String[] args) {
		
		
		String endpointPath= END_POINT_PATH;
		String resourcePath=RESOURCE_PATH;
		String region=REGION;
		HttpMethodName methodName=HttpMethodName.POST;		
		
		String unitarioPos = "buena apoyo de todos nosotros";
		String unitario = "malo para la salud";
		String respuestaBaseDatos = "\""+unitarioPos+"\""; 

		String request="{\r\n" + 
				"  \"encuesta\": [\r\n"  
				 + respuestaBaseDatos+"\r\n"+ 
				"  ]\r\n" + 
				"}"; 
		 
		

		ProxyResponse proxyResponse=procesarApi(endpointPath, resourcePath, region, 
				methodName, request); 

		System.out.println("Codigo Rpta: "+proxyResponse.getCodeRpta());
		System.out.println("Mensaje Rpta: "+proxyResponse.getMsgRpta());
		
		  
		String respuestaPos = LABEL_POSITIVO;

		String[] palabras = proxyResponse.getMsgRpta().split("\\W+");
		for (String palabra : palabras) {
			
			//System.out.println("palabra ==>" + palabra);
		    if (respuestaPos.equals(palabra)) {
		        //System.out.println("Encontrado");
		        indicador = 1; 
		   } else indicador = 0;
		}
		
		System.out.println("resultado es "+indicador );
		
	}*/
	
	
	public  static ProxyResponse procesarApi(String endpointPath, String resourcePath, String region, HttpMethodName methodName, String request) {
		
		ProxyResponse response=null;
		GenericApiGatewayResponse apiResponse=null;
		InputStream inputStrean=null;
		try {
			inputStrean = new StringInputStream(request);					

			//BasicAWSCredentials creds = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
			//AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion("us-east-1").withCredentials(new AWSStaticCredentialsProvider(creds)).build();

			GenericApiGatewayClient client = new GenericApiGatewayClientBuilder()
	                .withClientConfiguration(new ClientConfiguration())
	                //.withCredentials(new AWSStaticCredentialsProvider(creds))
	                .withEndpoint(endpointPath) // your API ID
	                .withRegion(Region.getRegion(Regions.fromName(region)))
	                .build();        
	        
            apiResponse = client.execute(  // throws exception for non-2xx response
                    new GenericApiGatewayRequestBuilder()
                            .withHttpMethod(methodName)
                            .withResourcePath(resourcePath).withBody(inputStrean).build());

            response = new ProxyResponse(String.valueOf(apiResponse.getHttpResponse().getStatusCode()), apiResponse.getBody());
	       

		} catch (UnsupportedEncodingException e) {
			System.out.println("Convert String to InputStream Exception " + e);
            response = new ProxyResponse("400", e.getMessage());
		} catch (GenericApiGatewayException e) {
            System.out.println("Client threw exception " + e);
            response = new ProxyResponse("400", e.getMessage());
        }
			
		return response;
		
		
	}

}
