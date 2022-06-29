package it.csi.stacore.staconsultazionesrv.integration.bo.id;

/**
 * DOCUMENT ME!
 * 
 * @author $author$
 * @version $Revision$
 */
public class IdProprietario extends LongId implements java.io.Serializable {
	// ~ Instance fields
	// ==========================================================

	/**
	 * 
	 */
	private static final long serialVersionUID = 607568227337025897L;
	/**
	 * @uml.property name="idSubentrante"
	 * @uml.associationEnd
	 */
	private IdProprietario idSubentrante = null;

	// ~ Constructors
	// =============================================================

	/**
	 * Creates a new IdProprietario object.
	 * 
	 * @param id
	 *            DOCUMENT ME!
	 */
	public IdProprietario(long id) {
		super(id);
	}

	/**
	 * Creates a new IdProprietario object.
	 * 
	 * @param id
	 *            DOCUMENT ME!
	 * @param idSubentrante
	 *            DOCUMENT ME!
	 */
	public IdProprietario(long id, IdProprietario idSubentrante) {
		this(id);
		this.idSubentrante = idSubentrante;
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

		if ((object != null) && object instanceof IdProprietario) {
			IdProprietario altro = (IdProprietario) object;
			equals = (this.getId() == altro.getId());
		}

		return equals;
	}

	// ~ Methods
	// ==================================================================

	
}
