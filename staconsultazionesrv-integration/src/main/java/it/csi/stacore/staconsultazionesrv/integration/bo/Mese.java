package it.csi.stacore.staconsultazionesrv.integration.bo;

import java.util.HashMap;
import java.util.Map;

import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdDecodifica;
import it.csi.stacore.staconsultazionesrv.integration.util.EqualsUtil;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class Mese extends Decodifica {
  //~ Static fields/initializers ===============================================

  /**
	 * 
	 */
	private static final long serialVersionUID = -3729052785021636330L;

/**
   * DOCUMENT ME!
   */
  public static final Mese GENNAIO   =
    new Mese(new IdDecodifica(1), "GEN", "GENNAIO");

  /**
   * DOCUMENT ME!
   */
  public static final Mese FEBBRAIO  =
    new Mese(new IdDecodifica(2), "FEB", "FEBBRAIO");

  /**
   * DOCUMENT ME!
   */
  public static final Mese MARZO     =
    new Mese(new IdDecodifica(3), "MAR", "MARZO");

  /**
   * DOCUMENT ME!
   */
  public static final Mese APRILE    =
    new Mese(new IdDecodifica(4), "APR", "APRILE");

  /**
   * DOCUMENT ME!
   */
  public static final Mese MAGGIO    =
    new Mese(new IdDecodifica(5), "MAG", "MAGGIO");

  /**
   * DOCUMENT ME!
   */
  public static final Mese GIUGNO    =
    new Mese(new IdDecodifica(6), "GIU", "GIUGNO");

  /**
   * DOCUMENT ME!
   */
  public static final Mese LUGLIO    =
    new Mese(new IdDecodifica(7), "LUG", "LUGLIO");

  /**
   * DOCUMENT ME!
   */
  public static final Mese AGOSTO    =
    new Mese(new IdDecodifica(8), "AGO", "AGOSTO");

  /**
   * DOCUMENT ME!
   */
  public static final Mese SETTEMBRE =
    new Mese(new IdDecodifica(9), "SET", "SETTEMBRE");

  /**
   * DOCUMENT ME!
   */
  public static final Mese OTTOBRE  =
    new Mese(new IdDecodifica(10), "OTT", "OTTOBRE");

  /**
   * DOCUMENT ME!
   */
  public static final Mese NOVEMBRE =
    new Mese(new IdDecodifica(11), "NOV", "NOVEMBRE");

  /**
   * DOCUMENT ME!
   */
  public static final Mese DICEMBRE =
    new Mese(new IdDecodifica(12), "DIC", "DICEMBRE");
  private static Map       mesi = null;

  //~ Constructors =============================================================

  private Mese(IdDecodifica id, String codice, String descrizione) {
    super(id, codice, descrizione);
  }

  //~ Methods ==================================================================

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static Map getMesi() {
    if(mesi == null) {
      mesi = new HashMap();

      mesi.put(GENNAIO.getId(), GENNAIO);
      mesi.put(FEBBRAIO.getId(), FEBBRAIO);
      mesi.put(MARZO.getId(), MARZO);
      mesi.put(APRILE.getId(), APRILE);
      mesi.put(MAGGIO.getId(), MAGGIO);
      mesi.put(GIUGNO.getId(), GIUGNO);
      mesi.put(LUGLIO.getId(), LUGLIO);
      mesi.put(AGOSTO.getId(), AGOSTO);
      mesi.put(SETTEMBRE.getId(), SETTEMBRE);
      mesi.put(OTTOBRE.getId(), OTTOBRE);
      mesi.put(NOVEMBRE.getId(), NOVEMBRE);
      mesi.put(DICEMBRE.getId(), DICEMBRE);
    }

    return mesi;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String toTwoDigitString() {
    String result = getId().toString();

    if(result.length() < 2) {
      result = "0" + result;
    }

    return result;
  }

  /**
   * DOCUMENT ME!
   *
   * @param id DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static Mese getMeseById(IdDecodifica id) {
    return (Mese) getMesi().get(id);
  }

  /**
   * DOCUMENT ME!
   *
   * @param other DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean equals(Object other) {
    boolean equals = false;
    
    if((other != null) && other instanceof Mese) {
      Mese altro = (Mese) other;
      equals = EqualsUtil.objectEquals(getCodice(), altro.getCodice());
    }

    return equals;
  }

}
