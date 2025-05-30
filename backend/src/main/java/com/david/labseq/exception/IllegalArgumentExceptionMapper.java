package com.david.labseq.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(IllegalArgumentException ex) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(ex.getMessage())
                .build();
    }
}
