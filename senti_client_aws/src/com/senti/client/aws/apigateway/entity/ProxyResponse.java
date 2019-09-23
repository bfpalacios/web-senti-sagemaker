package com.senti.client.aws.apigateway.entity;

public class ProxyResponse {
	private String codeRpta;
	private String msgRpta;
	
	public ProxyResponse(String codeRpta, String msgRpta) {
		super();
		this.codeRpta = codeRpta;
		this.msgRpta = msgRpta;
	}
	public ProxyResponse() {
		super();
	}
	public String getCodeRpta() {
		return codeRpta;
	}
	public void setCodeRpta(String codeRpta) {
		this.codeRpta = codeRpta;
	}
	public String getMsgRpta() {
		return msgRpta;
	}
	public void setMsgRpta(String msgRpta) {
		this.msgRpta = msgRpta;
	}
	
	
	

}
