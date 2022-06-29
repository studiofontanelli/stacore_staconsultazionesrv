package it.csi.stacore.staconsultazionesrv.business.helper.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.stacore.staconsultazionesrv.api.dto.Posizione;
import it.csi.stacore.staconsultazionesrv.api.dto.Utente;
import it.csi.stacore.staconsultazionesrv.business.exception.HelperException;
import it.csi.stacore.staconsultazionesrv.business.helper.PosizioneHelper;
import it.csi.stacore.staconsultazionesrv.integration.bo.Veicolo;
import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdPosizione;
import it.csi.stacore.staconsultazionesrv.integration.dao.PosizioneDAO;
import it.csi.stacore.staconsultazionesrv.integration.dao.VeicoloDAO;
import it.csi.stacore.staconsultazionesrv.integration.service.stasogg.StasoggService;
import it.csi.stacore.staconsultazionesrv.util.Tracer;
import it.csi.stacore.staconsultazionesrv.util.XmlSerializer;

@Service("posizioneHelper")
public class PosizioneHelperImpl extends CommonHelperImpl implements PosizioneHelper {
	
	
	
	@Autowired
	private StasoggService stasoggService;
	
	@Autowired
	private PosizioneDAO posizioneDAO;
	
	@Autowired
	private VeicoloDAO veicoloDAO;
	
	@PostConstruct
	public void init() {
		final String method = "init";
		try {
			Tracer.debug(LOG, getClass().getName(), method, "called");
			
			
			
		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception "  +e);
		}
		finally {
			
		}
		
	}

	
	public boolean testResources() throws HelperException {
		final String method = "testResources";
		try {
			Tracer.debug(LOG, getClass().getName(), method, "called");
			return stasoggService.testResource();
		} catch (Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new HelperException(e.getMessage());
		}
		finally {
			
		}
		
	}


	@Override
	public Posizione caricaDettaglioPosizione(Long id, Utente utente) throws HelperException {
		final String method = "caricaDettaglioPosizione";
		Posizione result = null;
		try {
			
			IdPosizione idPosizione = new IdPosizione(id);
			
			it.csi.stacore.staconsultazionesrv.integration.bo.Posizione posizione= posizioneDAO.loadById(idPosizione);
			
			
			Tracer.debug(LOG, getClass().getName(), method, "found posizione\n " + XmlSerializer.objectToXml(posizione));
			
			
			if(posizione != null) {
				if(posizione.getIdVeicolo() != null) {
					Veicolo veicolo = veicoloDAO.loadById(posizione.getIdVeicolo());
					Tracer.debug(LOG, getClass().getName(), method, "found veicolo\n " + XmlSerializer.objectToXml(veicolo));
					
				}
				if(posizione.getIdProprietario() != null) {
					
					Tracer.debug(LOG, getClass().getName(), method, "load stasogg");
					
					Tracer.debug(LOG, getClass().getName(), method, "carico il soggetto GMS dato l'ID proprietario " + posizione.getIdProprietario().getId());
					
					/*
					ServizioProprietariAccessoTAU servizioProprietariAccessoTAU = new ServizioProprietariAccessoTAU();
					GmsIdSoggetto gmsIdSoggetto = servizioProprietariAccessoTAU
							.loadGMSIdSoggettoByIdProprietario(conn,
									posizione.getIdProprietario());

					proprietario = proprietariAccessoGMSBean.loadById(
							gmsIdSoggetto, posizione.getIdProprietario(), utente);
					*/
				}
			}
			
			/*
			 * 
			 * if (posizione.getIdProprietario() != null) {
				ServizioProprietariAccessoTAU servizioProprietariAccessoTAU = new ServizioProprietariAccessoTAU();
				GmsIdSoggetto gmsIdSoggetto = servizioProprietariAccessoTAU
						.loadGMSIdSoggettoByIdProprietario(conn,
								posizione.getIdProprietario());

				proprietario = proprietariAccessoGMSBean.loadById(
						gmsIdSoggetto, posizione.getIdProprietario(), utente);
			}
			 * 
			 */
			
		} catch (Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception " + e);
			throw new HelperException(e.getMessage());
		}
		finally {
			
		}
		return result;
	}

	

}
