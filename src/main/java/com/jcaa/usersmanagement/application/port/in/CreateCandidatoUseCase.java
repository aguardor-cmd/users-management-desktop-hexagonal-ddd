package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.application.service.dto.command.CreateCandidatoCommand;
import com.jcaa.usersmanagement.domain.model.CandidatoModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface CreateCandidatoUseCase {
  CandidatoModel execute(@NotNull @Valid CreateCandidatoCommand command);
}
