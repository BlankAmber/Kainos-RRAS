package org.kainos.ea.util;

import com.auth0.jwt.exceptions.JWTVerificationException;
import org.kainos.ea.client.JWTExpiredException;
import org.kainos.ea.db.RoleID;

import javax.ws.rs.core.Response;

public final class ControllerUtil {
    private ControllerUtil() {

    }

    private static Response validAuthHeaderAtLeastRoleID(String authHeader, RoleID roleId) {
        try {
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Invalid or missing Authorisation header").build();
            }

            String jwt = authHeader.substring("Bearer ".length());
            switch (roleId) {
                case ADMIN:
                    if (!JWTUtil.isAdmin(jwt)) {
                        System.out.println("Forbidden response received when verifying "
                                + "if user is an admin!");
                        return Response.status(Response.Status.FORBIDDEN).build();
                    }
                    break;
                case EMPLOYEE:
                    if (!JWTUtil.isAtLeastEmployee(jwt)) {
                        System.out.println("Forbidden response received when verifying "
                                + "if user is at least an employee!");
                        return Response.status(Response.Status.FORBIDDEN).build();
                    }
                    break;
                default:
                    System.out.println("Invalid role specified when validating auth header!");
                    return Response.status(Response.Status.BAD_REQUEST)
                            .entity("Invalid role specified").build();
            }
        } catch (JWTExpiredException e) {
            return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
        } catch (JWTVerificationException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return null;
    }

    public static Response validAuthHeaderIsAdmin(String authHeader) {
        return validAuthHeaderAtLeastRoleID(authHeader, RoleID.ADMIN);
    }

    public static Response validAuthHeaderAtLeastEmployee(String authHeader) {
        return validAuthHeaderAtLeastRoleID(authHeader, RoleID.EMPLOYEE);
    }
}
