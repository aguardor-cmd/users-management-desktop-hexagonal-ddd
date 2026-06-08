package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.DeleteCandidatoUseCase;
import com.jcaa.usersmanagement.application.port.out.DeleteCandidatoPort;
import com.jcaa.usersmanagement.application.port.out.GetCandidatoByIdPort;
import com.jcaa.usersmanagement.application.service.dto.command.DeleteCandidatoCommand;
import com.jcaa.usersmanagement.application.service.mapper.CandidatoApplicationMapper;
import com.jcaa.usersmanagement.domain.exception.CandidatoNotFoundException;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoId;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
public final class DeleteCandidatoService implements DeleteCandidatoUseCase {

  private final DeleteCandidatoPort deleteCandidatoPort;
  private final GetCandidatoByIdPort getCandidatoByIdPort;
  private final Validator validator;

  @Override
  public void execute(final DeleteCandidatoCommand command) {
    validateCommand(command);

    final CandidatoId id = CandidatoApplicationMapper.fromDeleteCommandToCandidatoId(command);
    ensureCandidatoExists(id);

    deleteCandidatoPort.delete(id);
  }

  private void validateCommand(final DeleteCandidatoCommand command) {
    final Set<ConstraintViolation<DeleteCandidatoCommand>> violations = validator.validate(command);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
  }

  private void ensureCandidatoExists(final CandidatoId id) {
    getCandidatoByIdPort
        .getById(id)
        .orElseThrow(() -> CandidatoNotFoundException.becauseIdWasNotFound(id.value()));
  }
}
