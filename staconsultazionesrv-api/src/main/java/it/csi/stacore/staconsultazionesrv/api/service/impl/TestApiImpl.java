package it.csi.stacore.staconsultazionesrv.api.service.impl;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.stacore.staconsultazionesrv.api.dto.GenericResponse;
import it.csi.stacore.staconsultazionesrv.api.service.TestApi;
import it.csi.stacore.staconsultazionesrv.business.helper.TestResourceHelper;



@Component("testApi")
public class TestApiImpl implements TestApi {

	@Autowired
	private TestResourceHelper testResourceHelper;

	public Response testResources(SecurityContext securityContext, HttpHeaders httpHeaders ) {
		GenericResponse response = new GenericResponse();
		boolean testResource = testResourceHelper.testResources();
		if(testResource)
			response.setMessage("TUTTO OK");
		else
			response.setMessage("TEST RESOURCE KO");

		return Response.ok().entity(response).build();
	}

}
