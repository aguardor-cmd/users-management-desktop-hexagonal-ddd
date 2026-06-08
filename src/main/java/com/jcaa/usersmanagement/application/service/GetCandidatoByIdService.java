package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.GetCandidatoByIdUseCase;
import com.jcaa.usersmanagement.application.port.out.GetCandidatoByIdPort;
import com.jcaa.usersmanagement.application.service.dto.query.GetCandidatoByIdQuery;
import com.jcaa.usersmanagement.application.service.mapper.CandidatoApplicationMapper;
import com.jcaa.usersmanagement.domain.exception.CandidatoNotFoundException;
import com.jcaa.usersmanagement.domain.model.CandidatoModel;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoId;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
public final class GetCandidatoByIdService implements GetCandidatoByIdUseCase {

  private final GetCandidatoByIdPort getCandidatoByIdPort;
  private final Validator validator;

  @Override
  public CandidatoModel execute(final GetCandidatoByIdQuery query) {
    validateQuery(query);

    final CandidatoId id = CandidatoApplicationMapper.fromGetCandidatoByIdQueryToCandidatoId(query);

    return getCandidatoByIdPort
        .getById(id)
        .orElseThrow(() -> CandidatoNotFoundException.becauseIdWasNotFound(id.value()));
  }

  private void validateQuery(final GetCandidatoByIdQuery query) {
    final Set<ConstraintViolation<GetCandidatoByIdQuery>> violations = validator.validate(query);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
  }
}
