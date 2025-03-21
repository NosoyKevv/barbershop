package com.barbershop.common.utils.state_type;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StateTypeConverter implements AttributeConverter<StateType, String> {

    @Override
    public String convertToDatabaseColumn(StateType stateType) {
        return stateType.getValue();
    }

    @Override
    public StateType convertToEntityAttribute(String value) {
        return StateType.fromValue(value);
    }
}
