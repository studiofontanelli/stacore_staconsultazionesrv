package it.csi.stacore.staconsultazionesrv.api.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import it.csi.stacore.staconsultazionesrv.business.aspect.CommonAspect;
import it.csi.stacore.staconsultazionesrv.util.Constants;


@Component("apiAdapterAspect")
@Aspect
public class AdapterAspectApi extends CommonAspect{

	public static final String LOGGER_PREFIX = Constants.APPLICATION_CODE + ".aspect";

	
	@Before(value="execution(*  it.csi.stacore.staconsultazionesrv.api.adapter..*.*(..))")
	public void beforeAspect(JoinPoint joinPoint) throws Throwable {
		super.beforeAspect(joinPoint);
	}




}