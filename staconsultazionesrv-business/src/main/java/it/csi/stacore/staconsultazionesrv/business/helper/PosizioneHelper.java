package it.csi.stacore.staconsultazionesrv.business.helper;

import it.csi.stacore.staconsultazionesrv.api.dto.Posizione;
import it.csi.stacore.staconsultazionesrv.api.dto.Utente;
import it.csi.stacore.staconsultazionesrv.business.exception.HelperException;

public interface PosizioneHelper {

	
	
	public boolean testResources() throws HelperException;
	
	
	
	public Posizione caricaDettaglioPosizione(Long id, Utente utente) throws HelperException;
		
}
