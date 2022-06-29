package it.csi.stacore.staconsultazionesrv.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Environment {



	@Value("${stasogg_service_endpoint_url}")
	private String stasoggEndpoint;

	public String getStasoggEndpoint() {
		return stasoggEndpoint;
	}

	public void setStasoggEndpoint(String stasoggEndpoint) {
		this.stasoggEndpoint = stasoggEndpoint;
	}

	
	




}
