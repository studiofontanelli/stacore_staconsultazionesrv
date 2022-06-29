package it.csi.stacore.staconsultazionesrv.integration.bo.factory;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import it.csi.stacore.staconsultazionesrv.integration.bo.DatiTecnici;
import it.csi.stacore.staconsultazionesrv.integration.bo.StoricoDatiTecnici;
import it.csi.stacore.staconsultazionesrv.integration.bo.TipoVeicolo;
import it.csi.stacore.staconsultazionesrv.integration.bo.Veicolo;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdVeicolo;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class VeicoloFactory implements java.io.Serializable {
  //~ Static fields/initializers ===============================================

  private static final long serialVersionUID = 1211212121L;
	private static VeicoloFactory istance = new VeicoloFactory();

  //~ Constructors =============================================================

  private VeicoloFactory() {
  }

  //~ Methods ==================================================================

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static VeicoloFactory getInstance() {
    if(istance == null) {
      istance = new VeicoloFactory();
    }

    return istance;
  }

  /**
   * restituisce l'oggetto Veicolo
   *
   * @param idVeicolo
   * @param tipo
   * @param idSubentrante
   * @param telaio
   * @param dataUltimaRevisione
   *
   * @return
   */
  public Veicolo buildWithoutDatiTecnici(
                                         Long idVeicolo, TipoVeicolo tipo,
                                         Long idSubentrante, String telaio,
                                         Date dataUltimaRevisione
                                        ) {
    IdVeicolo idSub  =
      (idSubentrante != null) ? new IdVeicolo(idSubentrante.longValue()) : null;
    IdVeicolo idVeic = null;

    if(idVeicolo != null) {
      idVeic = new IdVeicolo(idVeicolo.longValue(), idSub);
    }

    return new Veicolo(
                       idVeic, tipo,    // idProprietario
                       telaio, dataUltimaRevisione,
                       new StoricoDatiTecnici(new LinkedList())
                      );    // storicoDatiTecnici
  }

  /**
   * restituisce un veicolo partendo dal tipo e dalla targa
   *
   * @param tipoVeicolo
   * @param targa
   *
   * @return
   */
  public Veicolo buildByTipoVeicoloTarga(TipoVeicolo tipoVeicolo, String targa) {
    return this.buildByIdVeicoloTipoVeicoloTelaioTarga(
                                                       null, tipoVeicolo, null,
                                                       targa
                                                      );
  }

  /**
   * restituisce un veicolo non presente in banca dati
   *
   * @param tipoVeicolo
   * @param targa
   *
   * @return
   */
  public Veicolo buildVeicoloTassaCircolazioneByTipoVeicoloTarga(TipoVeicolo tipoVeicolo, String targa) {
    return this.buildByIdVeicoloTipoVeicoloTelaioTarga(
                                                       null, tipoVeicolo, null,
                                                       targa
                                                      );
  }

  /**
   * restituisce un veicolo partendo dal tipo e dal telaio
   *
   * @param tipoVeicolo
   * @param telaio
   *
   * @return
   */
  public Veicolo buildByTipoVeicoloTelaio(
                                          TipoVeicolo tipoVeicolo, String telaio
                                         ) {
    return this.buildByIdVeicoloTipoVeicoloTelaioTarga(
                                                       null, tipoVeicolo, telaio,
                                                       null
                                                      );
  }

  /**
   * restituisce un veicolo partendo dal tipo, dal telaio e dalla targa
   *
   * @param tipoVeicolo
   * @param telaio DOCUMENT ME!
   * @param targa
   *
   * @return
   */
  public Veicolo buildByTipoVeicoloTelaioTarga(
                                               TipoVeicolo tipoVeicolo,
                                               String telaio, String targa
                                              ) {
    return this.buildByIdVeicoloTipoVeicoloTelaioTarga(
                                                       null, tipoVeicolo, telaio,
                                                       targa
                                                      );
  }

  /**
   * DOCUMENT ME!
   *
   * @param lIdVeicolo DOCUMENT ME!
   * @param tipoVeicolo DOCUMENT ME!
   * @param telaio DOCUMENT ME!
   * @param targa DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public Veicolo buildByIdVeicoloTipoVeicoloTelaioTarga(
                                                        Long lIdVeicolo,
                                                        TipoVeicolo tipoVeicolo,
                                                        String telaio,
                                                        String targa
                                                       ) {
    // costruisco l'idVeicolo
    IdVeicolo idVeicolo = null;

    if(lIdVeicolo != null) {
      idVeicolo = new IdVeicolo(lIdVeicolo.longValue());
    }

    // costruisco il tipo veicolo
    TipoVeicolo tipo = tipoVeicolo;

    //costruisco lo storico dei dati tecnici
    LinkedList list = new LinkedList();

    if((targa != null) && (targa.length() != 0)) {
      // costruisco i dati tecnici
      DatiTecniciFactory datiFactory = DatiTecniciFactory.getInstance();
      DatiTecnici        tec = datiFactory.buildByTarga(targa);
      list.add(tec);
    }

    StoricoDatiTecnici storico = new StoricoDatiTecnici(list);

    return new Veicolo(
                       idVeicolo,    // idVeicolo
                       tipo,    // idProprietario
                       telaio, null,    // telaio
                       storico
                      );
  }

  /**
   * restituisce il veicolo completo a partire dai dati del veicolo e dalla
   * lista dei dati tecnici
   *
   * @param veicolo
   * @param datiTecnici
   *
   * @return
   */
  public Veicolo buildByVeicoloDatiTecnici(Veicolo veicolo, List datiTecnici) {
    return new Veicolo(
                       veicolo.getId(), veicolo.getTipoVeicolo(),
                       veicolo.getTelaio(), veicolo.getDataUltimaRevisione(),
                       new StoricoDatiTecnici(datiTecnici)
                      );
  }
}
