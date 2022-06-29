package it.csi.stacore.staconsultazionesrv.integration.bo;

import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdDecodifica;
import it.csi.stacore.staconsultazionesrv.integration.util.EqualsUtil;

/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class DestinazioneVeicolo extends Decodifica implements java.io.Serializable {
	//~ Static fields/initializers ===============================================

	/**
	 *
	 */
	private static final long serialVersionUID = -2905319756563728708L;

	private static final String CODICE_AUTOVEICOLO_IN_SERVIZIO_PUBBLICO_DI_LINEA_INTEGRATIVO = "7";

	private static final String CODICE_AUTOVEICOLO_USO_ESCLUSIVO_DI_POLIZIA = "8";

	private static final String CODICE_AUTOVETTURA_PER_TRASPORTO_DI_PERSONE = "A";

	private static final String CODICE_AUTOBUS_PER_TRASPORTO_DI_PERSONE = "B";

	private static final String CODICE_AUTOCARRO_PER_TRASPORTO_DI_COSE = "C";

	private static final String CODICE_AUTOCARAVAN = "I";

	private static final String CODICE_AUTOVEICOLO_PER_USO_SPECIALE = "L";

	private static final String CODICE_TRAS_SPECIFICO_PERSONE_PART_CONDIZIONI = "O";

	private static final String CODICE_AUTOVEICOLO_TRASPORTO_PROMISCUO_PERSONE_COSE = "P";

	private static final String CODICE_TRATTORE_STRADALE_PER_RIMORCHIO = "S";

	private static final String CODICE_TRATTORE_PER_SEMIRIMORCHIO = "T";

	private static final String CODICE_AUTOVEICOLO_PER_TRASPORTO_SPECIFICO = "V";

	private static final String CODICE_QUADRICICLO_PER_TRASP_DI_PERSONE = "3";

	private static final String CODICE_QUADRICICLO_PER_TRASP_DI_COSE = "4";

	private static final String CODICE_QUADRICICLO_PER_USO_SPECIALE = "5";

	private static final String CODICE_QUADRICICLO_TRASP_SPECIFICO = "6";

	private static final String CODICE_MOTOVEICOLO_USO_ESCLUSIVO_DI_POLIZIA = "9";

	private static final String CODICE_TRICICLO_PER_TRASPORTO_PROMISCUO = "D";

	private static final String CODICE_TRICICLO_PER_USO_SPECIALE = "F";

	private static final String CODICE_TRICICLO_PER_TRASPORTO_SPECIFICO = "G";

	private static final String CODICE_MOTOCICLO_PER_TRASPORTO_PERSONE = "M";

	private static final String CODICE_TRICICLO_PER_TRASPORTO_COSE = "N";

	private static final String CODICE_TRICICLO_PER_TRASPORTO_DI_PERSONE = "Z";

	private static final String CODICE_SEMIRIMORCHIO_PER_TRASPORTO_SPECIFICO = "E";

	private static final String CODICE_SEMIRIMORCHIO_PER_TRASPORTO_COSE = "H";

	private static final String CODICE_RIMORCHIO_PER_TRASPORTO_ATTREZZATURE_TURISTICHE_E_SPORTIVE = "J";

	private static final String CODICE_RIMORCHIO_PER_TRASPORTI_SPECIFICI = "K";

	private static final String CODICE_SEMIRIMORCHIO_PER_TRASPORTO_PERSONE = "Q";

	private static final String CODICE_RIMORCHIO_PER_TRASPORTO_COSE = "R";

	private static final String CODICE_CARAVAN = "U";

	private static final String CODICE_RIMORCHIO_PER_TRASPORTO_PERSONE = "W";

	private static final String CODICE_RIMORCHIO_PER_USO_SPECIALE = "X";

	private static final String CODICE_SEMIRIMORCHIO_PER_USO_SPECIALE = "Y";

	//~ Constructors =============================================================

	//
	//  public static final DestinazioneVeicolo PERSONE = new DestinazioneVeicolo(new IdDecodifica(3),"A","AUTOVETTURA PER TRASPORTO DI PERSONE");
	//  public static final DestinazioneVeicolo PROMISCUO = new DestinazioneVeicolo(new IdDecodifica(9),"P","AUTOVEICOLO TRASPORTO PROMISCUO PERSONE/COSE");
	//  public static final DestinazioneVeicolo AUTOBUS = new DestinazioneVeicolo(new IdDecodifica(4),"B","AUTOBUS PER TRASPORTO DI PERSONE");
	//  public static final DestinazioneVeicolo AUTOCARRO = new DestinazioneVeicolo(new IdDecodifica(5),"C","AUTOCARRO PER TRASPORTO DI COSE");
	//  public static final DestinazioneVeicolo AUTOVEICOLO_PER_USO_SPECIALE = new DestinazioneVeicolo(new IdDecodifica(7),"L","AUTOVEICOLO PER USO SPECIALE");
	//  public static final DestinazioneVeicolo POLIZIA = new DestinazioneVeicolo(new IdDecodifica(2),"8","AUTOVEICOLO USO ESCLUSIVO DI POLIZIA");
	//  public static final DestinazioneVeicolo AUTOCARAVAN = new DestinazioneVeicolo(new IdDecodifica(6),"I","AUTOCARAVAN");
	//  public static final DestinazioneVeicolo TRASPORTO_SPECIFICO = new DestinazioneVeicolo(new IdDecodifica(12),"V","AUTOVEICOLO PER TRASPORTO SPECIFICO");
	//  public static final DestinazioneVeicolo TRATTORE_STRADALE_PER_RIMORCHIO = new DestinazioneVeicolo(new IdDecodifica(10),"S","TRATTORE STRADALE PER RIMORCHIO");
	//  public static final DestinazioneVeicolo TRATTORE_PER_SEMIRIMORCHIO = new DestinazioneVeicolo(new IdDecodifica(11),"T","TRATTORE PER SEMIRIMORCHIO");
	//  public static final DestinazioneVeicolo SEMIRIMORCHIO_PER_TRASPORTO_SPECIFICO = new DestinazioneVeicolo(new IdDecodifica(24),"E","TRATTORE PER SEMIRIMORCHIO");
	//  public static final DestinazioneVeicolo SEMIRIMORCHIO_PER_TRASPORTO_COSE = new DestinazioneVeicolo(new IdDecodifica(25),"H","SEMIRIMORCHIO PER TRASPORTO COSE");
	//  public static final DestinazioneVeicolo RIMORCHIO_PER_TRASPORTI_SPECIFICI = new DestinazioneVeicolo(new IdDecodifica(27),"K","RIMORCHIO PER TRASPORTI SPECIFICI");
	//  public static final DestinazioneVeicolo RIMORCHIO_PER_TRASPORTO_COSE = new DestinazioneVeicolo(new IdDecodifica(29),"R","RIMORCHIO PER TRASPORTO COSE");
	//  public static final DestinazioneVeicolo RIMORCHIO_PER_TRASPORTO_ATTREZZATURE_TURISTICHE_E_SPORTIVE = new DestinazioneVeicolo(new IdDecodifica(26),"J","RIMORCHIO PER TRASPORTO ATTREZZATURE TURISTICHE E SPORTIVE");
	//  public static final DestinazioneVeicolo CARAVAN = new DestinazioneVeicolo(new IdDecodifica(30),"U","CARAVAN");
	//  public static final DestinazioneVeicolo RIMORCHIO_PER_USO_SPECIALE = new DestinazioneVeicolo(new IdDecodifica(32),"X","RIMORCHIO PER USO SPECIALE");
	//  public static final DestinazioneVeicolo SEMIRIMORCHIO_PER_USO_SPECIALE   = new DestinazioneVeicolo(new IdDecodifica(33),"Y","SEMIRIMORCHIO PER USO SPECIALE");
	//  public static final DestinazioneVeicolo SEMIRIMORCHIO_PER_TRASPORTO_PERSONE   = new DestinazioneVeicolo(new IdDecodifica(28),"Q","SEMIRIMORCHIO PER TRASPORTO PERSONE");
	//  public static final DestinazioneVeicolo RIMORCHIO_PER_TRASPORTO_PERSONE   = new DestinazioneVeicolo(new IdDecodifica(31),"W","RIMORCHIO PER TRASPORTO PERSONE");
	//
	//  public static final DestinazioneVeicolo QUADRICICLO_PER_TRASP_DI_PERSONE   = new DestinazioneVeicolo(new IdDecodifica(13),"3","QUADRICICLO PER TRASP. DI PERSONE");
	//  public static final DestinazioneVeicolo MOTOCICLO_PER_TRASPORTO_PERSONE   = new DestinazioneVeicolo(new IdDecodifica(21),"M","MOTOCICLO PER TRASPORTO PERSONE");
	//  public static final DestinazioneVeicolo TRICICLO_PER_TRASPORTO_DI_PERSONE   = new DestinazioneVeicolo(new IdDecodifica(23),"Z","TRICICLO PER TRASPORTO DI PERSONE");
	//
	public DestinazioneVeicolo(IdDecodifica idDecodifica, String codice, String descrizione) {
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

		if ((object != null) && object instanceof DestinazioneVeicolo) {
			DestinazioneVeicolo altro = (DestinazioneVeicolo) object;
			equals = EqualsUtil.objectEquals(getCodice(), altro.getCodice());
		}

		return equals;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAutoveicoloInServizioPubblicoDiLineaIntegrativo() {
		return this.getCodice().equals(CODICE_AUTOVEICOLO_IN_SERVIZIO_PUBBLICO_DI_LINEA_INTEGRATIVO);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAutoveicoloUsoEsclusivoDiPolizia() {
		return this.getCodice().equals(CODICE_AUTOVEICOLO_USO_ESCLUSIVO_DI_POLIZIA);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAutovetturaPerTrasportoDiPersone() {
		return this.getCodice().equals(CODICE_AUTOVETTURA_PER_TRASPORTO_DI_PERSONE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAutobusPerTrasportoDiPersone() {
		return this.getCodice().equals(CODICE_AUTOBUS_PER_TRASPORTO_DI_PERSONE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAutocarroPerTrasportoDiCose() {
		return this.getCodice().equals(CODICE_AUTOCARRO_PER_TRASPORTO_DI_COSE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAutocaravan() {
		return this.getCodice().equals(CODICE_AUTOCARAVAN);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAutoveicoloPerUsoSpeciale() {
		return this.getCodice().equals(CODICE_AUTOVEICOLO_PER_USO_SPECIALE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isTrasSpecificoPersonePartCondizioni() {
		return this.getCodice().equals(CODICE_TRAS_SPECIFICO_PERSONE_PART_CONDIZIONI);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAutoveicoloTrasportoPromiscuoPersoneCose() {
		return this.getCodice().equals(CODICE_AUTOVEICOLO_TRASPORTO_PROMISCUO_PERSONE_COSE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isTrattoreStradalePerRimorchio() {
		return this.getCodice().equals(CODICE_TRATTORE_STRADALE_PER_RIMORCHIO);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isTrattorePerSemirimorchio() {
		return this.getCodice().equals(CODICE_TRATTORE_PER_SEMIRIMORCHIO);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAutoveicoloPerTrasportoSpecifico() {
		return this.getCodice().equals(CODICE_AUTOVEICOLO_PER_TRASPORTO_SPECIFICO);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isQuadricicloPerTrasportoDiPersone() {
		return this.getCodice().equals(CODICE_QUADRICICLO_PER_TRASP_DI_PERSONE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isQuadricicloPerTrasportoDiCose() {
		return this.getCodice().equals(CODICE_QUADRICICLO_PER_TRASP_DI_COSE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isQuadricicloPerUsoSpeciale() {
		return this.getCodice().equals(CODICE_QUADRICICLO_PER_USO_SPECIALE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isQuadricicloPerTrasportoSpecifico() {
		return this.getCodice().equals(CODICE_QUADRICICLO_TRASP_SPECIFICO);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isMotoveicoloUsoEsclusivoDiPolizia() {
		return this.getCodice().equals(CODICE_MOTOVEICOLO_USO_ESCLUSIVO_DI_POLIZIA);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isTricicloPerTrasportoPromiscuo() {
		return this.getCodice().equals(CODICE_TRICICLO_PER_TRASPORTO_PROMISCUO);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isTricicloPerUsoSpeciale() {
		return this.getCodice().equals(CODICE_TRICICLO_PER_USO_SPECIALE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isTricicloPerTrasportoSpecifico() {
		return this.getCodice().equals(CODICE_TRICICLO_PER_TRASPORTO_SPECIFICO);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isMotocicloPerTrasportoPersone() {
		return this.getCodice().equals(CODICE_MOTOCICLO_PER_TRASPORTO_PERSONE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isTricicloPerTrasportoCose() {
		return this.getCodice().equals(CODICE_TRICICLO_PER_TRASPORTO_COSE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isTricicloPerTrasportoDiPersone() {
		return this.getCodice().equals(CODICE_TRICICLO_PER_TRASPORTO_DI_PERSONE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isSemirimorchioPerTrasportoSpecifico() {
		return this.getCodice().equals(CODICE_SEMIRIMORCHIO_PER_TRASPORTO_SPECIFICO);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isSemirimorchioPerTrasportoCose() {
		return this.getCodice().equals(CODICE_SEMIRIMORCHIO_PER_TRASPORTO_COSE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isRimorchioPerTrasportoAttrezzatireTuristicheESportive() {
		return this.getCodice().equals(CODICE_RIMORCHIO_PER_TRASPORTO_ATTREZZATURE_TURISTICHE_E_SPORTIVE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isRimorchioPerTrasportiSpecifici() {
		return this.getCodice().equals(CODICE_RIMORCHIO_PER_TRASPORTI_SPECIFICI);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isSemirimorchioPerTrasportoPersone() {
		return this.getCodice().equals(CODICE_SEMIRIMORCHIO_PER_TRASPORTO_PERSONE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isRimorchioPerTrasportoCose() {
		return this.getCodice().equals(CODICE_RIMORCHIO_PER_TRASPORTO_COSE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isCaravan() {
		return this.getCodice().equals(CODICE_CARAVAN);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isRimorchioPerTrasportoPersone() {
		return this.getCodice().equals(CODICE_RIMORCHIO_PER_TRASPORTO_PERSONE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isRimorchioPerUsoSpeciale() {
		return this.getCodice().equals(CODICE_RIMORCHIO_PER_USO_SPECIALE);
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isSemirimorchioPerUsoSpeciale() {
		return this.getCodice().equals(CODICE_SEMIRIMORCHIO_PER_USO_SPECIALE);
	}
}
