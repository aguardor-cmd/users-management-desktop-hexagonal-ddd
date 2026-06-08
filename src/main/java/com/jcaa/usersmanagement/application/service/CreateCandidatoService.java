package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.CreateCandidatoUseCase;
import com.jcaa.usersmanagement.application.port.out.GetCandidatoByCorreoPort;
import com.jcaa.usersmanagement.application.port.out.SaveCandidatoPort;
import com.jcaa.usersmanagement.application.service.dto.command.CreateCandidatoCommand;
import com.jcaa.usersmanagement.application.service.mapper.CandidatoApplicationMapper;
import com.jcaa.usersmanagement.domain.exception.CandidatoAlreadyExistsException;
import com.jcaa.usersmanagement.domain.model.CandidatoModel;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoCorreo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
public final class CreateCandidatoService implements CreateCandidatoUseCase {

  private final SaveCandidatoPort saveCandidatoPort;
  private final GetCandidatoByCorreoPort getCandidatoByCorreoPort;
  private final Validator validator;

  @Override
  public CandidatoModel execute(final CreateCandidatoCommand command) {
    validateCommand(command);

    final CandidatoCorreo correo = new CandidatoCorreo(command.correo());
    ensureCorreoIsNotTaken(correo);

    final CandidatoModel candidatoToSave = CandidatoApplicationMapper.fromCreateCommandToModel(command);
    return saveCandidatoPort.save(candidatoToSave);
  }

  private void validateCommand(final CreateCandidatoCommand command) {
    final Set<ConstraintViolation<CreateCandidatoCommand>> violations = validator.validate(command);
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
