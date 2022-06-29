package it.csi.stacore.staconsultazionesrv.integration.dao;

import java.sql.Connection;

import it.csi.stacore.staconsultazionesrv.integration.bo.Posizione;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdPosizione;
import it.csi.stacore.staconsultazionesrv.integration.exception.ResourceAccessException;

/**
 * 
 * @author andreafontanelli
 *
 */
public interface PosizioneDAO {


	
	public Posizione loadById(IdPosizione id) throws ResourceAccessException;

}
