package it.csi.stacore.staconsultazionesrv.integration.bo;

import org.apache.commons.lang3.StringUtils;

import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdFonte;



/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class Fonte extends Decodifica implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9195281141401960734L;
	public static final int AGEVOLAZIONE=0;
	public static final int POSIZIONE=1;
	
	public static final String CODICE_DTT="DTT";
	public static final String CODICE_PRA="PRA";
	public static final String CODICE_RIV="RIV";
	public static final String CODICE_SGATA="SGATA";
	public static final String CODICE_POSTE="POSTE";
	public static final String CODICE_RISC="RISC";
	public static final String CODICE_REG="REG";
	public static final String CODICE_NN="NN";
	
  //~ Constructors =============================================================

  /**
   * Creates a new Fonte object.
   *
   * @param idFonte DOCUMENT ME!
   * @param codice DOCUMENT ME!
   * @param descrizione DOCUMENT ME!
   */
  public Fonte(IdFonte idFonte, String codice, String descrizione) {
    super(idFonte, codice, descrizione);
  }

  //~ Methods ==================================================================

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public IdFonte getIdFonte() {
    return (IdFonte) getId();
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

    if((object != null) && object instanceof Fonte) {
      Fonte altro = (Fonte) object;
      equals = StringUtils.equals(getCodice(), altro.getCodice());
    }

    return equals;
  }
  
  public boolean isAdattaATipoDato(final Integer tipoDato) {
  	boolean result;
  	
  	switch(tipoDato.intValue()) {
  		case AGEVOLAZIONE:
  			result=
  					CODICE_RIV.equalsIgnoreCase(getCodice()) ||
  					CODICE_SGATA.equalsIgnoreCase(getCodice()) ||
  					CODICE_REG.equalsIgnoreCase(getCodice());
  			
  			break;
  			
  		case POSIZIONE:
  			result=
  				CODICE_DTT.equalsIgnoreCase(getCodice()) ||
  				CODICE_PRA.equalsIgnoreCase(getCodice()) ||
  				CODICE_SGATA.equalsIgnoreCase(getCodice()) ||
  				CODICE_NN.equalsIgnoreCase(getCodice());
  			break;
  			
  			
  		default:
  			result=false;
  		break;
  		
  	}
  	return result;
  }
  
  public static Fonte getFonteRegione() {
		return new Fonte(new IdFonte(6), "Regione", CODICE_REG);
	}
  
}