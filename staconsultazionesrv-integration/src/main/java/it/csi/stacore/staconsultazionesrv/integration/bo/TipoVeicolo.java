package it.csi.stacore.staconsultazionesrv.integration.bo;

import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdDecodifica;
import it.csi.stacore.staconsultazionesrv.integration.util.EqualsUtil;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class TipoVeicolo extends Decodifica implements java.io.Serializable {
  //~ Static fields/initializers ===============================================

  /**
	 * 
	 */
	private static final long serialVersionUID = 8713029499689705094L;
private static final String CODICE_AUTOVEICOLO                     = "A";
  private static final String CODICE_MOTOVEICOLO                     = "M";
  private static final String CODICE_RIMORCHIO                       = "R";
  private static final String CODICE_CICLOMOTORE                     = "C";
  private static final String CODICE_QUADRICICLO_LEGGERO             = "Q";
  private static final String CODICE_TARGA_PROVA_AUTOVEICOLO         = "PA";
  private static final String CODICE_TARGA_PROVA_MOTOVEICOLO         = "PM";
  private static final String CODICE_TARGA_PROVA_RIMORCHIO           = "PR";
  private static final String CODICE_TARGA_PROVA_CICLOMOTORE         = "PC";
  private static final String CODICE_TARGA_PROVA_QUADRICICLO_LEGGERO = "PQ";
  private static final String CODICE_TARGA_PROVA_AUTOSCAFO           = "PS";
  private static final String CODICE_TARGA_PROVA_MOTORE_FUORIBORDO   = "MF";
  

  //~ Constructors =============================================================

  /**
   * Creates a new TipoVeicolo object.
   *
   * @param idDecodifica DOCUMENT ME!
   * @param codice DOCUMENT ME!
   * @param descrizione DOCUMENT ME!
   */
  public TipoVeicolo(
                     IdDecodifica idDecodifica, String codice,
                     String descrizione
                    ) {
    super(idDecodifica, codice, descrizione);
  }

  //~ Methods ==================================================================

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public IdDecodifica getIdTipoVeicolo() {
    return getId();
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

    if((object != null) && object instanceof TipoVeicolo) {
      TipoVeicolo altro = (TipoVeicolo) object;
      equals = EqualsUtil.objectEquals(getCodice(), altro.getCodice());
    }

    return equals;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isAutoveicolo() {
    return this.getCodice().equals(CODICE_AUTOVEICOLO);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isMotoveicolo() {
    return this.getCodice().equals(CODICE_MOTOVEICOLO);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isRimorchio() {
    return this.getCodice().equals(CODICE_RIMORCHIO);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isCiclomotore() {
    return this.getCodice().equals(CODICE_CICLOMOTORE);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isQuadricicloLeggero() {
    return this.getCodice().equals(CODICE_QUADRICICLO_LEGGERO);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isTargaProvaAutoveicolo() {
    return this.getCodice().equals(CODICE_TARGA_PROVA_AUTOVEICOLO);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isTargaProvaMotoveicolo() {
    return this.getCodice().equals(CODICE_TARGA_PROVA_MOTOVEICOLO);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isTargaProvaRimorchio() {
    return this.getCodice().equals(CODICE_TARGA_PROVA_RIMORCHIO);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isTargaProvaCiclomotore() {
    return this.getCodice().equals(CODICE_TARGA_PROVA_CICLOMOTORE);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isTargaProvaQuadricicloLeggero() {
    return this.getCodice().equals(CODICE_TARGA_PROVA_QUADRICICLO_LEGGERO);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isAssociabileAVeicoloInBancaDati() {
    return isAutoveicolo() || isMotoveicolo() || isRimorchio();
  }
  
  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isTargaProvaAutoscafo() {
    return this.getCodice().equals(CODICE_TARGA_PROVA_AUTOSCAFO);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isTargaProvaMotoreFuoribordo() {
    return this.getCodice().equals(CODICE_TARGA_PROVA_MOTORE_FUORIBORDO);
  }

  public boolean isAbilitatoSAP() {
  	return isAutoveicolo() || isMotoveicolo();
  }
}
