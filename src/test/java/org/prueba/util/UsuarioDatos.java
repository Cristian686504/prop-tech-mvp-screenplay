package org.prueba.util;

public record UsuarioDatos(
        String nombre,
        String email,
        String password,
        String telefono,
        String tipoDocumento,
        String idDocumento,
        String rol) {}
