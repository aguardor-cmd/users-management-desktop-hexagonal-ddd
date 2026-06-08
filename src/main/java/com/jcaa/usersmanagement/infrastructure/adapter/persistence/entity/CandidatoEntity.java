package com.jcaa.usersmanagement.infrastructure.adapter.persistence.entity;

public record CandidatoEntity(
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
