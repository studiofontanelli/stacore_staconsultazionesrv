package it.csi.stacore.staconsultazionesrv.integration.bo;

import java.math.BigDecimal;
import java.util.Date;

import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdDatiTecnici;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdDecodifica;
import it.csi.stacore.staconsultazionesrv.integration.util.EqualsUtil;
import it.csi.stacore.staconsultazionesrv.util.UnitConversionUtil;

/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class DatiTecnici extends AbstractBO implements OggettoStoricizzato, Comparable, java.io.Serializable {
	//~ Static fields/initializers ===============================================

	/**
	 *
	 */
	private static final long serialVersionUID = -2763680092817199949L;

	/**
	 * DOCUMENT ME!
	 */
	public static final String STATO_APERTA = Posizione.STATO_APERTA;

	/**
	 * DOCUMENT ME!
	 */
	public static final String STATO_CHIUSA = Posizione.STATO_CHIUSA;

	private static final String INVALID_SCADENZA = "scadenza_incorretta";

	private static final String INVALID_TARGA = "targa_incorretta";

	private static final String INVALID_TRASPORTO_MERCI = "trasporto_merci_incorretta";

	private static final String INVALID_MASSA_COMPLESSIVA = "massa_complessiva_incorretta";

	private static final String INVALID_KILOWATT = "potenza_effettiva_incorretta";

	private static final String INVALID_PORTATA = "portata_effettiva_incorretta";

	private static final String INVALID_NUMPOSTI = "num_posti_incorretta";

	private static final String INVALID_NUMASSI = "num_assi_incorretta";

	private static final String INVALID_POTENZA_FISCALE = "potenza_fiscale_incorretta";

	private static final String INVALID_CILINDRATA = "cilindrata_incorretta";

	private static final String INVALID_MASSARIMORCHIABILE = "massa_rimorchiabile_incorretta";
	
	private static final String INVALID_EMISSIONE_CO2 = "emissione_co2_incorretta";

	// identifica la lunghezza del campo targa

	/**
	 * DOCUMENT ME!
	 */
	public static final int TARGA_POSSESSO_LENGTH = 8;

	public static final int TARGA_CIRCOLAZIONE_LENGTH = 18;

	/**
	 * DOCUMENT ME!
	 */
	public static final int TRASPORTO_MERCI_LENGTH = 1;

	/**
	 * DOCUMENT ME!
	 */
	public static final int MASSA_COMPLESSIVA_LENGTH = 5;

	/**
	 * DOCUMENT ME!
	 */
	public static final int KILOWATT_LENGTH = 6;

	/**
	 * DOCUMENT ME!
	 */
	public static final int PORTATA_LENGTH = 5;

	/**
	 * DOCUMENT ME!
	 */
	public static final int NUMPOSTI_LENGTH = 3;

	/**
	 * DOCUMENT ME!
	 */
	public static final int NUMASSI_LENGTH = 1;

	/**
	 * DOCUMENT ME!
	 */
	public static final int POTENZA_FISCALE_LENGTH = 5;

	/**
	 * DOCUMENT ME!
	 */
	public static final int CILINDRATA_LENGTH = 5;

	/**
	 * DOCUMENT ME!
	 */
	public static final int MASSARIMORCHIABILE_LENGTH = 6;
	
	/**
	 * DOCUMENT ME!
	 */
	public static final int EMISSIONE_CO2_LENGTH = 5;

	//~ Instance fields ==========================================================

	/**
	 * @uml.property  name="id"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private final IdDatiTecnici id;

	/**
	 * @uml.property  name="eventoInizio"
	 * @uml.associationEnd
	 */
	private Evento eventoInizio;

	/**
	 * @uml.property  name="eventoFine"
	 * @uml.associationEnd
	 */
	private Evento eventoFine;

	/**
	 * @uml.property  name="fonte"
	 * @uml.associationEnd
	 */
	private Fonte fonte;

	/**
	 * @uml.property  name="targa"
	 */
	private String targa;

	// mese di scadenza
	// ad uso dell'operatore
	// anche ad uso del calcolo tassa
	// dato calcolato da CalcoloScadenza (vedi documento Calcolo tassa)
	/**
	 * @uml.property  name="scadenzaAttribuita"
	 */
	private Integer scadenzaAttribuita;

	/**
	 * @uml.property  name="destinazione"
	 * @uml.associationEnd
	 */
	private DestinazioneVeicolo destinazione;

	/**
	 * @uml.property  name="uso"
	 * @uml.associationEnd
	 */
	private UsoVeicolo uso;

	// flag
	/**
	 * @uml.property  name="trasportoMerci"
	 */
	private String trasportoMerci;

	/**
	 * @uml.property  name="carrozzeria"
	 * @uml.associationEnd
	 */
	private Carrozzeria carrozzeria;

	/**
	 * @uml.property  name="massaComplessiva"
	 */
	private String massaComplessiva;

	/**
	 * @uml.property  name="kiloWatt"
	 */
	private BigDecimal kiloWatt;

	/**
	 * @uml.property  name="portata"
	 */
	private Integer portata;

	/**
	 * @uml.property  name="alimentazione"
	 * @uml.associationEnd
	 */
	private Combustibile alimentazione;

	/**
	 * @uml.property  name="hasSospensionePneum"
	 */
	private Boolean hasSospensionePneum;

	/**
	 * @uml.property  name="numPosti"
	 */
	private Integer numPosti;

	/**
	 * @uml.property  name="numAssi"
	 */
	private Integer numAssi;

	/**
	 * @uml.property  name="potenzaFiscale"
	 */
	private Integer potenzaFiscale; //cavalli fiscali

	/**
	 * @uml.property  name="cilindrata"
	 */
	private Integer cilindrata;

	/**
	 * @uml.property  name="isEcoDiesel"
	 */
	private Boolean isEcoDiesel;

	/**
	 * @uml.property  name="isGancioPresente"
	 */
	private Boolean isGancioPresente;

	/**
	 * @uml.property  name="massaRimorchiabile"
	 */
	private Integer massaRimorchiabile;

	/**
	 * @uml.property  name="isRimorchiabile"
	 */
	private Boolean isRimorchiabile;

	private CategoriaEuro categoriaEuro;

	private Boolean isImpiantoAGas;

	private String emissioneCO2;

	private Date dataInstallazioneGas;
	
	private Date dataCollaudoGas;
	
	private Combustibile alimentazioneImpiantoGas;
	
	private Date dataDisinstallazioneGas;
	
	//~ Constructors =============================================================

	public String getEmissioneCO2() {
		return emissioneCO2;
	}

	public void setEmissioneCO2(String emissioneCO2) {
		if (emissioneCO2 != null) {
			verifyLength(emissioneCO2.toString(), EMISSIONE_CO2_LENGTH, INVALID_EMISSIONE_CO2);
		}

		this.emissioneCO2 = emissioneCO2;
	}

	// Constructor
	public DatiTecnici(IdDatiTecnici id) {
		this.id = id;
	}

	//~ Methods ==================================================================

	// Implementation of OggettoStoricizzato
	/**
	 * @return  Returns the eventoFine.
	 * @uml.property  name="eventoFine"
	 */
	public Evento getEventoFine() {
		return eventoFine;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="eventoInizio"
	 */
	public Evento getEventoInizio() {
		return eventoInizio;
	}

	/**
	 * DOCUMENT ME!
	 * @param eventoFine  DOCUMENT ME!
	 * @uml.property  name="eventoFine"
	 */
	public void setEventoFine(Evento eventoFine) {
		this.eventoFine = eventoFine;
	}

	/**
	 * DOCUMENT ME!
	 * @param eventoInizio  DOCUMENT ME!
	 * @uml.property  name="eventoInizio"
	 */
	public void setEventoInizio(Evento eventoInizio) {
		this.eventoInizio = eventoInizio;
	}

	// Getters
	/**
	 * @return  Returns the id.
	 * @uml.property  name="id"
	 */
	public IdDatiTecnici getId() {
		return this.id;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="fonte"
	 */
	public Fonte getFonte() {
		return fonte;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="carrozzeria"
	 */
	public Carrozzeria getCarrozzeria() {
		return carrozzeria;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="uso"
	 */
	public UsoVeicolo getUso() {
		return uso;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="trasportoMerci"
	 */
	public String getTrasportoMerci() {
		return trasportoMerci;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="targa"
	 */
	public String getTarga() {
		return targa;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="scadenzaAttribuita"
	 */
	public Integer getScadenzaAttribuita() {
		return scadenzaAttribuita;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public Mese getScadenzaMese() {
		Mese mese = null;

		if (scadenzaAttribuita != null) {
			mese = Mese.getMeseById(new IdDecodifica(scadenzaAttribuita.longValue()));
		}

		return mese;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="potenzaFiscale"
	 */
	public Integer getPotenzaFiscale() {
		return potenzaFiscale;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="portata"
	 */
	public Integer getPortata() {
		return portata;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="numPosti"
	 */
	public Integer getNumPosti() {
		return numPosti;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="numAssi"
	 */
	public Integer getNumAssi() {
		return numAssi;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="massaRimorchiabile"
	 */
	public Integer getMassaRimorchiabile() {
		return massaRimorchiabile;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="massaComplessiva"
	 */
	public String getMassaComplessiva() {
		return massaComplessiva;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="kiloWatt"
	 */
	// Cambiato in data 02/01/2006
	//  public String getKiloWatt() {
	//    return kiloWatt;
	//  }
	public BigDecimal getKiloWatt() {
		return kiloWatt;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="isGancioPresente"
	 */
	public Boolean getIsGancioPresente() {
		return isGancioPresente;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="isEcoDiesel"
	 */
	public Boolean getIsEcoDiesel() {
		return isEcoDiesel;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="isRimorchiabile"
	 */
	public Boolean getIsRimorchiabile() {
		return isRimorchiabile;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="hasSospensionePneum"
	 */
	public Boolean getHasSospensionePneum() {
		return hasSospensionePneum;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="destinazione"
	 */
	public DestinazioneVeicolo getDestinazione() {
		return destinazione;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="cilindrata"
	 */
	public Integer getCilindrata() {
		return cilindrata;
	}

	/**
	 * DOCUMENT ME!
	 * @return  DOCUMENT ME!
	 * @uml.property  name="alimentazione"
	 */
	public Combustibile getAlimentazione() {
		return alimentazione;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public String getStato() {
		return (eventoFine == null) ? STATO_APERTA : STATO_CHIUSA;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isAperto() {
		return eventoFine == null;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean isChiuso() {
		return eventoFine != null;
	}

	// Getters non associati direttamente ad un attributo
	public BigDecimal getPortataInQuintali() {
		BigDecimal result = null;

		if (portata != null) {
			result = UnitConversionUtil.convertKgIntoQuintali(new BigDecimal(portata.toString()));
		}

		return result;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public BigDecimal getPesoComplessivoInTonnellate() {
		return UnitConversionUtil.convertKgIntoTonnellate(UnitConversionUtil.parseWeight(getMassaComplessiva()));
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public BigDecimal getPesoComplessivoInQuintali() {
		return UnitConversionUtil.convertKgIntoQuintali(UnitConversionUtil.parseWeight(getMassaComplessiva()));
	}

	// Setters
	/**
	 * @param fonte  The fonte to set.
	 * @uml.property  name="fonte"
	 */
	public void setFonte(Fonte fonte) {
		this.fonte = fonte;
	}

	/**
	 * DOCUMENT ME!
	 * @param alimentazione  DOCUMENT ME!
	 * @uml.property  name="alimentazione"
	 */
	public void setAlimentazione(Combustibile alimentazione) {
		this.alimentazione = alimentazione;
	}

	/**
	 * DOCUMENT ME!
	 * @param carrozzeria  DOCUMENT ME!
	 * @uml.property  name="carrozzeria"
	 */
	public void setCarrozzeria(Carrozzeria carrozzeria) {
		this.carrozzeria = carrozzeria;
	}

	/**
	 * DOCUMENT ME!
	 * @param cilindrata  DOCUMENT ME!
	 * @uml.property  name="cilindrata"
	 */
	public void setCilindrata(Integer cilindrata) {
		if (cilindrata != null) {
			verifyLength(cilindrata.toString(), CILINDRATA_LENGTH, INVALID_CILINDRATA);
		}

		this.cilindrata = cilindrata;
	}

	/**
	 * DOCUMENT ME!
	 * @param destinazione  DOCUMENT ME!
	 * @uml.property  name="destinazione"
	 */
	public void setDestinazione(DestinazioneVeicolo destinazione) {
		this.destinazione = destinazione;
	}

	/**
	 * DOCUMENT ME!
	 * @param hasSospensionePneum  DOCUMENT ME!
	 * @uml.property  name="hasSospensionePneum"
	 */
	public void setHasSospensionePneum(Boolean hasSospensionePneum) {
		this.hasSospensionePneum = hasSospensionePneum;
	}

	/**
	 * DOCUMENT ME!
	 * @param isEcoDiesel  DOCUMENT ME!
	 * @uml.property  name="isEcoDiesel"
	 */
	public void setIsEcoDiesel(Boolean isEcoDiesel) {
		this.isEcoDiesel = isEcoDiesel;
	}

	/**
	 * DOCUMENT ME!
	 * @param isGancioPresente  DOCUMENT ME!
	 * @uml.property  name="isGancioPresente"
	 */
	public void setIsGancioPresente(Boolean isGancioPresente) {
		this.isGancioPresente = isGancioPresente;
	}

	/**
	 * DOCUMENT ME!
	 * @param isRimorchiabile  DOCUMENT ME!
	 * @uml.property  name="isRimorchiabile"
	 */
	public void setIsRimorchiabile(Boolean isRimorchiabile) {
		this.isRimorchiabile = isRimorchiabile;
	}

	/**
	 * DOCUMENT ME!
	 * @param kiloWatt  DOCUMENT ME!
	 * @uml.property  name="kiloWatt"
	 */
	// Cambiato in data 02/01/2006
	//  public void setKiloWatt(String kiloWatt) {
	//    verifyLength(kiloWatt, KILOWATT_LENGTH, INVALID_KILOWATT);
	//    this.kiloWatt = kiloWatt;
	//  }
	public void setKiloWatt(BigDecimal kiloWatt) {
		if (kiloWatt == null) return;

		verifyLength(kiloWatt.toString(), KILOWATT_LENGTH, INVALID_KILOWATT);
		this.kiloWatt = kiloWatt;
	}

	/**
	 * DOCUMENT ME!
	 * @param massaComplessiva  DOCUMENT ME!
	 * @uml.property  name="massaComplessiva"
	 */
	public void setMassaComplessiva(String massaComplessiva) {
		verifyLength(massaComplessiva, MASSA_COMPLESSIVA_LENGTH, INVALID_MASSA_COMPLESSIVA);
		this.massaComplessiva = massaComplessiva;
	}

	/**
	 * DOCUMENT ME!
	 * @param massaRimorchiabile  DOCUMENT ME!
	 * @uml.property  name="massaRimorchiabile"
	 */
	public void setMassaRimorchiabile(Integer massaRimorchiabile) {
		if (massaRimorchiabile != null) {
			verifyLength(massaRimorchiabile.toString(), MASSARIMORCHIABILE_LENGTH, INVALID_MASSARIMORCHIABILE);
		}

		this.massaRimorchiabile = massaRimorchiabile;
	}

	/**
	 * DOCUMENT ME!
	 * @param numAssi  DOCUMENT ME!
	 * @uml.property  name="numAssi"
	 */
	public void setNumAssi(Integer numAssi) {
		if (numAssi != null) {
			verifyLength(numAssi.toString(), NUMASSI_LENGTH, INVALID_NUMASSI);
		}

		this.numAssi = numAssi;
	}

	/**
	 * DOCUMENT ME!
	 * @param numPosti  DOCUMENT ME!
	 * @uml.property  name="numPosti"
	 */
	public void setNumPosti(Integer numPosti) {
		if (numPosti != null) {
			verifyLength(numPosti.toString(), NUMPOSTI_LENGTH, INVALID_NUMPOSTI);
		}

		this.numPosti = numPosti;
	}

	/**
	 * DOCUMENT ME!
	 * @param portata  DOCUMENT ME!
	 * @uml.property  name="portata"
	 */
	public void setPortata(Integer portata) {
		if (portata != null) {
			verifyLength(portata.toString(), PORTATA_LENGTH, INVALID_PORTATA);
		}

		this.portata = portata;
	}

	/**
	 * DOCUMENT ME!
	 * @param potenzaFiscale  DOCUMENT ME!
	 * @uml.property  name="potenzaFiscale"
	 */
	public void setPotenzaFiscale(Integer potenzaFiscale) {
		if (potenzaFiscale != null) {
			verifyLength(potenzaFiscale.toString(), POTENZA_FISCALE_LENGTH, INVALID_POTENZA_FISCALE);
		}

		this.potenzaFiscale = potenzaFiscale;
	}

	/**
	 * effettua anche i controlli formali che la scadenza sia un mese (valore ammesso 1 - 12)
	 * @param scadenzaAttribuita  DOCUMENT ME!
	 * @throws IllegalArgumentException  DOCUMENT ME!
	 * @uml.property  name="scadenzaAttribuita"
	 */
	public void setScadenzaAttribuita(Integer scadenzaAttribuita) {
		if (scadenzaAttribuita != null) {
			int mese = scadenzaAttribuita.intValue();

			if ((mese < 1) || (mese > 12)) {
				throw new IllegalArgumentException(INVALID_SCADENZA);
			}
		}

		this.scadenzaAttribuita = scadenzaAttribuita;
	}

	/**
	 * DOCUMENT ME!
	 * @param targa  DOCUMENT ME!
	 * @uml.property  name="targa"
	 */
	public void setTarga(String targa) {
		verifyLength(targa, TARGA_CIRCOLAZIONE_LENGTH, INVALID_TARGA);
		this.targa = targa;
	}

	/**
	 * DOCUMENT ME!
	 * @param trasportoMerci  DOCUMENT ME!
	 * @uml.property  name="trasportoMerci"
	 */
	public void setTrasportoMerci(String trasportoMerci) {
		verifyLength(trasportoMerci, TRASPORTO_MERCI_LENGTH, INVALID_TRASPORTO_MERCI);
		this.trasportoMerci = trasportoMerci;
	}

	/**
	 * DOCUMENT ME!
	 * @param uso  DOCUMENT ME!
	 * @uml.property  name="uso"
	 */
	public void setUso(UsoVeicolo uso) {
		this.uso = uso;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param object DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean equals(Object object) {
		boolean equals = false;

		if ((object != null) && object instanceof DatiTecnici) {
			DatiTecnici altro = (DatiTecnici) object;
			equals = EqualsUtil.objectEquals(getId(), altro.getId()) && EqualsUtil.objectEquals(getEventoFine(), altro.getEventoFine())
					&& EqualsUtil.objectEquals(getEventoInizio(), altro.getEventoInizio()) && EqualsUtil.objectEquals(getFonte(), altro.getFonte())
					&& EqualsUtil.objectEquals(getCarrozzeria(), altro.getCarrozzeria()) && EqualsUtil.objectEquals(getUso(), altro.getUso())
					&& EqualsUtil.objectEquals(getTrasportoMerci(), altro.getTrasportoMerci()) && EqualsUtil.objectEquals(getTarga(), altro.getTarga())
					&& EqualsUtil.objectEquals(getScadenzaAttribuita(), altro.getScadenzaAttribuita())
					&& EqualsUtil.objectEquals(getPotenzaFiscale(), altro.getPotenzaFiscale())
					&& EqualsUtil.objectEquals(getPortata(), altro.getPortata()) && EqualsUtil.objectEquals(getNumPosti(), altro.getNumPosti())
					&& EqualsUtil.objectEquals(getNumAssi(), altro.getNumAssi())
					&& EqualsUtil.objectEquals(getMassaRimorchiabile(), altro.getMassaRimorchiabile())
					&& EqualsUtil.objectEquals(getMassaComplessiva(), altro.getMassaComplessiva())
					&& EqualsUtil.objectEquals(getKiloWatt(), altro.getKiloWatt())
					&& EqualsUtil.objectEquals(getIsGancioPresente(), altro.getIsGancioPresente())
					&& EqualsUtil.objectEquals(getIsEcoDiesel(), altro.getIsEcoDiesel())
					&& EqualsUtil.objectEquals(getIsRimorchiabile(), altro.getIsRimorchiabile())
					&& EqualsUtil.objectEquals(getHasSospensionePneum(), altro.getHasSospensionePneum())
					&& EqualsUtil.objectEquals(getDestinazione(), altro.getDestinazione())
					&& EqualsUtil.objectEquals(getCilindrata(), altro.getCilindrata())
					&& EqualsUtil.objectEquals(getCategoriaEuro(), altro.getCategoriaEuro())
					&& EqualsUtil.objectEquals(getIsImpiantoAGas(), altro.getIsImpiantoAGas())
					&& EqualsUtil.objectEquals(getEmissioneCO2(), altro.getEmissioneCO2())
					&& EqualsUtil.objectEquals(getAlimentazione(), altro.getAlimentazione())
					// Impianto a gas
					&& EqualsUtil.objectEquals(getDataInstallazioneGas(), altro.getDataInstallazioneGas())
					&& EqualsUtil.objectEquals(getDataCollaudoGas(), altro.getDataCollaudoGas())
					&& EqualsUtil.objectEquals(getTipoAlimentazioneGas(), altro.getTipoAlimentazioneGas())
					&& EqualsUtil.objectEquals(getDataDisinstallazioneGas(), altro.getDataDisinstallazioneGas());
		}

		return equals;
	}

	/** Compara dati tecnici in base alla data dell'evento inizio
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o) {
		if (getEventoInizio() == null) return 0;
		DatiTecnici altro = (DatiTecnici) o;
		if (altro == null) return 0;
		return getEventoInizio().compareTo(altro.getEventoInizio());
	}

	public CategoriaEuro getCategoriaEuro() {
		return categoriaEuro;
	}

	public void setCategoriaEuro(CategoriaEuro categoriaEuro) {
		this.categoriaEuro = categoriaEuro;
	}

	public Boolean getIsImpiantoAGas() {
		return isImpiantoAGas;
	}

	public void setIsImpiantoAGas(Boolean isImpiantoAGas) {
		this.isImpiantoAGas = isImpiantoAGas;
	}

	public Date getDataDisinstallazioneGas() {
		return dataDisinstallazioneGas;
	}

	public void setDataDisinstallazioneGas(Date dataDisinstallazioneGas) {
		this.dataDisinstallazioneGas = dataDisinstallazioneGas;
	}

	public Date getDataInstallazioneGas() {
		return dataInstallazioneGas;
	}

	public void setDataInstallazioneGas(Date dataInstallazioneGas) {
		this.dataInstallazioneGas = dataInstallazioneGas;
	}

	public Date getDataCollaudoGas() {
		return dataCollaudoGas;
	}

	public void setDataCollaudoGas(Date dataCollaudoGas) {
		this.dataCollaudoGas = dataCollaudoGas;
	}

	public Combustibile getTipoAlimentazioneGas() {
		return alimentazioneImpiantoGas;
	}

	public void setTipoAlimentazioneGas(Combustibile alimentazioneImpiantoGas) {
		this.alimentazioneImpiantoGas = alimentazioneImpiantoGas;
	}
}
