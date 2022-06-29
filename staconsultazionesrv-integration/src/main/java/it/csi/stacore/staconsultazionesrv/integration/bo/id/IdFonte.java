package it.csi.stacore.staconsultazionesrv.integration.bo.id;

/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class IdFonte extends IdDecodifica implements java.io.Serializable {
  //~ Constructors =============================================================

  /**
	 * 
	 */
	private static final long serialVersionUID = 7529808196643739205L;

/**
   * Creates a new IdFonte object.
   *
   * @param id DOCUMENT ME!
   */
  public IdFonte(long id) {
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

    if((object != null) && object instanceof IdFonte) {
      IdFonte altro = (IdFonte) object;
      equals = (this.getId() == altro.getId());
    }

    return equals;
  }
}
