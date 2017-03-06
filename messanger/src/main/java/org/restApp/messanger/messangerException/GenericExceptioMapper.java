package org.restApp.messanger.messangerException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.restApp.messanger.model.ErrorMessage;
@Provider
public class GenericExceptioMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "visit my website");		
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				       .entity(errorMessage)
				       .build();
				
	}


}
