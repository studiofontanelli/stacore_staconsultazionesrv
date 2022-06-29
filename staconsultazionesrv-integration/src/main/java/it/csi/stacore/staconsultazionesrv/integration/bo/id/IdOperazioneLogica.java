package it.csi.stacore.staconsultazionesrv.integration.bo.id;

import java.io.Serializable;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class IdOperazioneLogica extends LongId implements Serializable {
  //~ Constructors =============================================================

  /**
	 * 
	 */
	private static final long serialVersionUID = 8486533212059046769L;

/**
   * DOCUMENT ME!
   *
   * @param id
   */
  public IdOperazioneLogica(long id) {
    super(id);
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

    if((object != null) && object instanceof IdOperazioneLogica) {
      IdOperazioneLogica altro = (IdOperazioneLogica) object;
      equals = (this.getId() == altro.getId());
    }

    return equals;
  }
}
