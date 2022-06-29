package it.csi.stacore.staconsultazionesrv.integration.service.stasogg.impl;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.csi.stacore.staconsultazionesrv.integration.exception.IntegrationException;
import it.csi.stacore.staconsultazionesrv.integration.service.ParentIntegrationServiceImpl;
import it.csi.stacore.staconsultazionesrv.integration.service.stasogg.StasoggService;
import it.csi.stacore.staconsultazionesrv.util.Environment;
import it.csi.stacore.staconsultazionesrv.util.Tracer;

@Service
public class StasoggServiceImpl extends ParentIntegrationServiceImpl implements StasoggService {

	@Autowired
	private Environment environment;
	
	
	@PostConstruct
	public void init() {
		final String method = "init";
		try {
			
			Tracer.info(LOG, getClass().getName(), method, "stasogg endpoint "  + environment.getStasoggEndpoint());
			
			
			

		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception "  +e);
		}
		finally {

		}

	}
	
	public boolean testResource() throws IntegrationException {
		final String method = "testResource";
		boolean result = false;
		try {
			RestTemplate restTemplate = new RestTemplate();
			String resourceUrl = environment.getStasoggEndpoint() + "/test/resources";
		
			Tracer.debug(LOG, getClass().getName(), method, "resourceUrl= "  + resourceUrl);
			
			
			String response = restTemplate.getForObject(resourceUrl, String.class);
			
			Tracer.debug(LOG, getClass().getName(), method, "response "  +response);
			
			if(StringUtils.isNotBlank(response)){
				result = true;
			}
			
		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception "  +e);
			throw new IntegrationException(e.getMessage(), e);
			
			
		}
		finally {

		}
		return result;
	}

}
