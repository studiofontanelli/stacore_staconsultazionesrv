package it.csi.stacore.staconsultazionesrv.integration.bo;

import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdDecodifica;
import it.csi.stacore.staconsultazionesrv.integration.util.EqualsUtil;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class UsoVeicolo extends Decodifica implements java.io.Serializable {
  //~ Static fields/initializers ===============================================

  /**
	 * 
	 */
	private static final long serialVersionUID = 2850781976761410177L;
private static final String CODICE_PROPRIO                               =
    "0";
  private static final String CODICE_TERZI_DA_NOLEGGIO_CON_CONDUC          =
    "1";
  private static final String CODICE_TERZI_DA_LOCARE_SENZA_CONDUC          =
    "2";
  private static final String CODICE_DI_TERZI                              =
    "3";
  private static final String CODICE_PROPRIO_4                             =
    "4";
  private static final String CODICE_PROPRIO_5                             =
    "5";
  private static final String CODICE_DI_TERZI_CON_AUTORIZZAZIONI_VINCOLATE =
    "6";
  private static final String CODICE_DI_TERZI_CON_AUTORIZZAZIONE_LIBERA    =
    "7";
  private static final String CODICE_USO_SPECIALE                          =
    "8";
  private static final String CODICE_PRIV_LOCAZIONE_FAC_COMPERA            =
    "9";

  //~ Constructors =============================================================

  //    public static final UsoVeicolo PROPRIO = new UsoVeicolo(new IdDecodifica(1),"0","PROPRIO");
  //    public static final UsoVeicolo NOL_CON_CONDUCENTE = new UsoVeicolo(new IdDecodifica(2),"1","DI TERZI DA NOLEGGIO CON CONDUC.");
  //    public static final UsoVeicolo NOL_SENZA_CONDUCENTE = new UsoVeicolo(new IdDecodifica(3),"2","DI TERZI DA LOCARE SENZA CONDUC.");
  //    public static final UsoVeicolo TERZI = new UsoVeicolo(new IdDecodifica(4),"3","DI TERZI");
  public UsoVeicolo(
                    IdDecodifica idDecodifica, String codice, String descrizione
                   ) {
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

    if((object != null) && object instanceof UsoVeicolo) {
      UsoVeicolo altro = (UsoVeicolo) object;
      equals = EqualsUtil.objectEquals(getCodice(), altro.getCodice());
    }

    return equals;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isProprio() {
    return this.getCodice().equals(CODICE_PROPRIO);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isTerziDaNoleggioConConducente() {
    return this.getCodice().equals(CODICE_TERZI_DA_NOLEGGIO_CON_CONDUC);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isTerziDaLocareSenzaConducente() {
    return this.getCodice().equals(CODICE_TERZI_DA_LOCARE_SENZA_CONDUC);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isDiTerzi() {
    return this.getCodice().equals(CODICE_DI_TERZI);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isProprio4() {
    return this.getCodice().equals(CODICE_PROPRIO_4);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isProprio5() {
    return this.getCodice().equals(CODICE_PROPRIO_5);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isDiTerziConAutorizzazioniVincolante() {
    return this.getCodice().equals(CODICE_DI_TERZI_CON_AUTORIZZAZIONI_VINCOLATE);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isDiTerziConAutorizzazioneLibera() {
    return this.getCodice().equals(CODICE_DI_TERZI_CON_AUTORIZZAZIONE_LIBERA);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isUsoSpeciale() {
    return this.getCodice().equals(CODICE_USO_SPECIALE);
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isPrivLocazioneFacCompera() {
    return this.getCodice().equals(CODICE_PRIV_LOCAZIONE_FAC_COMPERA);
  }
}
