package com.barbershop.common.utils.state_type;

import lombok.Getter;

@Getter
public enum StateType {

    PENDIENTE("Pendiente"),
    POSPUESTO("Pospuesto"),
    EN_PROCESO("En proceso"),
    COMPLETADO("Completado"),
    CANCELADO("Cancelado");

    private final String value;

    StateType(String value) {
        this.value = value;
    }

    //todo Metodo para validar el y devolver el tipo del enum
    public static StateType fromValue(String value) {
        return switch (value) {
            case "Pendiente" -> StateType.PENDIENTE;
            case "Pospuesto" -> StateType.POSPUESTO;
            case "En proceso" -> StateType.EN_PROCESO;
            case "Completado" -> StateType.COMPLETADO;
            case "Cancelado" -> StateType.CANCELADO;
            default ->
                    throw new IllegalArgumentException("Invalid status type appointment [" + value + "] not supported");
        };
    }
}
