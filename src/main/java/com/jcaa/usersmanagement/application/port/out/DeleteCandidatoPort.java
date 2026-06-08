package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.valueobject.CandidatoId;

public interface DeleteCandidatoPort {
  void delete(CandidatoId id);
}
