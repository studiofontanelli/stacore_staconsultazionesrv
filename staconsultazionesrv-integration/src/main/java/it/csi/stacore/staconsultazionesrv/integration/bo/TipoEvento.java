package it.csi.stacore.staconsultazionesrv.integration.bo;

import org.apache.commons.lang3.StringUtils;

import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdTipoEvento;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class TipoEvento extends Decodifica implements java.io.Serializable {
	//~ Static fields/initializers ===============================================

	private static final long serialVersionUID = 7762008834448504969L;

	private static final String CODICE_IMMATRICOLAZIONE = "01";

	private static final String CODICE_REIMMATRICOLAZIONE = "02";

	private static final String CODICE_AGGIORNAMENTO_DATI_TECNICI = "03";

	private static final String CODICE_PASSAGGIO_PROPRIETA = "04";

	private static final String CODICE_CAMBIO_RESIDENZA = "05";

	//  private static final String CODICE_PASSAGGIO_PROPRIETA_REGIONALE       = "04";
	//  private static final String CODICE_CAMBIO_RESIDENZA_REGIONALE          = "05";
	private static final String CODICE_CAMBIO_RESIDENZA_INTER_REGIONALE = "06";

	private static final String CODICE_PASSAGGIO_PROPRIETA_INTER_REGIONALE = "07";

	private static final String CODICE_ESPORTAZIONE = "08";

	private static final String CODICE_RADIAZIONE = "09";

	private static final String CODICE_IMPORTAZIONE = "10";

	private static final String CODICE_CESSIONE_AD_IGNOTI = "11";

	private static final String CODICE_IMPIANTO_A_GAS = "12";

	private static final String CODICE_RIMORCHIABILITA = "13";

	private static final String CODICE_DISINSTALLAZIONE_IMPIANTO_A_GAS = "14";

	public static final TipoEvento TIPO_EVENTO_IMPIANTO_A_GAS = new TipoEvento(new IdTipoEvento(12), "12", "Installazione impianto a gas");

	public static final TipoEvento TIPO_EVENTO_ANN_MASSA_RIM = new TipoEvento(new IdTipoEvento(13), "13", "Annullamento massa rimorchiabile");

	public static final TipoEvento TIPO_EVENTO_DIS_IMPIANTO_A_GAS = new TipoEvento(new IdTipoEvento(14), "14", "Disinstallazione impianto a gas");

	//~ Constructors =============================================================

	// Constructors
	public TipoEvento(IdTipoEvento idTipoEvento, String codice, String descrizione) {
		super(idTipoEvento, codice, descrizione);
	}

	//~ Methods ==================================================================

	// Getters
	public IdTipoEvento getIdTipoEvento() {
		return (IdTipoEvento) getId();
	}

	// Equals
	public boolean equals(Object object) {
		boolean equals = false;

		if ((object != null) && object instanceof TipoEvento) {
			TipoEvento altro = (TipoEvento) object;
			equals = StringUtils.equals(getCodice(), altro.getCodice());
		}

		return equals;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isImmatricolazione() {
		return getCodice().equals(CODICE_IMMATRICOLAZIONE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAggiornamentoDatiTecnici() {
		return getCodice().equals(CODICE_AGGIORNAMENTO_DATI_TECNICI);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isCambioResidenzaInterRegionale() {
		return getCodice().equals(CODICE_CAMBIO_RESIDENZA_INTER_REGIONALE);
	}

	//  /**
	//   * DOCUMENT ME!
	//   *
	//   * @return DOCUMENT ME!
	//   */
	//  public boolean isCambioResidenzaRegionale() {
	//    return getCodice().equals(CODICE_CAMBIO_RESIDENZA_REGIONALE);
	//  }

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isCambioResidenza() {
		return getCodice().equals(CODICE_CAMBIO_RESIDENZA);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isEsportazione() {
		return getCodice().equals(CODICE_ESPORTAZIONE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isImportazione() {
		return getCodice().equals(CODICE_IMPORTAZIONE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isPassaggioProprietaInterRegionale() {
		return getCodice().equals(CODICE_PASSAGGIO_PROPRIETA_INTER_REGIONALE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isPassaggioProprieta() {
		return getCodice().equals(CODICE_PASSAGGIO_PROPRIETA);
	}

	//  /**
	//   * DOCUMENT ME!
	//   *
	//   * @return DOCUMENT ME!
	//   */
	//  public boolean isPassaggioProprietaRegionale() {
	//    return getCodice().equals(CODICE_PASSAGGIO_PROPRIETA_REGIONALE);
	//  }

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isRadiazione() {
		return getCodice().equals(CODICE_RADIAZIONE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isReimmatricolazione() {
		return getCodice().equals(CODICE_REIMMATRICOLAZIONE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isCessioneAdIgnoti() {
		return getCodice().equals(CODICE_CESSIONE_AD_IGNOTI);
	}

	public boolean isImpiantoAGas() {
		return getCodice().equals(CODICE_IMPIANTO_A_GAS);
	}

	public boolean isDisinstallazioneImpiantoAGas() {
		return getCodice().equals(CODICE_DISINSTALLAZIONE_IMPIANTO_A_GAS);
	}

	public boolean isRimorchiabilita() {
		return getCodice().equals(CODICE_RIMORCHIABILITA);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static String getCodiceImmatricolazione() {
		return CODICE_IMMATRICOLAZIONE;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static String getCodiceReimmatricolazione() {
		return CODICE_REIMMATRICOLAZIONE;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static String getCodiceAggiornamentoDatiTecnici() {
		return CODICE_AGGIORNAMENTO_DATI_TECNICI;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static String getCodiceCambioResidenza() {
		return CODICE_CAMBIO_RESIDENZA;
	}

	//  /**
	//   * DOCUMENT ME!
	//   *
	//   * @return DOCUMENT ME!
	//   */
	//  public static String getCodiceCambioResidenzaRegionale() {
	//    return CODICE_CAMBIO_RESIDENZA_REGIONALE;
	//  }

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static String getCodiceCambioResidenzaInterRegionale() {
		return CODICE_CAMBIO_RESIDENZA_INTER_REGIONALE;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static String getCodiceEsportazione() {
		return CODICE_ESPORTAZIONE;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static String getCodiceRadiazione() {
		return CODICE_RADIAZIONE;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static String getCodiceImportazione() {
		return CODICE_IMPORTAZIONE;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static String getCodicePassaggioProprietaInterRegionale() {
		return CODICE_PASSAGGIO_PROPRIETA_INTER_REGIONALE;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static String getCodicePassaggioProprieta() {
		return CODICE_PASSAGGIO_PROPRIETA;
	}

	//  /**
	//   * DOCUMENT ME!
	//   *
	//   * @return DOCUMENT ME!
	//   */
	//  public static String getCodicePassaggioProprietaRegionale() {
	//    return CODICE_PASSAGGIO_PROPRIETA_REGIONALE;
	//  }

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static String getCodiceCessioneAdIgnoti() {
		return CODICE_CESSIONE_AD_IGNOTI;
	}
	
	public static String getCodiceImpiantoAGas() {
		return CODICE_IMPIANTO_A_GAS;
	}
	
	public static String getCodiceDisinstallazioneImpiantoAGas() {
		return CODICE_DISINSTALLAZIONE_IMPIANTO_A_GAS;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isEventoChiusuraPosizione() {
		boolean result = false;

		if (
		//       getCodice().equals(CODICE_PASSAGGIO_PROPRIETA_INTER_REGIONALE) ||
		//           getCodice().equals(CODICE_CAMBIO_RESIDENZA_INTER_REGIONALE) ||
		getCodice().equals(CODICE_PASSAGGIO_PROPRIETA) || getCodice().equals(CODICE_CAMBIO_RESIDENZA) || getCodice().equals(CODICE_RADIAZIONE)
				|| getCodice().equals(CODICE_ESPORTAZIONE) || getCodice().equals(CODICE_CESSIONE_AD_IGNOTI)) {
			result = true;
		}

		return result;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isEventoVariazioneVeicolo() {
		boolean result = false;

		if (getCodice().equals(CODICE_IMMATRICOLAZIONE)
				|| getCodice().equals(CODICE_AGGIORNAMENTO_DATI_TECNICI)
				|| getCodice().equals(CODICE_REIMMATRICOLAZIONE)
				|| getCodice().equals(CODICE_IMPIANTO_A_GAS)
				|| getCodice().equals(CODICE_DISINSTALLAZIONE_IMPIANTO_A_GAS)) {
			result = true;
		}

		return result;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isEventoInserimentoVeicolo() {
		boolean result = false;

		if (
		//       getCodice().equals(CODICE_PASSAGGIO_PROPRIETA_INTER_REGIONALE) ||
		//           getCodice().equals(CODICE_CAMBIO_RESIDENZA_INTER_REGIONALE) ||
		getCodice().equals(CODICE_PASSAGGIO_PROPRIETA) || getCodice().equals(CODICE_CAMBIO_RESIDENZA) || getCodice().equals(CODICE_IMMATRICOLAZIONE)
				|| getCodice().equals(CODICE_IMPORTAZIONE)) {
			result = true;
		}

		return result;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isEventoPerIngressoDaAltraRegioneVeicoloNoto() {
		boolean result = false;

		if (getCodice().equals(CODICE_PASSAGGIO_PROPRIETA) || getCodice().equals(CODICE_CAMBIO_RESIDENZA)) {
			result = true;
		}

		return result;
	}

	public boolean isValidoSAP() {
		return !getCodice().equals("06") && !getCodice().equals("07") && !getCodice().equals("08") && !getCodice().equals("09");
	}
}
