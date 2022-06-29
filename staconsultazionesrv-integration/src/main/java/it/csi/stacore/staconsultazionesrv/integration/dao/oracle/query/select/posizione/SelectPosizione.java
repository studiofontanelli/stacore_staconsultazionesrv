package it.csi.stacore.staconsultazionesrv.integration.dao.oracle.query.select.posizione;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.csi.stacore.staconsultazionesrv.integration.bo.Evento;
import it.csi.stacore.staconsultazionesrv.integration.bo.Fonte;
import it.csi.stacore.staconsultazionesrv.integration.bo.Posizione;
import it.csi.stacore.staconsultazionesrv.integration.bo.TipoEvento;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdFonte;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdOperazioneLogica;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdPosizione;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdProprietario;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdTipoEvento;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdVeicolo;
import it.csi.stacore.staconsultazionesrv.integration.dao.oracle.query.select.AbstractSelect;
import it.csi.stacore.staconsultazionesrv.integration.dao.oracle.query.select.TAURDEResultSet;
import it.csi.stacore.staconsultazionesrv.integration.dao.oracle.query.select.TauPreparedStatement;
import it.csi.stacore.staconsultazionesrv.integration.dao.oracle.util.OracleQuery;
import it.csi.stacore.staconsultazionesrv.integration.dao.oracle.util.OracleQueryList;
import it.csi.stacore.staconsultazionesrv.integration.exception.InvalidSearchObjectException;
import it.csi.stacore.staconsultazionesrv.util.Constants;
import it.csi.util.performance.StopWatch;

