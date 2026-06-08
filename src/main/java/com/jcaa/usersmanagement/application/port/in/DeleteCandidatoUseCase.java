package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.application.service.dto.command.DeleteCandidatoCommand;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface DeleteCandidatoUseCase {
  void execute(@NotNull @Valid DeleteCandidatoCommand command);
}
