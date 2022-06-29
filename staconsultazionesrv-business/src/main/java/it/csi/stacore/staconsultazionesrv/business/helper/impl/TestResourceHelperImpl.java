package it.csi.stacore.staconsultazionesrv.business.helper.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.stacore.staconsultazionesrv.business.exception.HelperException;
import it.csi.stacore.staconsultazionesrv.business.helper.TestResourceHelper;
import it.csi.stacore.staconsultazionesrv.integration.service.stasogg.StasoggService;
import it.csi.stacore.staconsultazionesrv.util.Tracer;

@Service("testResourceHelper")
public class TestResourceHelperImpl extends CommonHelperImpl implements TestResourceHelper {
	
	
	@Autowired
	private StasoggService stasoggService;
	
	
	@PostConstruct
	public void init() {
		final String method = "init";
		try {
			Tracer.debug(LOG, getClass().getName(), method, "called");
			
			
			
		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception "  +e);
		}
		finally {
			
		}
		
	}

	@Override
	public boolean testResources() throws HelperException {
		final String method = "testResources";
		boolean testResources = false;
		try {
			Tracer.debug(LOG, getClass().getName(), method, "called");
			testResources = stasoggService.testResource();
		} catch (Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new HelperException(e.getMessage());
		}
		finally {
			
		}
		return testResources;
		
	}

	

}
