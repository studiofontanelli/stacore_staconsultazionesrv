package it.csi.stacore.staconsultazionesrv.integration.bo.id;

/**
 * DOCUMENT ME!
 * 
 * @author $author$
 * @version $Revision$
 */
public class IdVeicolo extends LongId implements java.io.Serializable {
	// ~ Instance fields
	// ==========================================================

	/**
	 * 
	 */
	private static final long serialVersionUID = -8106999853835857033L;
	/**
	 * @uml.property name="idSubentrante"
	 * @uml.associationEnd
	 */
	private IdVeicolo idSubentrante = null;

	// ~ Constructors
	// =============================================================

	/**
	 * Creates a new IdVeicolo object.
	 * 
	 * @param id
	 *            DOCUMENT ME!
	 */
	public IdVeicolo(long id) {
		super(id);
	}

	/**
	 * Creates a new IdVeicolo object.
	 * 
	 * @param id
	 *            DOCUMENT ME!
	 * @param idSubentrante
	 *            DOCUMENT ME!
	 */
	public IdVeicolo(long id, IdVeicolo idSubentrante) {
		this(id);
		this.idSubentrante = idSubentrante;
	}

	// ~ Methods
	// ==================================================================

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @uml.property name="idSubentrante"
	 */
	public IdVeicolo getIdSubentrante() {
		return idSubentrante;
	}

	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((idSubentrante == null) ? 0 : idSubentrante.hashCode());
		return result;
	}

	public boolean equals(Object object) {
		boolean equals = false;

		if ((object != null) && object instanceof IdVeicolo) {
			IdVeicolo altro = (IdVeicolo) object;
			equals = (this.getId() == altro.getId());
		}

		return equals;
	}

}
