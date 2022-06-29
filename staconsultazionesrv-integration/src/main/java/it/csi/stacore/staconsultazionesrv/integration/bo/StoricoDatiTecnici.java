package it.csi.stacore.staconsultazionesrv.integration.bo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.csi.stacore.staconsultazionesrv.integration.bo.id.IdDatiTecnici;
import it.csi.stacore.staconsultazionesrv.integration.util.EqualsUtil;
import it.csi.stacore.staconsultazionesrv.util.DateUtil;

/**
 * DOCUMENT ME!
 * 
 * @author $author$
 * @version $Revision$
 */
public class StoricoDatiTecnici implements java.io.Serializable {
	// ~ Instance fields
	// ==========================================================

	/**
	 * 
	 */
	private static final long serialVersionUID = 2051137755209322695L;

	/**
	 * @uml.property name="datiTecniciList"
	 * @uml.associationEnd multiplicity="(0 -1)"
	 *                     elementType="it.csi.stacore.staon.business.bo.DatiTecnici"
	 */
	private final List datiTecniciList;

	// ~ Constructors
	// =============================================================

	/**
	 * Creates a new StoricoDatiTecnici object.
	 * 
	 * @param datiTecniciList
	 *            DOCUMENT ME!
	 */
	public StoricoDatiTecnici(final List datiTecniciList) {

		if (datiTecniciList == null)
			throw new IllegalArgumentException();
		
		

		List tmp = new LinkedList(datiTecniciList);
		Collections.sort(tmp);

		// verificaCoerenzaStorico(tmp);

		this.datiTecniciList = Collections.unmodifiableList(tmp);
		// se installazione = true
		// se disinstallazione = false
		// altrimenti = isInstallatoImpiantoGasAllaData(data)
		for (Iterator iter = this.datiTecniciList.iterator(); iter.hasNext();) {
			DatiTecnici dt = (DatiTecnici) iter.next();
			Evento eventoInizio = dt.getEventoInizio();
			if (eventoInizio != null && eventoInizio.getTipoEvento() != null) {
				if (eventoInizio.getTipoEvento().isImpiantoAGas()) {
					dt.setIsImpiantoAGas(Boolean.TRUE);
				} else if (eventoInizio.getTipoEvento().isDisinstallazioneImpiantoAGas()) {
					dt.setIsImpiantoAGas(Boolean.FALSE);
				} else {
					Date data = eventoInizio.getData();
					dt.setIsImpiantoAGas(new Boolean(isInstallatoImpiantoGasAllaData(data)));
				}
			}
		}
	}
	
	// ~ Methods
	// ==================================================================

	public DatiTecnici getDatiTecniciById(IdDatiTecnici idDatiTecnici) {
		if (idDatiTecnici != null) {
			for (Iterator iter = datiTecniciList.iterator(); iter.hasNext();) {
				DatiTecnici datiTecnici = (DatiTecnici) iter.next();
				if (idDatiTecnici.equals(datiTecnici.getId())) {
					return datiTecnici;
				}
			}
		}
		return null;
	}

