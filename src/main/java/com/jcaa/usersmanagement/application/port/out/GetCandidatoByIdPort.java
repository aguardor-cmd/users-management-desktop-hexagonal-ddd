package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.CandidatoModel;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoId;
import java.util.Optional;

public interface GetCandidatoByIdPort {
  Optional<CandidatoModel> getById(CandidatoId id);
}
