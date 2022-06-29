package it.csi.stacore.staconsultazionesrv.integration.bo;

/**
 * DOCUMENT ME!
 * @author  $author$
 * @version  $Revision$
 */
public interface OggettoStoricizzato extends java.io.Serializable {
  //~ Methods ==================================================================

  /**
	 * DOCUMENT ME!
	 * @return    DOCUMENT ME!
	 * @uml.property  name="eventoInizio"
	 * @uml.associationEnd  
	 */
  public Evento getEventoInizio();

  /**
	 * DOCUMENT ME!
	 * @return    DOCUMENT ME!
	 * @uml.property  name="eventoFine"
	 * @uml.associationEnd  
	 */
  public Evento getEventoFine();

  /**
	 * DOCUMENT ME!
	 * @param evento  DOCUMENT ME!
	 * @uml.property  name="eventoInizio"
	 */
  public void setEventoInizio(Evento evento);

  /**
	 * DOCUMENT ME!
	 * @param evento  DOCUMENT ME!
	 * @uml.property  name="eventoFine"
	 */
  public void setEventoFine(Evento evento);
}
