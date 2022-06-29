package it.csi.stacore.staconsultazionesrv.api.dto;

import java.util.Objects;
import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import it.csi.stacore.staconsultazionesrv.api.dto.Abilitazione;
import it.csi.stacore.staconsultazionesrv.api.dto.Cassa;
import it.csi.stacore.staconsultazionesrv.api.dto.Ente;
import it.csi.stacore.staconsultazionesrv.api.dto.Evento;
import it.csi.stacore.staconsultazionesrv.api.dto.Fonte;
import it.csi.stacore.staconsultazionesrv.api.dto.Profilo;
import it.csi.stacore.staconsultazionesrv.api.dto.Proprietario;
import it.csi.stacore.staconsultazionesrv.api.dto.Sportello;
import it.csi.stacore.staconsultazionesrv.api.dto.TipoUtente;
import it.csi.stacore.staconsultazionesrv.api.dto.Veicolo;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@ApiModel(description="Posizione")

public class Posizione  implements Serializable {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [implicit-camel-case] 
  private static final long serialVersionUID = 1L;
  
  private Long id = null;
  private Long idOperazioneLogica = null;
  private Long idVeicolo = null;
  private Long idTipoSoggettoPassivo = null;
  private Proprietario proprietario = null;
  private Veicolo veicolo = null;
  private Fonte fonte = null;
  private Evento eventoInizio = null;
  private Evento eventoFine = null;
  private String codiceFiscale = null;
  private TipoUtente tipoUtente = null;
  private Ente ente = null;
  private Profilo profilo = null;
  private Abilitazione abilitazione = null;
  private List<Cassa> elencoCassa = new ArrayList<>();
  private List<Sportello> elencoSportello = new ArrayList<>();

  /**
   **/
  
  @ApiModelProperty(example = "id Posizione", value = "")

  // nome originario nello yaml: id 
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  /**
   **/
  
  @ApiModelProperty(example = "id Operazione Logica", value = "")

  // nome originario nello yaml: idOperazioneLogica 
  public Long getIdOperazioneLogica() {
    return idOperazioneLogica;
  }
  public void setIdOperazioneLogica(Long idOperazioneLogica) {
    this.idOperazioneLogica = idOperazioneLogica;
  }

  /**
   **/
  
  @ApiModelProperty(example = "id veicolo", value = "")

  // nome originario nello yaml: idVeicolo 
  public Long getIdVeicolo() {
    return idVeicolo;
  }
  public void setIdVeicolo(Long idVeicolo) {
    this.idVeicolo = idVeicolo;
  }

  /**
   **/
  
  @ApiModelProperty(example = "id tipo soggetto passivo", value = "")

  // nome originario nello yaml: idTipoSoggettoPassivo 
  public Long getIdTipoSoggettoPassivo() {
    return idTipoSoggettoPassivo;
  }
  public void setIdTipoSoggettoPassivo(Long idTipoSoggettoPassivo) {
    this.idTipoSoggettoPassivo = idTipoSoggettoPassivo;
  }

  /**
   * Proprietario
   **/
  
  @ApiModelProperty(value = "Proprietario")

