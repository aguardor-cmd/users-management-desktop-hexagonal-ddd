package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.application.service.dto.query.GetCandidatoByIdQuery;
import com.jcaa.usersmanagement.domain.model.CandidatoModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface GetCandidatoByIdUseCase {
  CandidatoModel execute(@NotNull @Valid GetCandidatoByIdQuery query);
}
