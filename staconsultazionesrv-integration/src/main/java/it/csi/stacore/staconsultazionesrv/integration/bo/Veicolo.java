package it.csi.stacore.staconsultazionesrv.integration.bo;

import java.util.Date;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdDatiTecnici;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdVeicolo;
import it.csi.stacore.staconsultazionesrv.integration.util.EqualsUtil;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class Veicolo extends AbstractBO implements java.io.Serializable {
	//~ Static fields/initializers ===============================================

	/**
	 * DOCUMENT ME!
	 */
	static final long           serialVersionUID = 7779688540364140019L;
	private static final String INVALID_TELAIO = "telaio_incorretta";
	private static final int    TELAIO_LENGTH  = 20;
	//private static final BigDecimal LIMITE_KW_IBRIDO = new BigDecimal(100);

	//~ Instance fields ==========================================================

	// Id
	/**
	 * @uml.property  name="id"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private IdVeicolo    id;
	/**
	 * @uml.property  name="tipoVeicolo"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private TipoVeicolo        tipoVeicolo;
	/**
	 * @uml.property  name="telaio"
	 */
	private String             telaio;
	/**
	 * @uml.property  name="dataUltimaRevisione"
	 */
	private Date               dataUltimaRevisione;
	/**
	 * @uml.property  name="storicoDatiTecnici"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private StoricoDatiTecnici storicoDatiTecnici = null;
	
	private boolean flagRicercaAg;
	private IdDatiTecnici idDatiTecnici  = null;
	private IdDatiTecnici nuovoIdDatiTecnici  = null;

	//~ Constructors =============================================================

	/**
	 * Creates a new Veicolo object.
	 *
	 * @param id
	 * @param tipoVeicolo
	 * @param telaio
	 * @param dataUltimaRevisione
	 * @param storicoDatiTecnici
	 */
	public Veicolo(
			IdVeicolo id, TipoVeicolo tipoVeicolo, String telaio,
			Date dataUltimaRevisione, StoricoDatiTecnici storicoDatiTecnici
			) {
		this.id = id;
		this.setTipoVeicolo(tipoVeicolo);
		this.setTelaio(telaio);
		this.setDataUltimaRevisione(dataUltimaRevisione);
		this.storicoDatiTecnici = storicoDatiTecnici;
		this.flagRicercaAg = false;
	}

	//~ Methods ==================================================================

	// Getters

	/**
	 * ritorna IdVeicolo
	 * @return
	 * @uml.property  name="id"
	 */
	public IdVeicolo getId() {
		return id;
	}

	/**
	 * ritorna StoricoDatiTecnici
	 * @return
	 * @uml.property  name="storicoDatiTecnici"
	 */
	public StoricoDatiTecnici getStoricoDatiTecnici() {
		return storicoDatiTecnici;
	}

	/**
	 * ritorna telaio
	 * @return
	 * @uml.property  name="telaio"
	 */
	public String getTelaio() {
		return telaio;
	}

	/**
	 * ritorna tipoVeicolo
	 * @return
	 * @uml.property  name="tipoVeicolo"
	 */
	public TipoVeicolo getTipoVeicolo() {
		return tipoVeicolo;
	}

	/**
	 * ritorna
	 * @return
	 * @uml.property  name="dataUltimaRevisione"
	 */
	public Date getDataUltimaRevisione() {
		return dataUltimaRevisione;
	}

	// Setters

	/**
	 * salva il telaio
	 * @param  telaio
	 * @uml.property  name="telaio"
	 */
	public void setTelaio(String telaio) {
		verifyLength(telaio, TELAIO_LENGTH, INVALID_TELAIO);
		this.telaio = telaio;
	}

	/**
	 * salva tipoVeicolo
	 * @param  tipoVeicolo
	 * @uml.property  name="tipoVeicolo"
	 */
	public void setTipoVeicolo(TipoVeicolo tipoVeicolo) {
		this.tipoVeicolo = tipoVeicolo;
	}

	/**
	 * salva dataUltimaRevisione
	 * @param  dataUltimaRevisione
	 * @uml.property  name="dataUltimaRevisione"
	 */
	public void setDataUltimaRevisione(Date dataUltimaRevisione) {
		this.dataUltimaRevisione = dataUltimaRevisione;
	}

	public boolean isBPower() {
		if (isBPowerGpl() || isBPowerMetano()) {
			return true;
		}

		return false;
	}

	public boolean isBPowerGpl() {
		if (getStoricoDatiTecnici() != null
				&& getStoricoDatiTecnici().getDatiTecniciCorrenti() != null) {
			Combustibile alimentazione = getStoricoDatiTecnici()
					.getDatiTecniciCorrenti().getAlimentazione();
			DatiTecnici immatricolazione = getStoricoDatiTecnici()
					.getDatiTecniciAllaData(getStoricoDatiTecnici().getDataImmatricolazione());

			if (alimentazione != null && immatricolazione != null) {
				if ((alimentazione.isBGpl() && immatricolazione.getAlimentazione().isBGpl())) {
					return true;
				}
			}
		}

		return false;

	}

	public boolean isBPowerMetano() {
		if (getStoricoDatiTecnici() != null && getStoricoDatiTecnici().getDatiTecniciCorrenti() != null) {
			Combustibile alimentazione = getStoricoDatiTecnici().getDatiTecniciCorrenti().getAlimentazione();
			DatiTecnici immatricolazione = getStoricoDatiTecnici().getDatiTecniciAllaData(getStoricoDatiTecnici().getDataImmatricolazione());
			if (alimentazione != null && immatricolazione != null) {
				if ((alimentazione.isBMet() && immatricolazione.getAlimentazione().isBMet())) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isBPowerIbrido() {
		if (getStoricoDatiTecnici() != null && getStoricoDatiTecnici().getDatiTecniciCorrenti() != null) {
			Combustibile alimentazione = getStoricoDatiTecnici().getDatiTecniciCorrenti().getAlimentazione();
			DatiTecnici immatricolazione = getStoricoDatiTecnici().getDatiTecniciAllaData(getStoricoDatiTecnici().getDataImmatricolazione());
			if (alimentazione != null && immatricolazione != null) {
				if ((alimentazione.isBenzElettrico() && immatricolazione.getAlimentazione().isBenzElettrico())) {
					return true;
				}
			}
		}
		return false;
	}


	/*
	public boolean isAgevolazioneApplicabile() {
		if (getStoricoDatiTecnici() != null & getStoricoDatiTecnici().getDatiTecniciCorrenti() != null) {
			DestinazioneVeicolo destinazione = getStoricoDatiTecnici().getDatiTecniciCorrenti().getDestinazione();
			Combustibile alimentazione = getStoricoDatiTecnici().getDatiTecniciCorrenti().getAlimentazione();
			DatiTecnici primoDatoTecnico = getStoricoDatiTecnici().getDatiTecniciAllaData(getStoricoDatiTecnici().getDataImmatricolazione());

			if (destinazione != null && alimentazione != null) {
				if ((destinazione.isAutoveicoloTrasportoPromiscuoPersoneCose()
						|| destinazione.isAutovetturaPerTrasportoDiPersone()
						|| destinazione.isAutocarroPerTrasportoDiCose()

						|| destinazione.isMotocicloPerTrasportoPersone()       // MOTOCICLO PER TRASPORTO PERSONE
						|| destinazione.isMotoveicoloUsoEsclusivoDiPolizia()   // MOTOVEICOLO USO ESCLUSIVO DI POLIZIA
						|| destinazione.isQuadricicloPerTrasportoDiCose()      // QUADRICICLO PER TRASP.DI COSE
						|| destinazione.isQuadricicloPerTrasportoDiPersone()   // QUADRICICLO PER TRASP. DI PERSONE
						|| destinazione.isQuadricicloPerUsoSpeciale()          // QUADRICICLO PER USO SPECIALE
						|| destinazione.isQuadricicloPerTrasportoSpecifico()   // QUADRICICLO TRASP. SPECIFICO
						|| destinazione.isTricicloPerTrasportoCose()           // TRICICLO PER TRASPORTO COSE
						|| destinazione.isTricicloPerTrasportoDiPersone()      // TRICICLO PER TRASPORTO DI PERSONE
						|| destinazione.isTricicloPerTrasportoPromiscuo()      // TRICICLO PER TRASPORTO PROMISCUO
						|| destinazione.isTricicloPerUsoSpeciale()             // TRICICLO PER USO SPECIALE
						|| destinazione.isTricicloPerTrasportoSpecifico()     //  TRICICLO PER TRASPORTO SPECIFICO
					)
						&& alimentazione.isElettr()) {
					return true;
				}
			}

			if (alimentazione != null && primoDatoTecnico != null) {
				Combustibile alimentazionePrimoDatoTecnico = primoDatoTecnico.getAlimentazione();

				if ((alimentazione.isGpl() && alimentazionePrimoDatoTecnico.isGpl())
						|| ((alimentazione.isMetano() && alimentazionePrimoDatoTecnico.isMetano())
								|| (alimentazione.isBGpl() && alimentazionePrimoDatoTecnico.isBGpl())
								|| ((alimentazione.isBMet() && alimentazionePrimoDatoTecnico.isBMet())))) {
					return true;
				}
				//AF: aggiunto controllo per veicoli Ibridi (Benzina + elettrico)
				if ((alimentazione.isBenzElettrico() && alimentazionePrimoDatoTecnico.isBenzElettrico()) && 
					(
					destinazione.isAutoveicoloInServizioPubblicoDiLineaIntegrativo()  // AUTOVEICOLO IN SERVIZIO PUBBLICO DI LINEA INTEGRATIVO
					|| destinazione.isAutoveicoloUsoEsclusivoDiPolizia()   //  AUTOVEICOLO USO ESCLUSIVO DI POLIZIA
					|| destinazione.isAutovetturaPerTrasportoDiPersone()   //  AUTOVETTURA PER TRASPORTO DI PERSONE
					|| destinazione.isAutobusPerTrasportoDiPersone()       //  AUTOBUS PER TRASPORTO DI PERSONE
					|| destinazione.isAutocarroPerTrasportoDiCose()        //  AUTOCARRO PER TRASPORTO DI COSE
					|| destinazione.isAutocaravan()                        //  AUTOCARAVAN
					|| destinazione.isTrasSpecificoPersonePartCondizioni() //  TRAS.SPECIFICO PERSONE PART.CONDIZIONI
					|| destinazione.isAutoveicoloTrasportoPromiscuoPersoneCose()   //  TRICICLO PER TRASPORTO SPECIFICO
					|| destinazione.isAutoveicoloPerUsoSpeciale() 			//  AUTOVEICOLO PER USO SPECIALE	
					|| destinazione.isTrattoreStradalePerRimorchio()       //  TRATTORE STRADALE PER RIMORCHIO
					|| destinazione.isTrattorePerSemirimorchio()           //  TRATTORE PER SEMIRIMORCHIO
					|| destinazione.isAutoveicoloPerTrasportoSpecifico()     //  AUTOVEICOLO PER TRASPORTO SPECIFICO	
					) && primoDatoTecnico.getKiloWatt().compareTo(LIMITE_KW_IBRIDO) <= 0
				) {
					return true;
				}
			}
		}
		return false;
	}
	*/

	public boolean isParticolariAlimentazioni() {
		if (getStoricoDatiTecnici() != null && getStoricoDatiTecnici().getDatiTecniciCorrenti() != null) {
			DestinazioneVeicolo destinazione = getStoricoDatiTecnici().getDatiTecniciCorrenti().getDestinazione();
			Combustibile alimentazione = getStoricoDatiTecnici().getDatiTecniciCorrenti().getAlimentazione();
			DatiTecnici primoDatoTecnico = getStoricoDatiTecnici().getDatiTecniciAllaData(getStoricoDatiTecnici().getDataImmatricolazione());

			if (destinazione != null && alimentazione != null) {
				if ((destinazione.isAutoveicoloTrasportoPromiscuoPersoneCose()
						|| destinazione.isAutovetturaPerTrasportoDiPersone()
						|| destinazione.isAutocarroPerTrasportoDiCose())
						&& alimentazione.isElettr()) {
					return true;
				}
			}
			if (alimentazione != null && primoDatoTecnico != null) {
				Combustibile alimentazionePrimoDatoTecnico = primoDatoTecnico.getAlimentazione();
				if ((alimentazione.isGpl() && alimentazionePrimoDatoTecnico.isGpl())
						|| ((alimentazione.isMetano() && alimentazionePrimoDatoTecnico.isMetano())
								|| (alimentazione.isBGpl() && alimentazionePrimoDatoTecnico.isBGpl())
								|| ((alimentazione.isBMet() && alimentazionePrimoDatoTecnico.isBMet())))) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Indicates whether some other object is "equal to" this one
	 *
	 * @param object
	 *
	 * @return
	 */
	public boolean equals(Object object) {
		boolean equals = false;

		if((object != null) && object instanceof Veicolo) {
			Veicolo altro = (Veicolo) object;
			equals =
					EqualsUtil.objectEquals(getId(), altro.getId()) &&
					EqualsUtil.objectEquals(
							getStoricoDatiTecnici(),
							altro.getStoricoDatiTecnici()
							) &&
					EqualsUtil.objectEquals(getTelaio(), altro.getTelaio()) &&
					EqualsUtil.objectEquals(getTipoVeicolo(), altro.getTipoVeicolo()) &&
					EqualsUtil.objectEquals(
							getDataUltimaRevisione(),
							altro.getDataUltimaRevisione()
							);
		}

		return equals;
	}

	/**
	 * restituisce l'hashcode
	 *
	 * @return
	 */
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	public void setId(IdVeicolo id) {
		this.id = id;
	}

	public boolean isFlagRicercaAg() {
		return flagRicercaAg;
	}

	public void setFlagRicercaAg(boolean flagRicercaAg) {
		this.flagRicercaAg = flagRicercaAg;
	}

	public IdDatiTecnici getIdDatiTecnici() {
		return idDatiTecnici;
	}

	public void setIdDatiTecnici(IdDatiTecnici idDatiTecnici) {
		this.idDatiTecnici = idDatiTecnici;
	}

	public IdDatiTecnici getNuovoIdDatiTecnici() {
		return nuovoIdDatiTecnici;
	}

	public void setNuovoIdDatiTecnici(IdDatiTecnici nuovoIdDatiTecnici) {
		this.nuovoIdDatiTecnici = nuovoIdDatiTecnici;
	}
}
