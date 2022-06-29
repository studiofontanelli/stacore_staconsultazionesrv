/*
 * Created on 26-mag-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package it.csi.stacore.staconsultazionesrv.util;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

/**
 * DOCUMENT ME!
 *
 * @author curtoni TODO To change the template for this generated type comment
 *         go to Window - Preferences - Java - Code Style - Code Templates
 */
public class UnitConversionUtil {
	//~ Methods ==================================================================

	/**
	 * Converte una stringa contenente un peso in un numero decimale che esprime
	 * il peso in kg.
	 *
	 * @param weightString Stringa contenente un peso
	 *
	 * @return Peso in kilogrammi
	 */
	public static BigDecimal parseWeight(String weightString) {
		BigDecimal result = null;

		if (weightString != null) {
			if (StringUtils.isNumeric(weightString)) {
				result = new BigDecimal(weightString);
			} else {
				// FIXME 26-mag-2005 AC - Tentare una conversione
			}
		}

		return result;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param weightInKg DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static BigDecimal convertKgIntoQuintali(BigDecimal weightInKg) {
		BigDecimal weightInQuintali = null;

		if (weightInKg != null) {
			weightInQuintali = weightInKg.divide(new BigDecimal(100), 2, 2);
		}

		return weightInQuintali;
	}

	/**
	 * DOCUMENT ME!
	 *
	 * @param weightInKg DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static BigDecimal convertKgIntoTonnellate(BigDecimal weightInKg) {
		BigDecimal weightInTonnellate = null;

		if (weightInKg != null) {
			weightInTonnellate = weightInKg.divide(new BigDecimal(1000), 2, 2);
		}

		return weightInTonnellate;
	}
}
