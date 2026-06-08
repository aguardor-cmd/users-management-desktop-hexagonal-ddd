package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.UpdateCandidatoUseCase;
import com.jcaa.usersmanagement.application.port.out.GetCandidatoByCorreoPort;
import com.jcaa.usersmanagement.application.port.out.GetCandidatoByIdPort;
import com.jcaa.usersmanagement.application.port.out.UpdateCandidatoPort;
import com.jcaa.usersmanagement.application.service.dto.command.UpdateCandidatoCommand;
import com.jcaa.usersmanagement.application.service.mapper.CandidatoApplicationMapper;
import com.jcaa.usersmanagement.domain.exception.CandidatoAlreadyExistsException;
import com.jcaa.usersmanagement.domain.exception.CandidatoNotFoundException;
import com.jcaa.usersmanagement.domain.model.CandidatoModel;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoCorreo;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoId;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
public final class UpdateCandidatoService implements UpdateCandidatoUseCase {

  private final UpdateCandidatoPort updateCandidatoPort;
  private final GetCandidatoByIdPort getCandidatoByIdPort;
  private final GetCandidatoByCorreoPort getCandidatoByCorreoPort;
  private final Validator validator;

  @Override
  public CandidatoModel execute(final UpdateCandidatoCommand command) {
    validateCommand(command);

    final CandidatoId id = new CandidatoId(command.id());
    final CandidatoModel currentCandidato =
        getCandidatoByIdPort
            .getById(id)
            .orElseThrow(() -> CandidatoNotFoundException.becauseIdWasNotFound(id.value()));

    final CandidatoCorreo newCorreo = new CandidatoCorreo(command.correo());
    if (!currentCandidato.getCorreo().equals(newCorreo)) {
      ensureCorreoIsNotTaken(newCorreo);
    }

    final CandidatoModel candidatoToUpdate = CandidatoApplicationMapper.fromUpdateCommandToModel(command);

    return updateCandidatoPort.update(candidatoToUpdate);
  }

  private void validateCommand(final UpdateCandidatoCommand command) {
    final Set<ConstraintViolation<UpdateCandidatoCommand>> violations = validator.validate(command);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
  }

  private void ensureCorreoIsNotTaken(final CandidatoCorreo correo) {
    getCandidatoByCorreoPort
        .getByCorreo(correo)
        .ifPresent(
            ignored -> {
              throw CandidatoAlreadyExistsException.becauseCorreoAlreadyExists(correo.value());
            });
  }
}
