package it.csi.stacore.staconsultazionesrv.integration.bo;

import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdDecodifica;
import it.csi.stacore.staconsultazionesrv.integration.util.EqualsUtil;

/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class Carrozzeria extends Decodifica implements java.io.Serializable {
	//~ Static fields/initializers ===============================================

	/**
	 *
	 */
	private static final long serialVersionUID = 6585148237097209157L;

	private static final String CODICE_CARRELLO_TRASPORTO_VEICOLI_FERROVIARI = "C1";

	private static final String CODICE_RIMORCHIO_TRASPORTO_IMBARCAZIONI = "C2";

	private static final String CODICE_AUTOVETTURA_SCUOLA_GUIDA = "C3";

	private static final String CODICE_AUTOVEICOLO_TRASPORTO_LATTE = "C4";

	private static final String CODICE_AUTOVEICOLO_TRASPORTO_CARNI_MACELLATE = "C5";

	private static final String CODICE_AUTOVEICOLO_RSU = "C6";

	private static final String CODICE_AUTOVEICOLO_TRASPORTO_GENERI_MONOPOLIO = "C7";

	private static final String CODICE_AUTOVEICOLO_BOTTE_VUOTATURA_POZZI_NERI = "C8";

	private static final String CODICE_AMBULANZA = "C9";

	private static final String CODICE_AUTOVEICOLO_ESTINZIONE_INCENDI = "C10";

	private static final String CODICE_AUTOCARRO_KW = "F0";

	//~ Constructors =============================================================

	/**
	 * Creates a new Carrozzeria object.
	 *
	 * @param idDecodifica DOCUMENT ME!
	 * @param codice DOCUMENT ME!
	 * @param descrizione DOCUMENT ME!
	 */
	public Carrozzeria(IdDecodifica idDecodifica, String codice, String descrizione) {
		super(idDecodifica, codice, descrizione);
	}

	//~ Methods ==================================================================

	/**
	 * DOCUMENT ME!
	 *
	 * @param object DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean equals(Object object) {
		boolean equals = false;

		if ((object != null) && object instanceof Carrozzeria) {
			Carrozzeria altro = (Carrozzeria) object;
			equals = EqualsUtil.objectEquals(getCodice(), altro.getCodice());
		}

		return equals;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAutoveicoloEstinzioneIncendi() {
		return this.getCodice().equals(CODICE_AUTOVEICOLO_ESTINZIONE_INCENDI);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAmbulanza() {
		return this.getCodice().equals(CODICE_AMBULANZA);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAutoveicoloBotteVuotaturaPozziNeri() {
		return this.getCodice().equals(CODICE_AUTOVEICOLO_BOTTE_VUOTATURA_POZZI_NERI);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAutoveicoloTrasportoGeneriMonopolio() {
		return this.getCodice().equals(CODICE_AUTOVEICOLO_TRASPORTO_GENERI_MONOPOLIO);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAutoveicoloRSU() {
		return this.getCodice().equals(CODICE_AUTOVEICOLO_RSU);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAutoveicoloTrasportoCarniMacellate() {
		return this.getCodice().equals(CODICE_AUTOVEICOLO_TRASPORTO_CARNI_MACELLATE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAutoveicoloTrasportoLatte() {
		return this.getCodice().equals(CODICE_AUTOVEICOLO_TRASPORTO_LATTE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAutovetturaScuolaGuida() {
		return this.getCodice().equals(CODICE_AUTOVETTURA_SCUOLA_GUIDA);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isRimorchioTrasportoImbarcazioni() {
		return this.getCodice().equals(CODICE_RIMORCHIO_TRASPORTO_IMBARCAZIONI);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isCarrelloTrasportoVeicoliFerroviari() {
		return this.getCodice().equals(CODICE_CARRELLO_TRASPORTO_VEICOLI_FERROVIARI);
	}

	public boolean isAutocarroKw() {
		return this.getCodice().equals(CODICE_AUTOCARRO_KW);
	}
}
