package com.jcaa.usersmanagement.infrastructure.adapter.persistence.dto;

public record CandidatoPersistenceDto(
    String id,
    String nombre,
    String apellido,
    String pais,
    String ciudad,
    String barrio,
    String numeroManzana,
    String numeroCasa,
    String telefono,
    String correo) {}
