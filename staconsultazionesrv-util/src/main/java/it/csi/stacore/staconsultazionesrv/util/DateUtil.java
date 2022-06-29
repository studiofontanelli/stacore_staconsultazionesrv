package it.csi.stacore.staconsultazionesrv.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * DOCUMENT ME!
 *
 * @author curtoni
 */
public class DateUtil {
	//~ Static fields/initializers ===============================================
	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final String DATE_FORMAT_yyyyMMdd = "yyyyMMdd";
	
	public static final String DATE_EXPRESSION = "([0-3]{0,1}[0-9])(?:(?:/([01]{0,1}[0-9])/)|(?:\\\\-([01]{0,1}[0-9])\\\\-))((?:19|20)[0-9]{2})";
	
	public static boolean forceSimpleTimeZone = true; // parametro per  risolvere i problemi con le date di GMS

	private static final String DATE_FORMAT_TIME = "dd/MM/yyyy H:mm";

	private static final String DATE_FORMAT_SECOND = "dd/MM/yyyy H:mm:ss";	
	
	private static final String MONTH_DATE_FORMAT = "MM";

	private static final String YEAR_DATE_FORMAT = "yyyy";
	
	private static final String YEAR_DAY_FORMAT = "dd";
	
	private static final String YEAR_MONTH_FORMAT = "MM";
	
	private static Locale locale = Locale.ITALIAN;
	   // (true fino a quando GMS non passer� a BEA8)
	

	//~ Methods ==================================================================
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param textInput DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 *
	 * @throws ParseException DOCUMENT ME!
	 */
//	public static Date decodeFromTextInput(String textInput) throws ParseException {
//		SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT, locale);
//		df.setLenient(false);
//
//		Date date;
//
//		// verifico che contenga solo numeri
//		Perl5Compiler compiler = new Perl5Compiler();
//		Pattern pattern = null;
//
//		try {
//			pattern = compiler.compile(DATE_EXPRESSION);
//		} catch (MalformedPatternException e) {
//		}
//
//		Perl5Matcher matcher = new Perl5Matcher();
//
//		if (!matcher.matches(textInput, pattern)) {
//			throw new ParseException("La data non � nel formato " + DATE_FORMAT, 0);
//		}
//
//		date = df.parse(textInput);
//
//		return date;
//	}
//	
	
	/*
	public static Date decodeFromTextInput(String textInput) throws ParseException {
		if (textInput == null)
			return null;

		SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT, locale);
		

		
		df.setLenient(false);

		Date date;

		// verifico che contenga solo numeri
		Perl5Compiler compiler = new Perl5Compiler();
		Pattern pattern = null;

		try {
			pattern = compiler.compile(DATE_EXPRESSION);
		} catch (MalformedPatternException e) {
		}

		Perl5Matcher matcher = new Perl5Matcher();

		if (!matcher.matches(textInput, pattern)) {
			throw new ParseException(
					"La data non � nel formato " + DATE_FORMAT, 0);
		}

		date = df.parse(textInput);

		return date;
	}
	*/
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param date DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static String format(Date date) {

		return format(date, DATE_FORMAT);
	}
	
	public static String format_yyyyMMdd(Date date) {
		
		return format(date, DATE_FORMAT_yyyyMMdd);
	}
	
	public static String formatWithTime(Date date) {
		
		return format(date, DATE_FORMAT_TIME);
	}
	
	public static String formatWithTimeSecond(Date date) {
		
		return format(date, DATE_FORMAT_SECOND);
	}
	
	private static String format(Date date, String dateFormat) {
		String formattedDate = null;

		if (date == null) {
			formattedDate = "-";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, locale);
			sdf.setLenient(false);

			formattedDate = sdf.format(date);
		}

