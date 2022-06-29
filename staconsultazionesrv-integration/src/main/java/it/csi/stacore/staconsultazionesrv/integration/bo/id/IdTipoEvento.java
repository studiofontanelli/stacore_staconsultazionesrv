package it.csi.stacore.staconsultazionesrv.integration.bo.id;

/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class IdTipoEvento extends IdDecodifica implements java.io.Serializable {
  //~ Constructors =============================================================

  /**
	 * 
	 */
	private static final long serialVersionUID = -5745118535758771343L;

/**
   * Creates a new IdTipoEvento object.
   *
   * @param id DOCUMENT ME!
   */
  public IdTipoEvento(long id) {
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

    if((object != null) && object instanceof IdTipoEvento) {
      IdTipoEvento altro = (IdTipoEvento) object;
      equals = (this.getId() == altro.getId());
    }

    return equals;
  }
}
