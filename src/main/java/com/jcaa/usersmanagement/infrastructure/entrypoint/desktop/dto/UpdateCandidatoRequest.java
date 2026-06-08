package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto;

public record UpdateCandidatoRequest(
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
