package it.csi.stacore.staconsultazionesrv.api.service.impl;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.stacore.staconsultazionesrv.api.dto.GenericResponse;
import it.csi.stacore.staconsultazionesrv.api.dto.Utente;
import it.csi.stacore.staconsultazionesrv.api.service.PosizioneApi;
import it.csi.stacore.staconsultazionesrv.business.helper.PosizioneHelper;
import it.csi.stacore.staconsultazionesrv.business.helper.TestResourceHelper;



@Component("posizioneApi")
public class PosizioneApiImpl implements PosizioneApi {

	@Autowired
	private TestResourceHelper testResourceHelper;
	
	@Autowired
	private PosizioneHelper posizioneHelper;

	public Response testResources(SecurityContext securityContext, HttpHeaders httpHeaders ) {
		GenericResponse response = new GenericResponse();
		boolean testResource = testResourceHelper.testResources();
		if(testResource)
			response.setMessage("TUTTO OK");
		else
			response.setMessage("TEST RESOURCE KO");

		return Response.ok().entity(response).build();
	}

	@Override
	public Response caricaDettaglioPosizione(Long id, Utente utente, SecurityContext securityContext,HttpHeaders httpHeaders) {
		return Response.ok().entity(posizioneHelper.caricaDettaglioPosizione(id, utente)).build();
	}

}
