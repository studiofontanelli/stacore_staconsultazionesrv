package it.csi.stacore.staconsultazionesrv.integration.dao;

import it.csi.stacore.staconsultazionesrv.integration.bo.Veicolo;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdVeicolo;
import it.csi.stacore.staconsultazionesrv.integration.exception.ResourceAccessException;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public interface VeicoloDAO {
  
  public Veicolo loadById(IdVeicolo id) throws ResourceAccessException;
  

  }
