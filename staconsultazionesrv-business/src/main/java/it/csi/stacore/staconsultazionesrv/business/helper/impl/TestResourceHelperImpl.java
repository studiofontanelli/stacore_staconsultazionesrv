package it.csi.stacore.staconsultazionesrv.business.helper.impl;

import javax.annotation.PostConstruct;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> 4187d7cfb811770ff3b7868935cddd1b9abc4884
import org.springframework.stereotype.Service;

import it.csi.stacore.staconsultazionesrv.business.exception.HelperException;
import it.csi.stacore.staconsultazionesrv.business.helper.TestResourceHelper;
<<<<<<< HEAD
import it.csi.stacore.staconsultazionesrv.integration.service.stasogg.StasoggService;
=======
>>>>>>> 4187d7cfb811770ff3b7868935cddd1b9abc4884
import it.csi.stacore.staconsultazionesrv.util.Tracer;

@Service("testResourceHelper")
public class TestResourceHelperImpl extends CommonHelperImpl implements TestResourceHelper {
	
	
<<<<<<< HEAD
	@Autowired
	private StasoggService stasoggService;
=======
	
	
>>>>>>> 4187d7cfb811770ff3b7868935cddd1b9abc4884
	
	
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
<<<<<<< HEAD
		boolean testResources = false;
		try {
			Tracer.debug(LOG, getClass().getName(), method, "called");
			testResources = stasoggService.testResource();
=======
		try {
			Tracer.debug(LOG, getClass().getName(), method, "called");
			return true;
>>>>>>> 4187d7cfb811770ff3b7868935cddd1b9abc4884
		} catch (Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new HelperException(e.getMessage());
		}
		finally {
			
		}
<<<<<<< HEAD
		return testResources;
=======
>>>>>>> 4187d7cfb811770ff3b7868935cddd1b9abc4884
		
	}

	

}
