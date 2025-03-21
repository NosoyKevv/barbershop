package com.barbershop.common.utils.document_type;

import lombok.Getter;

@Getter
public enum DocumentType {
    CC("Cédula de ciudadania"),
    TI("Tarjeta de identidad"),
    PP("Pasaporte");

    private final String value;

    DocumentType(String value) {
        this.value = value;
    }

    //todo Metodo para validar el y devolver el tipo del enum
    public static DocumentType fromValue(String value) {
        return switch (value) {
            case "Cédula de ciudadania" -> DocumentType.CC;
            case "Tarjeta de identidad" -> DocumentType.TI;
            case "Pasaporte" -> DocumentType.PP;
            default -> throw new IllegalArgumentException("Invalid document type person [" + value + "] not supported");
        };
    }

}
