/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.stacore.staconsultazionesrv.api.service;

import it.csi.stacore.staconsultazionesrv.api.dto.*;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import it.csi.stacore.staconsultazionesrv.api.dto.ErrorDto;
import it.csi.stacore.staconsultazionesrv.api.dto.GenericResponse;
import it.csi.stacore.staconsultazionesrv.api.dto.Utente;

import java.util.List;
import java.util.Map;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.HttpHeaders;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/posizione")


@io.swagger.annotations.Api(description = "the posizione API")

public interface PosizioneApi  {
   
    @GET
    @Path("/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Posizione", notes = "Effettua il test dei servizi richiamati", response = GenericResponse.class, tags={ "posizioni", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class) })
    public Response caricaDettaglioPosizione( @PathParam("id") Long id,@ApiParam(value = "Utente" ,required=true) Utente utente,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders );
}
