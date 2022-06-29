package it.csi.stacore.staconsultazionesrv.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@ApiModel(description="Posizione Estesa")

public class PosizioneExt  implements Serializable {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [implicit-camel-case] 
  private static final long serialVersionUID = 1L;
  
  private String dummy = null;

  /**
   * Dummy property
   **/
  
  @ApiModelProperty(value = "Dummy property")

  // nome originario nello yaml: dummy 
  public String getDummy() {
    return dummy;
  }
  public void setDummy(String dummy) {
    this.dummy = dummy;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PosizioneExt posizioneExt = (PosizioneExt) o;
    return Objects.equals(dummy, posizioneExt.dummy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dummy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PosizioneExt {\n");
    
    sb.append("    dummy: ").append(toIndentedString(dummy)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

