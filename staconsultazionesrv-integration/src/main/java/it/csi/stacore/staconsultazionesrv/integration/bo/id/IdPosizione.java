package it.csi.stacore.staconsultazionesrv.integration.bo.id;

/**
 * DOCUMENT ME!
 * 
 * @author $author$
 * @version $Revision$
 */
public class IdPosizione extends LongId implements java.io.Serializable {
	// ~ Constructors
	// =============================================================

	/**
	 * 
	 */
	private static final long serialVersionUID = 2964290346316348732L;

	/**
	 * Creates a new IdPosizione object.
	 * 
	 * @param id
	 *            DOCUMENT ME!
	 */
	public IdPosizione(long id) {
		super(id);
	}

	// ~ Methods
	// ==================================================================

	/**
	 * DOCUMENT ME!
	 * 
	 * @param object
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public boolean equals(Object object) {
		boolean equals = false;

		if ((object != null) && object instanceof IdPosizione) {
			IdPosizione altro = (IdPosizione) object;
			equals = (this.getId() == altro.getId());
		}

		return equals;
	}
}
