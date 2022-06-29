package it.csi.stacore.staconsultazionesrv.integration.dao.oracle;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import it.csi.stacore.staconsultazionesrv.integration.bo.Evento;
import it.csi.stacore.staconsultazionesrv.integration.bo.Posizione;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdPosizione;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdVeicolo;
import it.csi.stacore.staconsultazionesrv.integration.dao.AbstractDAO;
import it.csi.stacore.staconsultazionesrv.integration.dao.PosizioneDAO;
import it.csi.stacore.staconsultazionesrv.integration.dao.oracle.query.select.posizione.SelectEventoFineByIdVeicoloDate;
import it.csi.stacore.staconsultazionesrv.integration.dao.oracle.query.select.posizione.SelectPosizione;
/*
import it.csi.stacore.staon.business.bo.bonifica.OperazioneLogica;
import it.csi.stacore.staon.integration.oracle.query.delete.posizione.DeletePosizione;
import it.csi.stacore.staon.integration.oracle.query.insert.posizione.InsertPosizione;
import it.csi.stacore.staon.integration.oracle.query.select.posizione.SelectCountPosizione;
import it.csi.stacore.staon.integration.oracle.query.select.posizione.SelectEventoFineByIdVeicoloDate;
import it.csi.stacore.staon.integration.oracle.query.select.posizione.SelectIdCassaOperazione;
import it.csi.stacore.staon.integration.oracle.query.select.posizione.SelectIdTipoUtenteOperazione;
import it.csi.stacore.staon.integration.oracle.query.select.posizione.SelectPosizione;
import it.csi.stacore.staon.integration.oracle.query.select.posizione.SelectPosizioneConIdVeicoloEDataDecorrenza;
import it.csi.stacore.staon.integration.oracle.query.select.posizione.SelectPosizionePaginata;
import it.csi.stacore.staon.integration.oracle.query.select.posizione.SelectPosizioni;
import it.csi.stacore.staon.integration.oracle.query.select.posizione.SelectTotalePosizioniPaginate;
import it.csi.stacore.staon.integration.oracle.query.update.posizione.UpdatePosizione;
*/
import it.csi.stacore.staconsultazionesrv.integration.exception.ResourceAccessException;
import it.csi.stacore.staconsultazionesrv.util.Tracer;

/*
 * 
 */
@Repository("oraclePosizioneDAO")
public class OraclePosizioneDAO extends AbstractDAO implements PosizioneDAO {

	
	private Evento selectEventoFineByIdVeicoloDate(IdVeicolo idVeicolo, java.util.Date date) throws ResourceAccessException {
		final String method = "loadUtenteById";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		
		SelectEventoFineByIdVeicoloDate select = new SelectEventoFineByIdVeicoloDate(idVeicolo, date);
		Connection connection = null;
		try {
			connection = getConnection();
			return (Evento) select.execute(connection);
		}catch (Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new ResourceAccessException(e.getMessage(), e);
		}
		finally{
			releaseConnection(connection);
			Tracer.debug(LOG, getClass().getName(), method, "END");
		}
	}
	
	public Posizione loadById(IdPosizione id) throws ResourceAccessException {
		final String method = "loadUtenteById";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		
		Posizione result = null;
		Connection connection = null;
		
		try{
			connection = getConnection();
			SelectPosizione select = new SelectPosizione(id);
				
			result = (Posizione) select.execute(connection);

			if (result != null) {
				result.setEventoFine(selectEventoFineByIdVeicoloDate(result.getIdVeicolo(), result.getEventoInizio().getData()));
			}
			


		}catch (Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new ResourceAccessException(e.getMessage(), e);
		}
		finally{
			releaseConnection(connection);
			Tracer.debug(LOG, getClass().getName(), method, "END");
		}
		return result;
	}
	
}