	/**
	 * restituisce l'ultimo dato tecnico valido
	 * 
	 * @return
	 */
	public DatiTecnici getDatiTecniciCorrenti() {
		DatiTecnici result = null;
		int iSize = this.datiTecniciList.size();

		if (iSize != 0) {
			result = (DatiTecnici) this.datiTecniciList.get(iSize - 1);
		}

		return result;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @uml.property name="datiTecniciList"
	 */
	public List getDatiTecniciList() {
		return datiTecniciList;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param dataRiferimento
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public DatiTecnici getDatiTecniciPrecedenti(Date dataRiferimento) {
		List reversedList = new ArrayList(datiTecniciList);
		Collections.reverse(reversedList);

		for (Iterator iter = reversedList.iterator(); iter.hasNext();) {
			DatiTecnici datiTecnici = (DatiTecnici) iter.next();

			Date dataCorrente = datiTecnici.getEventoInizio().getData();

			boolean before = dataCorrente.before(dataRiferimento);

			if (before) {
				return datiTecnici;
			}
		}

		return null;
	}
	
	public DatiTecnici getDatiTecniciPrecedenti(Date dataRiferimento,
			String codiceEvento) {
		List reversedList = new ArrayList(datiTecniciList);
		Collections.reverse(reversedList);
		
		for (Iterator iter = reversedList.iterator(); iter.hasNext();) {
			DatiTecnici datiTecnici = (DatiTecnici) iter.next();
			
			Evento evento = datiTecnici.getEventoInizio();
			Date dataCorrente = evento.getData();
			
			boolean before = dataCorrente.before(dataRiferimento);
			
			if (before) {
				if (codiceEvento == null)
					return datiTecnici;
				else if (codiceEvento.equals(evento.getTipoEvento().getCodice()))
					return datiTecnici;
			}
		}
		
		return null;
	}
	
	public DatiTecnici getEventoGasPrecedente(Date data) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date dataRiferimento = cal.getTime();
		
		DatiTecnici installazione = getDatiTecniciPrecedenti(dataRiferimento,
				TipoEvento.getCodiceImpiantoAGas());
		DatiTecnici disinstallazione = getDatiTecniciPrecedenti(
				dataRiferimento, TipoEvento
						.getCodiceDisinstallazioneImpiantoAGas());
		if (installazione != null && disinstallazione != null) {
			if(installazione.getEventoInizio().getData().before(disinstallazione.getEventoInizio().getData()))
				return disinstallazione;
			else
				return installazione;
		} else if (installazione != null)
			return installazione;
		 else if (disinstallazione != null)
				return disinstallazione;
		
		return null;
	}
	
	public DatiTecnici getEventoGasSuccessivo(Date data) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		Date dataRiferimento = cal.getTime();
		
		DatiTecnici installazione = getDatiTecniciSuccessivi(dataRiferimento,
				TipoEvento.getCodiceImpiantoAGas());
		DatiTecnici disinstallazione = getDatiTecniciSuccessivi(
				dataRiferimento, TipoEvento
						.getCodiceDisinstallazioneImpiantoAGas());
		if (installazione != null && disinstallazione != null) {
			if(installazione.getEventoInizio().getData().before(disinstallazione.getEventoInizio().getData()))
				return installazione;
			else
				return disinstallazione;
		} else if (installazione != null)
			return installazione;
		else if (disinstallazione != null)
			return disinstallazione;
		
		return null;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param dataRiferimento
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public DatiTecnici getDatiTecniciSuccessivi(Date dataRiferimento) {
		return getDatiTecniciSuccessivi(dataRiferimento, null);
	}
	
	public DatiTecnici getDatiTecniciSuccessivi(Date dataRiferimento,
			String codiceEvento) {
		DatiTecnici result = null;

		for (Iterator iter = datiTecniciList.iterator(); iter.hasNext();) {
			DatiTecnici datiTecnici = (DatiTecnici) iter.next();

			Evento evento = datiTecnici.getEventoInizio();
			Date dataCorrente = evento.getData();

			boolean after = dataCorrente.equals(dataRiferimento)
					|| dataCorrente.after(dataRiferimento);

			if (after) {
				if (codiceEvento == null)
					return datiTecnici;
				else if (codiceEvento.equals(evento.getTipoEvento().getCodice()))
					return datiTecnici;
			}
		}

		return result;

	}
	
	public DatiTecnici getDatiTecniciByDataInizio(Date dataRiferimento) {
		if (dataRiferimento != null) {
			for (Iterator iter = datiTecniciList.iterator(); iter.hasNext();) {
				DatiTecnici datiTecnici = (DatiTecnici) iter.next();
				Date dataInizio = datiTecnici.getEventoInizio().getData();
				if (dataRiferimento.equals(dataInizio))
					return datiTecnici;
			}
		}

		return null;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param dataRiferimento
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public DatiTecnici getDatiTecniciAllaData(Date dataRiferimento) {
		DatiTecnici result = null;

		for (Iterator iter = datiTecniciList.iterator(); iter.hasNext();) {
			boolean compresa = false;

			DatiTecnici datiTecnici = (DatiTecnici) iter.next();

			Evento eventoFine = datiTecnici.getEventoFine();

			Date dataInizio = datiTecnici.getEventoInizio().getData();

			if (eventoFine != null) {
				Date dataFine = datiTecnici.getEventoFine().getData();
				/*
				getLogger().debug(
						"StoricoDatiTecnici - getDatiTecniciAllaData dataInizio: " + dataInizio);
				getLogger().debug(
						"StoricoDatiTecnici - getDatiTecniciAllaData dataFine: " + dataFine);
				getLogger().debug(
						"StoricoDatiTecnici - getDatiTecniciAllaData dataRiferimento: " + dataRiferimento);
				*/
				
				compresa = (dataRiferimento.after(dataInizio) || dataRiferimento
						.equals(dataInizio))
						&& dataRiferimento.before(dataFine);
			} else {
				compresa = (dataRiferimento.after(dataInizio) || dataRiferimento
						.equals(dataInizio));
			}

			if (compresa) {
				return datiTecnici;
			}
		}

		return result;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public Date getDataImmatricolazione() {
		Date result = null;

		for (Iterator iter = datiTecniciList.iterator(); iter.hasNext();) {
			DatiTecnici datiTecnici = (DatiTecnici) iter.next();

			Evento eventoInizio = datiTecnici.getEventoInizio();

			if (eventoInizio.getTipoEvento().isImmatricolazione()) {
				result = eventoInizio.getData();
			}
		}

		return result;
	}

	public Date getDataRadiazione() {
		Date result = null;
		
		for (Iterator iter = datiTecniciList.iterator(); iter.hasNext();) {
			DatiTecnici datiTecnici = (DatiTecnici) iter.next();
			
			Evento eventoInizio = datiTecnici.getEventoInizio();
			
			if (eventoInizio.getTipoEvento().isRadiazione()) {
				result = eventoInizio.getData();
			}
		}
		
		return result;
	}
	
	/**
	 * Data di creazione del veicolo.<br/> E' la data di immatricolazione
	 * oppure la data di importazione.
	 * 
	 * @return DOCUMENT ME!
	 */
	public Date getDataInizioStoriaVeicolo() {
		Date result = null;

		for (Iterator iter = datiTecniciList.iterator(); iter.hasNext();) {
			DatiTecnici datiTecnici = (DatiTecnici) iter.next();

			Evento eventoInizio = datiTecnici.getEventoInizio();

			if (eventoInizio != null
					&& (eventoInizio.getTipoEvento().isImmatricolazione() || eventoInizio
							.getTipoEvento().isImportazione())) {
				result = eventoInizio.getData();
			}
		}

		return result;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	protected DatiTecnici getDatiTecniciUltimaReimmatricolazione() {
		List reversedList = new ArrayList(datiTecniciList);

		DatiTecnici result = null;

		for (Iterator iter = reversedList.iterator(); iter.hasNext();) {
			DatiTecnici datiTecnici = (DatiTecnici) iter.next();

			Evento eventoInizio = datiTecnici.getEventoInizio();

			if (eventoInizio != null) {
				if (eventoInizio.getTipoEvento().isReimmatricolazione()) {
					result = datiTecnici;
				}
			}
		}

		return result;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public Date getDataUltimaReimmatricolazione() {
		Date result = null;

		DatiTecnici datiTecniciUltimaImmatricolazione = getDatiTecniciUltimaReimmatricolazione();

		if (datiTecniciUltimaImmatricolazione != null) {
			result = datiTecniciUltimaImmatricolazione.getEventoInizio()
					.getData();
		}

		return result;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public String getTargaSostituita() {
		String result = null;

		DatiTecnici datiTecniciUltimaReimmatricolazione = getDatiTecniciUltimaReimmatricolazione();

		if (datiTecniciUltimaReimmatricolazione != null) {
			DatiTecnici datiTecniciPrecedenti = getDatiTecniciPrecedenti(datiTecniciUltimaReimmatricolazione
					.getEventoInizio().getData());

			if (datiTecniciPrecedenti != null) {
				result = datiTecniciPrecedenti.getTarga();
			}
		}

		return result;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return La lista delle targhe che il veicolo ha sostituito. Non comprende
	 *         la targa attuale.
	 */
	public List getListTargheSostituite() {
		List result = null;

		Map targhe = new HashMap();

		for (Iterator iter = datiTecniciList.iterator(); iter.hasNext();) {
			DatiTecnici datiTecnici = (DatiTecnici) iter.next();
			targhe.put(datiTecnici.getTarga(), null);
		}

		targhe.remove(getDatiTecniciCorrenti().getTarga());

		result = new ArrayList(targhe.keySet());

		return result;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return La lista delle targhe che il veicolo ha avuto.
	 */
	public List getListTarghe() {
		List result = null;

		Map targhe = new HashMap();

		for (Iterator iter = datiTecniciList.iterator(); iter.hasNext();) {
			DatiTecnici datiTecnici = (DatiTecnici) iter.next();
			targhe.put(datiTecnici.getTarga(), null);
		}

		result = new ArrayList(targhe.keySet());

		return result;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param dataRiferimento
	 * 
	 * @return La data d'installazione dell'impianto a gas relativa alla data di
	 *         riferimento, null se il veicolo non ha l'impianto a gas.
	 */
	public Date getDataInstallazioneImpiantoGasAllaData(Date dataRiferimento) {
		Date result = null;
		if (isInstallatoImpiantoGasAllaData(dataRiferimento)) {
			for (Iterator iterI = datiTecniciList.iterator(); iterI.hasNext();) {
				Evento installazione = ((DatiTecnici) iterI.next())
						.getEventoInizio();
				Date dataInstallazione = installazione.getData();
				if (installazione.getTipoEvento().isImpiantoAGas()
						&& !dataRiferimento.before(dataInstallazione)) {
					result = dataInstallazione;
				}
			}
		}

		return result;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param dataRiferimento
	 * 
	 * @return La data di disinstallazione dell'impianto a gas relativa alla
	 *         data di riferimento, null se il veicolo non ha l'impianto a gas.
	 */
	public Date getDataDisinstallazioneImpiantoGasAllaData(Date dataRiferimento) {
		Date result = null;
		if (!isInstallatoImpiantoGasAllaData(dataRiferimento)) {
			for (Iterator iterI = datiTecniciList.iterator(); iterI.hasNext();) {
				Evento disinstallazione = ((DatiTecnici) iterI.next())
						.getEventoInizio();
				Date dataDisinstallazione = disinstallazione.getData();
				if (disinstallazione.getTipoEvento()
						.isDisinstallazioneImpiantoAGas()
						&& !dataDisinstallazione.after(dataRiferimento)) {
					result = dataDisinstallazione;
				}
			}
		}

		return result;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return true se il veicolo ha l'impianto a gas in data odierna,
	 *         altrimenti false.
	 */
	public boolean isInstallatoImpiantoGas() {
		return isInstallatoImpiantoGasAllaData(DateUtil.getDataOdierna());
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param dataRiferimento
	 * 
	 * @return true se il veicolo ha l'impianto a gas alla data di riferimento,
	 *         altrimenti false.
	 */
	public boolean isInstallatoImpiantoGasAllaData(Date dataRiferimento) {
		boolean result = false;

		for (Iterator iterI = datiTecniciList.iterator(); iterI.hasNext();) {
			Evento installazione = ((DatiTecnici) iterI.next())
					.getEventoInizio();
			Date dataInstallazione = installazione.getData();
			if (installazione.getTipoEvento().isImpiantoAGas()
					&& !dataRiferimento.before(dataInstallazione)) {
				result = true;
				DatiTecnici disinstallazione = getDatiTecniciSuccessivi(dataInstallazione,
						TipoEvento.getCodiceDisinstallazioneImpiantoAGas());
				if (disinstallazione != null){
					Date dataDisinstallazione = disinstallazione.getEventoInizio().getData();
//					if (!dataDisinstallazione.after(dataRiferimento))
					if (dataDisinstallazione.before(dataRiferimento))
						result = false;
				}
			}
		}
		
		return result;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param dataRiferimento
	 * 
	 * @return true se la data di riferimento � compresa tra
	 *         un'installazione(compresa) e una disinstallazione(compresa),
	 *         altrimenti false (anche se manca la disinstallazione).
	 */
	public boolean isInPeriodoChiusoImpiantoGas(Date dataRiferimento) {
		boolean result = false;

		if (isInstallatoImpiantoGasAllaData(dataRiferimento)) {
			Date dataInstallazione = getDataInstallazioneImpiantoGasAllaData(dataRiferimento);
			DatiTecnici succ = getDatiTecniciSuccessivi(dataInstallazione,
					TipoEvento.getCodiceDisinstallazioneImpiantoAGas());
			if (succ != null
					&& !succ.getEventoInizio().getData().before(dataRiferimento)) {
					result = true;
			}
		}

		return result;
	}
	
	public boolean isPossibileInstallazioneGas(Date dataRiferimento) {
		return !isInPeriodoChiusoImpiantoGas(dataRiferimento)
				&& !isInstallatoImpiantoGasAllaData(dataRiferimento)
				&& (getDatiTecniciSuccessivi(dataRiferimento, TipoEvento
						.getCodiceImpiantoAGas()) == null);
	}
	
	public boolean isPossibileDisinstallazioneGas(Date dataRiferimento) {
		DatiTecnici eventoGasPrecedente = getEventoGasPrecedente(dataRiferimento);
		DatiTecnici eventoGasSuccessivo = getEventoGasSuccessivo(dataRiferimento);
		// Se c'� una disinstallazione precedente o successiva o se non c'e' nessuna installazione precedente,
		// non e' possibile inserire una disinstallazione
		if ((eventoGasPrecedente != null && eventoGasPrecedente.getEventoInizio().getTipoEvento().isDisinstallazioneImpiantoAGas()) ||
			(eventoGasSuccessivo != null && eventoGasSuccessivo.getEventoInizio().getTipoEvento().isDisinstallazioneImpiantoAGas()) ||
			(eventoGasPrecedente == null) )
			return false;
		return true;
		
		
		
//		if (isInstallatoImpiantoGasAllaData(dataRiferimento)) {
//			Date dataInstallazione = getDataInstallazioneImpiantoGasAllaData(dataRiferimento);
//			DatiTecnici disinstSucc = getDatiTecniciSuccessivi(dataInstallazione,
//					TipoEvento.getCodiceDisinstallazioneImpiantoAGas());
//			if (disinstSucc != null) {
//				DatiTecnici instSucc = getDatiTecniciPrecedenti(disinstSucc.getEventoInizio().getData(),
//						TipoEvento.getCodiceImpiantoAGas());
//				Date dataDisinstallazioneSucc = disinstSucc.getEventoInizio().getData();
//				if (!dataDisinstallazioneSucc.before(dataRiferimento)
//						&& (instSucc == null || dataDisinstallazioneSucc.after(instSucc
//						.getEventoInizio().getData())) ) {
//							result = true;
//				}
//			}
//		}
//		
//		return !result
//				&& isInstallatoImpiantoGasAllaData(dataRiferimento);
	}
	
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

		if ((object != null) && object instanceof StoricoDatiTecnici) {
			StoricoDatiTecnici altro = (StoricoDatiTecnici) object;
			equals = EqualsUtil.objectEquals(datiTecniciList,
					altro.datiTecniciList);
		}

		return equals;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	/*
	protected Logger getLogger() {
		return LogProvider.getLogger(this.getClass());
	}
	*/
	
	private void verificaCoerenzaStorico(List tmp) {
		if (tmp == null)
			throw new IllegalArgumentException(
					"La lista di dati tecnici � nulla");
		if (tmp.size() < 1)
			throw new IllegalArgumentException(
					"La lista di dati tecnici � vuota");

		Iterator iterator = tmp.iterator();

		// Controlla primo DT
		DatiTecnici primoDatoTecnico = (DatiTecnici) iterator.next();
		if (primoDatoTecnico == null)
			throw new IllegalArgumentException("Il primo dato tecnico � nullo");

		Evento primoEventoInizio = primoDatoTecnico.getEventoInizio();
		if (primoEventoInizio == null)
			throw new IllegalArgumentException("Il primo evento inizio � nullo");

		TipoEvento primoTipoEventoInizio = primoEventoInizio.getTipoEvento();
		if (primoTipoEventoInizio == null)
			throw new IllegalArgumentException(
					"Il tipo evento del primo evento inizio � nullo");

		if (!primoTipoEventoInizio.isImmatricolazione()
				&& !primoTipoEventoInizio.isImportazione())
			throw new IllegalArgumentException(
					"Il primo dato tecnico deve essere un'immatricolazione o un'importazione");

		// Controlla DT successivi al primo
		for (; iterator.hasNext();) {
			DatiTecnici datiTecnici = (DatiTecnici) iterator.next();
			if (datiTecnici == null)
				throw new IllegalArgumentException("Un dato tecnico � nullo");

			Evento eventoInizio = datiTecnici.getEventoInizio();
			if (eventoInizio == null)
				throw new IllegalArgumentException("Un evento inizio � nullo");

			TipoEvento tipoEventoInizio = eventoInizio.getTipoEvento();
			if (tipoEventoInizio == null)
				throw new IllegalArgumentException("Un tipo evento � nullo");

			if (tipoEventoInizio.isImmatricolazione()
					|| tipoEventoInizio.isImportazione())
				throw new IllegalArgumentException(
						"Non possono esistere pi� di un evento di immatricolazione o importazione");
		}
	}

	/* PER TESTARE 
	public static void main(String[] args) throws Exception {
		List listaDatiTecnici = new ArrayList(0);
		String AGGIORN = TipoEvento.getCodiceAggiornamentoDatiTecnici();
		String INSTALLA = TipoEvento.getCodiceImpiantoAGas();
		String DISINSTALLA = TipoEvento.getCodiceDisinstallazioneImpiantoAGas();

		listaDatiTecnici.add(creaDatoTecnico("11/11/1996", "01/01/1997", TipoEvento
				.getCodiceImmatricolazione()));
		listaDatiTecnici.add(creaDatoTecnico("01/01/1997", "01/01/1998", AGGIORN));
		listaDatiTecnici.add(creaDatoTecnico("01/01/1998", "02/02/2000", INSTALLA));
		// listaDatiTecnici.add(getDatoTecnico("01/01/1999", DISINSTALLA));
		listaDatiTecnici.add(creaDatoTecnico("02/02/2000", "01/01/2002", AGGIORN));
		// listaDatiTecnici.add(getDatoTecnico("01/01/2001", INSTALLA));
		listaDatiTecnici.add(creaDatoTecnico("01/01/2002", "01/01/2003", AGGIORN));
		listaDatiTecnici.add(creaDatoTecnico("01/01/2003", "04/04/2004", DISINSTALLA));
//		listaDatiTecnici.add(creaDatoTecnico("01/01/2004", INSTALLA));
		listaDatiTecnici.add(creaDatoTecnico("04/04/2004", "01/01/2006", AGGIORN));
		listaDatiTecnici.add(creaDatoTecnico("01/01/2006", "01/01/2007", AGGIORN));
		listaDatiTecnici.add(creaDatoTecnico("05/02/2008", "14/02/2008", INSTALLA));
		listaDatiTecnici.add(creaDatoTecnico("14/02/2008", null, DISINSTALLA));
		System.out.println("STORICO DATI TECNICI: ");
		for (Iterator iter = listaDatiTecnici.iterator(); iter.hasNext();) {
			DatiTecnici dt = (DatiTecnici) iter.next();
			String cod = dt.getEventoInizio().getTipoEvento().getCodice();
			String descr = "";
			if (TipoEvento.getCodiceImmatricolazione().equals(cod))
				descr = "IMMATR.";
			else if (AGGIORN.equals(cod))
				descr = "AGGIORN.";
			else if (TipoEvento.getCodiceImpiantoAGas().equals(cod))
				descr = "INSTALLAZIONE";
			else if (TipoEvento.getCodiceDisinstallazioneImpiantoAGas().equals(
					cod))
				descr = "DISINSTALLAZIONE";

			System.out.println(DateUtil.format(dt.getEventoInizio().getData())
					+ " - " + descr);

		}

		StoricoDatiTecnici stor = new StoricoDatiTecnici(listaDatiTecnici);
//		stor.isInstallatoImpiantoGasAllaData(DateUtil
//				.decodeFromTextInput("02/02/2000"));
//		stor.isInstallatoImpiantoGasAllaData(DateUtil
//				.decodeFromTextInput("02/02/2001"));
//		stor.isInstallatoImpiantoGasAllaData(DateUtil
//				.decodeFromTextInput("02/02/2002"));
//		stor.isInstallatoImpiantoGasAllaData(DateUtil
//				.decodeFromTextInput("31/12/2002"));
//		stor.isInstallatoImpiantoGasAllaData(DateUtil
//				.decodeFromTextInput("01/01/2003"));
//		stor.isInstallatoImpiantoGasAllaData(DateUtil
//				.decodeFromTextInput("01/01/2005"));
//		stor.isInstallatoImpiantoGasAllaData(DateUtil
//				.decodeFromTextInput("31/12/2006"));
//		stor.isInstallatoImpiantoGas();
//		System.out.println("Data installazione al "
//				+ dataRiferimento
//				+ ": "
//				+ DateUtil.format(stor
//						.getDataInstallazioneImpiantoGasAllaData(DateUtil
//								.decodeFromTextInput(dataRiferimento))));
//		System.out.println("Data disinstallazione al "
//				+ dataRiferimento
//				+ ": "
//				+ DateUtil.format(stor
//						.getDataDisinstallazioneImpiantoGasAllaData(DateUtil
//								.decodeFromTextInput(dataRiferimento))));
//		for (int i = 1995; i < 2008; i++) {
//			String dataRiferimentoStr = "01/01/" + i;
//			Date data = DateUtil.decodeFromTextInput(dataRiferimentoStr);
//			System.out.println("data " + dataRiferimentoStr
//					+ " � in periodo installazione? "
//					+ stor.isInPeriodoChiusoImpiantoGas(data)
//					+ ", possibilit� installazione: "
//					+ stor.isPossibileInstallazioneGas(data)
//					+ ", disintallazione: "
//					+ stor.isPossibileDisinstallazioneGas(data));
//		}
		
//		for (Iterator iter = stor.getDatiTecniciList().iterator(); iter.hasNext();) {
//			DatiTecnici dt = (DatiTecnici) iter.next();
//			System.out.println(DateUtil.format(dt.getEventoInizio().getData()) + ": " + dt.getIsImpiantoAGas());
//		}
		
		//System.out.println(stor.isInstallatoImpiantoGasAllaData(DateUtil.decodeFromTextInput("14/02/2008")));
		//System.out.println(stor.getDataInstallazioneImpiantoGasAllaData(DateUtil.decodeFromTextInput("14/02/2008")));
		
//		System.out.println("stor.isInstallatoImpiantoGas(): " + stor.isInstallatoImpiantoGas());
//		System.out.println("stor.isInstallatoImpiantoGasAlladata(): " + stor.isInstallatoImpiantoGasAllaData(DateUtil
//				.decodeFromTextInput("04/02/2008")));
	}
	*/
	/*
	private static DatiTecnici creaDatoTecnico(String dataInizio, String dataFine,
			String codiceEvento) throws ParseException {
		Evento evInizio = new Evento(new TipoEvento(new IdTipoEvento(new Long(
				codiceEvento).longValue()), codiceEvento, ""), DateUtil
				.decodeFromTextInput(dataInizio));
		Evento evFine;
		if (dataFine == null)
			evFine = null;
		else
			evFine = new Evento(null, DateUtil
				.decodeFromTextInput(dataFine));
		
		DatiTecnici dt = DatiTecniciFactory.getInstance().buildWithAll(null,
				null, evInizio, evFine, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null);
		return dt;
	}
	*/

}