package it.csi.stacore.staconsultazionesrv.integration.bo;


import java.util.Date;

/**
 * DOCUMENT ME!
 * 
 * @author $author$
 * @version $Revision$
 */
public class Evento implements java.io.Serializable, Comparable {
	// ~ Instance fields
	// ==========================================================

	/**
	 * 
	 */
	private static final long serialVersionUID = 4127993875851616621L;
	/**
	 * @uml.property name="tipoEvento"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	private TipoEvento tipoEvento;
	/**
	 * @uml.property name="data"
	 */
	private Date data;

	// ~ Constructors
	// =============================================================

	/**
	 * Creates a new Evento object.
	 * 
	 * @param tipoEvento
	 *            DOCUMENT ME!
	 * @param data
	 *            DOCUMENT ME!
	 */
	public Evento(TipoEvento tipoEvento, Date data) {
		this.tipoEvento = tipoEvento;
		this.data = data;
	}

	// ~ Methods
	// ==================================================================

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @uml.property name="data"
	 */
	public Date getData() {
		return data;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @uml.property name="tipoEvento"
	 */
	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param data
	 *            DOCUMENT ME!
	 * @uml.property name="data"
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param tipoEvento
	 *            DOCUMENT ME!
	 * @uml.property name="tipoEvento"
	 */
	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param object
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */

	
	/*
	 * Compara eventi in base alla data
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o) {
		if (o == null)
			return -1;
		Evento altroEvento = (Evento) o;
		return getData().compareTo(altroEvento.getData());
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((tipoEvento == null) ? 0 : tipoEvento.hashCode());
		return result;
	}
	
	/*
	public boolean equals(Object object) {
		boolean equals = false;

		if ((object != null) && object instanceof Evento) {
			Evento altro = (Evento) object;
			equals = EqualsUtil.objectEquals(getTipoEvento(),
					altro.getTipoEvento())
					&& EqualsUtil.objectEquals(getData(), altro.getData());
		}

		return equals;
	}
	*/
}
