package it.csi.stacore.staconsultazionesrv.integration.bo.id;

/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class IdDatiTecnici extends LongId implements java.io.Serializable {
  //~ Constructors =============================================================

  /**
	 * 
	 */
	private static final long serialVersionUID = 3344444001107880045L;

/**
   * Creates a new IdDatiTecnici object.
   *
   * @param id DOCUMENT ME!
   */
  public IdDatiTecnici(long id) {
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

    if((object != null) && object instanceof IdDatiTecnici) {
      IdDatiTecnici altro = (IdDatiTecnici) object;
      equals = (this.getId() == altro.getId());
    }

    return equals;
  }
}
