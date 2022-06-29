package it.csi.stacore.staconsultazionesrv.integration.dao.oracle;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import it.csi.stacore.staconsultazionesrv.integration.bo.Veicolo;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdVeicolo;
import it.csi.stacore.staconsultazionesrv.integration.dao.AbstractDAO;
import it.csi.stacore.staconsultazionesrv.integration.dao.VeicoloDAO;
import it.csi.stacore.staconsultazionesrv.integration.dao.oracle.query.select.veicolo.SelectVeicoloByIdList;
import it.csi.stacore.staconsultazionesrv.integration.exception.ResourceAccessException;
import it.csi.stacore.staconsultazionesrv.util.Tracer;
import it.csi.stacore.staconsultazionesrv.util.XmlSerializer;


@Repository("oracleVeicoloDAO")
public class OracleVeicoloDAO extends AbstractDAO implements VeicoloDAO {

	public Veicolo loadById(IdVeicolo id) throws ResourceAccessException {
		final String method = "loadById";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		Veicolo result = null;
		List<IdVeicolo> idVeicoloList = new ArrayList<IdVeicolo>();
		idVeicoloList.add(id);
		try {
			
			List<Veicolo> veicoliList = loadById(idVeicoloList);
			if (!veicoliList.isEmpty()) {
				result = (Veicolo) veicoliList.iterator().next();
			}
			return result;
		}catch (Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new ResourceAccessException(e.getMessage(), e);
		}
		finally{
			
			Tracer.debug(LOG, getClass().getName(), method, "END");
		}
	}


	public List<Veicolo> loadById(List<IdVeicolo> idVeicoli) throws ResourceAccessException {
		final String method = "loadById";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		List<Veicolo> risultato = new ArrayList<Veicolo>();

		if ((idVeicoli == null) || (idVeicoli.size() == 0)) {
			// nessun elemento presente, esco senza fare nulla
			return risultato;
		}
		Connection connection = null;
		try {
			connection = getConnection();

			SelectVeicoloByIdList select = new SelectVeicoloByIdList(idVeicoli);
			risultato =  select.executeMultipla(connection);
			
			Tracer.debug(LOG, getClass().getName(), method, "risultato\n " + XmlSerializer.objectToXml(risultato));
			
			return risultato;
		}catch (Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new ResourceAccessException(e.getMessage(), e);
		}
		finally{
			releaseConnection(connection);
			Tracer.debug(LOG, getClass().getName(), method, "END");
		}
	}


}