  // nome originario nello yaml: proprietario 
  public Proprietario getProprietario() {
    return proprietario;
  }
  public void setProprietario(Proprietario proprietario) {
    this.proprietario = proprietario;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")

  // nome originario nello yaml: veicolo 
  public Veicolo getVeicolo() {
    return veicolo;
  }
  public void setVeicolo(Veicolo veicolo) {
    this.veicolo = veicolo;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")

  // nome originario nello yaml: fonte 
  public Fonte getFonte() {
    return fonte;
  }
  public void setFonte(Fonte fonte) {
    this.fonte = fonte;
  }

  /**
   * Evento inizio
   **/
  
  @ApiModelProperty(value = "Evento inizio")

  // nome originario nello yaml: eventoInizio 
  public Evento getEventoInizio() {
    return eventoInizio;
  }
  public void setEventoInizio(Evento eventoInizio) {
    this.eventoInizio = eventoInizio;
  }

  /**
   * Evento fine
   **/
  
  @ApiModelProperty(value = "Evento fine")

  // nome originario nello yaml: eventoFine 
  public Evento getEventoFine() {
    return eventoFine;
  }
  public void setEventoFine(Evento eventoFine) {
    this.eventoFine = eventoFine;
  }

  /**
   * codice fiscale
   **/
  
  @ApiModelProperty(value = "codice fiscale")

  // nome originario nello yaml: codiceFiscale 
  public String getCodiceFiscale() {
    return codiceFiscale;
  }
  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")

  // nome originario nello yaml: tipoUtente 
  public TipoUtente getTipoUtente() {
    return tipoUtente;
  }
  public void setTipoUtente(TipoUtente tipoUtente) {
    this.tipoUtente = tipoUtente;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")

  // nome originario nello yaml: ente 
  public Ente getEnte() {
    return ente;
  }
  public void setEnte(Ente ente) {
    this.ente = ente;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")

  // nome originario nello yaml: profilo 
  public Profilo getProfilo() {
    return profilo;
  }
  public void setProfilo(Profilo profilo) {
    this.profilo = profilo;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")

  // nome originario nello yaml: abilitazione 
  public Abilitazione getAbilitazione() {
    return abilitazione;
  }
  public void setAbilitazione(Abilitazione abilitazione) {
    this.abilitazione = abilitazione;
  }

  /**
   * Elenco casse
   **/
  
  @ApiModelProperty(value = "Elenco casse")

  // nome originario nello yaml: elencoCassa 
  public List<Cassa> getElencoCassa() {
    return elencoCassa;
  }
  public void setElencoCassa(List<Cassa> elencoCassa) {
    this.elencoCassa = elencoCassa;
  }

  /**
   * Elenco sportelli
   **/
  
  @ApiModelProperty(value = "Elenco sportelli")

  // nome originario nello yaml: elencoSportello 
  public List<Sportello> getElencoSportello() {
    return elencoSportello;
  }
  public void setElencoSportello(List<Sportello> elencoSportello) {
    this.elencoSportello = elencoSportello;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Posizione posizione = (Posizione) o;
    return Objects.equals(id, posizione.id) &&
        Objects.equals(idOperazioneLogica, posizione.idOperazioneLogica) &&
        Objects.equals(idVeicolo, posizione.idVeicolo) &&
        Objects.equals(idTipoSoggettoPassivo, posizione.idTipoSoggettoPassivo) &&
        Objects.equals(proprietario, posizione.proprietario) &&
        Objects.equals(veicolo, posizione.veicolo) &&
        Objects.equals(fonte, posizione.fonte) &&
        Objects.equals(eventoInizio, posizione.eventoInizio) &&
        Objects.equals(eventoFine, posizione.eventoFine) &&
        Objects.equals(codiceFiscale, posizione.codiceFiscale) &&
        Objects.equals(tipoUtente, posizione.tipoUtente) &&
        Objects.equals(ente, posizione.ente) &&
        Objects.equals(profilo, posizione.profilo) &&
        Objects.equals(abilitazione, posizione.abilitazione) &&
        Objects.equals(elencoCassa, posizione.elencoCassa) &&
        Objects.equals(elencoSportello, posizione.elencoSportello);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, idOperazioneLogica, idVeicolo, idTipoSoggettoPassivo, proprietario, veicolo, fonte, eventoInizio, eventoFine, codiceFiscale, tipoUtente, ente, profilo, abilitazione, elencoCassa, elencoSportello);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Posizione {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idOperazioneLogica: ").append(toIndentedString(idOperazioneLogica)).append("\n");
    sb.append("    idVeicolo: ").append(toIndentedString(idVeicolo)).append("\n");
    sb.append("    idTipoSoggettoPassivo: ").append(toIndentedString(idTipoSoggettoPassivo)).append("\n");
    sb.append("    proprietario: ").append(toIndentedString(proprietario)).append("\n");
    sb.append("    veicolo: ").append(toIndentedString(veicolo)).append("\n");
    sb.append("    fonte: ").append(toIndentedString(fonte)).append("\n");
    sb.append("    eventoInizio: ").append(toIndentedString(eventoInizio)).append("\n");
    sb.append("    eventoFine: ").append(toIndentedString(eventoFine)).append("\n");
    sb.append("    codiceFiscale: ").append(toIndentedString(codiceFiscale)).append("\n");
    sb.append("    tipoUtente: ").append(toIndentedString(tipoUtente)).append("\n");
    sb.append("    ente: ").append(toIndentedString(ente)).append("\n");
    sb.append("    profilo: ").append(toIndentedString(profilo)).append("\n");
    sb.append("    abilitazione: ").append(toIndentedString(abilitazione)).append("\n");
    sb.append("    elencoCassa: ").append(toIndentedString(elencoCassa)).append("\n");
    sb.append("    elencoSportello: ").append(toIndentedString(elencoSportello)).append("\n");
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

