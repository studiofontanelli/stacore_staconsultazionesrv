package it.csi.stacore.staconsultazionesrv.integration.dao.oracle.query.select.posizione;

import java.sql.SQLException;

import it.csi.stacore.staconsultazionesrv.integration.bo.Evento;
import it.csi.stacore.staconsultazionesrv.integration.bo.TipoEvento;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdTipoEvento;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdVeicolo;
import it.csi.stacore.staconsultazionesrv.integration.dao.oracle.query.select.AbstractSelect;
import it.csi.stacore.staconsultazionesrv.integration.dao.oracle.query.select.TAURDEResultSet;
import it.csi.stacore.staconsultazionesrv.integration.dao.oracle.query.select.TauPreparedStatement;
import it.csi.stacore.staconsultazionesrv.integration.exception.InvalidSearchObjectException;



/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class SelectEventoFineByIdVeicoloDate extends AbstractSelect {
	//~ Instance fields ==========================================================

	/**
	 * @uml.property  name="idVeicolo"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private IdVeicolo      idVeicolo;
	/**
	 * @uml.property  name="date"
	 */
	private java.util.Date date;

	//~ Constructors =============================================================

	/**
	 * Creates a new SelectEventoFineByIdVeicoloDate object.
	 *
	 * @param idVeicolo
	 * @param date
	 */
	public SelectEventoFineByIdVeicoloDate(
			IdVeicolo idVeicolo,
			java.util.Date date
			) {
		super();
		this.idVeicolo   = idVeicolo;
		this.date        = date;
	}

	//~ Methods ==================================================================

	/**
	 * ritorna il BO
	 *
	 * @param rs
	 *
	 * @return
	 *
	 * @throws SQLException
	 */
	public Object createBO(TAURDEResultSet rs) throws SQLException {
		TipoEvento tipoEv = new TipoEvento(new IdTipoEvento(rs.getLong("ID_TIPO_EVENTO")),
				rs.getString("cod_tipo_evento"),
				rs.getString("desc_tipo_evento"));
		return new Evento(tipoEv, rs.getDate("DATA_DECORRENZA"));
	}

	/**
	 * ritorna l'SQL da eseguire
	 *
	 * @return
	 *
	 * @throws InvalidSearchObjectException
	 */
	public String getSQLStatement() throws InvalidSearchObjectException {
		if(idVeicolo == null) {
			throw new InvalidSearchObjectException("Ricerca EventoFine: idVeicolo non pu� essere null");
		}

		if(date == null) {
			throw new InvalidSearchObjectException("Ricerca EventoFine: date non pu� essere null");
		}

		return super.getSQLStatement();
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param stmt DOCUMENT ME!
	 *
	 * @throws SQLException DOCUMENT ME!
	 */
	protected void setPreparedStatement(TauPreparedStatement stmt)
			throws SQLException {
		int iPos = 1;
		stmt.setLong(iPos++, idVeicolo.getId());
		stmt.setLong(iPos++, idVeicolo.getId());
		stmt.setDate(iPos++, date);
	}
}
