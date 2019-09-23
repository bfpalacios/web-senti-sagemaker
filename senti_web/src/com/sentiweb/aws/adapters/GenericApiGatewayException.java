package com.sentiweb.aws.adapters;

import com.amazonaws.AmazonServiceException;

public class GenericApiGatewayException extends AmazonServiceException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GenericApiGatewayException(String errorMessage) {
        super(errorMessage);
    }

    public GenericApiGatewayException(String errorMessage, Exception cause) {
        super(errorMessage, cause);
    }
}