		return formattedDate;
	}
	
	public static Integer dateToInteger (Date date) {
		
		if (date == null) {
			return null;
		}else {
			String data = format(date, DATE_FORMAT);
			String[] array = data.split("/");
			if(array != null && array.length == 3) {
				String temp = array[2]+array[1];
				Integer d = new Integer(temp);
				return d;
			}
		}
		
		return null;
		
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param date DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static String formatMonthAsString(Date date) {
		String formattedDate = null;

		if (date == null) {
			formattedDate = "-";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(MONTH_DATE_FORMAT, locale);
			sdf.setLenient(false);

			formattedDate = sdf.format(date);
		}

		return formattedDate;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param date DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static int formatYearAsInt(Date date) {
		String formattedDate = null;
		int year = -1;

		if (date == null) {
			formattedDate = "-";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(YEAR_DATE_FORMAT, locale);
			sdf.setLenient(false);
			formattedDate = sdf.format(date);
		}

		try {
			year = Integer.parseInt(formattedDate);
		} catch (NumberFormatException e) {
		}

		return year;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param date DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static int formatDayAsInt(Date date) {
		String formattedDate = null;
		int day = -1;
		
		if (date == null) {
			formattedDate = "-";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(YEAR_DAY_FORMAT, locale);
			sdf.setLenient(false);
			formattedDate = sdf.format(date);
		}
		
		try {
			day = Integer.parseInt(formattedDate);
		} catch (NumberFormatException e) {
		}
		
		return day;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param date DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static int formatMonthAsInt(Date date) {
		String formattedDate = null;
		int month = -1;
		
		if (date == null) {
			formattedDate = "-";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(YEAR_MONTH_FORMAT, locale);
			sdf.setLenient(false);
			formattedDate = sdf.format(date);
		}
		
		try {
			month = Integer.parseInt(formattedDate);
		} catch (NumberFormatException e) {
		}
		
		return month;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param dataInizioUno DOCUMENT ME!
	 * @param dataFineUno DOCUMENT ME!
	 * @param dataInizioDue DOCUMENT ME!
	 * @param dataFineDue DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static boolean checkSovrapposizione(Date dataInizioUno, Date dataFineUno, Date dataInizioDue, Date dataFineDue) {
		boolean error = false;

		if (dataInizioUno == null) {
			// Un'intervallo non pu� avere dataInizio nulla
			error = true;
		} else if (dataInizioDue == null) {
			// Un'intervallo non pu� avere dataInizio nulla
			error = true;
		} else if ((dataFineUno == null) && (dataFineDue == null)) {
			// Entrambi gli intervalli aperti => si sovrappongono
			error = true;
		} else {
			if (dataFineUno == null) {
				// Primo intervallo aperto
				if (dataFineDue.after(dataInizioUno)) {
					error = true;
				}
			} else if (dataFineDue == null) {
				// Secondo intervallo aperto
				if (dataFineUno.after(dataInizioDue)) {
					error = true;
				}
			} else {
				// Entrambi gli intervalli chiusi
				if (!dataInizioDue.after(dataInizioUno) && !dataFineDue.before(dataInizioUno)) {
					error = true;
				}

				if (!dataInizioUno.after(dataInizioDue) && !dataFineUno.before(dataInizioDue)) {
					error = true;
				}
			}
		}

		return error;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param dataInizioUno DOCUMENT ME!
	 * @param dataFineUno DOCUMENT ME!
	 * @param dataInizioDue DOCUMENT ME!
	 * @param dataFineDue DOCUMENT ME!
	 * 
	 * 2006-11-14 L.S
	 * il metodo � stato modificato perch� nella creazione e maodifiche delle agevolazioni 
	 * quando la data inizio conincide con la data fine non si devonno considerare sovrapposte
	 * 
	 *
	 * @return DOCUMENT ME!
	 */

	public static int calcoloNumeroGiorni(Date dataInizio, Date dataFine) {
		int ONE_HOUR = 60 * 60 * 1000;
		int result = -1;
		long calc = -1;

		Calendar inizio = Calendar.getInstance();
		inizio.setTime(dataInizio);

		Calendar fine = Calendar.getInstance();
		fine.setTime(dataFine);

		inizio.set(Calendar.AM_PM, Calendar.AM);
		inizio.set(Calendar.HOUR, 0);
		inizio.set(Calendar.MINUTE, 0);
		inizio.set(Calendar.SECOND, 0);
		inizio.set(Calendar.MILLISECOND, 0);

		fine.set(Calendar.AM_PM, Calendar.AM);
		fine.set(Calendar.HOUR, 0);
		fine.set(Calendar.MINUTE, 0);
		fine.set(Calendar.SECOND, 0);
		fine.set(Calendar.MILLISECOND, 0);

		calc = fine.getTime().getTime() - inizio.getTime().getTime();
		calc = calc + ONE_HOUR;
		calc = calc / (ONE_HOUR * 24);

		result = (int) calc;

		return result;
	}
	
	/*
	public static boolean isValidTextInput(String textInput) {
		boolean result = false;

		if (!ValidationUtil.isEmpty(textInput)) {
			if (DATE_FORMAT.length() == textInput.length()) {
				try {
					if (decodeFromTextInput(textInput) != null) {
						result = true;
					}
				} catch (ParseException e) {
					// logger.debug("formato non data");
				}
			}
		}

		return result;
	}
	*/
	
	/*
	 *	Metodo per confrontare due date
	 *	Il metodo controlla che tra le due date ci sia almeno un giorno 
	 *	di differenza, usando il secondo metodo calcoloNumeroGiorni 
	 *  Le date vanno formattate in precedenza con DateUtil.format
	 *	
	 *	return value boolean
	 * */
	public static boolean VerificaDataMaggiore(Date dataMaggiore, Date dataMinore) {
		int confronto = calcoloNumeroGiorni(dataMaggiore, dataMinore);
		if (confronto > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param mm_yyyy DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static String getAnnoMeseString(String mm_yyyy) {
		String noSignificantValue = "";

		if (mm_yyyy == null) {
			return noSignificantValue;
		}

		if (mm_yyyy.length() < 6) {
			return noSignificantValue;
		}

		if (mm_yyyy.length() == 7) {
			// restituisce la scadenza in formato yyyymm, dato il formato mm/yyyy
			String meseString = mm_yyyy.toString().substring(0, 2);
			String annoString = mm_yyyy.toString().substring(3, 7);

			return annoString + meseString;
		}

		if (mm_yyyy.length() == 6) {
			// restituisce la scadenza in formato yyyymm, dato il formato mmyyyy
			String meseString = mm_yyyy.toString().substring(0, 2);
			String annoString = mm_yyyy.toString().substring(2, 6);

			return annoString + meseString;
		}

		return noSignificantValue;
	}
	
	/*
	private static Date azzeraOra(Date data){
		try {
			return decodeFromTextInput(format(data));
		} catch (ParseException ignore) {
			return null;
		}
	}
	*/
	
	
	public static Date getDataOdierna(){
		return Calendar.getInstance().getTime() ;
	}
	
	
	public static Date getDataOdiernaConOra() {
		Calendar adesso = new GregorianCalendar(Locale.ITALY);
		return adesso.getTime();
	}
	
	public static Date getCurrentDate() {
		return Calendar.getInstance().getTime() ;
	}
	
	public static Timestamp getCurrentTimeStamp() {
		return new Timestamp(getCurrentDate().getTime()) ;
	}

	public static Date cleanDate(Date date) {
		if (date == null) return null;

		Calendar inizio = Calendar.getInstance();
		inizio.setTime(date);
		inizio.set(Calendar.AM_PM, Calendar.AM);
		inizio.set(Calendar.HOUR, 0);
		inizio.set(Calendar.MINUTE, 0);
		inizio.set(Calendar.SECOND, 0);
		inizio.set(Calendar.MILLISECOND, 0);

		return inizio.getTime();
	}
	
	public static void main(String[] args) throws Exception {
//		Date data1 = decodeFromTextInput("01/01/2013");
//		Date data2 = decodeFromTextInput("31/12/2013");
//		Date data3 = decodeFromTextInput("07/12/2007");
//		Date data4 = decodeFromTextInput("01/01/2013");
//		
//		System.out.println(data1);
//		System.out.println(data2);
//		System.out.println(data3);
//		System.out.println(data4);
//		System.out.println(checkSovrapposizione(data1, data2, data3, data4));
//		System.out.println(checkSovrapposizioneAgevolazione(data1, data2, data3, data4));



//		System.out.println(decodeFromTextInput("2/10/1967"));
//		System.out.println(decodeFromTextInput("02/10/1967"));
//		System.out.println(decodeFromTextInput("02/1/1967"));
//		System.out.println(decodeFromTextInput("2/1/1967"));
//		System.out.println(formatMonthAsString(new Date()));
//		System.out.println(calcoloNumeroGiorni(null, new Date()));
		System.out.println(dateToInteger(getCurrentDate()));
		
		
	}

}