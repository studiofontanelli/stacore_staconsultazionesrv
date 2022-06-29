package it.csi.stacore.staconsultazionesrv.api.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import it.csi.stacore.staconsultazionesrv.business.aspect.CommonAspect;
import it.csi.stacore.staconsultazionesrv.util.Constants;


@Component("apiAspect")
@Aspect
public class ApiAspect extends CommonAspect{

	public static final String LOGGER_PREFIX = Constants.APPLICATION_CODE + ".aspect";

	
	@Around(value = "execution(* it.csi.stacore.staconsultazionesrv.api.service.impl..*.*(..))", argNames = "joinPoint")
	public Object stopWatchMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		return super.stopWatchAspect(joinPoint);
	}



}