/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class SelectPosizione extends AbstractSelect {
	//~ Instance fields ==========================================================

	/**
	 * @uml.property  name="idPosizione"
	 * @uml.associationEnd  
	 */
	private IdPosizione idPosizione = null;

	/**
	 * @uml.property  name="vincoliPosizione"
	 * @uml.associationEnd  
	 */
	private Posizione vincoliPosizione = null;

	/**
	 * DOCUMENT ME!
	 * @uml.property  name="bVincoli"
	 */
	boolean bVincoli = false; /* indica se ricerco per vincoli o Id */

	/**
	 * @uml.property  name="idVeicoloPrecedente"
	 */
	private Long idVeicoloPrecedente = null;

	/**
	 * @uml.property  name="idProprietarioPrecedente"
	 */
	private Long idProprietarioPrecedente = null;

	/**
	 * @uml.property  name="eventoFine"
	 * @uml.associationEnd  
	 */
	private Evento eventoFine = null;

	/**
	 * @uml.property  name="posizioniIncomplete"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="it.csi.stacore.staon.business.bo.Posizione"
	 */
	private List posizioniIncomplete = new ArrayList();
	
	Date dataDecorrenzaPrecedente = null;

	//~ Constructors =============================================================

	/**
	 * Creates a new SelectPosizione object.
	 */
	public SelectPosizione() {
		super();
	}

	/**
	 * Creates a new SelectPosizione object.
	 *
	 * @param idPosizione
	 */
	public SelectPosizione(IdPosizione idPosizione) {
		super();
		this.idPosizione = idPosizione;
		bVincoli = false;
	}

	/**
	 * Creates a new SelectPosizione object.
	 *
	 * @param vincoliPosizione
	 */
	public SelectPosizione(Posizione vincoliPosizione) {
		super();
		this.vincoliPosizione = vincoliPosizione;
		bVincoli = true;
	}

	//~ Methods ==================================================================

	/**
	 * ritorna il BO di Business Logic
	 *
	 * @param rs
	 *
	 * @return
	 *
	 * @throws java.sql.SQLException
	 */
	public Object createBO(TAURDEResultSet rs) throws java.sql.SQLException {
		Long idPosizioneLong = rs.getLong("id_posizione");
		Long idVeicoloLong = rs.getLong("id_veicolo");
		Long idProprietarioLong = rs.getLong("id_proprietario");
		Long idOperazioneLogica = rs.getLong("id_operazione");

		IdPosizione idPosizione = new IdPosizione(idPosizioneLong.longValue());
		IdProprietario idProprietario = (idProprietarioLong != null) ? new IdProprietario(idProprietarioLong.longValue()) : null;
		IdVeicolo idVeicolo = new IdVeicolo(idVeicoloLong.longValue());
		IdOperazioneLogica idOpeLogica = new IdOperazioneLogica(idOperazioneLogica.longValue());

	
		
		TipoEvento tipoEv = new TipoEvento(new IdTipoEvento(rs.getLong("ID_TIPO_EVENTO")) , rs.getString("cod_tipo_evento"), rs.getString("desc_tipo_evento"));
		Fonte fonte = new Fonte (new IdFonte(rs.getLong("id_fonte")), rs.getString("cod_fonte"), rs.getString("desc_fonte"));
 
		
		Date dataDecorrenza = rs.getDate("DATA_DECORRENZA");
		Evento eventoInizio = new Evento(tipoEv, dataDecorrenza);

		
		Long idTipoSoggettoPassivo = rs.getLong("ID_TIPO_SOGG_PASSIVO");

		if (idProprietarioLong != null) {
			if (!idVeicoloLong.equals(idVeicoloPrecedente) ||
				!idProprietarioLong.equals(idProprietarioPrecedente) ||
				(dataDecorrenzaPrecedente!=null && !dataDecorrenza.equals(dataDecorrenzaPrecedente)) ) {
				eventoFine = null;
			}
		} else {
			eventoFine = null;
		}

		Posizione posizione = new Posizione(idPosizione, idProprietario, idVeicolo, eventoInizio, eventoFine, fonte, idTipoSoggettoPassivo, idOpeLogica);

		if (eventoFine == null) {
			// devo recuperare l'evento fine dalla posizione appena successiva
			posizioniIncomplete.add(posizione);
		}

		eventoFine = eventoInizio;

		idVeicoloPrecedente = idVeicoloLong;
		idProprietarioPrecedente = idProprietarioLong;
		dataDecorrenzaPrecedente = dataDecorrenza;

		return posizione;
	}

	/**
	 * ritorna la stringa SQl da eseguire
	 *
	 * @return
	 *
	 * @throws InvalidSearchObjectException
	 */
	public String getSQLStatement() throws InvalidSearchObjectException {
		OracleQuery q = OracleQueryList.getInstance().getQuery(getClass().getName());
		String query = q.getBody() + q.getFieldBody("progCorrezioneT");
		query += (q.getFrom() + q.getParamFrom("tabT"));
		query += q.getWhere();

		// aggiungo il parametro cancellazione sempre necessario
		query += q.getParamWhere("cancellazione");

		if (bVincoli) {
			// ricerco per vincoli sulla posizione
			if (vincoliPosizione == null) {
				throw new InvalidSearchObjectException("Ricerca posizione: vincoliPosizione non pu� essere null");
			}

			IdProprietario idProprietario = vincoliPosizione.getIdProprietario();
			IdVeicolo idVeicolo = vincoliPosizione.getIdVeicolo();

			if (idProprietario == null && idVeicolo == null) {
				throw new InvalidSearchObjectException("Ricerca posizione: idProprietario e idVeicolo non pu� essere null");
			}

			if (idProprietario != null) {
				query += q.getParamWhere("idProprietario");
			}

			if (idVeicolo != null) {
				query += q.getParamWhere("idVeicolo");
			}

			query += q.getOrderBy();
		} else {
			// ricerco per idPosizione
			if (idPosizione == null) {
				throw new InvalidSearchObjectException("Ricerca posizione: idPosizione non pu� essere null");
			}

			query += q.getParamWhere("idPosizione");
		}

		return query;
	}

	/**
	 * Ritorna una Collection di oggetti costruiti nel metodo createBO(ResultSet
	 * rs) Da usare nel caso in cui la query debba eseguire ricerche multiple.
	 *
	 * @param conn
	 *
	 * @return
	 *
	 * @throws SQLException
	 * @throws InvalidSearchObjectException
	 */
	public List executeMultipla(Connection conn) throws SQLException, InvalidSearchObjectException {
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_NAME);
		stopWatch.start();

		getLogger().debug("[execute()] - query: " + getSQLStatement());

		TauPreparedStatement stmt = new TauPreparedStatement(conn, getSQLStatement());

		try {
			setPreparedStatement(stmt);

			TAURDEResultSet rs = stmt.executeQuery();

			try {
				List result = new ArrayList();
				idVeicoloPrecedente = null;
				idProprietarioPrecedente = null;
				posizioniIncomplete = new ArrayList();

				while (rs.next()) {
					Object queryResult = createBO(rs);

					if (queryResult != null) {
						result.add(0, queryResult);
					}
				}

				return result;
			} finally {
				rs.close();
			}
		} finally {
			stmt.close();
			stopWatch.dumpElapsed(getClass().getName(), "executeMultipla()", "esecuzione query", "query = " + getClass().getName());
		}
	}

	/**
	 * restituisce la lista di posizioni Incomplete a cui eventualmente settare l'eventoFine
	 * @return
	 * @uml.property  name="posizioniIncomplete"
	 */
	public List getPosizioniIncomplete() {
		return posizioniIncomplete;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param stmt DOCUMENT ME!
	 *
	 * @throws java.sql.SQLException DOCUMENT ME!
	 */
	protected void setPreparedStatement(TauPreparedStatement stmt) throws java.sql.SQLException {
		int iPos = 1;

		if (bVincoli) {
			// ricerco per vincoli sulla posizione
			IdProprietario idProprietario = vincoliPosizione.getIdProprietario();

			if (idProprietario != null) {
				stmt.setLongId(iPos++, idProprietario);
			}

			IdVeicolo idVeicolo = vincoliPosizione.getIdVeicolo();

			if (idVeicolo != null) {
				stmt.setLongId(iPos++, idVeicolo);
			}
		} else {
			// ricerco per idPosizione
			stmt.setLongId(iPos++, idPosizione);
		}
	}
}
