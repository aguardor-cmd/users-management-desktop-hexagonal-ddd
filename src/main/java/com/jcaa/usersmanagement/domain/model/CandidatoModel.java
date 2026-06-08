package com.jcaa.usersmanagement.domain.model;

import com.jcaa.usersmanagement.domain.valueobject.CandidatoApellido;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoBarrio;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoCiudad;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoCorreo;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoId;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoNombre;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoNumeroCasa;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoNumeroManzana;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoPais;
import com.jcaa.usersmanagement.domain.valueobject.CandidatoTelefono;
import lombok.Value;

@Value
public class CandidatoModel {

  CandidatoId id;
  CandidatoNombre nombre;
  CandidatoApellido apellido;
  CandidatoPais pais;
  CandidatoCiudad ciudad;
  CandidatoBarrio barrio;
  CandidatoNumeroManzana numeroManzana;
  CandidatoNumeroCasa numeroCasa;
  CandidatoTelefono telefono;
  CandidatoCorreo correo;

  public static CandidatoModel create(
      final CandidatoId id,
      final CandidatoNombre nombre,
      final CandidatoApellido apellido,
      final CandidatoPais pais,
      final CandidatoCiudad ciudad,
      final CandidatoBarrio barrio,
      final CandidatoNumeroManzana numeroManzana,
      final CandidatoNumeroCasa numeroCasa,
      final CandidatoTelefono telefono,
      final CandidatoCorreo correo) {
    return new CandidatoModel(
        id, nombre, apellido, pais, ciudad, barrio, numeroManzana, numeroCasa, telefono, correo);
  }
}
