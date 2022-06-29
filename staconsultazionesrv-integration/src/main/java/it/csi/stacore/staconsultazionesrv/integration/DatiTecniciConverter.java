/*
 * Created on 2-gen-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package it.csi.stacore.staconsultazionesrv.integration;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author 70702
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DatiTecniciConverter {
  public static String kiloWattToDb(BigDecimal kiloWatt) {
    String decaWattString=null;
    if (kiloWatt!=null) {
      decaWattString=String.valueOf(kiloWatt.multiply(new BigDecimal(100)).intValue());
    }
    return decaWattString;
  }
  
  public static BigDecimal kiloWattFromDb(String decaWattString) {
    BigDecimal kiloWatt=null;
    if (decaWattString!=null) {
      kiloWatt=new BigDecimal(new BigInteger(decaWattString),2);
    }
    return kiloWatt;
  }
  
  

}
