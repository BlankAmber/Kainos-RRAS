package org.kainos.ea.util;

import com.auth0.jwt.exceptions.JWTVerificationException;
import org.kainos.ea.client.JWTExpiredException;

import javax.ws.rs.core.Response;

public final class ControllerUtil {
    private ControllerUtil() {

    }

    public static Response validAuthHeaderAtLeastEmployee(String authHeader) {
        try {
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Invalid or missing Authorisation header").build();
            }

            String jwt = authHeader.substring("Bearer ".length());
            if (!JWTUtil.isAtLeastEmployee(jwt)) {
                return Response.status(Response.Status.FORBIDDEN).build();
            }
        } catch (JWTExpiredException e) {
            return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
        } catch (JWTVerificationException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return null;
    }

    public static Response validAuthHeaderIsAdmin(String authHeader) {
        try {
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Invalid or missing Authorisation header").build();
            }

            String jwt = authHeader.substring("Bearer ".length());
            if (!JWTUtil.isAdmin(jwt)) {
                return Response.status(Response.Status.FORBIDDEN).build();
            }
        } catch (JWTExpiredException e) {
            return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
        } catch (JWTVerificationException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return null;
    }
}
