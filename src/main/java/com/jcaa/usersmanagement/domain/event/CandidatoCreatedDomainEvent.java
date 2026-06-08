package com.jcaa.usersmanagement.domain.event;

import com.jcaa.usersmanagement.domain.model.CandidatoModel;
import java.util.Map;
import lombok.Getter;

@Getter
public final class CandidatoCreatedDomainEvent extends DomainEvent {

  private static final String EVENT_NAME = "candidato.created";

  private final CandidatoModel candidato;

  public CandidatoCreatedDomainEvent(final CandidatoModel candidato) {
    super(EVENT_NAME);
    this.candidato = candidato;
  }

  @Override
  public Map<String, String> payload() {
    return Map.of(
        "id", candidato.getId().value(),
        "nombre", candidato.getNombre().value(),
        "apellido", candidato.getApellido().value(),
        "pais", candidato.getPais().value(),
        "ciudad", candidato.getCiudad().value(),
        "barrio", candidato.getBarrio().value(),
        "numeroManzana", candidato.getNumeroManzana().value(),
        "numeroCasa", candidato.getNumeroCasa().value(),
        "telefono", candidato.getTelefono().value(),
        "correo", candidato.getCorreo().value());
  }
}
