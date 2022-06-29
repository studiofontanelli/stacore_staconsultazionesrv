package it.csi.stacore.staconsultazionesrv.integration.bo.factory;

import java.math.BigDecimal;
import java.util.Date;

import it.csi.stacore.staconsultazionesrv.integration.bo.Carrozzeria;
import it.csi.stacore.staconsultazionesrv.integration.bo.CategoriaEuro;
import it.csi.stacore.staconsultazionesrv.integration.bo.Combustibile;
import it.csi.stacore.staconsultazionesrv.integration.bo.DatiTecnici;
import it.csi.stacore.staconsultazionesrv.integration.bo.DestinazioneVeicolo;
import it.csi.stacore.staconsultazionesrv.integration.bo.Evento;
import it.csi.stacore.staconsultazionesrv.integration.bo.Fonte;
import it.csi.stacore.staconsultazionesrv.integration.bo.UsoVeicolo;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdDatiTecnici;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class DatiTecniciFactory implements java.io.Serializable {
  //~ Static fields/initializers ===============================================

  private static final long serialVersionUID = 121121212L;
	private static DatiTecniciFactory istance = new DatiTecniciFactory();

  //~ Constructors =============================================================

  private DatiTecniciFactory() {
  }

  //~ Methods ==================================================================

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static DatiTecniciFactory getInstance() {
    if(istance == null) {
      istance = new DatiTecniciFactory();
    }

    return istance;
  }

  /**
   * restituisce il dato tecnico con la sola targa impostata
   *
   * @param targa
   *
   * @return
   */
  public DatiTecnici buildByTarga(String targa) {
    DatiTecnici tec = new DatiTecnici(null);
    tec.setTarga(targa);

    return tec;
  }

  /**
   * DOCUMENT ME!
   *
   * @param idDatiTecnici DOCUMENT ME!
   * @param fonte DOCUMENT ME!
   * @param evInizio DOCUMENT ME!
   * @param evFine DOCUMENT ME!
   * @param targa DOCUMENT ME!
   * @param scadenza DOCUMENT ME!
   * @param destinazione DOCUMENT ME!
   * @param uso DOCUMENT ME!
   * @param trasporto DOCUMENT ME!
   * @param car DOCUMENT ME!
   * @param massa DOCUMENT ME!
   * @param kiloWatt DOCUMENT ME!
   * @param portata DOCUMENT ME!
   * @param alimentazione DOCUMENT ME!
   * @param hasSospensione DOCUMENT ME!
   * @param numPosti DOCUMENT ME!
   * @param numAssi DOCUMENT ME!
   * @param potenza DOCUMENT ME!
   * @param cilindrata DOCUMENT ME!
   * @param isEcoDiesel DOCUMENT ME!
   * @param isGancioPresente DOCUMENT ME!
   * @param massaRimorchiabile DOCUMENT ME!
   * @param isRimorchiabile DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public DatiTecnici buildWithAll(
                                  Long idDatiTecnici, 
                                  Fonte fonte,
                                  Evento evInizio, 
                                  Evento evFine, 
                                  String targa,
                                  Integer scadenza,
                                  DestinazioneVeicolo destinazione,
                                  UsoVeicolo uso, 
                                  String trasporto,
                                  Carrozzeria car, 
                                  String massa, 
                                  BigDecimal kiloWatt,
                                  Integer portata, 
                                  Combustibile alimentazione,
                                  Boolean hasSospensione, 
                                  Integer numPosti,
                                  Integer numAssi, 
                                  Integer potenza,
                                  Integer cilindrata, 
                                  Boolean isEcoDiesel,
                                  Boolean isGancioPresente,
                                  Integer massaRimorchiabile,
                                  Boolean isRimorchiabile,
                                  CategoriaEuro categoriaEuro,
                                  //Boolean isImpiantoAGas,
                                  String emissioneCO2,
                                  Date dataInstallazioneGas,
                                  Date dataCollaudoGas,
                                  Combustibile alimentazioneGas,
                                  Date dataDisinstallazioneGas
                                 ) {
    DatiTecnici tec =
      new DatiTecnici((idDatiTecnici != null)
                      ? new IdDatiTecnici(idDatiTecnici.longValue()) : null
                     );
    tec.setFonte(fonte);
    tec.setEventoInizio(evInizio);
    tec.setEventoFine(evFine);
    tec.setTarga(targa);
    tec.setScadenzaAttribuita(scadenza);
    tec.setDestinazione(destinazione);
    tec.setUso(uso);
    tec.setTrasportoMerci(trasporto);
    tec.setCarrozzeria(car);
    tec.setMassaComplessiva(massa);
    tec.setKiloWatt(kiloWatt);
    tec.setPortata(portata);
    tec.setAlimentazione(alimentazione);
    tec.setHasSospensionePneum(hasSospensione);
    tec.setNumPosti(numPosti);
    tec.setNumAssi(numAssi);
    tec.setPotenzaFiscale(potenza);
    tec.setCilindrata(cilindrata);
    tec.setIsEcoDiesel(isEcoDiesel);
    tec.setIsGancioPresente(isGancioPresente);
    tec.setMassaRimorchiabile(massaRimorchiabile);
    tec.setIsRimorchiabile(isRimorchiabile);
    tec.setCategoriaEuro(categoriaEuro);
    //tec.setIsImpiantoAGas(isImpiantoAGas);
    tec.setEmissioneCO2(emissioneCO2);
    tec.setDataInstallazioneGas(dataInstallazioneGas);
    tec.setDataCollaudoGas(dataCollaudoGas);
    tec.setTipoAlimentazioneGas(alimentazioneGas);
    tec.setDataDisinstallazioneGas(dataDisinstallazioneGas);

    return tec;
  }
}
