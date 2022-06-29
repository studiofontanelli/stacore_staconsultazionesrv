package it.csi.stacore.staconsultazionesrv.integration.bo;

import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdOperazioneLogica;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdPosizione;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdProprietario;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdVeicolo;
//import it.csi.stacore.staon.util.EqualsUtil;
import it.csi.stacore.staconsultazionesrv.integration.util.EqualsUtil;

/**
 * DOCUMENT ME!
 * 
 * @author $author$
 * @version $Revision$
 */
public class Posizione /*extends AbstractBO*/ implements /*OggettoStoricizzato*/ java.io.Serializable, Comparable {
	// ~ Static fields/initializers
	// ===============================================

	/**
	 * 
	 */
	private static final long serialVersionUID = 487047436560087029L;

	/**
	 * DOCUMENT ME!
	 */
	public static final String STATO_APERTA = "A";

	/**
	 * DOCUMENT ME!
	 */
	public static final String STATO_CHIUSA = "C";

	// ~ Instance fields
	// ==========================================================

	/**
	 * @uml.property name="id"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	private IdPosizione id = null;
	
	private IdOperazioneLogica idOpeLogica = null;
	/**
	 * @uml.property name="eventoInizio"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	private Evento eventoInizio;
	/**
	 * @uml.property name="eventoFine"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	private Evento eventoFine;

	// private String stato;
	/**
	 * @uml.property name="idProprietario"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	private IdProprietario idProprietario = null;
	/**
	 * @uml.property name="idVeicolo"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	private IdVeicolo idVeicolo = null;
	/**
	 * @uml.property name="fonte"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	private Fonte fonte = null;
	/**
	 * @uml.property name="tipoSoggettoPassivo"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	private Long idTipoSoggettoPassivo = null;

	// ~ Constructors
	// =============================================================

	/**
	 * Creates a new Posizione object.
	 * 
	 * @param id
	 *            DOCUMENT ME!
	 * @param idProprietario
	 *            DOCUMENT ME!
	 * @param idVeicolo
	 *            DOCUMENT ME!
	 * @param eventoInizio
	 *            DOCUMENT ME!
	 * @param eventoFine
	 *            DOCUMENT ME!
	 * @param fonte
	 *            DOCUMENT ME!
	 */
	public Posizione(IdPosizione id, IdProprietario idProprietario,
			IdVeicolo idVeicolo, Evento eventoInizio, Evento eventoFine,
			Fonte fonte) {
		this.id = id;
		this.idProprietario = idProprietario;
		this.idVeicolo = idVeicolo;
		this.eventoInizio = eventoInizio;
		this.eventoFine = eventoFine;
		this.fonte = fonte;
	}

	public Posizione(IdPosizione id, IdProprietario idProprietario,
			IdVeicolo idVeicolo, Evento eventoInizio, Evento eventoFine,
			Fonte fonte, Long idTipoSoggettoPassivo) {
		this.id = id;
		this.idProprietario = idProprietario;
		this.idVeicolo = idVeicolo;
		this.eventoInizio = eventoInizio;
		this.eventoFine = eventoFine;
		this.fonte = fonte;
		this.idTipoSoggettoPassivo = idTipoSoggettoPassivo;
	}
	
	public Posizione(IdPosizione id, IdProprietario idProprietario,
			IdVeicolo idVeicolo, Evento eventoInizio, Evento eventoFine,
			Fonte fonte, Long idTipoSoggettoPassivo, IdOperazioneLogica idOpeLogica) {
		this.id = id;
		this.idProprietario = idProprietario;
		this.idVeicolo = idVeicolo;
		this.eventoInizio = eventoInizio;
		this.eventoFine = eventoFine;
		this.fonte = fonte;
		this.idTipoSoggettoPassivo = idTipoSoggettoPassivo;
		this.idOpeLogica = idOpeLogica;
	}
	
	// ~ Methods
	// ==================================================================

