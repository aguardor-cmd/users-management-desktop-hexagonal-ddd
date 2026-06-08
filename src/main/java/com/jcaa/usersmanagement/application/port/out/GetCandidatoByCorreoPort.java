package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.CandidatoModel;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoCorreo;
import java.util.Optional;

public interface GetCandidatoByCorreoPort {
  Optional<CandidatoModel> getByCorreo(CandidatoCorreo correo);
}
