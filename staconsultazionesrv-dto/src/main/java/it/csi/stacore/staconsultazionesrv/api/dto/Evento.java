package it.csi.stacore.staconsultazionesrv.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import it.csi.stacore.staconsultazionesrv.api.dto.TipoEvento;
import java.util.Date;
import java.io.Serializable;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@ApiModel(description="Evento")

public class Evento  implements Serializable {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [implicit-camel-case] 
  private static final long serialVersionUID = 1L;
  
  private Date dataEvento = null;
  private TipoEvento tipoEvento = null;

  /**
   * data evento
   **/
  
  @ApiModelProperty(value = "data evento")

  // nome originario nello yaml: dataEvento 
  public Date getDataEvento() {
    return dataEvento;
  }
  public void setDataEvento(Date dataEvento) {
    this.dataEvento = dataEvento;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")

  // nome originario nello yaml: tipoEvento 
  public TipoEvento getTipoEvento() {
    return tipoEvento;
  }
  public void setTipoEvento(TipoEvento tipoEvento) {
    this.tipoEvento = tipoEvento;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Evento evento = (Evento) o;
    return Objects.equals(dataEvento, evento.dataEvento) &&
        Objects.equals(tipoEvento, evento.tipoEvento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataEvento, tipoEvento);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Evento {\n");
    
    sb.append("    dataEvento: ").append(toIndentedString(dataEvento)).append("\n");
    sb.append("    tipoEvento: ").append(toIndentedString(tipoEvento)).append("\n");
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

