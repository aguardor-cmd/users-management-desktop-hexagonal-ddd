package com.jcaa.usersmanagement.domain.event;

import com.jcaa.usersmanagement.domain.valueobject.CandidatoId;
import java.util.Map;
import lombok.Getter;

@Getter
public final class CandidatoDeletedDomainEvent extends DomainEvent {

  private static final String EVENT_NAME = "candidato.deleted";

  private final CandidatoId candidatoId;

  public CandidatoDeletedDomainEvent(final CandidatoId candidatoId) {
    super(EVENT_NAME);
    this.candidatoId = candidatoId;
  }

  @Override
  public Map<String, String> payload() {
    return Map.of("id", candidatoId.value());
  }
}