	// Implementation of OggettoStoricizzato
	/**
	 * @return Returns the eventoFine.
	 * @uml.property name="eventoFine"
	 */
	public Evento getEventoFine() {
		return eventoFine;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @uml.property name="eventoInizio"
	 */
	public Evento getEventoInizio() {
		return eventoInizio;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param evento
	 *            DOCUMENT ME!
	 * @uml.property name="eventoInizio"
	 */
	public void setEventoInizio(Evento evento) {
		this.eventoInizio = evento;
	}


	public IdOperazioneLogica getIdOpeLogica() {
		return idOpeLogica;
	}

	public void setIdOpeLogica(IdOperazioneLogica idOpeLogica) {
		this.idOpeLogica = idOpeLogica;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param evento
	 *            DOCUMENT ME!
	 * @uml.property name="eventoFine"
	 */
	public void setEventoFine(Evento evento) {
		this.eventoFine = evento;
	}

	// Getters
	/**
	 * @return Returns the id.
	 * @uml.property name="id"
	 */
	public IdPosizione getId() {
		return id;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @uml.property name="idProprietario"
	 */
	public IdProprietario getIdProprietario() {
		return idProprietario;
	}

	public void setIdProprietario(IdProprietario idProprietario) {
		this.idProprietario = idProprietario;
	}
	
	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @uml.property name="idVeicolo"
	 */
	public IdVeicolo getIdVeicolo() {
		return idVeicolo;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @uml.property name="fonte"
	 */
	public Fonte getFonte() {
		return fonte;
	}
	
	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @uml.property name="tipoSoggettoPassivo"
	 */
	public Long getIdTipoSoggettoPassivo() {
		return idTipoSoggettoPassivo;
	}
	
	public void setTipoSoggettoPassivo(Long tipoSoggettoPassivo) {
		this.idTipoSoggettoPassivo = tipoSoggettoPassivo;
	}
	
	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public String getStato() {
		return (eventoFine != null) ? STATO_CHIUSA : STATO_APERTA;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((eventoFine == null) ? 0 : eventoFine.hashCode());
		result = prime * result
				+ ((eventoInizio == null) ? 0 : eventoInizio.hashCode());
		result = prime * result + ((fonte == null) ? 0 : fonte.hashCode());
		result = prime * result + ((idTipoSoggettoPassivo == null) ? 0 : idTipoSoggettoPassivo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((idProprietario == null) ? 0 : idProprietario.hashCode());
		result = prime * result
				+ ((idVeicolo == null) ? 0 : idVeicolo.hashCode());
		return result;
	}

	public boolean equals(Object object) {
		boolean equals = false;

		if ((object != null) && object instanceof Posizione) {
			Posizione altro = (Posizione) object;
			equals = EqualsUtil.objectEquals(getId(), altro.getId())
					&& EqualsUtil.objectEquals(getIdProprietario(),
							altro.getIdProprietario())
					&& EqualsUtil.objectEquals(getIdVeicolo(),
							altro.getIdVeicolo())
					&& EqualsUtil.objectEquals(getEventoInizio(),
							altro.getEventoInizio())
					&& EqualsUtil.objectEquals(getEventoFine(),
							altro.getEventoFine())
					&& EqualsUtil.objectEquals(getFonte(), altro.getFonte())
					&& EqualsUtil.objectEquals(getIdTipoSoggettoPassivo(), altro.getIdTipoSoggettoPassivo());
		}

		return equals;
	}
	
	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public boolean isAperta() {
		return eventoFine == null;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public boolean isChiusa() {
		return eventoFine != null;
	}

	public boolean isPosizioneChiusuraStorico() {
		boolean result = false;

		TipoEvento tipoEvento = eventoInizio.getTipoEvento();
		if (tipoEvento != null) {
			result = tipoEvento.isEsportazione() || tipoEvento.isRadiazione();
		}

		return result;
	}

	public boolean isPosizioneAperturaStorico() {
		boolean result = false;

		TipoEvento tipoEvento = eventoInizio.getTipoEvento();
		if (tipoEvento != null) {
			result = tipoEvento.isImmatricolazione()
					|| tipoEvento.isImportazione();
		}

		return result;
	}

	public boolean isInCaricoARegioneCorrente() {
		boolean result = false;

		if (getIdProprietario() != null)
			result = true;

		return result;
	}

	public int compareTo(Object o) {
		Posizione altraPosizione = (Posizione) o;
		return eventoInizio.compareTo(altraPosizione.eventoInizio);
	}

}
