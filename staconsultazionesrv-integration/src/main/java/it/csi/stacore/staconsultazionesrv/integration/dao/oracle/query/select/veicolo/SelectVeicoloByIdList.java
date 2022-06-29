package it.csi.stacore.staconsultazionesrv.integration.dao.oracle.query.select.veicolo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import it.csi.stacore.staconsultazionesrv.integration.DatiTecniciConverter;
import it.csi.stacore.staconsultazionesrv.integration.bo.Carrozzeria;
import it.csi.stacore.staconsultazionesrv.integration.bo.CategoriaEuro;
import it.csi.stacore.staconsultazionesrv.integration.bo.Combustibile;
import it.csi.stacore.staconsultazionesrv.integration.bo.DatiTecnici;
import it.csi.stacore.staconsultazionesrv.integration.bo.DestinazioneVeicolo;
import it.csi.stacore.staconsultazionesrv.integration.bo.Evento;
import it.csi.stacore.staconsultazionesrv.integration.bo.Fonte;
import it.csi.stacore.staconsultazionesrv.integration.bo.TipoEvento;
import it.csi.stacore.staconsultazionesrv.integration.bo.TipoVeicolo;
import it.csi.stacore.staconsultazionesrv.integration.bo.UsoVeicolo;
import it.csi.stacore.staconsultazionesrv.integration.bo.Veicolo;
import it.csi.stacore.staconsultazionesrv.integration.bo.factory.DatiTecniciFactory;
import it.csi.stacore.staconsultazionesrv.integration.bo.factory.VeicoloFactory;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdDecodifica;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdFonte;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdTipoEvento;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdVeicolo;
import it.csi.stacore.staconsultazionesrv.integration.dao.oracle.query.select.AbstractSelect;
import it.csi.stacore.staconsultazionesrv.integration.dao.oracle.query.select.TAURDEResultSet;
import it.csi.stacore.staconsultazionesrv.integration.dao.oracle.query.select.TauPreparedStatement;
import it.csi.stacore.staconsultazionesrv.integration.dao.oracle.util.OracleQuery;
import it.csi.stacore.staconsultazionesrv.integration.dao.oracle.util.OracleQueryList;
import it.csi.stacore.staconsultazionesrv.integration.exception.InvalidSearchObjectException;
import it.csi.stacore.staconsultazionesrv.integration.exception.ResourceAccessException;
import it.csi.stacore.staconsultazionesrv.util.Constants;
import it.csi.stacore.staconsultazionesrv.util.Tracer;
import it.csi.util.performance.StopWatch;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class SelectVeicoloByIdList extends AbstractSelect {
	//~ Instance fields ==========================================================

	/**
	 * @uml.property  name="idVeicoli"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="it.csi.stacore.staon.business.bo.id.IdVeicolo"
	 */
	private List        idVeicoli;
	/**
	 * @uml.property  name="tec"
	 * @uml.associationEnd  
	 */
	private DatiTecnici tec;
	/**
	 * @uml.property  name="evFine"
	 * @uml.associationEnd  
	 */
	private Evento      evFine;
	/**
	 * @uml.property  name="datiTecnici" multiplicity="(0 -1)"
	 */
	private List        datiTecnici;
	/**
	 * @uml.property  name="veicoloCorrente"
	 * @uml.associationEnd  
	 */
	private Veicolo     veicoloCorrente;
	/**
	 * @uml.property  name="result" multiplicity="(0 -1)"
	 */
	private List        result;

	//~ Constructors =============================================================

	/**
	 * Creates a new SelectVeicoloByIdList object.
	 *
	 * @param idVeicoli
	 */
	public SelectVeicoloByIdList(List idVeicoli) {
		super();
		this.idVeicoli   = idVeicoli;

		// inizializzo le variabili per la creazione del resultSet
		tec               = null;
		evFine            = null;
		datiTecnici       = new ArrayList();
		veicoloCorrente   = null;
		result            = null;
	}

	//~ Methods ==================================================================

	/**
	 * restituisce l'oggetto di business logic
	 *
	 * @param rs
	 *
	 * @return
	 *
	 * @throws SQLException
	 */
	public Object createBO(TAURDEResultSet rs) throws SQLException {
		final String method = "createBO";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		try {
			Object             boRet        = null;
			VeicoloFactory     veiFactory   = VeicoloFactory.getInstance();
			DatiTecniciFactory tecFactory   = DatiTecniciFactory.getInstance();
			// DecodificaFactory  decodFactory = DecodificaFactory.getInstance();

			Long               lVeicolo = rs.getLong("ID_VEICOLO");

			Tracer.debug(LOG, getClass().getName(), method, "lVeicolo= " + lVeicolo);


			IdVeicolo idVeicolo = new IdVeicolo(lVeicolo.longValue());

			if((veicoloCorrente != null) && !veicoloCorrente.getId().equals(idVeicolo)) {
				// i veicoli sono differenti popolo il veicolo correttamente con i suoi dati tecnici
				getLogger().debug("veicoloCorrente.getId() e idVeicolo sono differenti");

				boRet =
						veiFactory.buildByVeicoloDatiTecnici(veicoloCorrente, datiTecnici);
				veicoloCorrente   = null;
				datiTecnici       = new ArrayList();
				evFine            = null;
			}

			if(veicoloCorrente == null) {
				Tracer.debug(LOG, getClass().getName(), method, "veicoloCorrente= " + veicoloCorrente);
				Long        idSubentrante = rs.getLong("id_subentrante");

				TipoVeicolo tipoVeic = rs.getLong("ID_TIPO_VEICOLO") != null ?  new TipoVeicolo(
						new IdDecodifica(rs.getLong("ID_TIPO_VEICOLO")), 
						rs.getString("cod_tipoveicolo"),
						rs.getString("desc_tipoveicolo")) : null;
				/*
        decodFactory.getTipoVeicolo(
                                    rs.getLong("ID_TIPO_VEICOLO"),
                                    rs.getString("cod_tipoveicolo"),
                                    rs.getString("desc_tipoveicolo")
                                   );
				 */
				veicoloCorrente =
						veiFactory.buildWithoutDatiTecnici(
								lVeicolo, tipoVeic, idSubentrante,
								rs.getString("telaio"),
								rs.getDate("DATA_ULTIMA_REVISIONE")
								);    // dataUltimaRevisione
			}

			Long idTecnico = rs.getLong("ID_DATI_TECNICI");

			// costruisco la fonte
			Fonte fonte =  rs.getLong("ID_FONTE") != null ? new Fonte(new IdFonte(rs.getLong("ID_FONTE")), rs.getString("cod_fonte"),
					rs.getString("DESC_fonte")) : null;;

			/*
      decodFactory.getFonte(
                            rs.getLong("ID_FONTE"), rs.getString("cod_fonte"),
                            rs.getString("DESC_fonte")
                           );
			 */

			// costruisco l'evento iniziale
			TipoEvento tipoEv = rs.getLong("ID_TIPO_EVENTO") != null ? new TipoEvento(
					new IdTipoEvento(rs.getLong("ID_TIPO_EVENTO")), 
					rs.getString("cod_tipo_evento"), 
					rs.getString("desc_tipo_evento")) : null;

			/*
      decodFactory.getTipoEvento(
                                 rs.getLong("ID_TIPO_EVENTO"),
                                 rs.getString("cod_tipo_evento"),
                                 rs.getString("desc_tipo_evento")
                                );
			 */
			Evento     evInizio = new Evento(tipoEv, rs.getDate("DATA_DECORRENZA"));

			// costruisco l'uso
			UsoVeicolo uso = rs.getLong("ID_TIPO_USO") != null ? new UsoVeicolo(new IdDecodifica(rs.getLong("ID_TIPO_USO")), rs.getString("cod_tipo_uso"),
					rs.getString("desc_tipo_uso")) : null;


			/*
      decodFactory.getTipoUsoVeicolo(
                                     rs.getLong("ID_TIPO_USO"),
                                     rs.getString("cod_tipo_uso"),
                                     rs.getString("desc_tipo_uso")
                                    );
			 */

			// costruisco la carrozzeria
			Carrozzeria car = rs.getLong("ID_TIPO_CARROZZERIA") != null ? new Carrozzeria(
					new IdDecodifica(rs.getLong("ID_TIPO_CARROZZERIA")),
					rs.getString("cod_tipo_carrozzeria"),
					rs.getString("desc_tipo_carrozzeria")) : null;
			/*
      decodFactory.getTipoCarrozzeria(
                                      rs.getLong("ID_TIPO_CARROZZERIA"),
                                      rs.getString("cod_tipo_carrozzeria"),
                                      rs.getString("desc_tipo_carrozzeria")
                                     );
			 */

			// costruisco il combustibile
			Combustibile combustibile = rs.getLong("ID_TIPO_COMBUSTIBILE") != null ? new Combustibile(new IdDecodifica(rs.getLong("ID_TIPO_COMBUSTIBILE")), 
					rs.getString("cod_combustibile"),
					rs.getString("desc_combustibile")) : null;
			/*
      decodFactory.getTipoCombustibile(
                                       rs.getLong("ID_TIPO_COMBUSTIBILE"),
                                       rs.getString("cod_combustibile"),
                                       rs.getString("desc_combustibile")
                                      );
			 */
			if (combustibile!=null) {
				combustibile.setIdGruppoAlimentazione(rs.getLong("ID_GRUPPO_ALIMENTAZIONE"));
			}

			// costruisco la destinazione veicolo
			DestinazioneVeicolo destVeic = rs.getLong("ID_DESTINAZIONE_VEICOLO") != null ? new DestinazioneVeicolo(
					new IdDecodifica(rs.getLong("ID_DESTINAZIONE_VEICOLO")), 
					rs.getString("cod_destinazione_veicolo"),
					rs.getString("desc_destinazione_veicolo")) : null;
			/*
      decodFactory.getDestinazioneVeicolo(
                                          rs.getLong("ID_DESTINAZIONE_VEICOLO"),
                                          rs.getString("cod_destinazione_veicolo"),
                                          rs.getString("desc_destinazione_veicolo")
                                         );
			 */

			// costruisco la categoria euro
			CategoriaEuro categoriaEuro = rs.getLong("ID_CATEGORIA_EURO") != null ? new CategoriaEuro(new IdDecodifica(rs.getLong("ID_CATEGORIA_EURO")), rs.getString("COD_CATEGORIA_EURO"),
					rs.getString("DESC_CATEGORIA_EURO")) : null;

			/*
    		decodFactory.getCategoriaEuro(
    		rs.getLong("ID_CATEGORIA_EURO"),
    		rs.getString("COD_CATEGORIA_EURO"),
    		rs.getString("DESC_CATEGORIA_EURO"));
			 */

			Combustibile combustibileGas = rs.getLong("id_combustibile_gas") != null ? new Combustibile(new IdDecodifica(rs.getLong("id_combustibile_gas")), 
					rs.getString("cod_combustibile_gas"),
					rs.getString("desc_combustibile_gas")): null;

			/*	
        decodFactory.getTipoCombustibile(
                                         rs.getLong("id_combustibile_gas"),
                                         rs.getString("cod_combustibile_gas"),
                                         rs.getString("desc_combustibile_gas")
                                        );
			 */
			tec = tecFactory.buildWithAll(
					idTecnico, fonte, evInizio, evFine,
					rs.getString("TARGA"),
					rs.getInteger("SCADENZA_ATTRIBUITA"), destVeic,
					uso, rs.getString("TRASPORTO_MERCI"), car,
					rs.getString("MASSA_COMPLESSIVA"),
					DatiTecniciConverter.kiloWattFromDb(rs.getString("KILO_WATT")),
					rs.getInteger("PORTATA"), combustibile,
					rs.getBooleanFromFlag("FLAG_SOSPENSIONE"),
					rs.getInteger("NUMERO_POSTI"),
					rs.getInteger("NUMERO_ASSI"),
					rs.getInteger("POTENZA_FISCALE"),
					rs.getInteger("CILINDRATA"),
					rs.getBooleanFromFlag("FLAG_ECODIESEL"),
					rs.getBooleanFromFlag("FLAG_GANCIO"),
					rs.getInteger("MASSA_RIMORCHIABILE"),
					rs.getBooleanFromFlag("FLAG_RIMORCHIABILITA"),
					categoriaEuro,
					//rs.getBooleanFromFlag("FLAG_IMPIANTO_GAS"),
					//rs.getString("EMISSIONE_CO2"),
					rs.getCO2("EMISSIONE_CO2"),
					rs.getDate("DATA_INSTAL_GPL"),
					rs.getDate("DATA_COLLAUDO_GPL"),
					combustibileGas,
					rs.getDate("DATA_DISINSTAL_GPL")
					);
			datiTecnici.add(0, tec);
			evFine = evInizio;

			return boRet;
		} 
		catch (Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new SQLException(e.getMessage(), e);
		}
		finally {
			Tracer.debug(LOG, getClass().getName(), method, "END");
		}
	}

	/**
	 * restituisce la string SQL da eseguire
	 *
	 * @return
	 *
	 * @throws InvalidSearchObjectException
	 */
	public String getSQLStatement() throws InvalidSearchObjectException {
		if((idVeicoli == null) || (idVeicoli.size() == 0)) {
			throw new InvalidSearchObjectException("Ricerca veicoli by idList: idVeicoli non pu� essere null o insieme vuoto");
		}

		OracleQuery q =
				OracleQueryList.getInstance().getQuery(getClass().getName());
		String      query =
				q.getBody() + q.getFrom() + q.getWhere() + q.getParamWhere("idVeicolo");

		query = StringUtils.replace(query, "$$listVeicoli",
				createCondition(idVeicoli, "tec.ID_VEICOLO"));

		query += q.getOrderBy();

		return query;
	}

	/**
	 * Ridefinisco il metodo per gestire il cambio di veicolo Ritorna una
	 * Collection di oggetti costruiti nel metodo createBO(ResultSet rs) Da
	 * usare nel caso in cui la query debba eseguire ricerche multiple.
	 *
	 * @param conn
	 *
	 * @return
	 *
	 * @throws SQLException
	 * @throws InvalidSearchObjectException
	 */
	public List executeMultipla(Connection conn) throws SQLException, InvalidSearchObjectException {
		final String method = "executeMultipla";
		Tracer.debug(LOG, getClass().getName(), method, "BEGIN");
		VeicoloFactory veiFactory = VeicoloFactory.getInstance();
		StopWatch   stopWatch = new StopWatch(Constants.APPLICATION_NAME);
		stopWatch.start();

		getLogger().debug("[execute()] - query: " + getSQLStatement());

		TauPreparedStatement stmt =
				new TauPreparedStatement(conn, getSQLStatement());

		try {

			setPreparedStatement(stmt);

			TAURDEResultSet rs = stmt.executeQuery();

			try {
				result = new ArrayList();

				while(rs.next()) {
					Object queryResult = createBO(rs);

					if(queryResult != null) {
						result.add(queryResult);
					}
				}

				// devo aggiungere l'ultimo veicolo solo se esistente
				if(veicoloCorrente != null) {
					Tracer.debug(LOG, getClass().getName(), method, "aggiungo veicoloCorrente");
					result.add(veiFactory.buildByVeicoloDatiTecnici(veicoloCorrente,datiTecnici));
				}

				return result;
			} finally {
				rs.close();
			}
		} finally {
			Tracer.debug(LOG, getClass().getName(), method, "END");
			stmt.close();
			stopWatch.dumpElapsed(
					getClass().getName(), "executeMultipla()",
					"esecuzione query",
					"query = " + getClass().getName()
					);
		}
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
		IdVeicolo id   = null;
		int       iPos = 1;

		for(int i = 0; i < idVeicoli.size(); i++) {
			id = (IdVeicolo) idVeicoli.get(i);
			stmt.setLongId(iPos++, id);
		}
	}
}
