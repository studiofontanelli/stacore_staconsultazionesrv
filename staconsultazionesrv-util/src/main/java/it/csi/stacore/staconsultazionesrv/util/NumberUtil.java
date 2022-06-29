package it.csi.stacore.staconsultazionesrv.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.lang3.math.NumberUtils;


public class NumberUtil {
	//~ Static fields/initializers ===============================================

	private static NumberFormat nf = NumberFormat.getInstance();

	//    static private String NUMBER_EXPRESSION = "[0-9]*([\\.,]?[0-9]+)";

	/*
	 * Espressione aggiornata per matchare solo le prime due cifre dopo la virgola
	 *
	 * Esempi:
	 * - validi: "0" ; "2" ; "1,0" ; "1.20" ; "0123" ;
	 * - non validi: "1," ; "1.200" ; "1.2.3"
	 */
	private static String NUMBER_EXPRESSION = "[-]{0,1}[0-9]+([,.]{1}[0-9]{1,2}){0,1}";

	//~ Methods ==================================================================

	/**
	 * DOCUMENT ME!
	 *
	 * @param textInput DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static BigDecimal decodeBigDecimalFromTextInput(String textInput) {
		//      NumberFormat df=new DecimalFormat(DECIMAL_FORMAT);
		//
		//      df.parse(textInput);
		BigDecimal result = null;

		if ((textInput != null) && isNumber(textInput)) {
			String decimalString = textInput.replace(',', '.');

			result = new BigDecimal(decimalString);
		}

		return result;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param arg DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static boolean isNumber(String arg) {
		return NumberUtils.isNumber(arg);
		
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param bigDecimal DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static String format(BigDecimal bigDecimal) {
//		 TODO [Ivano Canella] Vedere se modificare il nome del metodo in formatEuroCent
		String result = null;

		if (bigDecimal == null) {
			result = "";
		} else {
			// Corretto per supportare il Locale Italiano
			NumberFormat df = NumberFormat.getNumberInstance(Locale.ITALIAN);
			df.setGroupingUsed(false);
			df.setMinimumFractionDigits(2);

			BigDecimal scaledBigDecimal = new BigDecimal(bigDecimal.unscaledValue(), 2);

			result = df.format(scaledBigDecimal);
		}

		return result;
	}
	

	public static String format(BigDecimal bigDecimal, int numeroDecimali, boolean separatoreMigliaia) {
//		 TODO [Ivano Canella] Vedere se modificare il nome del metodo in formatEuroCent
		String result = null;

		if (bigDecimal == null) {
			result = "";
		} else {
			// Corretto per supportare il Locale Italiano
			NumberFormat df = NumberFormat.getNumberInstance(Locale.ITALIAN);
			df.setGroupingUsed(separatoreMigliaia);
			df.setMinimumFractionDigits(numeroDecimali);

			BigDecimal scaledBigDecimal = new BigDecimal(bigDecimal.unscaledValue(), numeroDecimali);

			result = df.format(scaledBigDecimal);
		}

		return result;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	
	
	public static void main(String[] args) {
		BigDecimal i = decodeBigDecimalFromTextInput("12222222544,0");
		
//		System.out.println(i);
		System.out.println(format(i, i.scale(), true));
	}
	
}