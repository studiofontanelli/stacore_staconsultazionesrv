package it.csi.stacore.staconsultazionesrv.integration.bo;

import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdDecodifica;
import it.csi.stacore.staconsultazionesrv.integration.util.EqualsUtil;

/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class Combustibile extends Decodifica implements java.io.Serializable {
	//~ Static fields/initializers ===============================================

	/**
	 *
	 */
	private static final long serialVersionUID = 7378067336070731143L;

	private static final String CODICE_BENZ = "B";

	private static final String CODICE_B_OLIO = "B-O";

	private static final String CODICE_B_WANK = "B-W";

	private static final String CODICE_ELETTR = "ELE";

	private static final String CODICE_GASOL = "G";

	private static final String CODICE_GPL = "GP";

	private static final String CODICE_B_GPL = "GPL";

	private static final String CODICE_B_MET = "M";

	private static final String CODICE_METANO = "ME";

	private static final String CODICE_MISCELA = "MSC";

	private static final String CODICE_PETROLIO = "P";

	private static final String CODICE_BENZINA_ELETTRICO = "B-E";

	//2010-10-11 L.S. STACORE-313
	private static final String CODICE_GASOL_ELETTRICO = "G-E";

	private static final String CODICE_BENZINA_ETANOLO = "BET";

	private static final String CODICE_GASOLIO_METANO = "G-M";

	private static final String CODICE_GASOLIO_GPL = "G-G";

	private static final String CODICE_GASOLIO_GAS_NATURALE_LIQUEFATTO = "GML";

	private static final String CODICE_GAS_NATURALE_LIQUEFATTO = "GNL";

	private static final String CODICE_IDROGENO = "H";

	private static final String CODICE_IDROGENO_ELETTRICO = "H-E";



	private Long idGruppoAlimentazione = null;

	//~ Constructors =============================================================

	//	public static Combustibile DIESEL = new Combustibile(new IdDecodifica(5),"G","GASOL");
	//	public static Combustibile BENZ = new Combustibile(new IdDecodifica(1),"B","BENZ");
	//	public static Combustibile ELETTR = new Combustibile(new IdDecodifica(4),"ELE","ELETTR");
	//	public static Combustibile METANO = new Combustibile(new IdDecodifica(9),"ME","METANO");
	//	public static Combustibile GPL = new Combustibile(new IdDecodifica(6),"GP","GPL");
	public Combustibile(IdDecodifica idDecodifica, String codice, String descrizione) {
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

		if ((object != null) && object instanceof Combustibile) {
			Combustibile altro = (Combustibile) object;
			equals = EqualsUtil.objectEquals(getCodice(), altro.getCodice());
		}

		return equals;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isBenz() {
		return this.getCodice().equals(CODICE_BENZ);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isBOlio() {
		return this.getCodice().equals(CODICE_B_OLIO);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isBWank() {
		return this.getCodice().equals(CODICE_B_WANK);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isElettr() {
		return this.getCodice().equals(CODICE_ELETTR);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isGasol() {
		return this.getCodice().equals(CODICE_GASOL);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isGpl() {
		return this.getCodice().equals(CODICE_GPL);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isBGpl() {
		return this.getCodice().equals(CODICE_B_GPL);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isBMet() {
		return this.getCodice().equals(CODICE_B_MET);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isMetano() {
		return this.getCodice().equals(CODICE_METANO);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isMiscela() {
		return this.getCodice().equals(CODICE_MISCELA);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isPetrolio() {
		return this.getCodice().equals(CODICE_PETROLIO);
	}


	public boolean isBenzElettrico() {
		return this.getCodice().equals(CODICE_BENZINA_ELETTRICO);
	}

	public boolean isGasolElettrico() {
		return this.getCodice().equals(CODICE_GASOL_ELETTRICO);
	}

	public boolean isBenzEtanolo() {
		return this.getCodice().equals(CODICE_BENZINA_ETANOLO);
	}

	public boolean isGasolioMetano() {
		return this.getCodice().equals(CODICE_GASOLIO_METANO);
	}

	public boolean isGasolioGpl() {
		return this.getCodice().equals(CODICE_GASOLIO_GPL);
	}

	public boolean isGasolioGasNaturaleLiquefatto() {
		return this.getCodice().equals(CODICE_GASOLIO_GAS_NATURALE_LIQUEFATTO);
	}

	public boolean isGasNaturaleLiquefatto() {
		return this.getCodice().equals(CODICE_GAS_NATURALE_LIQUEFATTO);
	}

	public boolean isIdrogeno() {
		return this.getCodice().equals(CODICE_IDROGENO);
	}

	public boolean isIdrogenoElettrico() {
		return this.getCodice().equals(CODICE_IDROGENO_ELETTRICO);
	}

	public void setIdGruppoAlimentazione(Long id) {
		this.idGruppoAlimentazione = id;
	}

	public Long getIdGruppoAlimentazione() {
		return idGruppoAlimentazione;
	}

	public boolean isAbilitatoSAP() {
		if(idGruppoAlimentazione==null) return false;

		return this.idGruppoAlimentazione.longValue()==1;
	}
}
